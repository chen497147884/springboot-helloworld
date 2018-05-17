package example.demo.springboot.helloworld;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

import static org.springframework.http.HttpStatus.OK;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = DemoApplication.class)
//@WebIntegrationTest(randomPort = true)
public class HomeControllerTest {

    @Value("${local.server.port}")
    private Integer port;

    private RestTemplate restTemplate = new RestTemplate();

    @Test
    public void helloWorld() {
        getRequest("/")
            .assertStatusCode(OK)
            .assertResponseBody("Hello from Alauda Container Cloud Platform!");
    }

    private HelloWorldResponse getRequest(String uri) {
        return new HelloWorldResponse(restTemplate.getForEntity(getUri(uri), String.class));
    }


    protected URI getUri(String uri) {
        return UriComponentsBuilder
            .newInstance()
            .scheme("http")
            .host("localhost")
            .port(port)
            .path(uri)
            .build()
            .toUri();
    }

}
