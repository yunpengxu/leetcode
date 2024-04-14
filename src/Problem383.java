package completed;

import java.util.HashMap;
import java.util.Map;


public class Problem383 {

  public boolean canConstruct(String ransomNote, String magazine) {
    Map<Character, Integer> countMap = new HashMap<>();
    for (char c : magazine.toCharArray()) {
      if (!countMap.containsKey(c)) {
        countMap.put(c, 1);
      } else {
        countMap.put(c, countMap.get(c) + 1);
      }
    }
    for (char c : ransomNote.toCharArray()) {
      if(!countMap.containsKey(c) || countMap.get(c) <=0) {
        return false;
      } else {
        countMap.put(c, countMap.get(c)-1);
      }
    }

    return true;
  }

  public static void main(String[] args) {
    Problem383 instance = new Problem383();
    System.out.println(instance.canConstruct("aa", "ab"));
  }

}
