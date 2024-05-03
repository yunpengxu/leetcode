package completed;

import java.util.*;
public class Problem2210 {

  public int countHillValley(int[] nums) {
    if(nums.length<=2) {
      return 0;
    }
    List<Integer> data = new ArrayList<>();
    data.add(nums[0]);
    for(int i=1; i< nums.length;i++) {
      if(nums[i]!= nums[i-1]) {
        data.add(nums[i]);
      }
    }
    int total =0;
    for(int i =1; i< data.size() -1; i++) {
      if(data.get(i) <data.get(i+1) && data.get(i) < data.get(i-1) ||data.get(i) >data.get(i+1) && data.get(i) > data.get(i-1)) {
        total++;
      }
    }
    return total;
  }
  public static void main(String[] args) {
    Problem2210 instance = new Problem2210();
    instance.countHillValley(new int[]{2,4,1,1,6,5});
    instance.countHillValley(new int[]{6,6,5,5,4,1});
  }
}
