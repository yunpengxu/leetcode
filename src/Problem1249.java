package completed;

import java.util.HashSet;


public class Problem1249 {

  public String minRemoveToMakeValid(String s) {
    java.util.Set<Integer> removeIndex = new HashSet<>();
    int count = 0;
    for(int i=0; i< s.length(); i++) {
      char c = s.charAt(i);
      if(c == '(') {
        count +=1;
      } else if(c == ')') {
        if(count <=0) {
          removeIndex.add(i);
        } else {
          count--;
        }
      }
    }
    count =0;
    for(int i=s.length()-1; i>=0; i--) {
      char c = s.charAt(i);
      if(c == ')') {
        count +=1;
      } else if(c == '(') {
        if(count <=0) {
          removeIndex.add(i);
        } else {
          count--;
        }
      }
    }
    StringBuffer sb = new StringBuffer();
    for(int i=0; i < s.length(); i++) {
      if(!removeIndex.contains(i)) {
        sb.append(s.charAt(i));
      }
    }
    return sb.toString();
  }


  public static void main(String[] args) {
    Problem1249 instance = new Problem1249();
    System.out.println(instance.minRemoveToMakeValid("lee(t(c)o)de)"));
    System.out.println(instance.minRemoveToMakeValid("a)b(c)d"));
    System.out.println(instance.minRemoveToMakeValid("))(("));
    System.out.println(instance.minRemoveToMakeValid("))((()))))))(())) (((((((((())(("));
  }
}
