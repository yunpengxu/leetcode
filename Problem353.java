package completed;

import java.util.*;
public class Problem353 {

  static class Cell {
    int x, y;
    Cell(int x, int y) {
      this.x = x; this.y=y;
    }

    @Override
    public int hashCode() {
      return x *31+y;
    }

    @Override
    public boolean equals(Object obj) {
      Cell other = (Cell) obj;
      return other.x == x && other.y == y;
    }
  }
  static class SnakeGame {

    int[] head;
    LinkedList<int[]> body = new LinkedList<>(), foods = new LinkedList<>();
    Set<Cell> bodyset = new HashSet<>();
    int width, height;
    int score =0;

    public SnakeGame(int width, int height, int[][] food) {
      this.width = width;
      this.height = height;
      head = new int[]{0, 0};
      body.add(head);
      bodyset.add(new Cell(0, 0));
      for(int[] f: food){
        foods.add(f);
      }
    }

    public int move(String direction) {
      if(score == -1) {
        return -1;
      }

      int[] nextHead = new int[2];
      int[] food= foods.peek();
      nextHead[0]= head[0];
      nextHead[1]= head[1];
      switch (direction){
        case "L":
          nextHead[1]= head[1]-1;
          break;
        case "R":
          nextHead[1]= head[1]+1;
          break;
        case "U":
          nextHead[0]= head[0]-1;
          break;
        case "D":
          nextHead[0]= head[0]+1;
          break;
      }
      if(nextHead[0]<0|| nextHead[0]>= height|| nextHead[1]<0 || nextHead[1]>= width) { // hit wall
        score = 01;
        return -1;
      } else if(food != null &&nextHead[0]==food[0] && nextHead[1]==food[1]) { // eat something;
        foods.poll();
        score++;
        head = nextHead;
        body.add(head);
        bodyset.add(new Cell(head[0], head[1]));
        return score;
      } else { // just move;
        head = nextHead;
        body.add(head);
        int[]tail =body.poll();
        bodyset.remove(new Cell(tail[0], tail[1]));
        if(bodyset.contains(new Cell(head[0], head[1]))) { // hit itself
          return -1;
        }
        bodyset.add(new Cell(head[0], head[1]));
      }
      return score;
    }
  }

  public static void main(String[] args) {
//    SnakeGame instance = new SnakeGame(3, 2, new int[][]{{1, 2}, {0, 1}});
//    System.out.println(instance.move("R"));
//    System.out.println(instance.move("D"));
//    System.out.println(instance.move("R"));
//    System.out.println(instance.move("U"));
//    System.out.println(instance.move("L"));
//    System.out.println(instance.move("U"));

//    SnakeGame instance = new SnakeGame(2, 2, new int[][]{{0, 1}});
//    System.out.println(instance.move("R"));
//    System.out.println(instance.move("D"));

    SnakeGame instance = new SnakeGame(3, 3, new int[][]{{2,0},{0,0},{0,2},{0,1},{2,2},{0,1}, {0, 1}});
    System.out.println(instance.move("D"));
    System.out.println(instance.move("D"));
    System.out.println(instance.move("R"));
    System.out.println(instance.move("U"));
    System.out.println(instance.move("U"));

    System.out.println(instance.move("L"));
    System.out.println(instance.move("D"));
    System.out.println(instance.move("R"));
    System.out.println(instance.move("R"));
    System.out.println(instance.move("U"));

    System.out.println(instance.move("L"));
    System.out.println(instance.move("L"));
    System.out.println(instance.move("D"));
    System.out.println(instance.move("R"));
    System.out.println(instance.move("U"));
  }

}
