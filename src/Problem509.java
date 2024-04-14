package completed;

import java.util.HashMap;


public class Problem509 {

  java.util.Map<Integer, Integer> results = new HashMap<>();

  public int fib(int n) {
    if(results.containsKey(n)) {
      return results.get(n);
    }
    if (n ==0) {
      results.put(0, 0);
      return results.get(0);
    }
    if (n ==1) {
      results.put(1, 1);
      return results.get(1);
    }
    int result = fib(n-1) + fib(n-2);
    results.put(n, result);
    return result;
  }

  public static void main(String[] args) {
    Problem509 instance = new Problem509();
    System.out.println(instance.fib(2));
    System.out.println(instance.fib(3));
    System.out.println(instance.fib(4));
    System.out.println(instance.fib(20));
  }
}
