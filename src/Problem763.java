package completed;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


public class Problem763 {

  class Pair implements Comparable <Pair>{
    int first;
    int last;
    Pair(int first, int last) {
      this.first = first;
      this.last = last;
    }

    @Override
    public int compareTo(Pair o) {
      if (first != o.first) {
        return first - o.first;
      }
      return last - o.last;
    }
  }

  public java.util.List<Integer> partitionLabels(String s) {
    java.util.Map<Character, Pair> map = new HashMap<>();
    for(int i =0; i< s.length(); i++) {
      Character curChar = s.charAt(i);
      if (!map.containsKey(curChar)) {
        map.put(curChar, new Pair(i, i));
      } else {
        Pair existing = map.get(curChar);
        map.put(curChar, new Pair(existing.first, i));
      }
    }

    java.util.List<Pair> allPairs = new ArrayList<>(map.values());
    Collections.sort(allPairs);
    java.util.List<Pair> outputPair = new ArrayList<>();
    Pair prev = allPairs.get(0);
    for(int i = 1; i< allPairs.size(); i++) {
      Pair cur = allPairs.get(i);
      if (prev.last< cur.first) {
        outputPair.add(prev);
        prev = cur;
      } else {
        int first = prev.first;
        int last = prev.last<cur.last? cur.last : prev.last;
        prev = new Pair(first, last);
      }
    }
    outputPair.add(prev);
    java.util.List<Integer> output = new ArrayList<>();
    for(int i =0; i < outputPair.size(); i++) {
      Pair p = outputPair.get(i);
      output.add(p.last - p.first + 1);
    }
    return output;
  }

  public static void main(String[] args) {
    Problem763 instance = new Problem763();
    instance.partitionLabels("eccbbbbdec");
  }
}
