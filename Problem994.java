package completed;

import java.util.*;
public class Problem994 {

  public int orangesRotting(int[][] grid) {
    int steps = 0;
    int height = grid.length, width = grid[0].length;

    LinkedList<int[]> queue = new LinkedList<>(), nextQueue = new LinkedList<>();
    for(int i=0; i< height; i++) {
      for(int j =0; j< width;j++) {
        if (grid[i][j]==2) {
          queue.add(new int[]{i, j});
        }
      }
    }

    int[][] delta = new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    while(!queue.isEmpty()) {
      int[] cell = queue.poll();
      for(int[] d: delta) {
        int ii = cell[0] + d[0], jj = cell[1] + d[1];
        if(ii>=0 &&ii< height &&jj>=0 && jj< width) {
          if(grid[ii][jj] ==1) {
            grid[ii][jj]=2;
            nextQueue.add(new int[]{ii, jj});
          }
        }
      }
      if(queue.isEmpty() && !nextQueue.isEmpty()) {
        steps++;
        queue = nextQueue;
        nextQueue = new LinkedList<>();
      }
    }

    for(int i=0; i< height; i++) {
      for(int j =0; j< width;j++) {
        if (grid[i][j]==1) {
          return -1;
        }
      }
    }
    return steps;
  }

  public static void main(String[] args) {
    Problem994 instance = new Problem994();
    instance.orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}});
  }
}
