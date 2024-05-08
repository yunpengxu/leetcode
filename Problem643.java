package completed;

import java.util.*;
public class Problem643 {

  public double findMaxAverage(int[] nums, int k) {
    LinkedList<Integer> queue = new LinkedList<>();
    double total = 0;
    double max = Integer.MIN_VALUE;
    for(int n: nums) {
      total+= n;
      queue.add(n);
      if(queue.size()== k+1) {
        int tail = queue.poll();
        total -=tail;
      }
      if(queue.size()==k) {
        double val = total/k;
        if(val > max) {
          max = val;
        }
      }
    }
    return max;
  }

  public static void main(String[] args) {
    Problem643 instance = new Problem643();
//    instance.findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4);
//    instance.findMaxAverage(new int[]{5}, 1);
    instance.findMaxAverage(new int[]{-1}, 1);
  }
}
