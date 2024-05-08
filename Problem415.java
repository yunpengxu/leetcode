package completed;

public class Problem415 {
  public String addStrings(String num1, String num2) {
    StringBuffer sb = new StringBuffer();
    int carry =0;
    for(int i = 0; i< num1.length() || i < num2.length(); i++) {
      int first = (i< num1.length())? num1.charAt(num1.length()-1 -i) -'0': 0;
      int second = (i< num2.length())? num2.charAt(num2.length()-1-i) -'0':0;
      int sum = first + second + carry;
      char c = (char) ((sum % 10) + '0');
      sb.append(c);
      if(sum >=10) {
        carry = 1;
      } else {
        carry = 0;
      }
    }
    if (carry ==1) {
      sb.append('1');
    }
    return sb.reverse().toString();
  }

  public static void main(String[] args) {
    Problem415 instance = new Problem415();
    instance.addStrings("11", "123");
    instance.addStrings("456", "77");
    instance.addStrings("0", "0");
  }
}
