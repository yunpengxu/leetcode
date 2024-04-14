package completed;

public class Problem1480 {

  public int[] runningSum(int[] nums) {
    int pre=0;
    int [] results = new int[nums.length];
    for(int i=0; i< nums.length; i++) {
      results[i] = pre + nums[i];
      pre = results[i];
    }
    return results;
  }

  public static void main(String[] args) {
    Problem1480 instance = new Problem1480();
    instance.runningSum(new int[]{1,2, 3, 4});
  }
}
