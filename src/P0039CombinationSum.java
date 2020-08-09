import java.util.*;

/**
 * https://leetcode.com/problems/combination-sum/
 * @author yunpeng
 *
 */
public class P0039CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
 Set<List<Integer>> resSet = getCombSum(candidates, target);
 List<List<Integer>> res = new ArrayList<List<Integer>>();
 if (resSet != null)
 {
   for (List<Integer> lst : resSet)
   {
     res.add(lst);
   }
 }
 return res;
 }

   private Set<List<Integer>> getCombSum(int[] candidates, int target) {
 Set<List<Integer>> res = new HashSet<List<Integer>>();
 int len = candidates.length;
 if (len != 0)
 {
   if (target == 0)
   {
     List<Integer> curLst = new ArrayList<Integer>();
     res.add(curLst);
     return res;
   }

   if (len == 1)
   {
     if (target % candidates[0] != 0)
     {
       return null;
     }
     List<Integer> curLst = new ArrayList<Integer>();
     for (int i = 0; i < target / candidates[0]; i++)
     {
       curLst.add(candidates[0]);
     }
     res.add(curLst);
     return res;
   }
   else
   {
     int firstNum = candidates[0];
     if (firstNum > target)
     {
       return null;
     }

     int[] remaining = new int[len - 1];
     System.arraycopy(candidates, 1, remaining, 0, len - 1);
     Set<List<Integer>> with1Res = getCombSum(remaining, target - firstNum);
     Set<List<Integer>> witoutRes = getCombSum(remaining, target);
     Set<List<Integer>> withPlusRes = getCombSum(candidates, target - firstNum);

     if (with1Res != null)
     {
       for (List<Integer> lst : with1Res)
       {
         lst.add(firstNum);
         Collections.sort(lst);
         res.add(lst);
       }
     }
     if (withPlusRes != null)
     {
       for (List<Integer> lst : withPlusRes)
       {
         lst.add(firstNum);
         Collections.sort(lst);
         res.add(lst);
       }
     }
     if (witoutRes != null)
     {
       res.addAll(witoutRes);
     }
   }
 }
 return res;
}
}
