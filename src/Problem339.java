package completed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem339 {

    public static class NestedInteger {

      Integer singleInteger = null;
      Boolean isInteger = null;
      java.util.List<NestedInteger> niList = new ArrayList<>();
       // Constructor initializes an empty nested list.

           public NestedInteger() {
           }

           // Constructor initializes a single integer.
           public NestedInteger(int value) {
             isInteger = true;
             singleInteger = value;
           }

           // @return true if this NestedInteger holds a single integer, rather than a nested list.
           public boolean isInteger() {
             return isInteger;
           }

           // @return the single integer that this NestedInteger holds, if it holds a single integer
           // Return null if this NestedInteger holds a nested list
           public Integer getInteger() {
             if(isInteger()) {
               return singleInteger;
             }
             return null;
           }

           // Set this NestedInteger to hold a single integer.
           public void setInteger(int value) {
             isInteger = true;
             this.singleInteger = value;
           }

           // Set this NestedInteger to hold a nested list and adds a nested integer to it.
           public void add(NestedInteger ni) {
             isInteger = false;
             niList.add(ni);
           }

           // @return the nested list that this NestedInteger holds, if it holds a nested list
           // Return empty list if this NestedInteger holds a single integer
           public List<NestedInteger> getList() {
             return niList;
           }
   }

  public int depthSum(List<NestedInteger> nestedList) {
    int total = 0;
    for(NestedInteger ni: nestedList) {
      total += getSum(ni, 1);
    }
    return total;
  }

  private int getSum(NestedInteger ni, int depth) {
      if(ni.isInteger()) {
        return depth * ni.getInteger();
      }
      List<NestedInteger> niList = ni.getList();
      int total = 0;
      for(NestedInteger item: niList) {
        total+= getSum(item, depth+1);
      }
      return total;
  }

  public static void main(String[] args) {
      Problem339 instance = new Problem339();
      NestedInteger n1 = new NestedInteger(1);
      NestedInteger n11 = new NestedInteger();
      n11.add(n1);
      n11.add(n1);
      NestedInteger n = new NestedInteger();
      n.add(n11);
      n.add(n1);
      n.add(n11);
      instance.depthSum(Arrays.asList(new NestedInteger[]{n}));
  }
}
