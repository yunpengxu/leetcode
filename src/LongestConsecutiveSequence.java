import java.util.*;

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 * 
 * @author yunpeng
 * 
 */
public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
		int len = nums.length;
		if (len < 2) {
			return len;
		}
		int maxCount = 1;
		Set<Integer> visited = new HashSet<Integer>();
		for (int i = 0; i < len; i++) {
			visited.add(nums[i]);
		}
		for (int i = 0; i < len; i++) {
			int val = nums[i];
			if (visited.remove(val)) {
				int sum = 1;
				for (int j = val - 1; visited.remove(j); j--) {
					sum++;
				}
				for (int j = val + 1; visited.remove(j); j++) {
					sum++;
				}
				if (sum > maxCount) {
					maxCount = sum;
				}
			}
		}
		return maxCount;
	}
}
