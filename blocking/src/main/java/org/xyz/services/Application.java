package org.xyz.services;

import org.xyz.services.server.StatusServer;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class Application {

  public static void main(final String[] args) throws Exception {
    final Weld weld = new Weld();
    final WeldContainer container = weld.initialize();
    final StatusServer server = container.select(StatusServer.class).get();

    container.shutdown();
  }

}
