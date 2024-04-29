package completed;

import java.util.HashSet;


public class Problem824 {

  public String toGoatLatin(String sentence) {
    java.util.Set<Character> vowels = new HashSet<>();
    vowels.add('a');
    vowels.add('e');
    vowels.add('i');
    vowels.add('o');
    vowels.add('u');
    vowels.add('A');
    vowels.add('E');
    vowels.add('I');
    vowels.add('O');
    vowels.add('U');
    StringBuffer output = new StringBuffer();
    StringBuffer curword = new StringBuffer();
    StringBuffer aaa = new StringBuffer();
    int index =0;
    while(index < sentence.length()) {
      if(sentence.charAt(index) == ' ') {
        if(curword.length() >0) {
          aaa.append('a');
          if(vowels.contains(curword.charAt(0))) {
          } else {
            char firstLetter = curword.charAt(0);
            curword.delete(0, 1);
            curword.append(firstLetter);
          }

          curword.append("ma");
          curword.append(aaa);
          output.append(curword);
        }
        output.append(' ');
        curword.delete(0, curword.length());
      } else {
        curword.append(sentence.charAt(index));
      }
      index++;
    }
    if(curword.length() >0) {
      aaa.append('a');
      if(vowels.contains(curword.charAt(0))) {
      } else {
        char firstLetter = curword.charAt(0);
        curword.delete(0, 1);
        curword.append(firstLetter);
      }
      curword.append("ma");
      curword.append(aaa);
      output.append(curword);
    }
    return output.toString();
  }

  public static void main(String[] args) {
    Problem824 instance = new Problem824();
    System.out.println(instance.toGoatLatin("I speak Goat Latin"));
    System.out.println(instance.toGoatLatin("The quick brown fox jumped over the lazy dog"));
  }
}
