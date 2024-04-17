package completed;

public class Problem2109 {
  public String addSpaces(String s, int[] spaces) {
    StringBuffer sb = new StringBuffer();
    int first = 0, second = 0;
    for(int i=0;i< spaces.length;i++) {
      second = spaces[i];
      sb.append(s.substring(first, second));
      sb.append(" ");
      first = second;
    }
    sb.append(s.substring(second, s.length()));
    return  sb.toString();
  }

  public static void main(String[]args) {
    Problem2109 instance = new Problem2109();
    instance.addSpaces("LeetcodeHelpsMeLearn", new int[]{8,13,15});
    instance.addSpaces("icodeinpython", new int[]{1,5,7,9});
    instance.addSpaces("spacing", new int[]{0,1,2,3,4,5,6});

    instance.addSpaces("spacing", new int[]{});
  }
}
