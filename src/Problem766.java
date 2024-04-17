package completed;

public class Problem766 {

  public boolean isToeplitzMatrix(int[][] matrix) {
    int height = matrix.length, width = matrix[0].length;
    for(int i =0; i < height; i++){
      int val = matrix[i][0];
      for(int j = 0; (j< width ) && (i+j < height); j++) {
        System.out.println(String.format("%d:%d", i+j, j));
        if(matrix[i+j][j] != val) {

          return false;
        }
      }
    }
    for(int i =0; i < width; i++){
      int val = matrix[0][i];
      for(int j = 0; (j< height) && (j+i< width) ; j++) {
        System.out.println(String.format("%d:%d", j, i+j));
        if(matrix[j][i+j] != val) {
          return false;
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
    Problem766 instance = new Problem766();
//    instance.isToeplitzMatrix(new int[][]{{18},{66}});
//    instance.isToeplitzMatrix(new int[][]{{1,2,3,4},{5,1,2,3},{9,5,1,2}});
    instance.isToeplitzMatrix(new int[][]{{11,74,0,93},{40,11,74,7}});
//    11,74,0,93],
//    40,11,74,7
  }
}
