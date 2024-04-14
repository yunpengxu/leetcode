package completed;

public class Problem367 {

  public boolean isPerfectSquare(int num) {
    if(num == 1){
      return true;
    }
    int first = 1, last = num;
    while(first <= last) {
      int mid = (int)((long)first +(long)last)/2;
      if (mid > Math.sqrt(Integer.MAX_VALUE)) {
        last = (int)Math.sqrt(Integer.MAX_VALUE);
      } else {
        int test = mid*mid;
        if (test== num) {
          return true;
        } else if (test > num) {
          last = mid-1;
        } else {
          first = mid+1;
        }
      }
    }

    return false;
  }

  public static void main(String[] args) {
    Problem367 instance = new Problem367();
//    System.out.println(instance.isPerfectSquare(1));
//    System.out.println(instance.isPerfectSquare(16));
    System.out.println(instance.isPerfectSquare(100489));
  }

}
