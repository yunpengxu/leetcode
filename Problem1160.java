package completed;

import java.util.*;
public class Problem1160 {

  public int countCharacters(String[] words, String chars) {
    Map<Character, Integer> template = getCount(chars);
    int total =0;
    for(String s: words) {
      Map<Character, Integer> curCount = getCount(s);
      Boolean isGood = true;
      for(Character c: curCount.keySet()) {
        if(!template.containsKey(c) || template.get(c) < curCount.get(c)) {
          isGood = false;
        }
      }
      if(isGood) {
        total += s.length();
      }
    }
    return total;
  }

  private Map<Character, Integer> getCount(String s) {
    Map<Character, Integer> map = new HashMap<>();
    for(Character c: s.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0)+1);
    }
    return map;
  }

  public static void main(String[] args) {
    Problem1160 instance = new Problem1160();
    instance.countCharacters(new String[]{"cat","bt","hat","tree"}, "atach");
    instance.countCharacters(new String[]{"hello","world","leetcode"}, "welldonehoneyr");
  }
}
