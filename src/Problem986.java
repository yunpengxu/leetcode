package completed;

import java.util.ArrayList;


public class Problem986 {

  class Pair {
    int first, second;
    Pair(int first, int second) {
      this.first = first;
      this.second = second;
    }
  }

  public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
    int len1 = firstList.length, len2 = secondList.length;
    java.util.List<Pair> outputList = new ArrayList<>();
    for(int i=0, j=0; i< len1 && j < len2; ) {
      int[] pair1 = firstList[i], pair2 = secondList[j];

      if(pair1[1] < pair2[0]) {
        i++;
      } else if(pair1[0]> pair2[1]) {
        j++;
      } else if(pair1[1] == pair2[0] ) {
        outputList.add(new Pair(pair1[1], pair1[1]));
        i++;
      } else if(pair1[0] == pair2[1] ) {
        outputList.add(new Pair(pair1[0], pair1[0]));
        j++;
      } else if (pair1[0] <= pair2[0] && pair1[1] >= pair2[1]) {
        outputList.add(new Pair(pair2[0], pair2[1]));
        j++;
      }
      else if (pair1[0] >= pair2[0] && pair1[1] <= pair2[1]) {
        outputList.add(new Pair(pair1[0], pair1[1]));
        i++;
      } else if(pair1[0] <= pair2[0]) {
        outputList.add(new Pair(pair2[0], pair1[1]));
        i++;
      } else {
        outputList.add(new Pair(pair1[0], pair2[1]));
        j++;
      }
    }

    int[][] output= new int[outputList.size()][];
    for(int i=0; i< outputList.size();i++){
      output[i]= new int[]{outputList.get(i).first, outputList.get(i).second};
    }
    return output;
  }

  public static void main(String[] args) {
    Problem986 instance = new Problem986();
    instance.intervalIntersection(new int[][]{{1, 3},{5,9}}, new int[][]{});
  }


}
