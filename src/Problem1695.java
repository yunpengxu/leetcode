package completed;

import java.util.HashSet;


public class Problem1695 {

  /*
  use two pointers.
   */
  public int maximumUniqueSubarray(int[] nums) {
    java.util.Set<Integer> uniqs = new HashSet<>();
    int firstIndex = 0, secondIndex =1;
    uniqs.add(nums[firstIndex]);
    int maxSum = nums[firstIndex];
    int curSum = maxSum;
    while(true) {
      while(secondIndex < nums.length && !uniqs.contains(nums[secondIndex])) {
        uniqs.add(nums[secondIndex]);
        curSum += nums[secondIndex];
        if(curSum> maxSum) {
          maxSum = curSum;
        }
        secondIndex++;
      }
      if (secondIndex== nums.length) {
        break;
      }

      while(uniqs.contains(nums[secondIndex]) && firstIndex<secondIndex) {
        curSum -= nums[firstIndex];
        uniqs.remove(nums[firstIndex]);
        firstIndex++;
      }
    }
    return maxSum;
  }

  public static void main(String[] args) {
    Problem1695 instance = new Problem1695();
    instance.maximumUniqueSubarray(new int[]{5,2,1,2,5,2,1,2,5});
  }

}
