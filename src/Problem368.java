package completed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem368 {
  public List<Integer> largestDivisibleSubset(int[] nums) {
    Map<Integer, List<Integer>> pathMap = new HashMap<>();
    for(int i: nums) {
      pathMap.put(i, new ArrayList<>());
    }
    for(int i=0; i< nums.length; i++) {
      for(int j =i+1; j< nums.length; j++) {
        if(nums[i]%nums[j] ==0 ||nums[j]%nums[i] ==0 ) {
          if(nums[i] < nums[j]) {
            List<Integer> pathI = pathMap.get(nums[i]);
            pathI.add(nums[j]);
            pathMap.put(nums[i], pathI);
          } else {
            List<Integer> pathJ = pathMap.get(nums[j]);
            pathJ.add(nums[i]);
            pathMap.put(nums[j], pathJ);
          }
        }
      }
    }
    Map<Integer, Integer> depthMap = new HashMap<>();
    int max = Integer.MIN_VALUE, maxNum = -1;
    for(int i =0; i< nums.length; i++) {
      if(!depthMap.containsKey(nums[i])) {
        helper(nums[i], pathMap, depthMap);
      }
      int d = depthMap.get(nums[i]);
      if(d > max) {
        max = d;
        maxNum= nums[i];
      }
    }
    List<Integer> maxPath = new ArrayList<>();
    maxPath.add(maxNum);
    while(max >0) {
      List<Integer> nextPath = pathMap.get(maxNum);
      for(Integer n: nextPath) {
        if(depthMap.get(n).equals(max-1)) {
          maxPath.add(n);
          maxNum = n;
          break;
        }
      }
      max--;
    }
    return maxPath;
  }

  private void helper(int num, Map<Integer, List<Integer>> pathMap, Map<Integer, Integer> depthMap) {
    List<Integer> nextNum = pathMap.get(num);
    if(nextNum.size()==0){
      depthMap.put(num, 1);
    } else{
      int max = Integer.MIN_VALUE;
      for(Integer n: nextNum) {
        if(!depthMap.containsKey(n)) {
          helper(n, pathMap, depthMap);
        }
        int d = depthMap.get(n);
        if(d > max){
          max = d;
        }
      }
      depthMap.put(num, max+1);
    }
  }

  public static void main(String[] args) {
    Problem368 instance = new Problem368();
//    instance.largestDivisibleSubset(new int[]{1, 2, 3});
//    instance.largestDivisibleSubset(new int[]{1,2,4,8});
    instance.largestDivisibleSubset(new int[]{3,4,16,8});

  }
}
