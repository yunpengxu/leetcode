package completed;

public class Problem941 {

  public boolean validMountainArray(int[] arr) {
    int len = arr.length;
    if (len <3) {
      return false;
    }
    int i =0;
    while(i +1< len && arr[i] < arr[i+1]) {
      i+=1;
    }
    if(i+1==len || arr[i]== arr[i+1]) {
      return false;
    }
    if(i==0) {
      return false;
    }
    i++;
    while(i+1 < len) {
      if(arr[i]<=arr[i+1]) {
        return false;
      }
      i++;
    }
    return true;
  }

  public static void main(String[]args) {
    Problem941 instance = new Problem941();
    System.out.println(instance.validMountainArray(new int[]{2,1}));
    System.out.println(instance.validMountainArray(new int[]{3,5,5}));
    System.out.println(instance.validMountainArray(new int[]{0,3,2,1}));

    System.out.println(instance.validMountainArray(new int[]{9,8,7,6,5,4,3,2,1,0}));
  }
}
