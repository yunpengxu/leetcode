import java.util.ArrayList;
import java.util.TreeMap;


/**
 * https://leetcode.com/problems/next-greater-element-ii/
 * first, find the max value of the array, use the next number as the start.
 * maintain a tree map, whose key is a number, value is the positions of the number.
 * e.g., if the array is [5, 5, 4, 3, 3]
 * 3 -> 3, 4
 * 4 -> 2
 * 5 -> 0, 1
 * Upon reading a new number, suppose it is 5 again, then find the floorKeys of 5, which are 3 and 4,
 * set the next greater numbers to 5 for all their list numbers, i.e., 2, 3, 4.
 * at this time, the output is [, , 5, 5, 5, ]
 * finally, iterate the output and set everything else to -1, [-1, -1, 5, 5, 5, -1]
 */
public class P0503NextGreaterElementII {
  public int[] nextGreaterElements(int[] nums) {
    int sz = nums.length;
    int[] output = new int[sz];
    if (sz ==0) {
      return nums;
    }
    else if (sz == 1) {
      output[0] = -1;
    } else {
      int max = nums[0];
      int maxIndex = 0;
      for(int i = 0; i< sz; i++) {
        if (nums[i] > max) {
          maxIndex = i;
          max = nums[i];
        }
        output[i] = -1;
      }

      java.util.TreeMap<Integer, java.util.List<Integer>> map = new TreeMap<>();
      int startIndex = (maxIndex + 1) % sz;
      for (int i = 0; i < sz; i++) {
        int curIndex = (i + startIndex) % sz;
        int curValue = nums[curIndex];
        if (!map.containsKey(curValue)) {
          map.put(curValue, new ArrayList<>());
        }
        java.util.List<Integer> curList = map.get(curValue);
        curList.add(curIndex);

        Integer smallerKey = map.floorKey(curValue -1);
        while (smallerKey != null) {
          java.util.List<Integer> smallerList = map.get(smallerKey);
          for (Integer smallerIndex: smallerList) {
            output[smallerIndex] = curValue;
          }
          map.remove(smallerKey);
          smallerKey = map.floorKey(smallerKey -1);
        }
      }
    }

    return output;
  }

  public static void main(String[] args) {
    P0503NextGreaterElementII instance = new P0503NextGreaterElementII();
    int[]output = instance.nextGreaterElements(new int[]{5, 5, 4, 3, 3, 5});
    for(int i =0; i < output.length; i++) {
      System.out.print(output[i] + ", ");
    }
  }
}
