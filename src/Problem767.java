package completed;

import java.util.*;
public class Problem767 {
  public String reorganizeString(String s) {
    Map<Character, Integer> countMap = new HashMap<>();
    for(int i=0;i< s.length();i++) {
      int existingCount = countMap.getOrDefault(s.charAt(i), 0);
      countMap.put(s.charAt(i), 1+ existingCount);
    }
    PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o2[1] - o1[1];
      }
    });
    for(Character ch: countMap.keySet()) {
      queue.add(new int[]{ch-'a', countMap.get(ch)});
    }
    StringBuffer sb = new StringBuffer();
    while(!queue.isEmpty()) {
      int[] top = queue.poll();
      sb.append((char)(top[0]+'a'));
      if(queue.isEmpty()) {
        if(top[1] > 1) {
          return "";
        } else {
          return sb.toString();
        }
      }
      int[] second = queue.poll();
      sb.append((char)(second[0]+'a'));
      if(top[1] >1) {
        queue.offer(new int[]{top[0], top[1]-1});
      }
      if(second[1] >1) {
        queue.offer(new int[]{second[0], second[1]-1});
      }
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    Problem767 instance = new Problem767();
    System.out.println(instance.reorganizeString("aab"));
    System.out.println(instance.reorganizeString("aaab"));
  }
}
