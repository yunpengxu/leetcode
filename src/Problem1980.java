package completed;

public class Problem1980 {
  public String findDifferentBinaryString(String[] nums) {
    java.util.Set<Integer> set = new java.util.TreeSet<>();
    for(int i = 0; i < nums.length; i++) {
      set.add(decode(nums[i]));
    }
    if(nums.length >0){
      for(int i =0; i <Integer.MAX_VALUE; i++) {
        if(!set.contains(i)) {
          return encode(i, nums[0].length());
        }
      }
    }
    return "";
  }

  private int decode(String num) {
    int len = num.length();
    int total = 0;
    for(int i=0; i< len; i++) {
      total = total *2 + (num.charAt(i)-'0');
    }

    return total;
  }

  private String encode(int i, int len) {
    StringBuffer sb = new StringBuffer();
    while(i >0) {
      sb.append(i%2);
      i = i/2;
    }
    int count = sb.length();
    while(count < len) {
      sb.append("0");
      count++;
    }

    return sb.reverse().toString();
  }

  public static void main(String[]args) {
    Problem1980 instance = new Problem1980();
    System.out.println(instance.findDifferentBinaryString(new String[]{"111","011","001"}));
  }
}
