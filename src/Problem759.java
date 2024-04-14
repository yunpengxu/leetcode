package completed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Problem759 {

  static class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
      start = _start;
      end = _end;
    }
  }

  public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
    List<Interval> allIntervals = new ArrayList<>();
    for(List<Interval> intervals: schedule) {
      allIntervals.addAll(intervals);
    }

    Collections.sort(allIntervals, new Comparator<Interval>() {
      @Override
      public int compare(Interval o1, Interval o2) {
        return (o1.start != o2.start)? o1.start - o2.start : o1.end - o2.end;
      }
    });

    List<Interval> outputs = new ArrayList<>();
    Interval preInterval = allIntervals.get(0);
    for(int i=1; i< allIntervals.size(); i++) {
      Interval curInterval = allIntervals.get(i);
      if(preInterval.end < curInterval.start) {
        outputs.add(new Interval(preInterval.end, curInterval.start));
        preInterval = curInterval;
      } else {
        int newEnd = preInterval.end > curInterval.end? preInterval.end : curInterval.end;
        preInterval = new Interval(preInterval.start, newEnd);
      }
    }
    return outputs;
  }

  public static void main(String[] args) {
    Problem759 instance = new Problem759();
    List<List<Interval>> schedule = new ArrayList<>();
//    schedule.add(Arrays.asList(new Interval[]{new Interval(1, 3), new Interval(5, 6)}));
//    schedule.add(Arrays.asList(new Interval[]{new Interval(1, 3)}));
//    schedule.add(Arrays.asList(new Interval[]{new Interval(4, 10)}));
    schedule.add(Arrays.asList(new Interval[]{new Interval(1, 3), new Interval(6, 7)}));
    schedule.add(Arrays.asList(new Interval[]{new Interval(2, 4)}));
    schedule.add(Arrays.asList(new Interval[]{new Interval(2, 5), new Interval(9, 12)}));
    instance.employeeFreeTime(schedule);

  }
}
