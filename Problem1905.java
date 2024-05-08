package completed;

public class Problem1905 {

  public int countSubIslands(int[][] grid1, int[][] grid2) {
    int[][] delta = new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    int m = grid1.length, n = grid1[0].length;
    for(int i =0; i< m; i++) {
      for(int j =0; j< n; j++) {
        if(grid2[i][j] == 1 && grid1[i][j] != 1) {
          clear(grid2, i, j);
        }
      }
    }
    int count =0;
    for(int i =0; i< m; i++) {
      for(int j =0; j< n; j++) {
        if(grid2[i][j] == 1) {
          count++;
          clear(grid2, i, j);
        }
      }
    }
    return count;
  }

  void clear(int[][]grid, int i, int j) {
    int m = grid.length, n = grid[0].length;
    int[][] delta = new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    grid[i][j] = 0;
    for(int[] d: delta){
      int ii = i+d[0], jj = j +d[1];
      if(ii>=0&&ii<m &&jj>=0&&jj<n && grid[ii][jj] == 1) {
        clear(grid, ii, jj);
      }
    }
  }

  public static void main(String[] args) {
    Problem1905 instance = new Problem1905();
    instance.countSubIslands(new int[][]{{1,1,1,1,0,0},{1,1,0,1,0,0},{1,0,0,1,1,1},{1,1,1,0,0,1},{1,1,1,1,1,0},{1,0,1,0,1,0},{0,1,1,1,0,1},{1,0,0,0,1,1},{1,0,0,0,1,0},{1,1,1,1,1,0}},
        new int[][]{{1,1,1,1,0,1},{0,0,1,0,1,0},{1,1,1,1,1,1},{0,1,1,1,1,1},{1,1,1,0,1,0},{0,1,1,1,1,1},{1,1,0,1,1,1},{1,0,0,1,0,1},{1,1,1,1,1,1},{1,0,0,1,0,0}});

//    instance.countSubIslands(new int[][]{{1,1,1,0,0},{0,1,1,1,1},{0,0,0,0,0},{1,0,0,0,0},{1,1,0,1,1}},
//    new int[][]{{1,1,1,0,0},{0,0,1,1,1},{0,1,0,0,0},{1,0,1,1,0},{0,1,0,1,0}});
//    instance.countSubIslands(new int[][]{{1,0,1,0,1},{1,1,1,1,1},{0,0,0,0,0},{1,1,1,1,1},{1,0,1,0,1}},
//    new int[][]{{0,0,0,0,0},{1,1,1,1,1},{0,1,0,1,0},{0,1,0,1,0},{1,0,0,0,1}});
  }
}
