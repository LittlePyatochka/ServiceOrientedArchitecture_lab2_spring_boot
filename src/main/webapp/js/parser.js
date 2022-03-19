function parseXml(xmlString) {
    return parseNode(new DOMParser().parseFromString(xmlString, "text/xml"));
}

function parseNode(xmlNode) {
    let {children} = xmlNode;
    children = Array.from(children);
    if (children.length === 0) return isNaN(+xmlNode.innerHTML) ? xmlNode.innerHTML : +xmlNode.innerHTML;
    let result = {};
    let namesCount = {}
    children.forEach(({nodeName}) => {
        let cur = +namesCount[nodeName];
        namesCount[nodeName] = isNaN(cur) ? 1 : cur + 1;
    });
    Object.entries(namesCount).forEach(([name, amount]) => {
        result[name] = amount > 1 || name === 'results' ? [] : undefined;
    })
    children.forEach(childNode => {
        const {nodeName} = childNode;
        if (namesCount[nodeName] > 1 || nodeName === 'results') result[nodeName].push(parseNode(childNode))
        else result[nodeName] = parseNode(childNode);
    });
    return result;
}

function convertObjectToXml(object, key) {
    if (!['array', 'object'].includes(typeof object)) return `<${key}>${object}</${key}>`;
    if (Array.isArray(object)) return object
        .map(v => convertObjectToXml(v, key))
        .reduce((acc, cur) => acc + cur);
    let value = Object.entries(object)
        .map(([name, value]) => convertObjectToXml(value, name))
        .reduce((acc, cur) => acc + cur);
    return key ? `<${key}>${value}</${key}>` : value;
}

function toXml(object) {
    return `<?xml version="1.0" encoding="UTF-8" standalone="yes"?>${convertObjectToXml(object)}`;
}
