package completed;

import java.util.Arrays;
import java.util.LinkedList;


public class Problem670 {



  public int maximumSwap(int num) {
    int[]array = encode(num);
    return decode(swap(array));
  }

  private int[] encode(int num) {
    LinkedList<Integer> numList = new LinkedList<>();
    while(num != 0) {
      numList.offer(num%10);
      num = num/10;
    }
    int[] results = new int[numList.size()];
    for(int i=0;i< numList.size();i++) {
      results[numList.size()-1 - i]= numList.get(i);
    }
    return results;
  }

  // sort, and find the first mismatch and swap
  private int[] swap(int[] array) {
    int[] arr = new int[array.length];
    System.arraycopy(array,  0, arr,0, array.length);
    Arrays.sort(arr);
    for(int i = 0; i< arr.length; i++) {
      if(array[i] != arr[arr.length -1 -i]) {
        for(int j = array.length-1; j>=0;j--) {
          if(array[j] == arr[arr.length -1 -i]) {
            int temp = array[j];
            array[j] = array[i];
            array[i] = temp;
            break;
          }
        }
        break;
      }
    }
    return array;
  }

  private int decode(int[] array) {
    int num = 0;
    for(int i=0; i< array.length;i++) {
      num = num * 10 + array[i];
    }
    return num;
  }

  public static void main(String[] args) {
    Problem670 instance = new Problem670();
    System.out.println(instance.maximumSwap(2736));
    System.out.println(instance.maximumSwap(0));
    System.out.println(instance.maximumSwap(9973));
  }
}
