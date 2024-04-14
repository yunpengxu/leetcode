package completed;

public class Problem278 {

  private boolean isBadVersion(int version) {
    return version > 1702766719;
  }

  public int firstBadVersion(int n) {
    int first = 1, last = n;
    while (first < last) {
      int mid = (int)(((long) first + (long)last) /2);
//      System.out.println(mid);

      if (isBadVersion(mid)) {
        last = mid;
      } else {
        first = mid +1;
      }
    }
    return first;
  }

  public static void main(String[] args) {
    Problem278 instance = new Problem278();
    System.out.println(instance.firstBadVersion(2126753390));
  }
}
