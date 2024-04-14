package completed;

public class Problem1344 {
  public double angleClock(int hour, int minutes) {
    double hourAngle = (hour + minutes / 60.0) * 30.0;
    double minAngle = minutes * 6;
    double angleDelta = Math.abs(hourAngle-minAngle);
    return (angleDelta> 180)? 360-angleDelta : angleDelta;
  }

  public static void main(String[] args) {
    Problem1344 instance = new Problem1344();
    System.out.println(instance.angleClock(3, 15));
  }
}
