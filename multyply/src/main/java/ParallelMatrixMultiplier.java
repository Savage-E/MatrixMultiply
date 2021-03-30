/**
 * Class for parallel matrix multiplication.
 */
public class ParallelMatrixMultiplier implements Runnable {


  private final int[][] matrix1;
  private final int[][] matrix2;
  private final int[][] result;
  private final int row;

  public ParallelMatrixMultiplier(int[][] matrix1, int[][] matrix2, int[][] result, int row) {
    this.matrix1 = matrix1;
    this.matrix2 = matrix2;
    this.result = result;
    this.row = row;
  }

  @Override
  public void run() {
    int length = matrix2[0].length;
    for (int i = 0; i < length; i++) {
      result[row][i] = 0;
      for (int j = 0; j < matrix1[row].length; j++) {
        result[row][i] += matrix1[row][j] * matrix2[j][i];
      }
    }
  }

  public int[][] getResult() {
    return result;
  }
}