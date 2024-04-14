package completed;

public class Problem1901 {

  public int[] findPeakGrid(int[][] mat) {
    int[] results = new int[2];
    int[] deltax = new int[]{-1, 0, 0, 1}, deltay = new int[]{0, -1, 1, 0};
    int height = mat.length, width = mat[0].length;
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        boolean peak = true;
        for (int k = 0; k < 4; k++) {
          int newi = i + deltax[k], newj = j + deltay[k];
          if (newi >= 0 && newi < height && newj >= 0 && newj < width) {
            if (mat[i][j] <= mat[newi][newj]) {
              peak = false;
              break;
            }
          }
        }
        if (peak) {
          results[0] = i;
          results[1] = j;
          return results;
        }
      }
    }
    return results;
  }

  public static void main(String[] args) {
    Problem1901 instance = new Problem1901();
    int[] results = instance.findPeakGrid(new int[][]{{10,20,15},{21,30,14},{7,16,32}});
    System.out.println();
  }
}
