package completed;

import java.util.ArrayList;


public class Problem1570 {


  class SparseVector {

    private java.util.List<Integer> indices = new ArrayList<>();
    private java.util.List<Integer> values = new ArrayList<>();

    SparseVector(int[] nums) {
      for(int i =0; i< nums.length; i++) {
        if(nums[i] != 0) {
          indices.add(i);
          values.add(nums[i]);
        }
      }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
      int this_len = indices.size(), other_len = vec.indices.size();
      int total = 0;
      for(int i = 0, j =0; i< this_len && j < other_len; ) {
        int this_index = indices.get(i);
        int this_val = values.get(i);
        int other_index = vec.indices.get(j);
        int other_val = vec.values.get(j);
        if (this_index == other_index) {
          total += this_val * other_val;
          i++;
          j++;
        } else if (this_index < other_index) {
          i++;
        } else {
          j++;
        }
      }
      return total;
    }
  }
}
