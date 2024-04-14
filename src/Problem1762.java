package completed;

import java.util.Stack;


public class Problem1762 {

  class StackElement {
    int index;
    int val;
    public StackElement(int index, int val) {
      this.val = val;
      this.index = index;
    }
  }

  public int[] findBuildings(int[] heights) {
    java.util.Stack<StackElement> stack = new Stack<>();
    if(heights.length>0) {
      stack.push(new StackElement(0, heights[0]));
    }

    for(int i =1; i< heights.length;i++) {
      while(!stack.empty()) {
        StackElement prev = stack.peek();
        if(prev.val <= heights[i]) {
          stack.pop();
        } else {
          break;
        }
      }
      stack.push(new StackElement(i, heights[i]));
    }
    int[] results = new int[stack.size()];
    for(int i=results.length-1; i>=0; i--) {
      results[i]= stack.pop().index;
    }
    return results;
  }
}
