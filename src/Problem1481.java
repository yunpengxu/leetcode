package completed;

import java.util.*;

public class Problem1481 {
  public int findLeastNumOfUniqueInts(int[] arr, int k) {
    Map<Integer, Integer> countMap = new HashMap<>();
    for(int i =0; i< arr.length;i++) {
      countMap.put(arr[i], countMap.getOrDefault(arr[i], 0)+1);
    }
    PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[1]-o2[1];
      }
    });
    for(Integer key: countMap.keySet()) {
      queue.offer(new int[] {key, countMap.get(key)});
    }
    int removedNum = 0, removedCount =0;
    while(!queue.isEmpty() && removedCount <k) {
      int[] polled = queue.poll();
      if(removedCount+polled[1] > k) {
        break;
      }
      removedNum++;
      removedCount+= polled[1];
    }
    return countMap.size() - removedNum;
  }

  public static void main(String[] args) {
    Problem1481 instance = new Problem1481();
    instance.findLeastNumOfUniqueInts(new int[]{5, 5, 4}, 1);
    instance.findLeastNumOfUniqueInts(new int[]{4,3,1,1,3,3,2}, 3);
  }

}
