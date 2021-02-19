package org.xyz.services.handlers;

import org.xyz.services.workers.Worker;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;
import javax.inject.Inject;
import javax.inject.Named;


public class SimpleHandler implements HttpHandler {

  private final Worker worker;

  @Inject
  public SimpleHandler(final Worker worker) {
    this.worker = worker;
  }

  @Override
  public void handle(final HttpExchange httpExchange) throws IOException {
    final String response = worker.work(time(httpExchange));

    httpExchange.sendResponseHeaders(200, response.getBytes().length);
    final OutputStream os = httpExchange.getResponseBody();
    os.write(response.getBytes());
    httpExchange.close();
  }

  private int time(final HttpExchange httpExchange) {
    final int time = Integer.parseInt(path(httpExchange).split("/")[2]);
    return time;
  }

  static String path(final HttpExchange exchange) {
    return exchange.getRequestURI().getPath();
  }
}
