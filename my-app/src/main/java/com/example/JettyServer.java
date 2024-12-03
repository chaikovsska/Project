package com.example;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

public class JettyServer {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8081);

        ServletContextHandler context = new ServletContextHandler();
        context.setContextPath("/api");

        ServletHolder servletHolder = new ServletHolder(new ServletContainer());
        servletHolder.setInitParameter("jersey.config.server.provider.packages", "com.example");
        context.addServlet(servletHolder, "/*");

        server.setHandler(context);

        server.start();
        server.join();
    }
}
