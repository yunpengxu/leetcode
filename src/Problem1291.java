package completed;

import java.util.*;
public class Problem1291 {

  public List<Integer> sequentialDigits(int low, int high) {
    String template = "123456789";
    String lowStr = String.format("%d", low), highStr = String.format("%d", high);
    List<Integer> results = new ArrayList<>();
    for(int len = lowStr.length(); len <= highStr.length(); len++) {
      for(int startIndex = 0; startIndex + len <= 9; startIndex++) {
        String substring = template.substring(startIndex, startIndex+len);
        int val = Integer.parseInt(substring);
        if(val >= low && val <= high) {
          results.add(val);
        }
      }
    }
    return results;
  }

  public static void main(String[] args) {
    Problem1291 instance = new Problem1291();
    instance.sequentialDigits(100, 300);
    instance.sequentialDigits(1000, 13000);
  }

}
