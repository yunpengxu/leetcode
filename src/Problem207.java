package completed;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;


public class Problem207 {

  public boolean canFinish(int numCourses, int[][] prerequisites) {
    java.util.Map<Integer, java.util.Set<Integer>> downstreamMap = new HashMap<>();
    java.util.Map<Integer, Integer> upstreamCountMap = new HashMap<>();
    for(int i =0; i < prerequisites.length; i++) {
      int precourse = prerequisites[i][1];
      int postcourse = prerequisites[i][0];

      if(!downstreamMap.containsKey(precourse)) {
        downstreamMap.put(precourse, new HashSet<>());
      }
      downstreamMap.get(precourse).add(postcourse);

      if(!upstreamCountMap.containsKey(postcourse)) {
        upstreamCountMap.put(postcourse, 0);
      }
      upstreamCountMap.put(postcourse, upstreamCountMap.get(postcourse) + 1);
    }

    java.util.LinkedList<Integer> queue = new LinkedList<>();
    for(int course =0; course< numCourses; course++) {
      if(!upstreamCountMap.containsKey(course)) {
        queue.add(course);
      }
    }

    int count = 0;
    while(!queue.isEmpty()) {
      Integer curcourse = queue.pop();
      count++;
      if (downstreamMap.containsKey(curcourse)) {
        java.util.Set<Integer> downstream = downstreamMap.get(curcourse);
        for(Integer downcourse: downstream) {
          int updatedCount = upstreamCountMap.get(downcourse) -1;
          upstreamCountMap.put(downcourse, updatedCount);
          if (updatedCount == 0) {
            queue.push(downcourse);
          }
        }
      }
    }

    return count == numCourses;
  }

  public static void main(String[] args) {
    Problem207 instance = new Problem207();
    System.out.println(instance.canFinish(2, new int[][]{{1, 0}, {0,1}}));
  }

}
