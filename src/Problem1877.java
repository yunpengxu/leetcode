package completed;

import java.util.Arrays;


public class Problem1877 {

  public int minPairSum(int[] nums) {
    Arrays.sort(nums);
    int max = Integer.MIN_VALUE;
    for(int first=0, last = nums.length-1; first< last; first++, last--) {
      int sum = nums[first] + nums[last];
      if(sum> max) {
        max = sum;
      }
    }
    return max;
  }

  public static void main(String[] args) {
    Problem1877 instance = new Problem1877();
    instance.minPairSum(new int[]{3,5,2,3});
    instance.minPairSum(new int[]{3,5,4,2,4,6});
  }
}
