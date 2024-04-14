package completed;

import java.util.LinkedList;


public class Problem547 {


  public int findCircleNum(int[][] isConnected) {
    int num = isConnected.length;
    int count = 0;
    java.util.Queue<Integer> queue = new LinkedList<>();
    for(int i=0; i< num; i++ ) {
      if(isConnected[i][i]>0) {
        count++;
        isConnected[i][i] = -1;
        queue.add(i);
        while(!queue.isEmpty()) {
          int j = queue.poll();
          for(int k = 0; k< num; k++) {
            if(isConnected[j][k] == 1 && isConnected[k][k] >0) {
              isConnected[k][k]=-1;
              queue.add(k);
            }
          }
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
    Problem547 instance = new Problem547();
    instance.findCircleNum(new int[][]{{1,1,1},{1,1,1},{1,1,1}});
  }
}
