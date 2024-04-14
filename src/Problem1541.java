package completed;

public class Problem1541 {

  public int minInsertions(String s) {
    StringBuffer sb = new StringBuffer();
    int i =0;
    int numInsert = 0;
    while(i< s.length()) {
      char curChar = s.charAt(i);
      if(curChar == '(') {
        sb.append(curChar);
        i++;
      } else if (i +1 < s.length()){
        char nextChar = s.charAt(i+1);
        if (nextChar == '(') {
          numInsert++;
          sb.append(')');
          i++;

        } else {
          sb.append(')');
          i+=2;
        }
      } else {
        sb.append(')');
        numInsert++;
        break;
      }
    }

    String converted = sb.toString();
    int count = 0;
    for(int j=0; j< converted.length(); j++) {
      char curChar = converted.charAt(j);
      if (curChar == '(') {
        count++;
      } else {
        count--;
      }

      if(count <0) {
        numInsert++;
        count =0;
      }
    }
    numInsert+=2* count;

    return numInsert;
  }

  public static void main(String[] args) {
    Problem1541 instance = new Problem1541();
    instance.minInsertions("))())(");
  }
}
