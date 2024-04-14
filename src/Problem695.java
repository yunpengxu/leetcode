package completed;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Problem695 {

  private static class Pixel {
    int x, y;
    Pixel(int x, int y) {
      this.x = x;
      this.y = y;
    }

    Pixel add(Pixel p) {
      return  new Pixel(x+ p.x, y+ p.y);
    }
  }

  private static Pixel[] DIRECTIONS = new Pixel[]{new Pixel(-1, 0), new Pixel(1, 0), new Pixel(0, -1), new Pixel(0, 1)};

  private java.util.List<Pixel> getNeighbors(Pixel pixel, int[][] grid){
    java.util.List<Pixel> neighbors = new ArrayList<>();
    int height = grid.length;
    int width = grid[0].length;
    for(Pixel p: DIRECTIONS) {
      Pixel newP = pixel.add(p);
      if (newP.x>=0 && newP.x < height && newP.y >= 0 && newP.y< width&& grid[newP.x][newP.y] == 1) {
        neighbors.add(newP);
      }
    }

    return neighbors;
  }

  public int maxAreaOfIsland(int[][] grid) {
    int index = 0;
    int maxCount = 0, curCount = 0;
    for(int i=0; i< grid.length; i++) {
      for(int j = 0; j< grid[0].length; j++) {
        if(grid[i][j] ==1) {
          index --;
          curCount =0;
          java.util.LinkedList<Pixel> queue = new LinkedList<>();
          queue.add(new Pixel(i, j));
          while(!queue.isEmpty()) {
            Pixel curP = queue.pop();
            if(grid[curP.x][curP.y]==1) {
              grid[curP.x][curP.y]= index;
              curCount ++;
              if(curCount > maxCount) {
                maxCount = curCount;
              }
              List<Pixel> neighbors = getNeighbors(curP, grid);
              queue.addAll(neighbors);
            }
          }
        }
      }
    }
    return maxCount;
  }

  public static void main(String[] args) {
    Problem695 instance = new Problem695();
//    instance.maxAreaOfIsland(new int[][]{{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}});
    instance.maxAreaOfIsland(new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}});
  }
}
