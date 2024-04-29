package completed;

import java.util.HashMap;
import java.util.TreeSet;


public class Problem983 {

  public int mincostTickets(int[] days, int[] costs) {
    java.util.TreeSet<Integer> travelDays = new TreeSet<>();
    for(int d: days) {
      travelDays.add(d);
    }
    java.util.Map<Integer, Integer> map= new HashMap<>();
    return minCost(travelDays, costs, days[0], map);
  }

  private int minCost(java.util.TreeSet<Integer> travelDays, int[] costs, int startDay, java.util.Map<Integer, Integer> map) {
    if(map.containsKey(startDay)) {
      return map.get(startDay);
    }

    int highest = travelDays.last();
    if(startDay <= highest) {
      int costDay =  (startDay+1 <= highest)? costs[0] +  minCost(travelDays, costs, travelDays.higher(startDay), map): costs[0];
      int costWeek =  (startDay+7 <= highest)? costs[1] +  minCost(travelDays, costs, travelDays.higher(startDay+6), map): costs[1];
      int costMonth =  (startDay+30 <= highest)? costs[2] +  minCost(travelDays, costs, travelDays.higher(startDay+29), map): costs[2];
      int cost =  Math.min(costDay, Math.min(costWeek, costMonth));
      map.put(startDay, cost);
      return cost;
    }
    map.put(startDay, 0);
    return 0;
  }

  public static void main(String[] args) {
    Problem983 instance = new Problem983();
    System.out.println(instance.mincostTickets(new int[]{1,2,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,20,21,24,25,
        27,28,29,30,31,34,37,38,39,41,43,44,45,47,48,49,54,57,60,62,63,66,69,70,72,74,76,78,80,81,82,83,84,85,88,89,91,93,94,97,99}, new int[]{9,38,134}));
    System.out.println(instance.mincostTickets(new int[]{1,2,3,4,5,6,7,8,9,10,30,31}, new int[]{2, 7, 15}));
//    System.out.println(instance.mincostTickets(new int[]{1,2,3,4,5,6,7,8,9,10,30,31}, new int[]{2, 7, 15}));
//    System.out.println(instance.mincostTickets(new int[]{1,4,6,7,8,20}, new int[]{2, 7, 15}));
  }
}
