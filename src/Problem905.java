package completed;

public class Problem905 {
  public int[] sortArrayByParity(int[] nums) {
    int[] results = new int[nums.length];
    int j = 0;
    for(int i=0; i < nums.length; i++) {
      if (nums[i] % 2 == 0) {
        results[j++] = nums[i];
      }
    }
    for(int i=0; i < nums.length; i++) {
      if (nums[i] % 2 != 0) {
        results[j++] = nums[i];
      }
    }
    return results;
  }

  public static void main(String[] args) {
    Problem905 instance = new Problem905();
    int[]results=instance.sortArrayByParity(new int[]{3,1,2,4});
    for (int i = 0; i<results.length;i++){

      System.out.println(results[i]);
    }
  }
}
