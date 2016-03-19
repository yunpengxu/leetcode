import java.util.*;

/**
 * https://leetcode.com/problems/4sum/
 * 
 * @author yunpeng
 * 
 */
public class The4Sum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		Set<List<Integer>> results = new HashSet<List<Integer>>();
		int len = nums.length;
		int[] arr = new int[len];
		System.arraycopy(nums, 0, arr, 0, len);
		Arrays.sort(arr);
		if (len > 0) {
			for (int i = 0; i < len - 3; i++) {
				int firstVal = arr[i];
				int target1 = target - firstVal;
				for (int j = i + 1; j < len - 2; j++) {
					int secondVal = arr[j];
					int target2 = target1 - secondVal;
					int third = j + 1, fourth = len - 1;
					while (third < fourth) {
						int thirdVal = arr[third];
						int fourthVal = arr[fourth];
						int tfSum = thirdVal + fourthVal;
						if (tfSum == target2) {
							List<Integer> curResult = new ArrayList<Integer>();
							curResult.add(firstVal);
							curResult.add(secondVal);
							curResult.add(thirdVal);
							curResult.add(fourthVal);
							results.add(curResult);
							third++;
							fourth--;
						} else if (tfSum < target2) {
							third++;
						} else {
							fourth--;
						}

					}

				}
			}
		}

		return new ArrayList<List<Integer>>(results);
	}
}
