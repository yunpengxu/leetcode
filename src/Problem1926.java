package completed;

import java.util.ArrayList;
import java.util.LinkedList;

public class Problem1926 {

  class Cell {
    int col, row, depth;
    Cell(int row, int col, int depth) {
      this.row = row;
      this.col = col;
      this.depth = depth;
    }
  }

  private Boolean isValid(char[][]maze, boolean[][] visited, Cell entrance, Cell cell) {
    int rowNum = maze.length, colNum = maze[0].length;
    return cell.row >=0 && cell.row<rowNum &&
        cell.col>=0 && cell.col< colNum &&
        visited[cell.row][cell.col]== false &&
        !(cell.row == entrance.row && cell.col == entrance.col) &&
        maze[cell.row][cell.col]!= '+';
  }

  private Boolean isExit(int rowNum, int colNum, Cell cell) {
    return cell.row==0 || cell.row == rowNum-1 || cell.col ==0 || cell.col == colNum -1;
  }

  public int nearestExit(char[][] maze, int[] entrance) {
    boolean[][] visited = new boolean[maze.length][maze[0].length];
    java.util.Queue<Cell>  queue = new LinkedList<>();
    Cell entranceCell = new Cell(entrance[0], entrance[1], 0);
    queue.offer(entranceCell);
    visited[entrance[0]][entrance[1]]= true;
    int distance = -1;
    while (!queue.isEmpty()) {
      Cell curCell = queue.poll();
      java.util.List<Cell> neighbors = new ArrayList<>();
      neighbors.add(new Cell(curCell.row-1, curCell.col, curCell.depth+1));
      neighbors.add(new Cell(curCell.row+1, curCell.col, curCell.depth+1));
      neighbors.add(new Cell(curCell.row, curCell.col-1, curCell.depth+1));
      neighbors.add(new Cell(curCell.row, curCell.col+1, curCell.depth+1));
      for(Cell cell: neighbors) {
        if(isValid(maze, visited, entranceCell, cell)) {
          visited[cell.row][cell.col] = true;
          queue.offer(cell);
          if (isExit(maze.length, maze[0].length, cell)) {
            distance = cell.depth;
          }
        }
      }
      if(distance>0) {
        break;
      }
    }

    return distance;
  }

  public static void main(String[] args) {
    Problem1926 instance = new Problem1926();
    System.out.println(instance.nearestExit(new char[][]{{'+','+','+'},{'.','.','.'},{'+','+','+'}}, new int[]{1, 0}));
  }
}
