package completed;

import java.util.*;
public class Problem1207 {

  public boolean uniqueOccurrences(int[] arr) {
    Map<Integer, Integer> countMap = new HashMap<>();
    for(int a:arr){
      countMap.put(a, countMap.getOrDefault(a, 0)+1);
    }
    Set<Integer> freqSet = new HashSet<>();
    for(int a: countMap.keySet()) {
      if(freqSet.contains(countMap.get(a))) {
        return false;
      }
      freqSet.add(countMap.get(a));
    }
    return true;
  }

  public static void main(String[] args) {
    Problem1207 instance = new Problem1207();
    System.out.println(instance.uniqueOccurrences(new int[]{1,2,2,1,1,3}));
    System.out.println(instance.uniqueOccurrences(new int[]{1,2}));
    System.out.println(instance.uniqueOccurrences(new int[]{-3,0,1,-3,1,1,1,-3,10,0}));
  }

}
