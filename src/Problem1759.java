package completed;

import java.util.HashMap;
import java.util.Map;
public class Problem1759 {
  public int countHomogenous(String s) {
    Map<Integer, Integer> countMap = new HashMap<>();
    Character preChar = null;
    int curLen = 0;
    for(char c: s.toCharArray()) {
      if(preChar== null) {
        preChar = c;
        curLen = 1;
      } else {
        if(preChar.equals(c)) {
          curLen++;
        } else {
          countMap.put(curLen, countMap.getOrDefault(curLen, 0)+1);
          curLen=1;
          preChar = c;
        }
      }
    }
    if(preChar != null) {
      countMap.put(curLen, countMap.getOrDefault(curLen, 0)+1);
    }
    int total =0;
    for(int len: countMap.keySet()) {
      total += countMap.get(len) * helper(len);
    }
    return total;
  }

  private int helper(int n) {
    int total =0, t=n;
    int MOD = (int) 1e9+7;
    for(int i=0; i<n;i++) {
      total = (total + t) % MOD;
      t--;
    }
    return total;
  }

  public static void main(String[] args) {
    Problem1759 instance = new Problem1759();
    instance.countHomogenous("abbcccaa");
    instance.countHomogenous("xy");
    instance.countHomogenous("zzzzz");
  }


}
