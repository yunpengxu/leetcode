import java.util.*;
/**
 * https://leetcode.com/submissions/detail/44193577/
 * @author yunpeng
 *
 */
public class P0216CombinationSumIII {
	public List<List<Integer>> combinationSum3(int k, int n) {
		Set<List<Integer>> results = combinationSumK(k, 1, n);
		if (results != null) {
			return new ArrayList<List<Integer>>(results);
		}
		return new ArrayList<List<Integer>>();
	}

	Set<List<Integer>> combinationSumK(int k, int first, int sum) {
		if (first > 9 || k <= 0 || first > sum) {
			return null;
		}

		Set<List<Integer>> results = new HashSet<List<Integer>>();
		if (k == 1) {
			if (sum <= 9 && sum >= first) {
				List<Integer> curLst = new ArrayList<Integer>();
				curLst.add(sum);
				results.add(curLst);
				return results;
			} else {
				return null;
			}
		}

		Set<List<Integer>> withoutRes = combinationSumK(k, first + 1, sum);
		if (withoutRes != null) {
			results.addAll(withoutRes);
		}
		Set<List<Integer>> withRes = combinationSumK(k - 1, first + 1, sum
				- first);
		if (withRes != null) {
			for (List<Integer> curLst : withRes) {
				List<Integer> curResLst = new ArrayList<Integer>();
				curResLst.add(first);
				curResLst.addAll(curLst);
				results.add(curResLst);
			}
		}

		return results.size() > 0 ? results : null;
	}
}
