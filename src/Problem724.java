package completed;

public class Problem724 {

  public int pivotIndex(int[] nums) {
    int[] front = new int[nums.length];
    int[] rear = new int[nums.length];

    int prevFront = 0, prevRear =0;
    for(int i = 0; i < nums.length; i++) {
      if(i==0) {
        front[i]=0;
        rear[i]=0;
      } else{
        front[i]= prevFront + nums[i-1];
        prevFront = front[i];
        rear[nums.length-1 -i]= prevRear+ nums[nums.length-i];
        prevRear = rear[nums.length-1 -i];
      }

    }
    for(int i = 0; i < nums.length; i++) {
      if(front[i] == rear[i]) {
        return i;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    Problem724 instance = new Problem724();
    System.out.println(instance.pivotIndex(new int[]{1,7,3,6,5,6}));
  }
}
