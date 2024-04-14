package completed;

public class Problem1662 {

  public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
    String pre1 = "", pre2 = "";
    int i = 0, j = 0;
    while(i< word1.length && j< word2.length) {
      if (pre1.equals("")) {
        pre1 = word1[i];
      }
      if (pre2.equals("")) {
        pre2 = word2[j];
      }
      if(pre1.length() == pre2.length()) {
        if(pre1.equals(pre2)) {
          i++;
          j++;
          pre1 = "";
          pre2 = "";
        } else {
          return  false;
        }
      } else if(pre1.startsWith(pre2)) {
        pre1 = pre1.substring(pre2.length());
        pre2 = "";
        j++;
      } else if (pre2.startsWith(pre1)) {
        pre2 = pre2.substring(pre1.length());
        pre1 = "";
        i++;
      } else {
        return false;
      }
    }
    return i==word1.length && j== word2.length;
  }

  public static void main(String[]args) {
    Problem1662 instance = new Problem1662();
    System.out.println(instance.arrayStringsAreEqual(new String[]{"abc", "d", "defg"}, new String[]{"abcddefg"}));
  }
}
