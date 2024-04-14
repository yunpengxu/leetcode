package completed;

public class Problem2108 {

  public String firstPalindrome(String[] words) {
    String result = "";
    for(String str: words) {
      String reverse = new StringBuffer().append(str).reverse().toString();
      if(str.equals(reverse)) {
        result = str;
        break;
      }
    }
    return result;
  }
}
