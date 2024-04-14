package completed;

import java.util.Stack;


public class Problem1614 {
  public int maxDepth(String s) {
    java.util.Stack<Character> stack = new Stack<>();
    int maxDepth = 0;
    for(int i =0; i< s.length();i++) {
      Character curChar = s.charAt(i);
      if(curChar.equals('(')) {
        stack.push(curChar);
        int depth = stack.size();
        if (depth> maxDepth) {
          maxDepth = depth;
        }
      } else if (curChar.equals(')')) {
        stack.pop();
      }
    }
    return maxDepth;
  }

  public static void main(String[] args) {
    Problem1614 instance = new Problem1614();
    System.out.println(instance.maxDepth("(1+(2*3)+((8)/4))+1"));
  }
}
