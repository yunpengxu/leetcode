package completed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Problem249 {

  public List<List<String>> groupStrings(String[] strings) {
    Map<String, List<String>> map = new HashMap<>();
    for(String s: strings) {
      char[] chars = s.toCharArray();
      char preChar = chars[0];
      StringBuffer sb = new StringBuffer();
      for(int i=1; i < chars.length;i++) {
        int delta = chars[i] >= preChar? chars[i] - preChar: 26 - preChar + chars[i];
        sb.append(delta).append(":");
      }
      String key = sb.toString();
      List<String> strings4Key = map.getOrDefault(key, new ArrayList<>());
      strings4Key.add(s);
      map.put(key, strings4Key);
    }
    List<List<String>> results = new ArrayList<>();
    results.addAll(map.values());
    return results;
  }

  public static void main(String[] args) {
    Problem249 instance = new Problem249();
    instance.groupStrings(new String[] {"abc","bcd","acef","xyz","az","ba","a","z"});
    instance.groupStrings(new String[] {"a"});
  }
}
