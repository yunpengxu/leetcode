package completed;

import java.util.HashMap;
import java.util.TreeMap;


public class Problem1365 {

  public int[] decompressRLElist(int[] nums) {
    java.util.TreeMap<Integer, Integer> countMap = new TreeMap<>();
    for(int i = 0; i< nums.length;i++) {
      if(!countMap.containsKey(nums[i])) {
        countMap.put(nums[i], 0);
      }
      countMap.put(nums[i], countMap.get(nums[i])+1);
    }
    java.util.Map<Integer, Integer> dict = new HashMap<>();
    int total =0;
    for(Integer key: countMap.keySet()) {
      Integer val = countMap.get(key);
      dict.put(key, total);
      total+= val;
    }
    int[] output = new int[nums.length];
    for(int i =0; i< nums.length; i++) {
      int key = nums[i];
      int count = dict.get(key);
      output[i]= count;
    }
    return output;
  }

  public static void main(String[] args) {
    Problem1365 instance = new Problem1365();
    instance.decompressRLElist(new int[]{7,7,7,7});
  }

}
