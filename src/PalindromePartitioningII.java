
/**
 * https://leetcode.com/problems/palindrome-partitioning-ii/
 * @author yunpeng
 *
 */
public class PalindromePartitioningII {
	public int minCut(String s) {
        int len = s.length();
		if (len < 2) {
			return 0;
		}
		char[] str = s.toCharArray();
		int[] cuts = new int[len];
		for (int i = 0; i < len; i++) {
			cuts[i] = i;
		}
		for (int i = 1; i < len; i++) {
			for (int j = 1; i - j >= 0 && i + j < len
					&& str[i - j] == str[i + j]; j++) { // odd case;
				if (i - j == 0) {
					cuts[i + j] = 0;
				} else if (cuts[i + j] > cuts[i - j - 1] + 1) {
					cuts[i + j] = cuts[i - j -1] + 1;
				}
			}
			for (int j = 1; i - j >= 0 && i + j -1 < len
					&& str[i - j] == str[i + j - 1]; j++) { // even case;
				if (i - j == 0) {
					cuts[i + j - 1] = 0;
				} else if (cuts[i + j - 1] > cuts[i - j - 1] + 1) {
					cuts[i + j - 1] = cuts[i - j - 1] + 1;
				}
			}

			for (int j = i + 1; j < len; j++) { // adjust the next;
				if (cuts[j] > cuts[j - 1] + 1) {
					cuts[j] = cuts[j - 1] + 1;
				}
			}
		}

		return cuts[len - 1];
    }
}
