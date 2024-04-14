package completed;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;


public class Problem1331 {

  public int[] arrayRankTransform(int[] arr) {
    java.util.TreeMap<Integer, List<Integer>> map = new TreeMap<>();
    for(int i= 0; i < arr.length; i++ ) {
      if(!map.containsKey(arr[i])) {
        map.put(arr[i], new ArrayList<>());
      }
      map.get(arr[i]).add(i);
    }
    int i = 1;
    int []output = new int[arr.length];
    for(Integer key: map.keySet()) {
      for(Integer idx: map.get(key)) {
        output[idx] = i;
      }
      i++;
    }
    return output;
  }

  public static void main(String[] args) {
    Problem1331 instance = new Problem1331();
    int[] output = instance.arrayRankTransform(new int[]{37,12,28,9,100,56,80,5,12});
    for(int o: output){
      System.out.print(o+",");
    }
  }
}
