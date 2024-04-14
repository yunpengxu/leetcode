package completed;

public class Problem605 {

  public boolean canPlaceFlowers(int[] flowerbed, int n) {
    int count = 0;
    int prev = 0;
    for(int i=0; i < flowerbed.length; i++) {
      if (flowerbed[i] == 0) {
        int next = (i==flowerbed.length-1)? 0: flowerbed[i+1];
        if (prev == 0 && next ==0) {
          count++;
          prev = 1;
        } else {
          prev = flowerbed[i];
        }
      } else {
        prev = flowerbed[i];
      }

      if(count >= n) {
        return true;
      }
    }
    return false;
  }
}
