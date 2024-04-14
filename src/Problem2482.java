package completed;

public class Problem2482 {

  public int[][] onesMinusZeros(int[][] grid) {
    int numRows = grid.length;
    int numCols = grid[0].length;
    int[] oneCountsByRow = new int[numRows];
    int[] oneCountsByCol = new int[numCols];
    for(int i =0; i< numRows; i++) {
      oneCountsByRow[i] =0;
    }
    for(int j =0; j< numCols; j++) {
      oneCountsByCol[j]=0;
    }

    for(int i =0; i< numRows; i++) {
      for(int j=0; j<numCols; j++) {
        oneCountsByRow[i]+= grid[i][j];
        oneCountsByCol[j]+=grid[i][j];
      }
    }

    int[][] results = new int[numRows][numCols];
    for(int i =0; i< numRows; i++) {
      for(int j=0; j<numCols; j++) {
        results[i][j]= 2*oneCountsByRow[i]+2*oneCountsByCol[j] - numCols- numRows;
      }
    }
    return results;
  }

  public static void main(String[]args) {
    Problem2482 instance = new Problem2482();
    instance.onesMinusZeros(new int[][]{{0,1,1},{1,0,1},{0,0,1}});
  }
}
