/**
 * https://leetcode.com/problems/find-the-duplicate-number/
 *
 * @author yunpeng
 *
 */
public class P0287FindtheDuplicateNumber {

	public int findDuplicate(int[] nums) {
		int slow = 0, fast = 0;
		while (true) {
			slow = nums[slow];
			fast = nums[nums[fast]];
			if (fast == slow) {
				break;
			}
		}

		int org = 0;
		while (true) {
			org = nums[org];
			slow = nums[slow];
			if (org == slow) {
				return org;
			}
		}
	}
}
