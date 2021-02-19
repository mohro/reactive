package org.xyz.services.workers;

public class SimpleWorker implements Worker {

  @Override
  public String work(final int time) {
    System.out.printf("Simple worker sleeping for:: %d\n", time);
    slowWork(time);
    System.out.printf("Simple worker waking after:: %d\n", time);
    return OK;
  }

  private static void slowWork(final int i) {
    try {
      Thread.sleep(i);
    } catch (final Exception e) {
    }
  }
}
