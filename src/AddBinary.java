import java.util.*;

/**
 * https://leetcode.com/problems/add-binary/
 * 
 * @author yunpeng
 * 
 */
public class AddBinary {
	public String addBinary(String a, String b) {
		char[] b1 = a.toCharArray();
		char[] b2 = b.toCharArray();

		StringBuilder sb = new StringBuilder();
		int i = b1.length - 1, j = b2.length - 1;
		boolean inc = false;
		while (i >= 0 || j >= 0) {
			int b1Val = (i >= 0) ? b1[i] - '0' : 0;
			int b2Val = (j >= 0) ? b2[j] - '0' : 0;
			int curVal = b1Val + b2Val + ((inc) ? 1 : 0);
			if (curVal <= 1) {
				inc = false;
				sb.append((char) (curVal + '0'));
			} else {
				inc = true;
				sb.append((char) (curVal - 2 + '0'));
			}
			i--;
			j--;
		}
		if (inc) {
			sb.append("1");
		}

		return sb.reverse().toString();
	}
}
