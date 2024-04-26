package completed;

public class Problem647 {

  public int countSubstrings(String s) {
    char[] chars = s.toCharArray();
    int len = chars.length;
    int count = 0;
    for(int i =0; i< len; i++) {
      count++;
      // check the case where chars[i] is the center;
      int first = i-1, last= i+1;
      while(first >=0 && last<len) {
        if(chars[first] == chars[last]) {
          count++;
          first--;
          last++;
        } else{
          break;
        }
      }
      // check the case where the center is between chars[i] and chars[i+1];
      if(i+1 < len &&chars[i] == chars[i+1]) {
        count++;
        first = i-1;
        last = i+2;
        while(first >=0 && last<len) {
          if(chars[first] == chars[last]) {
            count++;
            first--;
            last++;
          } else{
            break;
          }
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
    Problem647 instance = new Problem647();
    instance.countSubstrings("abc");
    instance.countSubstrings("aaa");
  }

}
