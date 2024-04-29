package completed;

public class Problem536 {


   public static class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
   }

  public TreeNode str2tree(String s) {
     if(s.length()==0) {
       return null;
     }
     int rootVal = 0;
    Boolean isNegative = false;
    int i =0;
    if(s.charAt(i) =='-') {
      isNegative = true;
      i++;
    }
    while(i< s.length() && s.charAt(i) != '(') {
      rootVal = rootVal * 10 + (s.charAt(i) - '0');
      i++;
    }
    if(isNegative) {
      rootVal = rootVal * -1;
    }
    TreeNode rootNode = new TreeNode(rootVal);

    String leftString = extractChildStr(s, i);
    String rightString = extractChildStr(s, i+ leftString.length()+2);
    if(leftString.length() >0) {
      TreeNode leftNode = str2tree(leftString);
      rootNode.left = leftNode;
    }
    if(rightString.length() >0) {
      TreeNode rightNode = str2tree(rightString);
      rootNode.right = rightNode;
    }
    return rootNode;
  }

  String extractChildStr(String s, int startIndex) {
     if(startIndex >= s.length()) {
       return "";
     }
     StringBuffer sb = new StringBuffer();
     int leftCount = 1;
     int i=startIndex+1;
     while(leftCount >0) {
       if(s.charAt(i) == '(') {
         leftCount++;
       }
       if(s.charAt(i) == ')') {
         leftCount--;
       }
       if(leftCount >0) {
         sb.append(s.charAt(i));
       }
       i++;
     }
     return sb.toString();
  }

  public static void main(String[] args) {
     Problem536 instance = new Problem536();
    instance.str2tree("");
     instance.str2tree("4(2(3)(1))(6(5))");
    instance.str2tree("4(2(3)(1))(6(5)(7))");
    instance.str2tree("-4(2(3)(1))(6(5)(7))");
  }
}
