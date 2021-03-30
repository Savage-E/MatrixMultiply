import java.util.Random;
import java.util.logging.Logger;

/**
 * Generator of random numbers.
 */
public class MatrixGenerator {

  private static final Logger LOGGER = Logger.getLogger("MatrixGenerator");

  public static int[][] generate(int rows, int columns) {

    int[][] result = new int[rows][columns];

    Random random = new Random();

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {

        result[i][j] = random.nextInt(100) * 10;
      }
    }

    return result;
  }


}
