package completed;

import java.util.ArrayList;
import java.util.TreeMap;


public class Problem348 {

  static class Line {
    int num, owner, count;
    String key;
    Boolean isWinner = null;
    Line(int n, String k, int o) {
      num = n;
      key = k;
      owner = o;
      count = 0;
    }

    Boolean play(int player) {
      if(player == owner) {
        count++;
        if(count ==num && isWinner== null) {
          isWinner = true;
        }
      } else {
        isWinner = false;
      }
      return isWinner;
    }
  }

  static class TicTacToe {

    java.util.Map<String, Line> map = new TreeMap<>();
    int num;
    int player = 1;
    public TicTacToe(int n) {
      num = n;
    }

    public int move(int row, int col, int player) {
      java.util.List<String> keys = new ArrayList<>();
      keys.add(String.format("%d:%d", row+1, 0));
      keys.add(String.format("%d:%d", 0, col+1));
      if(row==col) {
        keys.add(String.format("%d:%d", num, num));
      }
      if(row + col == num-1) {
        keys.add(String.format("%d:%d", -(num), -(num)));
      }

      for(String key: keys) {
        Line line = map.getOrDefault(key, new Line(num, key, player));
        map.put(key, line);
        Boolean isWinner = line.play(player);
        if(isWinner != null && isWinner == true) {
          return player;
        }
      }
      player++;
      return 0;
    }
  }

  public static void main(String[] args) {
    TicTacToe instance = new TicTacToe(3);
    System.out.println(instance.move(0, 0, 1));
    System.out.println(instance.move(0, 2, 2));
    System.out.println(instance.move(2, 2, 1));
    System.out.println(instance.move(1, 1, 2));
    System.out.println(instance.move(2, 0, 1));
    System.out.println(instance.move(1, 0, 2));
    System.out.println(instance.move(2, 1, 1));
  }

}
