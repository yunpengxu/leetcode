package completed;

import java.util.ArrayList;
import java.util.HashMap;


public class Problem525 {
  public int findMaxLength(int[] nums) {
    int len = nums.length;
    int oneCount = 0, zeroCount = 0;
    int[] diffCount = new int[len+1];
    diffCount[0]= 0;
    for(int i =0; i< len; i++) {
      if(nums[i] ==0) {
        zeroCount++;
      } else{
        oneCount++;
      }
      diffCount[i+1]= oneCount-zeroCount;
    }
    int maxLen = Integer.MIN_VALUE;
    java.util.Map<Integer, java.util.List<Integer>> posMap = new HashMap<>();
    for(int i = 0; i< len+1; i++) {
      java.util.List<Integer> posForCount = posMap.getOrDefault(diffCount[i], new ArrayList<>());
      posForCount.add(i);
      int delta = i - posForCount.get(0);
      if(delta> maxLen){
        maxLen = delta;
      }
      posMap.put(diffCount[i], posForCount);
    }
    return Math.max(0, maxLen);
  }

  public static void main(String[] args) {
    Problem525 instance = new Problem525();
    instance.findMaxLength(new int[]{0, 1});
    instance.findMaxLength(new int[]{0, 1, 0});
    instance.findMaxLength(new int[]{0, 1, 0, 1, 0});
  }
}
