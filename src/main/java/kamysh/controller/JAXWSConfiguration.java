package kamysh.controller;

import kamysh.dto.ServiceDiscoveryDTO;

import kamysh.utils.ClientFactoryBuilder;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@RequestMapping(path = "/api")
public class JAXWSConfiguration extends Application {

    public JAXWSConfiguration() throws Exception {
        super();

        String sdUrl = System.getenv("CONSUL_URL");

        ServiceDiscoveryDTO configuration = new ServiceDiscoveryDTO();
        configuration.setId("l1");
        configuration.setName("lab1");
        configuration.setAddress(System.getenv("LAB1_IP"));
        configuration.setPort(Integer.valueOf(System.getenv("LAB1_PORT")));
        Client client = ClientFactoryBuilder.getClient();
        String url = sdUrl + "/v1/agent/service/register";

        Response response = client.target(url)
                .request(MediaType.APPLICATION_JSON_TYPE + "; charset=UTF-8")
                .header("content-type", "application/x-www-form-urlencoded")
                .put(Entity.entity(configuration, MediaType.APPLICATION_JSON_TYPE));
    }

}
