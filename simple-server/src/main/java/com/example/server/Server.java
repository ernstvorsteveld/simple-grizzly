package com.example.server;

import com.sun.grizzly.http.embed.GrizzlyWebServer;
import com.sun.grizzly.http.servlet.ServletAdapter;
import com.sun.jersey.spi.spring.container.servlet.SpringServlet;
import org.springframework.web.filter.DelegatingFilterProxy;

import java.io.IOException;

public class Server {

    private static final String host = "localhost";
    private static final int port = 8081;
    private static final String context = "myapp";
    public static final String BASE_URI = "http://" + host + ":" + port + "/" + context;

    public static GrizzlyWebServer startServerWithSpring() throws IOException {
        ServletAdapter servletAdapter = new ServletAdapter();
        servletAdapter.setContextPath("/");

        // For jersey + Spring
        servletAdapter.setServletInstance(new SpringServlet());
        servletAdapter.addContextParameter("contextConfigLocation", "classpath:/spring-context.xml");
        servletAdapter.addServletListener("org.springframework.web.context.ContextLoaderListener");
        servletAdapter.addServletListener("org.springframework.web.context.request.RequestContextListener");
        servletAdapter.addInitParameter("com.sun.jersey.api.json.POJOMappingFeature", "true");

        // For Spring Security
        servletAdapter.addFilter(new DelegatingFilterProxy(), "springSecurityFilterChain", null);

        GrizzlyWebServer grizzlyServer = new GrizzlyWebServer(host, port, "", false);
//        final SelectorThread selectorThread = GrizzlyServerFactory.create("http://localhost:8081", servletAdapter);
        grizzlyServer.addGrizzlyAdapter(servletAdapter, new String[]{"/"});

        return grizzlyServer;
    }

    /**
     * Main method.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        final GrizzlyWebServer grizzlyServer = startServerWithSpring();
        System.out.println("Server listening to: " + BASE_URI);
        grizzlyServer.start();

        System.out.println("Start running server(host: " + host + ",port: " + Integer.toString(port));
        System.out.println("Press any key to stop the server.");
        System.in.read();
    }
}

