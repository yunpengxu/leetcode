package completed;

import java.util.HashSet;


public class Problem2956 {

  public int[] findIntersectionValues(int[] nums1, int[] nums2) {
    java.util.Set<Integer> set1 = new HashSet<>();
    java.util.Set<Integer> set2 = new HashSet<>();
    for(int num: nums1) {
      set1.add(num);
    }
    for(int num: nums2) {
      set2.add(num);
    }
    int count1=0, count2 = 0;
    for(int num: nums1) {
      if(set2.contains(num)) {
        count1++;
      }
    }
    for(int num: nums2) {
      if(set1.contains(num)) {
        count2++;
      }
    }
    return new int[]{count1, count2};
  }

  public static void main(String[] args) {
    Problem2956 instance = new Problem2956();
    System.out.println(instance.findIntersectionValues(new int[]{4,3,2, 3, 1}, new int[]{2,2, 5,2, 3, 6}));
    System.out.println(instance.findIntersectionValues(new int[]{3,4, 2, 3}, new int[]{1, 5}));
  }

}
