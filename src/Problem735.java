package completed;

import java.util.Stack;


public class Problem735 {

  public int[] asteroidCollision(int[] asteroids) {
    int index = 0;
    java.util.Stack<Integer> stack = new Stack<>();
    while(index < asteroids.length && asteroids[index] <0) {
      stack.add(asteroids[index++]);
    }
    while(index < asteroids.length) {
      if(asteroids[index] >0) {
        stack.add(asteroids[index]);
      } else {
        while(!stack.isEmpty() && stack.peek() >0 && (stack.peek()+ asteroids[index])<0) {
          stack.pop();
        }
        if(!stack.isEmpty()) {
          if(stack.peek()>0) {
            if(stack.peek() + asteroids[index] ==0) {
              stack.pop();
            }
          } else {
            stack.add(asteroids[index]);
          }
        } else {
          stack.add(asteroids[index]);
        }
      }
      index++;
    }
    int[] outputs = new int[stack.size()];
    for(int i =0; i< outputs.length; i++) {
      outputs[i] = stack.get(i);
    }
    return outputs;
  }

  public static void main(String[] args) {
    Problem735 instance = new Problem735();
    instance.asteroidCollision(new int[] {-5, -10, 5, 10, -5, -7, -10, 5, -3, 1});
  }
}
