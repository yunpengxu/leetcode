package completed;

import java.util.*;
public class Problem1814 {

  public int countNicePairs(int[] nums) {
    int[] rev = new int[nums.length], diff = new int[nums.length];
    for(int i=0;i< nums.length;i++) {
      rev[i]= reverse(nums[i]);
      diff[i]= nums[i] - rev[i];
    }
    int total = 0;
    // pay attention to this counting trick, creat a map to look up existing counts and add;
    Map<Integer, Integer> dups = new HashMap<>();
    for(int i =0; i < diff.length;i++) {
      int existing = dups.getOrDefault(diff[i], 0);
      total = (total+existing)%(int)(1e9 + 7);
      dups.put(diff[i], existing+1);
    }
    return total;
  }

  private int reverse(int num) {
    int val = 0;
    while(num >0) {
      val *=10;
      val += num %10 ;
      num /= 10;
    }
    return val;
  }

  public static void main(String[] args) {
    Problem1814 instance = new Problem1814();
    instance.countNicePairs(new int[]{42,11,1,97});
    instance.countNicePairs(new int[]{13,10,35,24,76});
  }
}
