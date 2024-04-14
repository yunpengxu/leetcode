package completed;

import java.util.Stack;


// only remove duplicity of 2;
public class Problem1047 {

  public String removeDuplicates(String s) {
    java.util.Stack<Character> stack = new Stack<>();

    if (s.length() >0) {
      stack.push(s.charAt(0));
    }
    int i = 1;
    while(i < s.length()) {
      Character curChar = s.charAt(i);
      if (!stack.isEmpty()) {
        Character prevChar = stack.peek();
        if(prevChar.equals(curChar)) {
          stack.pop();
        } else {
          stack.push(curChar);
        }
      } else{
        stack.push(curChar);
      }

      i++;
    }

    StringBuffer sb = new StringBuffer();
    while (!stack.empty()){
      sb.append(stack.pop());
    }
    return sb.reverse().toString();
  }

//  // remove duplicity of 2+;
//  public String removeDuplicates(String s) {
//    java.util.Stack<Character> stack = new Stack<>();
//
//    if (s.length() >0) {
//      stack.push(s.charAt(0));
//    }
//    int i = 1;
//    while(i < s.length()) {
//      Boolean shouldPush = Boolean.TRUE;
//      while(i+1< s.length() && s.charAt(i)== s.charAt(i+1)) {
//        i++;
//        shouldPush = Boolean.FALSE;
//      }
//
//      Character curChar = s.charAt(i);
//      while (!stack.isEmpty()) {
//        Character prevChar = stack.peek();
//        if(prevChar.equals(curChar)) {
//          stack.pop();
//          shouldPush = Boolean.FALSE;
//        } else {
//          break;
//        }
//      }
//
//      if(shouldPush) {
//        stack.push(curChar);
//      }
//      i++;
//    }
//
//    StringBuffer sb = new StringBuffer();
//    while (!stack.empty()){
//      sb.append(stack.pop());
//    }
//    return sb.reverse().toString();
//  }

  public static void main(String[] args) {
    Problem1047 instance = new Problem1047();
    System.out.println(instance.removeDuplicates("azxxzy"));
  }
}
