package completed;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;


public class Problem2610 {

  public List<List<Integer>> findMatrix(int[] nums) {
    java.util.Map<Integer, Integer> countMap = new HashMap<>();
    for(int data: nums) {
      countMap.put(data, countMap.getOrDefault(data, 0) + 1);
    }
    java.util.TreeMap<Integer, List<Integer>> freqMap = new TreeMap<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o2 - o1;
      }
    });
    for(Integer data: countMap.keySet()) {
      int freq = countMap.get(data);
      if(!freqMap.containsKey(freq)) {
        freqMap.put(freq, new ArrayList<>());
      }
      freqMap.get(freq).add(data);
    }

    List<List<Integer>> results = new ArrayList<>();
    for(Integer freq: freqMap.keySet()) {
      for(int i = 0; i < freq; i++) {
        if (results.size() <= i) {
          results.add(new ArrayList<>());
        }
        List<Integer> curResults = results.get(i);
        curResults.addAll(freqMap.get(freq));
      }
    }
    return results;
  }

  public static void main(String[] args) {
    Problem2610 instance = new Problem2610();
    instance.findMatrix(new int[]{1,3,4,1,2,3,1});
    instance.findMatrix(new int[]{1,2,3,4});
  }
}
