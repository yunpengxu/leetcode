
/**
 * https://leetcode.com/problems/climbing-stairs/submissions/
 * @author yunpeng
 *
 */
public class P0070ClimbingStairs {
	public int climbStairs(int n) {
        if(n==1 || n==0)
        {
            return 1;
        }

        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 1;
        for(int i = 2; i < n; i++)
        {
        	arr[i] = arr[i -1] + arr[i -2];
        }


        return arr[n-1] + arr[n-2];
    }
}
