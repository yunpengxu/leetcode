package completed;

public class Problem1685 {

  public int[] getSumAbsoluteDifferences(int[] nums) {
    if(nums.length == 1) {
      return new int[]{0};
    }

    int[] results = new int[nums.length];
    for(int i=0; i< nums.length;i++) {
      results[i]=0;
    }
    for(int i = 1; i< nums.length; i++) {
      results[0] += nums[i] - nums[0];
    }

    int preIndex = 0;
    for(int curIndex = 1; curIndex < nums.length; curIndex++) {
      int preVal = nums[preIndex], preSum = results[preIndex];
      int curVal = nums[curIndex];
      int leftDiff = (curVal - preVal)  * (preIndex);
      int rightDiff = (curVal - preVal) * (nums.length - curIndex - 1);
      int curSum = preSum + leftDiff - rightDiff;
      results[curIndex] = curSum;
      preIndex = curIndex;
    }
    return results;
  }

  public static void main(String[] args) {
    Problem1685 instance = new Problem1685();
    instance.getSumAbsoluteDifferences(new int[]{2, 3, 5});
    instance.getSumAbsoluteDifferences(new int[]{1,4,6,8,10});
  }

}
