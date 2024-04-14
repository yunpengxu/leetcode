package completed;

// Not accepted yet.
public class Problem523 {
  public boolean checkSubarraySum(int[] nums, int k) {
    int[] residuals = new int[nums.length+1];
    residuals[0]= 0;
    java.util.Map<Integer, Integer> residualIndex = new java.util.HashMap<>();
    residualIndex.put(0, -1);
    for(int i = 1; i <= nums.length; i++) {
      residuals[i] = (residuals[i-1] + nums[i-1]) %k;
      if(!residualIndex.containsKey(residuals[i])) {
        residualIndex.put(residuals[i], i-1);
      } else {
        if (i-1 - residualIndex.get(residuals[i]) >=2) {
          return true;
        }
      }
    }

    return false;
  }

  public static void main(String[] args) {
    Problem523 instance = new Problem523();
    System.out.println(instance.checkSubarraySum(new int[]{23,2,6,4,7}, 13));
  }
}
