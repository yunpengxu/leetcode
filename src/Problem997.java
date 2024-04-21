package completed;

import java.util.HashMap;
import java.util.HashSet;


public class Problem997 {
  public int findJudge(int n, int[][] trust) {
    if(trust.length==0) {
      return (n==1)? 1: -1;
    }
    java.util.Map<Integer, java.util.Set<Integer>> beTrustedMap = new HashMap<>();
    java.util.Map<Integer, java.util.Set<Integer>> trustedMap = new HashMap<>();
    for(int i =0;i < trust.length;i++) {
      java.util.Set<Integer> trusts = trustedMap.getOrDefault(trust[i][0], new HashSet<>());
      trusts.add(trust[i][1]);
      trustedMap.put(trust[i][0], trusts);
      java.util.Set<Integer> beTrusts = beTrustedMap.getOrDefault(trust[i][1], new HashSet<>());
      beTrusts.add(trust[i][0]);
      beTrustedMap.put(trust[i][1], beTrusts);
    }
    Integer judge = null;
    for(Integer i: beTrustedMap.keySet()) {
      if(beTrustedMap.get(i).size()== n-1) {
        if(judge != null) {
          return -1;
        }
        judge = i;
      }
    }
    if(judge == null || trustedMap.containsKey(judge)) {
      return -1;
    }
    return judge;
  }

  public static void main(String[] args) {
    Problem997 instance = new Problem997();
    instance.findJudge(2, new int[][]{{1, 2}});
    instance.findJudge(3, new int[][]{{1,3},{2,3}});
    instance.findJudge(3, new int[][]{{1,3},{2,3},{3,1}});
  }
}
