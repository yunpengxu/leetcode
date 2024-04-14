package completed;

import java.util.Stack;


public class Problem739 {

  class StackElement {
    int index;
    int val;
    public StackElement(int index, int val) {
      this.index = index;
      this.val = val;
    }
  }

  public int[] dailyTemperatures(int[] temperatures) {
    int[] results = new int[temperatures.length];
    java.util.Stack<StackElement> stack = new Stack<>();
    stack.push(new StackElement(0, temperatures[0]));
    for(int i=1; i < temperatures.length; i++) {
      if(temperatures[i-1] >= temperatures[i]) {
        stack.push(new StackElement(i, temperatures[i]));
      } else {
        StackElement prev = stack.peek();
        while(prev.val< temperatures[i]) {
          results[prev.index] = i - prev.index;
          stack.pop();
          if(stack.empty()) {
            break;
          }
          prev = stack.peek();
        }
        stack.push(new StackElement(i, temperatures[i]));
      }
    }

    while(!stack.empty()) {
      results[stack.pop().index]=0;
    }

    return results;
  }

  public static void main(String[] args) {
    Problem739 instance = new Problem739();
    int [] results = instance.dailyTemperatures(new int[]{30,40,50,60}) ;
    for(int i =0; i< results.length;i++) {
      System.out.print(results[i] + ", ");
    }
  }
}
