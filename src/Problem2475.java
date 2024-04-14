package completed;

import java.util.ArrayList;
import java.util.HashMap;


public class Problem2475 {
  public int unequalTriplets(int[] nums) {
    java.util.Map<Integer, Integer> counts = new HashMap<>();
    for(int i = 0; i< nums.length; i++) {
      int data = nums[i];
      int preCount = counts.getOrDefault(data, 0);
      counts. put(data, preCount+1);
    }
    int len = counts.size();
    if (len <=2) {
      return 0;
    }
    java.util.List<Integer> uniq = new ArrayList<>();
    int total = 0;
    uniq.addAll(counts.keySet());
    for(int i =0; i < len -2; i++) {
      int freqI = counts.get(uniq.get(i));
      for(int j = i+1; j< len -1; j++) {
        int freqJ = counts.get(uniq.get(j));
        for(int k = j+1; k< len ; k++) {
          int freqK = counts.get(uniq.get(k));
          total += freqI * freqJ * freqK;
        }
      }
    }

    return total;
  }

  public static void main(String[] args) {
    Problem2475 instance = new Problem2475();
    instance.unequalTriplets(new int[]{1, 1, 1, 1});
    instance.unequalTriplets(new int[]{4,4,2,4,3});
    instance.unequalTriplets(new int[]{1,3,1,2,4});
  }
}
