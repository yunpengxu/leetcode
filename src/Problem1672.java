package completed;

public class Problem1672 {

  public int maximumWealth(int[][] accounts) {
    int max = Integer.MIN_VALUE;
    for(int i = 0; i< accounts.length; i++) {
      int total = 0;
      for(int j = 0; j< accounts[0].length;j++) {
        total += accounts[i][j];
      }
      if (total > max) {
        max = total;
      }
    }
    return max;
  }

}
