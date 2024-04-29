package completed;

import java.util.HashMap;


public class Problem266 {

  public boolean canPermutePalindrome(String s) {
    char[] chars = s.toCharArray();
    int len = chars.length;
    java.util.Map<Character, Integer> countMap= new HashMap<>();
    for(int i =0; i< len; i++) {
      int count = countMap.getOrDefault(chars[i], 0);
      countMap.put(chars[i], count+1);
    }
    int oddNum = 0;
    for(Character key: countMap.keySet()) {
      int val = countMap.get(key);
      if (val %2 ==1) {
        oddNum++;
      }
      if(oddNum > 1) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    Problem266 instance = new Problem266();
    System.out.println(instance.canPermutePalindrome("code"));
    System.out.println(instance.canPermutePalindrome("aab"));
    System.out.println(instance.canPermutePalindrome("carerac"));
  }
}
