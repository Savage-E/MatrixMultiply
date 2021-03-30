import java.util.ArrayList;
import java.util.List;

/**
 * Creates 4 threads for row.
 */
public class ThreadsCreator {
  public static void multiply(int[][] matrix1, int[][] matrix2, int[][] result) {
    List<Thread> threads = new ArrayList<>();
    int rows1 = matrix1.length;
    for (int i = 0; i < rows1; i++) {
      ParallelMatrixMultiplier task = new ParallelMatrixMultiplier(matrix1, matrix2, result, i);
      Thread thread = new Thread(task);
      thread.start();
      threads.add(thread);
      if (threads.size() % 4 == 0) {
        waitForThreads(threads);
      }
    }
  }

  private static void waitForThreads(List<Thread> threads) {
    for (Thread thread : threads) {
      try {
        thread.join();
      } catch (InterruptedException e) {
        System.out.println("Exception : " + e);
      }
    }
    threads.clear();
  }
}

