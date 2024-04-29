package completed;

import java.util.LinkedList;
import java.util.Queue;


public class Problem286 {

  // breadth first search
  public void wallsAndGates(int[][] rooms) {
    int INF = Integer.MAX_VALUE;

    int[][]directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int height = rooms.length, width = rooms[0].length;

    Queue<int[]> queue = new LinkedList<>();
    for(int i=0; i< height;i++) {
      for(int j=0; j< width; j++) {
        if(rooms[i][j] == 0) {
          queue.add(new int[]{i, j});
        }
      }
    }
    Queue<int[]> nextQueue = new LinkedList<>();
    while(!queue.isEmpty()) {
      int[] curCell = queue.poll();
      int curDepth = rooms[curCell[0]][curCell[1]];
      for(int k =0;k< 4; k++) {
        int[] nextCell = new int[] {curCell[0]+ directions[k][0], curCell[1]+ directions[k][1]};
        if(nextCell[0] >=0 && nextCell[0]< height && nextCell[1]>=0 && nextCell[1] < width) {
          if(rooms[nextCell[0]][nextCell[1]] == INF) {
            rooms[nextCell[0]][nextCell[1]] = curDepth+1;
            nextQueue.add(new int[]{nextCell[0], nextCell[1]});
          }
        }
      }
      if(queue.isEmpty()) {
        queue = nextQueue;
        nextQueue = new LinkedList<>();
      }
    }
  }

  public static void main(String[] args) {
    Problem286 instance = new Problem286();
    instance.wallsAndGates(new int[][]{{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}});
  }
}
