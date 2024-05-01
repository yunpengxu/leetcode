package completed;

import java.util.*;
public class Problem1535 {

  public int getWinner(int[] arr, int k) {
    if(arr.length == 2) {
      return Math.max(arr[0], arr[1]);
    }

    Queue<Integer> queue = new LinkedList<>();
    int maxVal = Integer.MIN_VALUE;
    for(int i = 0; i< arr.length;i++) {
      if(maxVal< arr[i]) {
        maxVal = arr[i];
      }
      queue.add(arr[i]);
    }
    int winTimes = 0;
    int curWin = queue.poll();
    while(curWin!= maxVal && winTimes < k) {
      int nextVal = queue.poll();
      if(curWin > nextVal) {
        winTimes++;
        queue.add(nextVal);
      } else {
        queue.add(curWin);
        winTimes = 1;
        curWin = nextVal;
      }
    }

    return curWin;
  }

  public static void main(String[] args) {
    Problem1535 instance = new Problem1535();
    instance.getWinner(new int[]{2,1,3,5,4,6,7}, 2);
    instance.getWinner(new int[]{3, 2,1}, 10);
  }

}
