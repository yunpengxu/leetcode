package completed;

import java.util.HashMap;
import java.util.HashSet;


public class Problem791 {

  public String customSortString(String order, String s) {
    java.util.Map<Character, Integer> count = new HashMap<>();
    StringBuffer sb = new StringBuffer();
    java.util.Set<Character> vocab = new HashSet<>();
    for(int i =0; i< order.length();i++) {
      vocab.add(order.charAt(i));
    }
    for(int i =0; i< s.length();i++) {
      Character curChar = s.charAt(i);
      if (vocab.contains(curChar)) {
        if (!count.containsKey(curChar)) {
          count.put(curChar, 0);
        }
        count.put(curChar, count.get(curChar) + 1);
      } else {
        sb.append(curChar);
      }
    }
    String appendex = sb.toString();
    sb = new StringBuffer();
    for(Character curChar : order.toCharArray()) {
      if (count.containsKey(curChar)) {
        for(int i=0; i< count.get(curChar); i++) {
          sb.append(curChar);
        }
      }
    }
    return sb.toString()+ appendex;
  }

  public static void main(String[] args) {
    Problem791 instance = new Problem791();
    instance.customSortString("cbafg", "abcd");
  }

}
