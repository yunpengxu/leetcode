package completed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class Problem398 {

  static class Solution {

    java.util.Map<Integer, java.util.List<Integer>> map = new HashMap<>();
    Random random = new Random();
    public Solution(int[] nums) {
      for(int i = 0; i< nums.length; i++) {
        java.util.List<Integer> pos4Val = map.getOrDefault(nums[i], new ArrayList<>());
        pos4Val.add(i);
        map.put(nums[i], pos4Val);
      }
    }

    public int pick(int target) {
      java.util.List<Integer> pos4Val = map.get(target);
      if(pos4Val.size()==1) {
        return pos4Val.get(0);
      }

      int index = random.nextInt(pos4Val.size());
      return pos4Val.get(index);
    }
  }

  public static void main(String[] args) {
    Solution instance = new Solution(new int[]{1, 2, 3, 3, 3});
    instance.pick(3);
    instance.pick(1);
    instance.pick(3);
  }
}
