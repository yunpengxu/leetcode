package completed;

public class Problem557 {

  public String reverseWords(String s) {
    StringBuffer sb = new StringBuffer();
    StringBuffer output = new StringBuffer();
    for(int i = 0; i< s.length(); i++) {
      if(s.charAt(i) != ' ') {
        sb.append(s.charAt(i));
      }
      else {
        if(sb.length() >0) {
          output.append(sb.reverse());
          sb.delete(0, sb.length());
        }
        output.append(s.charAt(i));
      }
    }
    if(sb.length()>0){
      output.append(sb.reverse());
    }
    return output.toString();
  }

  public static void main(String[] args) {
    Problem557 instance = new Problem557();
    instance.reverseWords("Mr Ding");
  }
}
