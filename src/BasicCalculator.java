import java.util.*;

/**
 * https://leetcode.com/problems/basic-calculator/
 * 
 * @author yunpeng
 * 
 */
public class BasicCalculator {
	public int calculate(String s) {
		String woSpace = s.replaceAll("\\s", "");
		List<String> postStr = convertPostfix(woSpace);
		LinkedList<Integer> operands = new LinkedList<Integer>();
		for (String str : postStr) {
			if (!str.equals("+") && !str.equals("-")) {
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
				}
				operands.addLast(curResult);
			}
		}
		return operands.pollLast();
	}

	private List<String> convertPostfix(String s) {
		int len = s.length();
		List<String> results = new ArrayList<String>();
		StringBuffer operandBuffer = new StringBuffer();
		LinkedList<Character> operators = new LinkedList<Character>();
		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			if (c != '+' && c != '-' && c != '(' && c != ')') {
				operandBuffer.append(c);
			} else {
				String operand = operandBuffer.toString();
				if (!operand.isEmpty()) {
					results.add(operand);
				}
				operandBuffer.delete(0, operand.length());
				if (c != ')') {
					if (c == '+' || c == '-') {
						if (!operators.isEmpty()
								&& (operators.peekLast() == '+' || operators
										.peekLast() == '-')) {
							results.add(String.valueOf(operators.pollLast()));
						}
					}
					operators.addLast(c);
				} else {
					while (!operators.isEmpty() && operators.peekLast() != '(') {
						results.add(String.valueOf(operators.pollLast()));
					}
					operators.pollLast(); // for '(';
				}
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
