package completed;

import java.util.ArrayList;


public class Problem448 {

  public java.util.List<Integer> findDisappearedNumbers(int[] nums) {
    int[] all = new int[nums.length];
    for(int i=0; i< nums.length; i++) {
      all[i]=-1;
    }
    for(int i=0; i< nums.length; i++) {
      all[nums[i]-1]=1;
    }
    java.util.List<Integer> missing = new ArrayList<>();
    for(int i=0; i< nums.length; i++) {
      if(all[i]<0) {
        missing.add(i+1);
      }
    }
    return  missing;
  }

  public static void main(String[] args) {
    Problem448 instance = new Problem448();
    instance.findDisappearedNumbers(new int[]{1,1});
  }
}
