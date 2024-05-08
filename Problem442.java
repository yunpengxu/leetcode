package completed;

import java.util.*;
public class Problem442 {

  // circular sort;
  public List<Integer> findDuplicates(int[] nums) {
    int i =0;
    while(i< nums.length) {
      int targetIndex = nums[i] -1;
      if(nums[i]!= nums[targetIndex]) {
          int temp = nums[targetIndex];
          nums[targetIndex] = nums[i];
          nums[i]= temp;
        } else {
          i++;
        }
    }
    List<Integer> results = new ArrayList<>();
    for(int j=0;j< nums.length;j++) {
      if(nums[j] != j+1) {
        results.add(nums[j]);
      }
    }
    return results;
  }

  public static void main(String[] args) {
    Problem442 instance = new Problem442();
    instance.findDuplicates(new int[]{4,3,2,7,8,2,3,1});
    instance.findDuplicates(new int[]{1,1,2});
    instance.findDuplicates(new int[]{1});
  }
}
