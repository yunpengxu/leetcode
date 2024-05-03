package completed;

import java.util.HashMap;


public class Problem246 {

  public boolean isStrobogrammatic(String num) {
    java.util.Map<Character, Character> letters = new HashMap<>();
    letters.put('0', '0');
    letters.put('1', '1');
    letters.put('6', '9');
    letters.put('8', '8');
    letters.put('9', '6');

    int first = 0, last = num.length() -1;
    while(first <= last) {
      Character fst = num.charAt(first);
      Character lst = num.charAt(last);
      if(!lst.equals(letters.get(fst))) {
        return false;
      }
      first++;
      last--;
    }
    return true;
  }

  public static void main(String[] args) {
    Problem246 instance = new Problem246();
    System.out.println(instance.isStrobogrammatic("69"));
    System.out.println(instance.isStrobogrammatic("88"));
    System.out.println(instance.isStrobogrammatic("962"));
  }
}
