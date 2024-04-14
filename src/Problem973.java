package completed;

import java.util.ArrayList;
import java.util.Collections;


public class Problem973 {

  class Point implements Comparable <Point> {
    int x, y;
    double distance;
    public Point(int x, int y) {
      this.x = x;
      this.y = y;
      this.distance = Math.sqrt(x*x + y*y);
    }

    @Override
    public int compareTo(Point o) {
      return (distance <= o.distance )? -1: 1;
    }
  }

  public int[][] kClosest(int[][] points, int k) {
    java.util.List<Point> pointList = new ArrayList<>();
    for(int i=0; i< points.length; i++) {
      pointList.add(new Point(points[i][0],points[i][1]));
    }
    Collections.sort(pointList);
    int[][] results = new int[k][2];
    for(int i=0; i<k; i++) {
      Point p = pointList.get(i);
      results[i][0]=p.x;
      results[i][1]=p.y;
    }
    return results;
  }

  public static void main(String[] args) {
    Problem973 instance = new Problem973();
    instance.kClosest(new int[][]{{3,3},{5,-1},{-2,4}}, 2);
  }
}
