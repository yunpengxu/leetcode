package completed;

public class Problem1768 {

  public String mergeAlternately(String word1, String word2) {
    int i=0;
    StringBuffer sb = new StringBuffer();
    while(i< word1.length() && i < word2.length()) {
      sb.append(word1.charAt(i));
      sb.append(word2.charAt(i));
      i++;
    }
    if(i< word1.length()){
      sb.append(word1.substring(i));
    }
    if(i< word2.length()){
      sb.append(word2.substring(i));
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    Problem1768 instance = new Problem1768();
    System.out.println(instance.mergeAlternately("ab", "pqrs"));
  }
}
