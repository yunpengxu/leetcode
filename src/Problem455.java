package completed;

import java.util.Arrays;


public class Problem455 {

  public int findContentChildren(int[] g, int[] s) {
    Arrays.sort(g);
    Arrays.sort(s);
    int count = 0;
    for (int i=0, j=0; i< g.length && j<s.length;) {
      if (g[i] <= s[j]) {
        i++;
        j++;
        count++;
      } else {
        j++;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    Problem455 instance = new Problem455();
    System.out.println(instance.findContentChildren(new int[]{1, 2,3 }, new int[] {1,1 }));
  }
}
