package completed;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;


public class Problem253 {

  static class Interval {
    int first, second;
    Interval(int f, int s) {
      first = f; second = s;
    }
  }

  public int minMeetingRooms(int[][] intervals) {
    java.util.List<Interval> inters = new ArrayList<>();
    for(int i=0; i< intervals.length;i++) {
      inters.add(new Interval(intervals[i][0],intervals[i][1]));
    }
    Collections.sort(inters, new Comparator<Interval>() {
      @Override
      public int compare(Interval o1, Interval o2) {
        return o1.first - o2.first;
      }
    });

    int curRoomNum = 0, maxRoomNum = 0;
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    for(Interval in: inters) {
      curRoomNum++;
      queue.offer(in.second);
      while(!queue.isEmpty()) {
        Integer top = queue.peek();
        if(top > in.first) {
          break;
        }
        queue.poll();
        curRoomNum--;
      }

      if(curRoomNum > maxRoomNum) {
        maxRoomNum = curRoomNum;
      }
    }
    return maxRoomNum;
  }

  public static void main(String[] args) {
    Problem253 instance = new Problem253();
    instance.minMeetingRooms(new int[][]{{0,30},{5,10},{15,20}});
    instance.minMeetingRooms(new int[][]{{7,10},{2,4}});
  }
}
