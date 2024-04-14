package completed;

public class Problem1572 {

  public int diagonalSum(int[][] mat) {
    int size = mat.length;
    int total = 0;
    for(int i =0; i< size; i++) {
      total += mat[i][i];
      if(size -1 -i !=i) {
        total += mat[i][size-1-i];
      }
    }
    return total;
  }

  public static void main(String[] args) {
    Problem1572 instance = new Problem1572();
    instance.diagonalSum(new int[][]{{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}});
  }
}
