package completed;

public class Problem498 {
  public int[] findDiagonalOrder(int[][] mat) {
    int height = mat.length, width = mat[0].length;
    Step step = new Step(height, width, 0, 0, 1);
    int count = 1, total = height*width;
    int[]results = new int[total];
    while (count <= total) {
      results[count-1] = mat[step.y][step.x];
      step = new Step(height, width, step.getNextX(), step.getNextY(), step.getNextDirection());
      count++;
    }
    return results;
  }

  class Step {

    int height, width, x, y, direction;
    int nextX, nextY, nextDirection;
    public Step(int height, int width, int x, int y, int direction) {
      this.height = height;
      this.width = width;
      this.x = x;
      this.y = y;
      this.direction = direction;
      this.nextDirection = direction;

      nextX = direction >0? x +1: x -1;
      nextY = direction >0? y-1 : y+1;
      if (nextX < 0 || nextX >= width) {
        nextX = x;
        nextY = y+1;
        nextDirection = direction *-1;
      }
      if (nextY <0 || nextY >= height) {
        nextY = y;
        nextX = x+1;
        nextDirection = direction *-1;
      }
    }

    public int getNextDirection() {
      return nextDirection;
    }

    public int getNextX(){
      return nextX;
    }
    public int getNextY(){
      return nextY;
    }
  }

  public static void main(String[] args) {
    Problem498 instance = new Problem498();
//    int[] results = instance.findDiagonalOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    int[] results = instance.findDiagonalOrder(new int[][]{{1,2},{3,4}});
    System.out.println();
  }
}
