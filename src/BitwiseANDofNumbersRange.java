/**
 * https://leetcode.com/problems/bitwise-and-of-numbers-range/
 * @author yunpeng
 *
 */
public class BitwiseANDofNumbersRange {
	public int rangeBitwiseAnd(int m, int n) {
        int count = 0;
		while (m != n) {
			m >>= 1;
			n >>= 1;
			count++;
		}
		return n << count;
    }
}
