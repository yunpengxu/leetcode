package completed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Problem2225 {

  public List<List<Integer>> findWinners(int[][] matches) {
    java.util.Map<Integer, Integer> loseCount = new HashMap<>();
    java.util.Set<Integer> player = new java.util.TreeSet<>();
    for(int i = 0; i< matches.length; i++) {
      int winner = matches[i][0];
      int loser = matches[i][1];
      player.add(winner);
      player.add(loser);
      int preLoseCount = loseCount.getOrDefault(loser, 0);
      loseCount.put(loser, preLoseCount+1);
    }

    List<Integer> notlose = new ArrayList<>();
    List<Integer> loseone = new ArrayList<>();
    for(Integer i : player) {
      if (!loseCount.containsKey(i)) {
        notlose.add(i);
      } else if (loseCount.get(i)==1) {
        loseone.add(i);
      }
    }

    return Arrays.asList(new List[]{notlose, loseone});
  }

  public static void main(String[]args) {
    Problem2225 instance = new Problem2225();
    List<List<Integer>> results = instance.findWinners(new int[][]{{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}});
    System.out.println();
  }


}
