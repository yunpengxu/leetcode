package completed;

import java.util.ArrayList;


public class Problem1281 {

  public int subtractProductAndSum(int n) {
    java.util.List<Integer> splits = helper(n);
    int multiply = 1;
    int sum = 0;
    for(Integer i : splits){
      sum += i;
      multiply *= i;
    }
    return multiply - sum;
  }

  private java.util.List<Integer> helper(int n) {
    java.util.List<Integer> results = new ArrayList<>();
    while(n >0) {
      int curNum = n% 10;
      results.add(curNum);
      n = n/ 10;
    }
    return results;
  }

  public static void main(String[] args) {
    Problem1281 instance = new Problem1281();
    System.out.println(instance.subtractProductAndSum(234));
    System.out.println(instance.subtractProductAndSum(4421));
  }
}
