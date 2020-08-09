import java.util.*;

/**
 * https://leetcode.com/problems/3sum/
 * @author yunpeng
 *
 */
public class P0015The3Sum {
	public List<List<Integer>> threeSum(int[] nums) {
		int len = nums.length;
		int[] arr = new int[len];
		System.arraycopy(nums, 0, arr, 0, len);
		Arrays.sort(arr);
		Set<List<Integer>> results = new HashSet<List<Integer>>();
		if (len >= 3) {
			for (int i = 0; i < len; i++) {
				int curVal = arr[i];
				int target = 0 - curVal;
				int first = i + 1, last = len - 1;
				while (first < last) {
					int firstVal = arr[first], lastVal = arr[last];
					int flSum = firstVal + lastVal;
					if (flSum == target) {
						List<Integer> curResult = new ArrayList<Integer>();
						if (i < first) {
							curResult.add(curVal);
							curResult.add(firstVal);
							curResult.add(lastVal);
						} else if (i < last) {
							curResult.add(firstVal);
							curResult.add(curVal);
							curResult.add(lastVal);
						} else {
							curResult.add(firstVal);
							curResult.add(lastVal);
							curResult.add(curVal);
						}
						results.add(curResult);
						first++;
						last--;
					} else if (flSum < target) {
						first++;
					} else {
						last--;
					}
				}
			}
		}
		return new ArrayList<List<Integer>>(results);
	}
}
