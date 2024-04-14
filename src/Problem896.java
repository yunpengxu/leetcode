package completed;

public class Problem896 {

  public boolean isMonotonic(int[] nums) {
    if(nums.length<=2) {
      return true;
    }
    Boolean trendUp = null;
    for(int i=1; i< nums.length; i++) {
      if(nums[i]> nums[i-1]) {
        trendUp = true;
        break;
      }
      if(nums[i]< nums[i-1]) {
        trendUp = false;
        break;
      }
      if(i== nums.length-1) {
        return true;
      }
    }
    for(int i =1; i< nums.length; i++) {
      if(trendUp && nums[i]< nums[i-1]) {
        return false;
      }
      if(!trendUp && nums[i]> nums[i-1]) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    Problem896 instance = new Problem896();
    System.out.println(instance.isMonotonic(new int[]{1,3,2}));
  }

}
