package completed;

import java.util.Arrays;
import java.util.List;

public class Problem412 {
  public List<String> fizzBuzz(int n) {
    String[]results = new String[n];
    for(int i=0;i< n;i++){
      if((i+1)%3==0 && (i+1)%5==0 ) {
        results[i] = "FizzBuzz";
      } else if ((i+1)%3==0) {
        results[i] = "Fizz";
      } else if ((i+1)%5==0) {
        results[i] = "Buzz";
      } else {
        results[i] = String.format("%d", i+1);
      }
    }

    return Arrays.asList(results);
  }

  public static void main(String[] args) {
    Problem412 instance = new Problem412();
    instance.fizzBuzz(15);
  }
}
