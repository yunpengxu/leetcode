package completed;

import java.util.ArrayList;


public class Problem1313 {

  public int[] decompressRLElist(int[] nums) {
    java.util.List<Integer> outputList = new ArrayList<>();
    for(int i=0; i+1< nums.length; i+=2) {
      int times = nums[i];
      int val = nums[i+1];
      for(int j = 0; j< times; j++) {
        outputList.add(val);
      }
    }
    int[] output = new int[outputList.size()];
    for(int i =0; i< outputList.size(); i++) {
      output[i] = outputList.get(i);
    }
    return output;
  }

}
