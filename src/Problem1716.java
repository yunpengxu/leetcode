package completed;

public class Problem1716 {
  public int totalMoney(int n) {
    int weeks = n /7;
    int weeklyBaseSum = 28 * weeks;
    int weeklyIncrease = (0+7*weeks)*(weeks-1)/2;
    int remainingDay = n %7;
    int remaining = 0;
    int remainingStart= n/7+1;
    for(int i=0; i< remainingDay;i++) {
      remaining= remaining+ remainingStart;
      remainingStart++;
    }
    return remaining+ weeklyBaseSum+ weeklyIncrease;
  }

  public static void main(String[] args) {
    Problem1716 instance = new Problem1716();
//    System.out.println(instance.totalMoney(4));
//    System.out.println(instance.totalMoney(10));
//    System.out.println(instance.totalMoney(20));
    System.out.println(instance.totalMoney(26));
  }
}
