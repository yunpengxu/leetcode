package completed;

public class Problem1099 {
  public int twoSumLessThanK(int[] nums, int k) {
    java.util.TreeMap<Integer, Integer> map = new java.util.TreeMap<>();
    for(int i =0; i< nums.length; i++) {
      if(!map.containsKey(nums[i])) {
        map.put(nums[i], 0);
      }
      map.put(nums[i], map.get(nums[i])+1);
    }
    int minGap = Integer.MAX_VALUE, maxSum =0;
    for(int i =0; i < nums.length; i++) {
      int delta = k -nums[i];
      Integer lower = map.lowerKey(delta);
      if (lower != null) {
        if(lower.equals(nums[i]) && map.get(lower).equals(1)) {
          // this part is important, since the best pair may be itself.
          lower = map.lowerKey(lower);
          if(lower == null) {
            continue;
          }
        }
        int gap = k - (nums[i] + lower);
        if (gap < minGap) {
          minGap = gap;
          maxSum = nums[i] + lower;
        }
      }
    }

    return (minGap != Integer.MAX_VALUE)? maxSum: -1;
  }

  public static  void main(String[] args) {
    Problem1099 instance = new Problem1099();
    System.out.println(instance.twoSumLessThanK(new int[]{10,20,30}, 15));
  }

}
