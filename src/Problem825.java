package completed;

import java.util.TreeMap;


public class Problem825 {

  public int numFriendRequests(int[] ages) {
    TreeMap<Integer, Integer> ageCount = new TreeMap<>();
    for(int a: ages) {
      if(!ageCount.containsKey(a)) {
        ageCount.put(a, 0);
      }
      ageCount.put(a, ageCount.get(a)+1);
    }
    TreeMap<Integer, Integer> accAgeCount = new TreeMap<>();
    int totalCount = 0;
    for(int a: ageCount.keySet()) {
      accAgeCount.put(a, ageCount.get(a) + totalCount);
      totalCount = accAgeCount.get(a);
    }
    accAgeCount.put(-1, 0);
    int totalRequests = 0;
    for(int a: ageCount.keySet()) {
      int minAge = a/2+8, maxAge = a;
      if (maxAge>=minAge){
        int startCount = accAgeCount.containsKey(minAge)? accAgeCount.get(accAgeCount.floorKey(minAge-1)): accAgeCount.get(accAgeCount.floorKey(minAge));
        int endCount = accAgeCount.get(accAgeCount.floorKey(maxAge));
        totalRequests += (endCount-startCount-1) * ageCount.get(a);
      }
    }
    return  totalRequests;
  }

  public static void main(String[]args){
    Problem825 instance = new Problem825();
    instance.numFriendRequests(new int[]{20,30,100,110,120});
  }
}
