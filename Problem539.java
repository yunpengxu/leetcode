package completed;

import java.util.*;
public class Problem539 {

  public int findMinDifference(List<String> timePoints) {
    List<Integer> time = new ArrayList<>();
    for(String t: timePoints) {
      String[] splits = t.split(":");
      int hour = conver2Num(splits[0]);
      int min = conver2Num(splits[1]);
      int minutes = hour *60+ min;
      time.add(minutes);
    }
    Collections.sort(time);
    int delta = Integer.MAX_VALUE;
    for(int i = 1; i< time.size();i++) {
      if(time.get(i) -time.get(i-1) < delta) {
        delta = time.get(i) -time.get(i-1);
      }
    }
    return Math.min(24*60+time.get(0)- time.get(time.size()-1), delta);
  }

  private int conver2Num(String str) {
    if(str.startsWith("0")) {
      if(str.equals("00")){
        return 0;
      }
      return Integer.valueOf(str.substring(1));
    } else{
      return Integer.valueOf(str);
    }
  }

  public static void main(String[] args) {
    Problem539 instance = new Problem539();
    System.out.print(instance.findMinDifference(Arrays.asList(new String[]{"23:59","00:00"})));
    System.out.println(instance.findMinDifference(Arrays.asList(new String[]{"00:00","23:59","00:00"})));
  }
}
