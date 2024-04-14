package completed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;


public class Problem384 {

  private java.util.List<Integer> origNums = new ArrayList<>();
  private Random random = new Random();

  public Problem384(int[] nums) {
    for(int i=0; i < nums.length; i++) {
      origNums.add(nums[i]);
    }
  }

  public int[] reset() {
    int[]output = new int[origNums.size()];
    for(int i=0; i< origNums.size();i++) {
      output[i]= origNums.get(i);
    }
    return output;
  }

  public int[] shuffle() {
    Integer[] indices = new Integer[origNums.size()];
    int [] randInt = new int[origNums.size()];
    for(int i=0; i < origNums.size(); i++) {
      indices[i] = i;
      randInt[i]= random.nextInt(100000);
    }
    Arrays.sort(indices, new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return randInt[o1]- randInt[o2];
      }
    });
    int[] output = new int[origNums.size()];
    for(int i =0; i< origNums.size();i++) {
      output[i]= origNums.get(indices[i]);
    }
    return output;
  }

  public static void main(String[]args) {
    Problem384 instance = new Problem384(new int[]{5, 7, 3, 2, 6, 4});
    int[]output = instance.shuffle();
    for(int o: output){
      System.out.print(o+",");
    }
    System.out.println();
    output = instance.reset();
    for(int o: output){
      System.out.print(o+",");
    }
    System.out.println();
    output = instance.shuffle();
    for(int o: output){
      System.out.print(o+",");
    }
  }
}
