import java.util.*;

/**
 * https://leetcode.com/problems/bulls-and-cows/
 * @author yunpeng
 *
 */
public class BullsandCows {
	public String getHint(String secret, String guess) {
	       char[] sChars = secret.toCharArray();
	    Map<Character, Integer> sCharMap = new HashMap<Character, Integer>();
	    for (char c : sChars)
	    {
	      if (!sCharMap.containsKey(c))
	      {
	        sCharMap.put(c, 1);
	      }
	      else
	      {
	        int cCount = sCharMap.get(c);
	        sCharMap.put(c, cCount + 1);
	      }
	    }

	    char[] gChars = guess.toCharArray();
	    int correct = 0, wrong = 0;
	    for (int i = 0; i < sChars.length; i++)
	    {
	      if (gChars[i] == sChars[i])
	      {
	        correct++;
	        int count = sCharMap.get(gChars[i]) - 1;
	        if (count == 0)
	        {
	          sCharMap.remove(gChars[i]);
	        }
	        else
	        {
	          sCharMap.put(gChars[i], count);
	        }
	      }
	    }
	    for (int i = 0; i < sChars.length; i++)
	    {
	      if (gChars[i] != sChars[i] &&sCharMap.keySet().contains(gChars[i]))
	      {
	        wrong++;
	        int count = sCharMap.get(gChars[i]) - 1;
	        if (count == 0)
	        {
	          sCharMap.remove(gChars[i]);
	        }
	        else
	        {
	          sCharMap.put(gChars[i], count);
	        }
	      }
	    }
	    return String.format("%dA%dB", correct, wrong);
	    }
}
