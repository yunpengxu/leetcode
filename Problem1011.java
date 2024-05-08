package completed;

public class Problem1011 {

  public int shipWithinDays(int[] weights, int days) {
    int max =0, total = 0;
    for(int w: weights) {
      total+=w;
      if(w> max) {
        max = w;
      }
    }
    int first = max, last = total;
    while(first<last) {
      int mid = (first+last)/2;
      boolean flag = canShip(weights, mid, days);
      if(flag) {
        last = mid;
      } else {
        first = mid+1;
      }
    }
    return first;
  }

  private boolean canShip(int[] weights, int capacity, int days) {
    int count = 1;
    int curTotal=0;
    for(int w: weights) {
      if(curTotal+ w <= capacity) {
        curTotal+= w;
      } else {
        curTotal=w;
        count++;
      }
    }

    return (count<= days);
  }

  public static void main(String[] args) {
    Problem1011 instance = new Problem1011();
    System.out.println(instance.shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10}, 5));
    System.out.println(instance.shipWithinDays(new int[]{3,2,2,4,1,4}, 3));
    System.out.println(instance.shipWithinDays(new int[]{1,2,3,1,1}, 4));
  }
}
