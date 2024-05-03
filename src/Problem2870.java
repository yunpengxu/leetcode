package completed;

import java.util.*;
public class Problem2870 {

  public int minOperations(int[] nums) {
    Map<Integer, Integer> countMap = new HashMap<>();
    for(int n: nums) {
      countMap.put(n, countMap.getOrDefault(n, 0)+1);
    }
    int total =0;
    for(int key: countMap.keySet()) {
      int count = countMap.get(key);
      if(count ==1) {
        return -1;
      }
      int div3 = count/3, mod3 = count%3;
      if(mod3 ==0) {
        total+= div3;
      } else  {
        total+= div3+ 1;
      }
    }
    return total;
  }

  public static void main(String[] args) {
    Problem2870 instance = new Problem2870();
    System.out.println(instance.minOperations(new int[]{2,3,3,2,2,4,2,3,4}));
    System.out.println(instance.minOperations(new int[]{2,1,2,2,3,3}));
  }
}
