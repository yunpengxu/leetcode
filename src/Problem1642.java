package completed;

import java.util.PriorityQueue;


public class Problem1642 {
  public int furthestBuilding(int[] heights, int bricks, int ladders) {
    int buildingNum = 0;
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    int usedLadders = 0, index = 1;
    while(usedLadders < ladders && index < heights.length) {
      if(heights[index] > heights[index-1]) {
        queue.offer(heights[index] - heights[index-1]);
        usedLadders++;
      }
      buildingNum++;
      index = index+1;
    }
    while(index < heights.length) {
      int gap = heights[index] - heights[index-1];
      if(gap<=0) {
        buildingNum++;
      } else {
        if(queue.isEmpty()) {
          if(gap <= bricks) {
            buildingNum++;
            bricks-= gap;
          } else {
            break;
          }
        } else {
          int leastGap = queue.peek();
          if(leastGap < gap) {
            if(leastGap <= bricks) {
              buildingNum++;
              bricks-= leastGap;
              queue.poll();
              queue.offer(gap);
            } else {
              break;
            }
          } else {
            if(gap <= bricks) {
              buildingNum++;
              bricks-= gap;
            } else {
              break;
            }
          }
        }
      }
      index++;
    }
    return buildingNum;
  }

  public static void main(String[] args) {
    Problem1642 instance = new Problem1642();
    instance.furthestBuilding(new int[]{4,2,7,6,9,14,12}, 5, 1);
    instance.furthestBuilding(new int[]{4,12,2,7,3,18,20,3,19}, 10, 2);
    instance.furthestBuilding(new int[]{14,3,19,3}, 17, 0);
  }
}
