package completed;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;


public class Problem1094 {

  public boolean carPooling(int[][] trips, int capacity) {
    java.util.Map<Integer, java.util.List<Integer>> changes = new TreeMap<>();
    for(int i = 0; i< trips.length; i++) {
      int passenger = trips[i][0];
      int start = trips[i][1];
      int end = trips[i][2];
      if (!changes.containsKey(start)) {
        changes.put(start, new ArrayList<>());
      }
      if (!changes.containsKey(end)) {
        changes.put(end, new ArrayList<>());
      }
      changes.get(start).add(passenger);
      changes.get(end).add(-1 *passenger);
    }

    int curcount = 0;
    for(Integer location: changes.keySet()) {
      List<Integer> curChanges = changes.get(location);
      for(Integer chg: curChanges) {
        curcount += chg;
      }
      if(curcount > capacity) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    Problem1094 instance = new Problem1094();
    instance.carPooling(new int[][]{{2,1,5},{3,3,7}}, 5);
  }
}
