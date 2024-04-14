package completed;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.stream.Collectors;


public class Problem1254 {

  class Pixel{
    int x, y;
    Pixel(int x,int y) {
      this.x = x;
      this.y = y;
    }
  }

  public int closedIsland(int[][] grid) {
    int height = grid.length, width = grid[0].length;
    int total =0;
    for(int i =0; i< height; i++) {
      for(int j = 0; j< width; j++) {
        if(grid[i][j] ==0) {
          boolean isBorder = false;
          java.util.LinkedList<Pixel> pixels = new LinkedList<>();
          pixels.add(new Pixel(i, j));
          while(!pixels.isEmpty()) {
            Pixel curPixel = pixels.pop();
            if(curPixel.x ==0 || curPixel.x == height-1 || curPixel.y ==0 || curPixel.y == width-1) {
              isBorder = true;
            }
            if(grid[curPixel.x][curPixel.y] == 0) {
              grid[curPixel.x][curPixel.y] = -1;
              pixels.addAll(getNeighors(curPixel, height, width, grid));
            }
            }
          if (!isBorder) {
            total++;
          }
          }
        }
      }
    return total;
  }

  private java.util.List<Pixel> getNeighors(Pixel pixel, int height, int width, int[][] grid) {
    java.util.List<Pixel> output = new ArrayList<>();
    output.add(new Pixel(pixel.x-1, pixel.y));
    output.add(new Pixel(pixel.x, pixel.y-1));
    output.add(new Pixel(pixel.x+1, pixel.y));
    output.add(new Pixel(pixel.x, pixel.y+1));
    return output.stream()
        .filter(pixel1 -> pixel1.x >=0 && pixel1.y >=0 && pixel1.x< height && pixel1.y< width && grid[pixel1.x][pixel1.y] ==0)
        .collect(Collectors.toList());
  }

  public static void main(String[]args) {
    Problem1254 instance = new Problem1254();
    instance.closedIsland(new int[][]{{1,1,1,1,1,1,1},{1,0,0,0,0,0,1},{1,0,1,1,1,0,1},{1,0,1,0,1,0,1},{1,0,1,1,1,0,1},{1,0,0,0,0,0,1},{1,1,1,1,1,1,1}});
  }
}
