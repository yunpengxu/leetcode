import java.util.*;

/**
 * https://leetcode.com/submissions/detail/46715279/
 * @author yunpeng
 */
public class The3SumClosest {
	public int threeSumClosest(int[] nums, int target) {
		int diff = Integer.MAX_VALUE, bestTotal = 0;
		int len = nums.length;
		if (len >= 3) {
			int[] arr = new int[len];
			System.arraycopy(nums, 0, arr, 0, len);
			Arrays.sort(arr);
			for (int first = 0; first < len - 2; first++) {
				int firstVal = arr[first];
				int miss = target - firstVal;
				int second = first + 1, third = len - 1;
				while (second < third) {
					int secondVal = arr[second];
					int thirdVal = arr[third];
					int stSum = secondVal + thirdVal;
					int curTotal = firstVal + stSum;
					int curDiff = Math.abs(target - curTotal);
					if (curDiff < diff) {
						diff = curDiff;
						bestTotal = curTotal;
						if (curDiff == 0) {
							return target;
						}
					}
					if (stSum < miss) {
						second++;
					} else {
						third--;
					}
				}
			}
		}

		return bestTotal;
	}
}
