package completed;

import java.util.*;
public class Problem380 {

  static class RandomizedSet {

    List<Integer> dataList = new ArrayList<>();
    Map<Integer, Integer> dataIdxMap = new HashMap<>();
    Random rand = new Random();
    public RandomizedSet() {

    }

    public boolean insert(int val) {
      if(dataIdxMap.containsKey(val)) {
        return false;
      }
      dataList.add(val);
      dataIdxMap.put(val, dataList.size()-1);
      return true;
    }

    public boolean remove(int val) {
      if(!dataIdxMap.containsKey(val)) {
        return false;
      }
      int dataIdx = dataIdxMap.get(val);
      int lastIdx = dataIdxMap.size() -1;
      int lastVal = dataList.get(lastIdx);
      if(dataIdx == lastIdx) {
        // only one record;
        dataIdxMap.remove(val);
        dataList.remove(lastIdx);
      } else {
        dataIdxMap.remove(val);
        dataIdxMap.put(lastVal, dataIdx);
        dataList.set(dataIdx, lastVal);
        dataList.remove(lastIdx);
      }
      return true;
    }

    public int getRandom() {
      int idx = rand.nextInt(dataList.size());
      return dataList.get(idx);
    }
  }

  public static void main(String[] args) {
    RandomizedSet instance = new RandomizedSet();
    instance.insert(1);
    instance.remove(2);
    instance.insert(2);
    System.out.println(instance.getRandom());
    instance.remove(1);
    instance.insert(2);
    System.out.println(instance.getRandom());
  }
}
