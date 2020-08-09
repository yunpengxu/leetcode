import java.util.*;

/**
 * https://leetcode.com/problems/combinations/
 * @author yunpeng
 *
 */
public class P0077Combinations {
	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
		if (k == 1) {
			for (int i = 1; i <= n; i++) {
				List<Integer> lst = new LinkedList<Integer>();
				lst.add(i);
				results.add(lst);
			}
		} else {
			for(int i = n; i>=k; i--) {
				List<List<Integer>> recResults = combine(i-1, k-1);
				for(List<Integer> lst : recResults) {
					lst.add(lst.size(), i);
					results.add(lst);
				}
			}
		}

		return results;
    }
}
