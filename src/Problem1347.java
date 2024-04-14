package completed;

import java.util.HashMap;
import java.util.HashSet;


public class Problem1347 {
  public int minSteps(String s, String t) {
    java.util.Map<Character, Integer> mapS = getCountMap(s), mapT = getCountMap(t);
    java.util.Set<Character> allChars = new HashSet<>();
    allChars.addAll(mapS.keySet());
    allChars.addAll(mapT.keySet());
    int sChars =0, tChars =0;
    for(Character character: allChars) {
      if(mapS.containsKey(character) && mapT.containsKey(character)) {
        if(mapS.get(character) > mapT.get(character)) {
          sChars+= mapS.get(character) - mapT.get(character);
        } else if(mapS.get(character) < mapT.get(character)) {
          tChars+= mapT.get(character) - mapS.get(character);
        }
      } else if(mapS.containsKey(character)) {
        sChars+= mapS.get(character);
      } else {
        tChars+= mapT.get(character);
      }
    }
    return Math.max(sChars, tChars);
  }

  private java.util.Map<Character, Integer> getCountMap(String s) {
    java.util.Map<Character, Integer> countMap = new HashMap<>();
    for(Character c: s.toCharArray()) {
      if(!countMap.containsKey(c)) {
        countMap.put(c, 0);
      }
      countMap.put(c, countMap.get(c) +1);
    }
    return countMap;
  }

  public static void main(String[] args) {
    Problem1347 instance = new Problem1347();
    instance.minSteps("anagram", "mangaar");
  }
}
