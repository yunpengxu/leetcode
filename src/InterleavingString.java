import java.util.*;
/**
 * https://leetcode.com/problems/interleaving-string/
 * 
 * @author yunpeng
 *
 */
public class InterleavingString {
private Set<String> interleaveVisted = new HashSet<String>();
    
	public boolean isInterleave(String s1, String s2, String s3) {
		int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
		if ((len1 + len2) != len3) {
			return false;
		}

		if (len1 == 0) {
			return s2.equals(s3);
		}
		if (len2 == 0) {
			return s1.equals(s3);
		}

		return isInterleaveHelper(s1.toCharArray(), len1, 0, s2.toCharArray(),
				len2, 0, s3.toCharArray(), len3, 0);
	}

	private boolean isInterleaveHelper(char[] s1, int len1, int i1, char[] s2,
			int len2, int i2, char[] s3, int len3, int i3) {
		String hashCode = String.format("%d+%d", i1, i2);
		if(interleaveVisted.contains(hashCode)) {
			return false;
		}
		interleaveVisted.add(hashCode);
		
		if (i1 == len1) {
			if (len2 - i2 == len3 - i3) {
				if (len2 - i2 == 0) {
					return true;
				} else {
					for (int i = 0; i + i2 < len2; i++) {
						if (s2[i + i2] != s3[i + i3]) {
							return false;
						}
					}
					return true;
				}
			}
			return false;
		} else if (i2 == len2 ) {
			if (len1 - i1 == len3 - i3) {
				if (len1 - i1 == 0) {
					return true;
				} else {
					for (int i = 0; i + i1 < len1; i++) {
						if (s1[i + i1] != s3[i + i3]) {
							return false;
						}
					}
					return true;
				}
			}
			return false;
		} else {
			char c1 = s1[i1], c2 = s2[i2], c3 = s3[i3];
			if (c3 != c1 && c3 != c2) {
				return false;
			}
			if (c3 == c1 && c3 == c2) {
				return isInterleaveHelper(s1, len1, i1 + 1, s2, len2, i2, s3,
						len3, i3 + 1)
						|| isInterleaveHelper(s1, len1, i1, s2, len2, i2 + 1,
								s3, len3, i3 + 1);
			}
			if (c3 == c1) {
				return isInterleaveHelper(s1, len1, i1 + 1, s2, len2, i2, s3,
						len3, i3 + 1);
			}
			return isInterleaveHelper(s1, len1, i1, s2, len2, i2 + 1, s3, len3,
					i3 + 1);
		}
	}
}
