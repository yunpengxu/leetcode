package completed;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


public class Problem2611 {

  class Tuple {
    int diff;
    int first;
    int second;

    Tuple(int first, int second) {
      this.first = first;
      this.second = second;
      this.diff = second - first;
    }
  }

  public int miceAndCheese(int[] reward1, int[] reward2, int k) {
    int len = reward1.length;
    java.util.List<Tuple> tuples = new ArrayList<>();
    for(int i=0; i< len; i++) {
      tuples.add(new Tuple(reward1[i], reward2[i]));
    }
    Collections.sort(tuples, new Comparator<Tuple>() {
      @Override
      public int compare(Tuple o1, Tuple o2) {
        return o1.diff - o2.diff;
      }
    });

    int count = 0;
    int total = 0;
    for(Tuple t: tuples) {
      if (count< k) {
        total += t.first;
      } else {
        total += t.second;
      }
      count++;
    }

    return total;

//    return helper(reward1, reward2, k, 0);
  }

  Map<String, Integer> resultMap = new HashMap<>();

  private int helper(int[] reward1, int[] reward2, int k, int pos) {
    String key = String.format("%d:%d", k, pos);
    if (resultMap.containsKey(key)) {
      return resultMap.get(key);
    }
    int len = reward1.length;
    if (k==0) {
      int total = 0;
      for(int i =pos; i< len; i++) {
        total+= reward2[i];
      }
      resultMap.put(key, total);
      return total;
    }

    if (len - pos ==k) {
      // this is important, dont forget that there is a case that we have to let mouse 1 eat all remaining cheese.
      int total = 0;
      for(int i =pos; i< len; i++) {
        total+= reward1[i];
      }
      resultMap.put(key, total);
      return total;
    }

    if (pos == len -1) {
      resultMap.put(key, reward1[pos]);
      return reward1[pos];
    }

    int eat = reward1[pos] + helper(reward1, reward2, k-1, pos+1);
    int noteat = reward2[pos] + helper(reward1, reward2, k, pos+1);
    int result = eat > noteat? eat: noteat;
    resultMap.put(key, result);
    return result;
  }

  public static void main(String[] args) {
    Problem2611 instance = new Problem2611();
//    System.out.println(instance.miceAndCheese(new int[]{1,1,3,4}, new int[]{4,4,1,1}, 2));
//    System.out.println(instance.miceAndCheese(new int[]{1,1}, new int[]{1,1}, 2));
    System.out.println(instance.miceAndCheese(new int[]{3,1,1,3}, new int[]{3,2,3,1}, 3));
  }

}
