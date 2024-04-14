package completed;

public class Problem1971 {

  public boolean validPath(int n, int[][] edges, int source, int destination) {
    int[]parents = new int[n];
    for(int i = 0; i< n; i++) {
      parents[i]=-1;
    }
    for(int i =0; i< edges.length; i++) {
      int first = edges[i][0];
      int second = edges[i][1];
      int root1 = findRoot(parents, first);
      int root2 = findRoot(parents, second);
      if(root1 != root2) {

        int bigger = parents[root1] <= parents[root2] ? root1: root2;
        int smaller = parents[root1] <= parents[root2] ? root2: root1;
        parents[bigger] = parents[bigger] + parents[smaller];
        parents[smaller] = bigger;
      }
    }

    return findRoot(parents, source) == findRoot(parents, destination);
  }

  private int findRoot(int[] parents, int i) {
    while(parents[i] >=0) {
      i = parents[i];
    }
    return i;
  }

  public static void main(String[] args) {
    Problem1971 instance = new Problem1971();
    System.out.println(instance.validPath(6, new int[][]{{0,1},{0,2},{3,5},{5,4},{4,3}}, 0, 5));
  }

}
