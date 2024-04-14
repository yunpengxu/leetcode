package completed;

public class Problem832 {

  public int[][] flipAndInvertImage(int[][] image) {
    for(int i =0; i< image.length; i++) {
      for(int j =0, k = image[0].length -1; j<= k; j++, k--) {
        if(j ==k) {
          image[i][j] = 1 - image[i][j];
        } else {
          image[i][j] = 1 - image[i][j];
          image[i][k] = 1 - image[i][k];
          int temp = image[i][j];
          image[i][j]= image[i][k];
          image[i][k]=temp;
        }
      }
    }
    return image;
  }

  public static void main(String[]args) {
    Problem832 instance = new Problem832();
    instance.flipAndInvertImage(new int[][]{{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}});
  }

}
