package completed;

public class Problem2849 {

  public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
    int deltax = Math.abs(fx-sx), deltay = Math.abs(fy-sy);
    if(deltax == 0 && deltay==0 && t==1) { // i dont know why only consider t=1 for the same position as a special case.
      return false;
    }
    return Math.max(deltax, deltay) <= t;
  }

}
