package completed;

import java.util.Arrays;
import java.util.Comparator;
import java.util.*;


public class Problem826 {

  public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
    int[][] info = new int[difficulty.length][2];
    for(int i =0; i< difficulty.length; i++) {
      info[i][0] = difficulty[i];
      info[i][1] = profit[i];
    }
    Arrays.sort(info, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[0]-o2[0];
      }
    });
    Arrays.sort(worker);

    int total = 0;
    TreeMap<Integer, Integer> profitMap = new TreeMap<>();
    int max = 0;
    for(int i = 0; i < difficulty.length && info[i][0] <= worker[worker.length-1]; i++) {
      if(info[i][1] > max) {
        max = info[i][1];
      }
      profitMap.put(info[i][0], max);
    }
    if (profitMap.size()>0) {
      int leastKey = profitMap.firstKey();
      for(int i=0; i< worker.length;i++) {
        if(profitMap.containsKey(worker[i])) {
          total+= profitMap.get(worker[i]);
        } else {
          if(worker[i]> leastKey) {
            total+= profitMap.lowerEntry(worker[i]).getValue();
          }
        }

      }
    }
    return total;
  }

  public static void main(String[] args) {
    Problem826 instance = new Problem826();
//    instance.maxProfitAssignment(new int[]{2,4,6,8,10}, new int[]{10,20,30,40,50}, new int[]{4,5,6,7});
    instance.maxProfitAssignment(new int[]{85,47,57}, new int[]{24,66,99}, new int[]{40,25,25});
  }
}
