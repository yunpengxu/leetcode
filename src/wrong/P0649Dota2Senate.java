package wrong;

/**
 * https://leetcode.com/problems/dota2-senate/
 * the algorithm failed on the case "DRRDRDRDRDDRDRDR" but i dont know how, as i think it should be "Dire" while the answer says "Radiant";
 * my idea is that for each iteration, find the first opposite party and ban it.
 */
public class P0649Dota2Senate {

  String predictPartyVictory(String senate) {
    String remainingSenates = senate;
    while (true) {
      char[] senatesArray = remainingSenates.toCharArray();
      remainingSenates = helper(senatesArray);
      if (remainingSenates == "Radiant" || remainingSenates == "Dire") {
        return remainingSenates;
      }
    }
  }

  private String helper(char[] senates) {
    int firstR = -1, firstD = -1;
    for(int i = 0; i < senates.length; i++) {
      char curChar = senates[i];
      if (curChar == 'R' && firstR <0 ) {
        firstR =i;
      }
      if (curChar == 'D' && firstD <0 ) {
        firstD =i;
      }
      if (firstR >=0 && firstD >=0) {
        break;
      }
    }
    if (firstR <0) {
      return "Dire";
    }
    if (firstD <0) {
      return "Radiant";
    }

    for(int i = 0; i < senates.length; i++) {
      char curChar = senates[i];
      if (curChar =='R') {
        senates[firstD] ='0';
        for (int j = firstD + 1; j < senates.length; j++) {
          if (senates[j] == 'D') {
            firstD = j;
            break;
          }
        }
        if (firstD == senates.length) {
          return "Radiant";
        }
      }
      if (curChar =='D') {
        senates[firstR] ='0';
        for (int j = firstR + 1; j < senates.length; j++) {
          if (senates[j] == 'R') {
            firstR = j;
            break;
          }
        }
        if (firstR == senates.length) {
          return "Dire";
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < senates.length; i++) {
      if (senates[i] != '0') {
        sb.append(senates[i]);
      }
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    P0649Dota2Senate instance = new P0649Dota2Senate();
    System.out.println(instance.helper("DDDD".toCharArray()));
  }
}
