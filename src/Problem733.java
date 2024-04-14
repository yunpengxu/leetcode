package completed;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;


public class Problem733 {
  class Pixel {
    int row;
    int col;
    public Pixel (int row, int col) {
      this.row = row;
      this.col = col;
    }

    @Override
    public boolean equals(Object obj) {
      Pixel other = (Pixel) obj;
      return this.col == other.col && this.row == other.row;
    }
  }

  private Boolean isValid(int[][] image, Pixel p, java.util.Set<Pixel> visited, int startColor) {
    int numRows = image.length;
    int numCols = image[0].length;
    int r = p.row, c = p.col;
    return (!visited.contains(p) &&
        p.row >=0 && p.row < numRows &&
        p.col>=0 && p.col< numCols &&
        image[r][c] == startColor);
  }

  public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    java.util.Set<Pixel> visited = new HashSet<>();
    int startColor = image[sr][sc];
    if (startColor == color) {
      return image;
    }
    java.util.Stack<Pixel> stack = new Stack<>();
    image[sr][sc] = color;
    Pixel curPixel = new Pixel(sr, sc);
    stack.add(curPixel);
    visited.add(curPixel);
    while (!stack.isEmpty()) {
      curPixel = stack.pop();
      int curRow = curPixel.row, curCol = curPixel.col;
      List<Pixel> neighbors = new ArrayList<>();
      neighbors.add(new Pixel(curRow, curCol-1));
      neighbors.add(new Pixel(curRow, curCol+1));
      neighbors.add(new Pixel(curRow-1, curCol));
      neighbors.add(new Pixel(curRow+1, curCol));
      for(Pixel p : neighbors) {
        if (isValid(image, p, visited, startColor)) {
          visited.add(p);
          image[p.row][p.col] = color;
          stack.push(p);
        }
      }
    }
    return image;
  }

  public static void main(String[] args) {
    Problem733 instance = new Problem733();
    int[][] results = instance.floodFill(new int[][]{{1,1,1},{1,1,0},{1,0,1}}, 1, 1, 2);
    for(int i =0; i< results.length; i++) {
      for(int j=0; j< results[0].length; j++) {
        System.out.print(results[i][j] + ", ");
      }
      System.out.println("");
    }
  }
}
