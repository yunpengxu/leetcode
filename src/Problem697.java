package completed;

import java.util.HashMap;


public class Problem697 {

  public int findShortestSubArray(int[] nums) {
    java.util.Map<Integer, Integer> freqs = new HashMap<>();
    java.util.Map<Integer, java.util.List<Integer>> pos = new HashMap<>();
    for(int i=0; i< nums.length;i++) {
      freqs.put(nums[i], 1+ freqs.getOrDefault(nums[i], 0));
      java.util.List<Integer> posForNum = pos.getOrDefault(nums[i], new java.util.ArrayList<Integer>());
      posForNum.add(i);
      pos.put(nums[i], posForNum);
    }
    int maxFreq = 0;
    for(Integer key: freqs.keySet()) {
      if(freqs.get(key) > maxFreq) {
        maxFreq = freqs.get(key);
      }
    }
    int minInterval = nums.length;;
    for(Integer key: freqs.keySet()) {
      if(freqs.get(key).equals(maxFreq)) {
        java.util.List<Integer> posForNum = pos.get(key);
        int curInterval = posForNum.get(posForNum.size()-1) - posForNum.get(0) +1;
        if (curInterval< minInterval) {
          minInterval = curInterval;
        }
      }
    }
    return  minInterval;
  }

  public static void main(String[] args) {
    Problem697 instance = new Problem697();
    instance.findShortestSubArray(new int[]{1,2,2,3,1});
    instance.findShortestSubArray(new int[]{1,2,2,3,1,4,2});
  }
}
