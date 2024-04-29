package completed;

public class Problem2595 {
  public int[] evenOddBit(int n) {
    int odd = 0, even =0;
    int pos =0;
    while(n>0) {
      if(n%2 ==1) {
        if(pos%2==0) {
          even++;
        } else {
          odd++;
        }
      }
      n = n/2;
      pos++;
    }

    return new int[] {even, odd};
  }

  public static void main(String[] args) {
    Problem2595 instance = new Problem2595();
    instance.evenOddBit(17);
    instance.evenOddBit(2);
  }

}
