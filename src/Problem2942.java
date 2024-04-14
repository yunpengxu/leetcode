package completed;

import java.util.ArrayList;


public class Problem2942 {
  public java.util.List<Integer> findWordsContaining(String[] words, char x) {
    java.util.List<Integer> results = new ArrayList<>();
    String c = String.valueOf(x);
    for(int i =0 ; i< words.length; i++) {
      String str= words[i];
      if (str.contains(c)) {
        results.add(i);
      }
    }
    return results;
  }

}
