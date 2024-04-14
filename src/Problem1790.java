package completed;

public class Problem1790 {

  public boolean areAlmostEqual(String s1, String s2) {
    if(s1.length() != s2.length() ) {
      return false;
    }
    if(s1.equals(s2)) {
      return true;
    }

    int first =0, last = s1.length()-1;
    while(first < s1.length()) {
      if(s1.charAt(first) != s2.charAt(first)) {
        break;
      }
      first++;
    }
    while(last >first) {
      if(s1.charAt(last) != s2.charAt(last)) {
        break;
      }
      last --;
    }

    if(first == last || !(s1.charAt(first) == s2.charAt(last) && s1.charAt(last) == s2.charAt(first))) {
      return false;
    }
    first++;
    while(first < last) {
      if(s1.charAt(first) != s2.charAt(first)) {
        return false;
      }
      first++;
    }
    return true;
  }
//
//  private TreeMap<Character, Integer> getCountMap(String s) {
//    TreeMap<Character, Integer> countMap = new TreeMap<>();
//    for(Character c: s.toCharArray()) {
//      countMap.put(c, countMap.getOrDefault(c, 0)+1);
//    }
//    return countMap;
//  }

  public static void main(String[] args) {
    Problem1790 instance = new Problem1790();
    System.out.println(instance.areAlmostEqual("attack", "defend"));
  }
}
