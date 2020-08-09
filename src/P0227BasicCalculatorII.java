import java.util.*;

/**
 *
 * @author yunpeng
 *
 */
public class P0227BasicCalculatorII {
	public int calculate(String s) {
		String woSpace = s.replaceAll("\\s", "");
		List<String> postStr = convertPost(woSpace);
		LinkedList<Integer> operands = new LinkedList<Integer>();
		for (String str : postStr) {
			if (!str.equals("+") && !str.equals("-") && !str.equals("*")
					&& !str.equals("/")) {
				int val = 0;
				char[] valStr = str.toCharArray();
				for (int i = 0; i < valStr.length; i++) {
					val = 10 * val + valStr[i] - '0';
				}
				operands.addLast(val);
			} else {
				int second = operands.pollLast();
				int first = operands.pollLast();
				int curResult = 0;
				switch (str) {
				case "+":
					curResult = first + second;
					break;
				case "-":
					curResult = first - second;
					break;
				case "*":
					curResult = first * second;
					break;
				case "/":
					curResult = first / second;
					break;
				}
				operands.addLast(curResult);
			}
		}
		return operands.pollLast();
	}

	private List<String> convertPost(String s) {
		Map<Character, Integer> predmap = new HashMap<Character, Integer>();
		predmap.put('+', 1);
		predmap.put('-', 1);
		predmap.put('*', 2);
		predmap.put('/', 2);

		int len = s.length();
		List<String> results = new ArrayList<String>();
		StringBuffer operandBuffer = new StringBuffer();
		LinkedList<Character> operators = new LinkedList<Character>();
		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			if (c != '+' && c != '-' && c != '*' && c != '/') {
				operandBuffer.append(c);
			} else {
				String operand = operandBuffer.toString();
				results.add(operand);
				operandBuffer.delete(0, operand.length());
				while (!operators.isEmpty()
						&& predmap.get(operators.peekLast()) >= predmap.get(c)) {
					results.add(String.valueOf(operators.pollLast()));
				}
				operators.addLast(c);
			}
		}
		if (operandBuffer.length() > 0) {
			results.add(operandBuffer.toString());
		}
		while (!operators.isEmpty()) {
			results.add(String.valueOf(operators.pollLast()));
		}
		return results;
	}
}
