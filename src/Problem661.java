package completed;

public class Problem661 {


  public int[][] imageSmoother(int[][] img) {
    int height = img.length, width = img[0].length;
    int[][] results = new int[height][width];
    int[] deltaI = new int[] {-1, -1, -1, 0, 0, 0, 1, 1, 1};
    int[] deltaJ = new int[] {-1, 0, 1, -1, 0, 1,-1, 0, 1};
    for(int i =0;i< height; i++) {
      for(int j =0; j < width; j++) {
        int totalSum = 0, totalCount =0;
        for(int k =0; k<9; k++) {
          int newI = i+ deltaI[k], newJ = j + deltaJ[k];
          if(newI>=0 && newI<height && newJ>=0 && newJ< width) {
            totalCount++;
            totalSum += img[newI][newJ];
          }
        }
        results[i][j] =totalSum/totalCount;
      }
    }
    return results;
  }

  public static void main(String[] args) {
    Problem661 instance = new Problem661();
    int[][] results = instance.imageSmoother(new int[][]{{100,200,100},{200,50,200},{100,200,100}});
//    int[][] results = instance.imageSmoother(new int[][]{{1,1,1},{1,0,1},{1,1,1}});
  }
}
