package completed;

import java.util.*;
public class Problem981 {

  static class TimeMap {
    Map<String, TreeMap<Integer, String>> valueMap = new HashMap<>();
    public TimeMap() {

    }

    public void set(String key, String value, int timestamp) {
      TreeMap<Integer, String> valmap = valueMap.getOrDefault(key, new TreeMap<Integer, String>());
      valmap.put(timestamp, value);
      valueMap.put(key, valmap);
    }

    public String get(String key, int timestamp) {
      if(valueMap.containsKey(key)) {
        TreeMap<Integer, String> valmap =valueMap.get(key);
        if(valmap.containsKey(timestamp)) {
          return valmap.get(timestamp);
        }
        if(valmap.firstKey() < timestamp) {
          return valmap.lowerEntry(timestamp).getValue();
        }
      }
      return "";
    }
  }

  public static void main(String[] args) {
    TimeMap instance = new TimeMap();
    instance.set("foo", "bar", 1);
    System.out.println(instance.get("foo", 1));
    System.out.println(instance.get("foo", 3));
    instance.set("foo", "bar2", 4);
    System.out.println(instance.get("foo", 4));
    System.out.println(instance.get("foo", 5));
  }
}
