package completed;

import java.util.Collections;
import java.util.HashMap;


public class Problem2260 {


  public int minimumCardPickup(int[] cards) {
    java.util.Map<Integer, Integer> lastIndexMap = new HashMap<>();
    java.util.Map<Integer, Integer> minIntervalMap = new HashMap<>();
    for(int i =0; i< cards.length; i++) {
      int curNum = cards[i];
      if(!lastIndexMap.containsKey(curNum)) {
        lastIndexMap.put(curNum, i);
        minIntervalMap.put(curNum, Integer.MAX_VALUE);
      } else {
        int lastIndex = lastIndexMap.get(curNum);
        int interval = i - lastIndex + 1;
        lastIndexMap.put(curNum, i);
        if(interval< minIntervalMap.get(curNum)) {
          minIntervalMap.put(curNum, interval);
        }
      }
    }
    int minInterval = Collections.min(minIntervalMap.values());
    if (minInterval == Integer.MAX_VALUE) {
      return -1;
    }
    return minInterval;
  }



}
