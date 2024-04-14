package completed;

import java.util.HashMap;


public class Problem2365 {

  // pay attention to off-by-one cases
  public long taskSchedulerII(int[] tasks, int space) {
    java.util.Map<Integer, Long> earliestDayMap = new HashMap<>();
    long day = 1;
    for(int i = 0; i < tasks.length; i++) {
      int curTask = tasks[i];
      if(!earliestDayMap.containsKey(curTask)) {
        earliestDayMap.put(curTask, day+ space+1);
        day ++;
      } else {
        long earliestDay = earliestDayMap.get(curTask);
        if(earliestDay <= day) {
          earliestDayMap.put(curTask, day+ space+1);
          day ++;
        } else {
          day = earliestDay;
          earliestDayMap.put(curTask, day+ space+1);
          day++;
        }
      }
    }
    return day-1;
  }

  public static void main(String[] args) {
    Problem2365 instance = new Problem2365();
    instance.taskSchedulerII(new int[]{1,2,1,2,3,1}, 3);
    instance.taskSchedulerII(new int[]{5, 8, 8, 5}, 2);
    System.out.println();
  }
}
