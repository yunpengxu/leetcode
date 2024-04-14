package completed;

public class Problem977 {

  public int[] sortedSquares(int[] nums) {
    int minabs = Integer.MAX_VALUE, minindex = -1;
    for(int i =0; i< nums.length;i++) {
      if(Math.abs(nums[i])<minabs) {
        minabs = Math.abs(nums[i]);
        minindex = i;
      }
    }
    int startIndex = minindex-1, endIndex = minindex+1;
    int[]output = new int[nums.length];
    output[0] = minabs* minabs;
    int index =1;
    while(startIndex>=0 && endIndex < nums.length) {
      int startVal = Math.abs(nums[startIndex]), endVal = Math.abs(nums[endIndex]);
      if(startVal< endVal){
        output[index++] = startVal*startVal;
        startIndex--;
      } else if (endVal< startVal){
        output[index++] = endVal*endVal;
        endIndex++;
      } else{
        output[index++] = startVal*startVal;
        output[index++] = endVal*endVal;
        startIndex--;
        endIndex++;
      }
    }
    while(startIndex>=0) {
      int startVal = Math.abs(nums[startIndex]);
      output[index++] = startVal*startVal;
      startIndex--;
    }
    while(endIndex < nums.length) {
      int endVal = Math.abs(nums[endIndex]);
      output[index++] = endVal*endVal;
      endIndex++;
    }
    return output;
  }

}
