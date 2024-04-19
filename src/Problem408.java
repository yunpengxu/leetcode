package completed;

public class Problem408 {
  public boolean validWordAbbreviation(String word, String abbr) {
    int len1 = word.length(), len2=abbr.length();
    int index1 = 0, index2 = 0;
    while(index1< len1 && index2< len2) {
      char c1 = word.charAt(index1), c2 = abbr.charAt(index2);
      if(!isNumber(c2)) {
        if(c1 == c2) {
          index1++;
          index2++;
          continue;
        } else {
          return false;
        }
      } else { // c2 is a number;
        int total = c2-'0';
        if(total ==0) {
          return false;
        }
        while(index2+1<len2 &&isNumber(abbr.charAt(index2+1))) {
          total = total*10 + (abbr.charAt(index2+1) -'0');
          index2++;
        }
        if(total + index1 > len1) {
          return false;
        } else {
          index1+= total;
          index2++;
        }
      }
    }
    if (index1 <= len1-1 || index2<= len2-1) {
      return false;
    }
    return true;
  }

  private boolean isNumber(char c) {
    return c >='0' && c<='9';
  }

  public static void main(String[] args) {
    Problem408 instance = new Problem408();
    instance.validWordAbbreviation("internationalization", "i5a11o1");
    instance.validWordAbbreviation("internationalization", "i12iz4n");
    instance.validWordAbbreviation("apple", "a2e");
  }
}
