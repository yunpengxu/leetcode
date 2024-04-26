package completed;

import java.util.ArrayList;
import java.util.List;

public class Problem163 {

  public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
    List<List<Integer>> results = new ArrayList<>();
    if(nums.length==0) {
      List<Integer> range = new ArrayList<>();
      range.add(lower);
      range.add(upper);
      results.add(range);
      return results;
    }

    int prev = lower-1, curv = nums[0];
    for(int i =0;i< nums.length;i++) {
      curv= nums[i];
      if (curv > prev +1) {
        List<Integer> range = new ArrayList<>();
        range.add(prev+1);
        range.add(curv -1);
        results.add(range);
      }
      prev = curv;
    }
    if(curv< upper) {
      List<Integer> range = new ArrayList<>();
      range.add(curv+1);
      range.add(upper);
      results.add(range);
    }
    return results;
  }

  public static void main(String[]args) {
    Problem163 instance = new Problem163();
    instance.findMissingRanges(new int[]{0,1,3,50,75}, 0, 99);
    instance.findMissingRanges(new int[]{-1}, -1, -1);
  }
}
