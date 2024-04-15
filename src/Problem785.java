package completed;

import java.util.HashMap;
import java.util.HashSet;


public class Problem785 {
  public boolean isBipartite(int[][] graph) {
    java.util.Set<Integer> visited = new HashSet<>();
    java.util.Map<Integer, Integer> assignments = new HashMap<>();
    for(int node =0; node< graph.length; node++) {
      if (!visited.contains(node)) {
        Boolean flag = helper(node, visited, assignments, graph, 1);
        if(!flag) {
          return false;
        }
      }
    }
    return true;
  }

  private Boolean helper(Integer node, java.util.Set<Integer> visited, java.util.Map<Integer, Integer> assignments, int[][] graph , int preAssignment) {
    visited.add(node);
    int curAssignment = preAssignment ==1? 2: 1;
    assignments.put(node, curAssignment);
    for(Integer connected: graph[node]) {
      if(!visited.contains(connected)) {
        Boolean flag = helper(connected, visited, assignments, graph, curAssignment);
        if (!flag) {
          return false;
        }
      } else {
        if(assignments.get(connected).equals(curAssignment)) {
          return false;
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
    Problem785 instance = new Problem785();
    instance.isBipartite(new int[][]{{1,2,3},{0,2},{0,1,3},{0,2}});
//    instance.isBipartite(new int[][]{{1,3},{0,2},{1,3},{0,2}});
  }

}
