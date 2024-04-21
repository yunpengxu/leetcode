package completed;

import java.util.ArrayList;
import java.util.List;


public class Problem364 {
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

  /**
   * Likely the test case is wrong, it failed on this case. [[1,1],2,[1,1],[[[[]]]]]
   * unless we add this in the getDepth method:
   * if(nestedIntegers.size()==0) {
   *       return 1;
   * }
   */
  public int depthSumInverse(List<NestedInteger> nestedList) {
    int depth = getDepth(nestedList);
    return getSum(depth, 1, nestedList);
  }

  int getSum(int maxDepth, int curDepth, List<NestedInteger> nestedList) {
    int weight = maxDepth - curDepth + 1 ;
    int total = 0;
    for(NestedInteger ni: nestedList) {
      if(ni.isInteger) {
        total += weight * ni.getInteger();
      } else {
        total += getSum(maxDepth, curDepth +1, ni.getList());
      }
    }
    return total;
  }

  private int getDepth(List<NestedInteger> nestedIntegers) {
    int depth = Integer.MIN_VALUE;
    if(nestedIntegers.size()==0) {
      return 1;
    }
    for(NestedInteger ni: nestedIntegers) {
      int curDepth = 0;
      if(!ni.isInteger()) {
        curDepth = getDepth(ni.getList());
      }
      if(curDepth> depth) {
        depth = curDepth;
      }
    }
    return depth+1;
  }

  public static void main(String[] args) {
    Problem364 instance = new Problem364();

    NestedInteger n1 = new NestedInteger(1);
    NestedInteger n11 = new NestedInteger();
    n11.add(n1);
    n11.add(n1);
    NestedInteger n = new NestedInteger();
    n.add(n11);
    n.add(new NestedInteger(2));
    n.add(n11);
    int result = instance.depthSumInverse(n.getList());
    System.out.println(result);
  }
}
