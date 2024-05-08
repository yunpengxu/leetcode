package completed;

public class Problem1010 {

  public int numPairsDivisibleBy60(int[] time) {
    int total = 0;
    int[]mods = new int[60];
    for(int i=0;i< 60;i++) {
      mods[i]=0;
    }
    for(int i =0; i< time.length; i++) {
      int t = time[i];
      int m = t%60;
      if(m ==0) {
        total += mods[0]; // the way how it counts pairs is very elegant.
        mods[m]++;
      } else {
        total += mods[60 - m];
        mods[m]++;
      }
    }
    return total;
  }

  public static void main(String[] args) {
    Problem1010 instance = new Problem1010();
    System.out.println(instance.numPairsDivisibleBy60(new int[]{30,20,150,100,40}));
    System.out.println(instance.numPairsDivisibleBy60(new int[]{60,60,60}));
  }
}
