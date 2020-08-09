/**
 * https://leetcode.com/problems/additive-number/
 *
 * @author yunpeng
 *
 */
public class P0306AdditiveNumber {
	public boolean isAdditiveNumber(String num) {
		int len = num.length();
		if (len < 3) {
			return false;
		}
		for (int i = 1; i <= (float) len / 2; i++) {
			String first = num.substring(0, i);
			for (int j = 1; 2 * i + j <= len && i + 2 * j <= len; j++) {
				String second = num.substring(i, i + j);
				if (isAddNumHelper(num, len, 0, first, second)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean isAddNumHelper(String num, int len, int index,
			String first, String second) {
		int fLen = first.length(), sLen = second.length();
		if (index + fLen == len) {
			return true;
		}
		String third = addStr(first, second);
		int tLen = third.length();
		if (index + fLen + sLen + tLen > len) {
			return false;
		}
		if (third.equals(num.substring(index + fLen + sLen, index + fLen + sLen
				+ tLen))) {
			if (index + fLen + sLen + tLen == len) {
				return true;
			}
			boolean flag = isAddNumHelper(num, len, index + fLen, second, third);
			if (flag) {
				return true;
			}
		}
		return false;
	}

	private String addStr(String first, String second) {
		int fLen = first.length(), sLen = second.length();
		StringBuffer sb = new StringBuffer();
		int carry = 0;
		for (int i = 0; i < fLen || i < sLen; i++) {
			int fVal = (i < fLen) ? first.charAt(fLen - 1 - i) - '0' : 0;
			int sVal = (i < sLen) ? second.charAt(sLen - 1 - i) - '0' : 0;
			int val = fVal + sVal + carry;
			if (val >= 10) {
				val -= 10;
				carry = 1;
			} else {
				carry = 0;
			}
			sb.append(val);
		}
		if (carry != 0) {
			sb.append(carry);
		}
		return sb.reverse().toString();
	}
}
