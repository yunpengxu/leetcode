import java.util.*;

/**
 * https://leetcode.com/submissions/detail/25160313/
 * @author yunpeng
 *
 */
public class CombinationSumII {
	public List<List<Integer>> combinationSum2(int[] num, int target)
	  {
	    List<List<Integer>> results = new ArrayList<List<Integer>>();    
	    Arrays.sort(num);
	    Set<List<Integer>> res = combinationSum2Set(num, target);
	    if (res != null)
	    {
	      for (List<Integer> lst : res)
	      {
	        results.add(lst);
	      }
	    }
	    return results;
	  }

	  private Set<List<Integer>> combinationSum2Set(int[] num, int target) {
	    if(num.length == 0) {
	      return null;
	    }
	    
	    if(num.length == 1) {
	      if(num[0]==target) {
	        Set<List<Integer>> retVals = new HashSet<List<Integer>>();
	        List<Integer> vals = new ArrayList<Integer>();
	        vals.add(target);
	        retVals.add(vals);
	        return retVals;
	      }
	      return null;
	    }
	    
	    int len = num.length;
	    int firstNum = num[0];
	    if(firstNum > target) {
	      return null;
	    }
	    
	    int[] remaining = new int[num.length -1];
	    System.arraycopy(num, 1, remaining, 0, num.length -1);
	    Set<List<Integer>> withRes = combinationSum2Set(remaining, target - firstNum);
	    Set<List<Integer>> withoutRes = combinationSum2Set(remaining, target);
	    if(firstNum!= target &&withRes == null && withoutRes == null) {
	      return null;
	    }
	    Set<List<Integer>> results =  new HashSet<List<Integer>>();
	    if(firstNum == target) {
	      List<Integer> vals = new ArrayList<Integer>();
	      vals.add(firstNum);
	      results.add(vals);
	    }
	    if(withRes != null) {
	      for(List<Integer> lst : withRes) {
	        lst.add(firstNum);
	        Collections.sort(lst);
	        results.add(lst);
	      }      
	    }
	    
	    if(withoutRes != null) {
	      results.addAll(withoutRes);
	    }
	    
	    return results;
	  }
}
