import java.util.Date;

/**
 * Created by Vlad Kotov
 * Date: 29.март.2021
 * Time:  14:54
 * Project: ParallelMatrixMultiplier
 * Description:
 */
public class MultiplyApp {

  public static void main(String[] args) {

    int[][] m1 = MatrixGenerator.generate(1000, 1000);
    int[][] m2 = MatrixGenerator.generate(1000, 1000);
    int[][] resultParallel = new int[m1.length][m2[0].length];

    System.out.println("Matrix 1: ");
    print(m1);
    System.out.println("Matrix 2: ");
    print(m2);

    System.out.println("Parallel one");

    Date start1 = new Date();
    ThreadsCreator.multiply(m1, m2, resultParallel);
    Date end1 = new Date();
    long parallelTime = end1.getTime() - start1.getTime();

    //System.out.println("\nTime taken in milli seconds: " + (end1.getTime() - start1.getTime()));
    System.out.println("Result matrix: ");
    print(resultParallel);


    System.out.println("Traditional one");
    Date start2 = new Date();
    int[][] resultTraditional = MatrixMultiplier.multiply(m1, m2);
    Date end2 = new Date();
    long traditionalTime = end2.getTime() - start2.getTime();
    //System.out.println("\nTime taken in milli seconds: " + (end2.getTime() - start2.getTime()));
    System.out.println("Result matrix: ");
    print(resultTraditional);


    System.out.println("\nTime taken in milli seconds in traditional approach: " + traditionalTime);
    System.out.println("\nTime taken in milli seconds in parallel approach: " + parallelTime);

  }

  private static void print(int[][] matrix) {
    int rows = matrix.length;
    int columns = matrix[0].length;
    for (int[] ints : matrix) {
      for (int j = 0; j < columns; j++) {
        System.out.print(ints[j] + "  ");
      }
      System.out.println();
    }
  }
}
