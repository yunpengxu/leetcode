package completed;

import java.util.TreeMap;


public class Problem933 {
  private java.util.TreeMap<Integer, Integer> countMap = new TreeMap<>();

  /**
   * Similar to problem 362
   */
  public Problem933() {
    countMap.put(0, 0);
  }

  public int ping(int t) {
    int prevKey = countMap.floorKey(t);
    int preCount =countMap.get(prevKey);
    int curCount = preCount+1;
    countMap.put(t, curCount);

    int preStartstamp = (t>3000)? t - 3000 : 0;
    int preStartCount = (countMap.containsKey(preStartstamp))? countMap.get(preStartstamp): countMap.floorEntry(preStartstamp).getValue();
    int deltaCount = curCount - preStartCount;
    // edge case: if preStart happens to have a ping, then add one
    int preExactStart = t-3000;
    if (countMap.containsKey(preExactStart) && countMap.get(preExactStart)!=0) {
      deltaCount +=1;
    }
    return deltaCount;
  }

  public static void main(String[] args) {
    Problem933 instance = new Problem933();
    System.out.println(instance.ping(1));
    System.out.println(instance.ping(100));
    System.out.println(instance.ping(3001));
    System.out.println(instance.ping(3002));
  }
}
