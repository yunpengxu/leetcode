package completed;

import java.util.HashMap;


public class Problem1512 {
  public int numIdenticalPairs(int[] nums) {
    java.util.Map<Integer, Integer> countMap = new HashMap<>();
    for(int i=0; i< nums.length; i++) {
      if (!countMap.containsKey(nums[i])) {
        countMap.put(nums[i], 0);
      }
      countMap.put(nums[i], countMap.get(nums[i])+1);
    }
    int total =0;
    for(int key: countMap.keySet()) {
      int val = countMap.get(key);
      if(val != 1) {
        total+= (val-1)*val/2;
      }
    }
    return total;
  }
}
