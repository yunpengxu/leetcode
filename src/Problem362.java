package completed;

import java.util.TreeMap;


public class Problem362 {

  private java.util.TreeMap<Integer, Integer> countMap = new TreeMap<>();

  public Problem362() {
    countMap.put(0, 0);
  }

  public void hit(int timestamp) {
    int prevKey = countMap.floorKey(timestamp);
    int preCount =countMap.get(prevKey);
    countMap.put(timestamp, preCount+1);
  }

  public int getHits(int timestamp) {
    int curCount = countMap.containsKey(timestamp)? countMap.get(timestamp) : countMap.floorEntry(timestamp).getValue();
    int preTimestamp = (timestamp>300)?timestamp - 300 : 0;
    int preCount = (countMap.containsKey(preTimestamp))? countMap.get(preTimestamp): countMap.floorEntry(preTimestamp).getValue();
    return curCount - preCount;
  }

  public static void main(String[]args) {
    Problem362 hitCounter = new Problem362();
    hitCounter.hit(1);       // hit at timestamp 1.
    hitCounter.hit(2);       // hit at timestamp 2.
    hitCounter.hit(3);       // hit at timestamp 3.
    System.out.println(hitCounter.getHits(4));   // get hits at timestamp 4, return 3.
    hitCounter.hit(300);     // hit at timestamp 300.
    System.out.println(hitCounter.getHits(300)); // get hits at timestamp 300, return 4.
    System.out.println(hitCounter.getHits(301)); // get hits at timestamp 301, return 3.
  }
}
