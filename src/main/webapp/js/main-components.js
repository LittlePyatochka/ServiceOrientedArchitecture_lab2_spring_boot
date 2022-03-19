Vue.component(
    'result-table',
    {
        template:
            `
                <div>
                    <h4 class="col-xs-1 text-center">Space marines</h4>
                    <table class="table table-striped table-bordered table-hover p-5 text-center">
                        <tr>
                            <th>Id</th>
                            <th>Name</th>
                            <th>Coordinates</th>
                            <th>Creation date</th>
                            <th>Health</th>
                            <th>Heart count</th>
                            <th>Loyal</th>
                            <th>Category</th>
                            <th>Chapter</th>
                        </tr>
                        <tr v-for="marine in spacemarines">
                            <td>{{ marine.id }}</td>
                            <td>{{ marine.name }}</td>
                            <td>Id: {{ marine.coordinates.id }} (X: {{ marine.coordinates.x }}. Y: {{ marine.coordinates.y }})</td>
                            <td>{{ formatCreationDate(marine) }}</td>
                            <td>{{ marine.health }}</td>
                            <td>{{ marine.heartCount }}</td>
                            <td>{{ marine.loyal }}</td>
                            <td>{{ marine.category }}</td>
                            <td v-if="marine.chapter">Id: {{ marine.chapter.id }} ({{ marine.chapter.name }})</td>
                            <td v-else>None</td>
                            <td>
                                <button class="btn btn-secondary" v-on:click="editSpaceMarine(marine)" type="submit">Edit</button>
                                <button class="btn btn-danger" v-on:click="deleteSpaceMarine(marine)" type="submit">Delete</button>
                            </td>
                        </tr>
                    </table>
                </div>
            `,

        props: ["spacemarines"],
        methods: {
            editSpaceMarine: function (spaceMarine) {
                this.$emit('editspacemarine', spaceMarine);
            },
            deleteSpaceMarine: function (spaceMarine) {
                this.$emit('deletespacemarine', spaceMarine);
            },
            formatCreationDate: function (spaceMarine) {
                return new Date(spaceMarine.creationDate).toLocaleDateString();
            }
        }
    }
);


Vue.component(
    'delete-loyal',
    {
        template:
            `
                <div>
                    <h4 class="col-xs-1 text-center">Additional actions</h4>
                    <h5 class="col-xs-1 text-center">Delete one object whose loyal field value is equal to the specified one</h5>
                    <label for="deleteLoyal">Loyal</label>
                        <label for="deleteLoyal" class="pl-5">true</label>
                        <input id="deleteLoyal" type="radio" value="true" v-model="v" name="deleteLoyal">
                        <label for="deleteLoyal" class="pl-5">false</label>
                        <input id="deleteLoyal" type="radio" value="false" v-model="v" name="deleteLoyal">
                    <button class="btn btn-danger" v-on:click="onDeleteLoyal(v)" type="submit">Delete loyal</button>
                    <h1 class="col-xs-1 text-center"></h1>
                </div>
            `,

        props: ["deleteLoyal"],
        data() {
            return {
                v: undefined
            }
        },
        watch: {
            deleteLoyal(v) {
                this.v = v;
            },
        },
        methods: {
            onDeleteLoyal: function (deleteLoyal) {
                this.$emit('delete-loyal', deleteLoyal);
            },
        }
    }
);

Vue.component(
    'min-heart-count',
    {
        template:
            `
                <div>
                    <h5 class="col-xs-1 text-center">Get any object that has a minimum heartCount value</h5>
                    <table class="table table-striped table-bordered table-hover p-3 text-center">
                        <tr>
                            <th>Id</th>
                            <th>Name</th>
                            <th>Coordinates</th>
                            <th>Creation date</th>
                            <th>Health</th>
                            <th>Heart count</th>
                            <th>Loyal</th>
                            <th>Category</th>
                            <th>Chapter</th>
                        </tr>
                        <tr>
                            <td>{{ minHeartCount.id }}</td>
                            <td>{{ minHeartCount.name }}</td>
                            <td>{{ coordinatesId }}</td>
                            <td>{{ formatCreationDate(minHeartCount) }}</td>
                            <td>{{ minHeartCount.health }}</td>
                            <td>{{ minHeartCount.heartCount }}</td>
                            <td>{{ minHeartCount.loyal }}</td>
                            <td>{{ minHeartCount.category }}</td>
                            <td>{{ chapterId }}</td>
                        </tr>
                    </table>
                    <button class="btn btn-success" v-on:click="onMinHeartCount()" type="submit">Get min heart count</button>
                    <h1 class="col-xs-1 text-center"></h1>
                </div>
            `,

        props: ["minHeartCount"],
        computed: {
            coordinatesId() {
                return this.minHeartCount?.coordinates?.id;
            },
            chapterId() {
                return this.minHeartCount?.chapter?.id;
            }
        },
        methods: {
            onMinHeartCount: function () {
                this.$emit('min-heart-count');
            },
            formatCreationDate: function (minHeartCount) {
                return new Date(minHeartCount.creationDate).toLocaleDateString();
            }
        }
    }
);

Vue.component(
    'count-health',
    {
        template:
            `
                <div>
                    <h5 class="col-xs-1 text-center">Get the number of objects whose Health field value is less than the specified</h5>
                    <label for="countHealth">Health</label>
                    <input id="countHealth" type="text" maxlength="8" v-model="v" name="countHealth">
                    <div>{{ value.healthCount }}</div>
                    <button class="btn btn-success d-block" v-on:click="onCountHealth(v)" type="submit">Get health count</button>
                    <h1 class="col-xs-1 text-center"></h1>
                </div>
            `,

        props: ["countHealth", "value"],
        data() {
            return {
                v: undefined
            }
        },
        watch: {
            countHealth(v) {
                this.v = v;
            },
        },
        methods: {
            onCountHealth: function (countHealth) {
                this.$emit('count-health', countHealth);
            },
        }
    }
);

Vue.component(
    'set-paratrooper',
    {
        template:
            `
                <div>
                    <h4 class="col-xs-1 text-center">Second lab</h4>
                    <h5 class="col-xs-1 text-center">Load space-marine</h5>
                    <label for="paratrooper">Space marine</label>
                    <input id="paratrooper" type="text" maxlength="8" v-model="v" name="paratrooper">
                    <div>{{ paratrooper }}</div>
                    <label for="starship">Starship</label>
                    <input id="starship" type="text" maxlength="8" v-model="p" name="starship">
                    <div>{{ starship }}</div>
                    <button class="btn btn-success d-block" v-on:click="setparatrooper(v, p)" type="submit">Load space marine to starship</button>

                    <table class="table table-striped table-bordered table-hover p-3 text-center">
                        <tr>
                            <th>Starship name</th>
                            <th>Quantity on board</th>
                        </tr>
                        <tr>
                            <td>{{ totalOnBoard.name }}</td>
                            <td>{{ totalOnBoard.totalParatroopers }}</td>
                        </tr>
                    </table>
                </div>
            `,

        props: ["paratrooper", "starship", "totalOnBoard"],
        data() {
            return {
                v: undefined,
                p: undefined
            }
        },
        methods: {
            setparatrooper: function (paratrooper, starship) {
                this.$emit('set-paratrooper', { paratrooper, starship });
            },
        }
    }
);

Vue.component(
    'land-all',
    {
        template:
            ` 
                <div>
                <h5 class="col-xs-1 text-center">Land all space-marine</h5>
                    <label for="landStarship">Starship</label>
                    <input id="landStarship" type="text" maxlength="8" v-model="l" name="landStarship">
                    <div>{{ landStarship }}</div>
                    <button class="btn btn-success d-block" v-on:click="landall(l)" type="submit">land all space marines</button>
                    <table class="table table-striped table-bordered table-hover p-3 text-center">
                        <tr>
                            <th>Starship name</th>
                            <th>Quantity on board</th>
                        </tr>
                        <tr>
                            <td>{{ checkLand.name }}</td>
                            <td>{{ checkLand.totalParatroopers }}</td>
                        </tr>
                    </table>
                </div>
            `,

        props: ["landStarship", "checkLand"],
        data() {
            return {
                l: undefined
            }
        },
        methods: {
            landall: function (landStarship) {
                this.$emit('land-all', { landStarship });
            },
        }
    }
);