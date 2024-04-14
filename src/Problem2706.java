package completed;

import java.util.Arrays;


public class Problem2706 {

  public int buyChoco(int[] prices, int money) {
    if(prices.length<2) {
      return money;
    }

    Arrays.sort(prices);
    int sum = prices[0]+ prices[1];
    return money>= sum? money -sum: money;
  }

  public static void main(String[]args) {
    Problem2706 instance = new Problem2706();
    System.out.println(instance.buyChoco(new int[]{25,24}, 92));
  }

}
