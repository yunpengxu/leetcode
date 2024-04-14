package completed;

import java.util.ArrayList;


public class Problem875 {

  public int minEatingSpeed(int[] piles, int h) {
    int len = piles.length;
    double total =0;
    int max = 0;
    for(int i =0;i < len; i++) {
      total+=piles[i];
      if (piles[i] >max) {
        max = piles[i];
      }
    }
    int avgspeed = (int) Math.ceil(total/h); // real speed needs to be faster than avg
    java.util.List<Integer> remaining = new ArrayList<>();
    for(int i =0;i < len; i++) {
      if(piles[i] > avgspeed) {
        remaining.add(piles[i]);
      }
    }
    int below = len - remaining.size();
    int timeBudget = h - below;
    int lowSpeed = avgspeed;
    int highspeed = max;
    while (lowSpeed < highspeed) {
      int midSpeed = (lowSpeed + highspeed) /2;
      int time = 0;
      for(Integer vol: remaining) {
        time +=Math.ceil((vol + 0.0) /midSpeed);
      }
      if (time > timeBudget) {
        lowSpeed = midSpeed +1 ;
      } else {
        highspeed = midSpeed;
      }
    }
    return  highspeed;
  }

  public static void main(String[] args) {
    Problem875 instance = new Problem875();
    instance.minEatingSpeed(new int[] {3,6,7,11}, 8);
    instance.minEatingSpeed(new int[] {30,11,23,4,20}, 5);
    instance.minEatingSpeed(new int[] {30,11,23,4,20}, 6);
  }
}
