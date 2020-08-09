import java.util.*;

/**
 * https://leetcode.com/problems/add-digits/
 *
 * @author yunpeng
 *
 */
public class P0258AddDigits {
	public int addDigits(int num) {
		// Alternative, can use num%9 to calc.
		if (num < 10) {
			return num;
		}
		int sum = 0;
		while (num > 0) {
			sum += num % 10;
			num /= 10;
		}
		return addDigits(sum);
	}
}
