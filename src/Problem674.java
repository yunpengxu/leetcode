package completed;

public class Problem674 {

  public int findLengthOfLCIS(int[] nums) {
    int len = nums.length;
    if(len ==0) {
      return 0;
    }
    int result = 1;
    if(len > 1) {
      int curLen = 1;
      for (int i = 1; i < len; i++) {
        if (nums[i]> nums[i-1]) {
          curLen ++;
          if (curLen > result) {
            result = curLen;
          }
        } else {
          curLen = 1;
        }
      }
    }

    return result;
  }

  public static void main(String[] args) {
    Problem674 instance = new Problem674();
    System.out.println(instance.findLengthOfLCIS(new int[]{1,3,5,4,7}));
    System.out.println(instance.findLengthOfLCIS(new int[]{2,2,2,2,2}));
  }
}
