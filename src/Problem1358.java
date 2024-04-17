package completed;

import java.util.HashMap;
import java.util.TreeSet;


public class Problem1358 {

  public int numberOfSubstrings(String s) {
    java.util.Map<Character, java.util.TreeSet<Integer>> posMap = new HashMap<>();
    posMap.put('a', new TreeSet<>());
    posMap.put('b', new TreeSet<>());
    posMap.put('c', new TreeSet<>());
    for(int i =0; i < s.length();i++) {
      Character c = s.charAt(i);
      posMap.get(c).add(i);
    }
    int total =0;
    for(int i= 0; i<s.length()-2; i++) {
      Character c = s.charAt(i);
      int posA = posMap.get('a').higher(i) == null? Integer.MAX_VALUE: posMap.get('a').higher(i);
      int posB = posMap.get('b').higher(i) == null? Integer.MAX_VALUE: posMap.get('b').higher(i);
      int posC = posMap.get('c').higher(i) == null? Integer.MAX_VALUE: posMap.get('c').higher(i);
      int higher =0;
      switch (c){
        case 'a': higher = Math.max(posB, posC);
        break;
        case 'b': higher = Math.max(posA, posC);
          break;
        case 'c': higher = Math.max(posB, posA);
          break;
      }
      if(higher <= s.length()-1) {
        total+= s.length() - higher;
      }
    }
    return total;
  }

  public static void main(String[] args) {
    Problem1358 instance = new Problem1358();
    instance.numberOfSubstrings("aaacb");
  }

}
