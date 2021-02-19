package org.xyz.services.server;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import javax.inject.Inject;
import javax.inject.Named;


public class StatusServer {

  public static final int PORT = 9000;

  @Inject
  public StatusServer(HttpHandler simpleHandler) throws IOException {
    final HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);
    server.createContext("/sleep", simpleHandler);
    server.setExecutor(null); // creates a default executor
    server.start();
  }
}
