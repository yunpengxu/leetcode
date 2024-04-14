package completed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Problem486 {
  public boolean predictTheWinner(int[] nums) {
    int total =0;
    for(int d: nums){
      total+= d;
    }
    java.util.List<Integer> list = new ArrayList<>();
    Arrays.stream(nums).forEach(i ->list.add(i));
    int val = getMax(list, 0, nums.length-1, total);
    return (2*val >= total);
  }

  private int getMax(List<Integer> list, int startIndex, int endIndex, int total) {
    if(startIndex == endIndex) {
      return list.get(startIndex);
    }
    if(startIndex+1== endIndex) {
      return list.get(startIndex) >= list.get(endIndex)? list.get(startIndex): list.get(endIndex);
    }
    int takeFirst = total - getMax(list, startIndex+1, endIndex, total - list.get(startIndex));
    int takeLast = total - getMax(list, startIndex, endIndex-1, total - list.get(endIndex));
    return takeFirst>= takeLast? takeFirst: takeLast;
  }

  public static void main(String[] args) {
    Problem486 instance = new Problem486();
    instance.predictTheWinner(new int[]{1,5,233,7});
  }
}
