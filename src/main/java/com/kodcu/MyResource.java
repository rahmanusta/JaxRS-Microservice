package com.kodcu;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

/**
 * Created by usta on 14.12.2014.
 */
@Path("/")
public class MyResource {

    @GET
    public String hello(){
        return "Merhaba Dunya";
    }

    public static void main(String[] args) throws InterruptedException {

        URI baseUri = UriBuilder.fromUri("http://localhost/").port(8080).build();
        ResourceConfig config = new ResourceConfig(MyResource.class);
        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(baseUri, config);

        Thread.currentThread().join();
    }
}
