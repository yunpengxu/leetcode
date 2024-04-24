package completed;

import java.util.LinkedList;


public class Problem346 {

  static class MovingAverage {
    LinkedList<Integer> stack = new LinkedList<>();
    double total =0;
    int size  =0;
    public MovingAverage(int size) {
      this.size = size;
    }

    public double next(int val) {
      total += val;
      stack.add(val);
      if(stack.size() > size) {
        int first = stack.pollFirst();
        total -= first;
      }
      return total / stack.size();
    }
  }

  public static void main(String[] args) {
    MovingAverage instance = new MovingAverage(3);
    System.out.println(instance.next(1));
    System.out.println(instance.next(10));
    System.out.println(instance.next(3));
    System.out.println(instance.next(5));
  }
}
