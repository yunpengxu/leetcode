package completed;

import java.util.Comparator;
import java.util.PriorityQueue;


public class Problem2558 {

  public long pickGifts(int[] gifts, int k) {
    PriorityQueue<Long> queue = new PriorityQueue<>(new Comparator<Long>() {
      @Override
      public int compare(Long o1, Long o2) {
        return o2>o1? 1: -1;
      }
    });
    for(int i =0; i < gifts.length; i++) {
      queue.offer((long)gifts[i]);
    }

    for(int i =0; i< k; i++) {
      long val = queue.poll();
      queue.offer((long)Math.sqrt(val));
    }
    long total =0;
    for(long val : queue){
      total+= val;
    }
    return total;
  }

  public static void main(String[] args) {
    Problem2558 instance = new Problem2558();
    instance.pickGifts(new int[]{411042986,697316006,569259488,665293106,728558122,395308016,962051539,449602622,225273018,421053664,772795795,42557563,640312042,791181812,239411012,610918759,7894884,951279693,478806887,792321489,11566125,445499925,164783184,832628691,216001498,68086337,621597421,683035143,138851304,999858983,978638960,957360800,845854378,339740721,805732223,301257941,948144266,316601503,834324760,952034242,485765680,367489151,562273287,443830581,527380862,354003764,868621029,285858008,554465828,934261207,326805671,476383643,849715786,573608875,356570192,430933288,720102531,360069216,998389465,433353834,960876305}, 10);
  }

}
