package completed;

import java.util.HashMap;


public class Problem953 {


  public boolean isAlienSorted(String[] words, String order) {
    java.util.Map<Character, Integer> orderMap = new HashMap<>();
    for(int i=0; i< order.length();i++) {
      orderMap.put(order.charAt(i), i);
    }

    for(int i =1; i< words.length; i++) {
      String word1 = words[i-1];
      String word2 = words[i];
      if(!isSorted(word1, word2, orderMap)) {
        return false;
      }
    }
    return true;
  }

  private boolean isSorted(String word1, String word2, java.util.Map<Character, Integer> orderMap) {
    for(int i= 0; i< word1.length() && i< word2.length(); i++) {
      Character letter1 = word1.charAt(i), letter2 = word2.charAt(i);
      int order1 = orderMap.get(letter1), order2 = orderMap.get(letter2);
      if(order1 < order2) {
        return true;
      }
      if(order1> order2) {
        return false;
      }
    }
    if (word1.length()> word2.length()) {
      return false;
    }
    return true;
  }

  public static void main(String[] args) {
    Problem953 instance = new Problem953();
    System.out.println(instance.isAlienSorted(new String[]{"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
    System.out.println(instance.isAlienSorted(new String[]{"word","world","row"}, "worldabcefghijkmnpqstuvxyz"));
    System.out.println(instance.isAlienSorted(new String[]{"apple","app"}, "abcdefghijklmnopqrstuvwxyz"));
  }
}
