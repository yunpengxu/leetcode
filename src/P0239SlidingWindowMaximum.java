import java.util.*;

/**
 * https://leetcode.com/problems/sliding-window-maximum/
 *
 * @author yunpeng
 *
 */
public class P0239SlidingWindowMaximum {
	static class Pair<S, T> {
		public Pair(S first, T second) {
			this.first = first;
			this.second = second;
		}

		S first;
		T second;
	}

	public static class SlideWindowQueue {
		// the second is the counts of elem between the current one and the
		// previous one;
		// when it is for the first elem, it is the count how many times it
		// needs to pop before reach to itself;
		private LinkedList<Pair<Integer, Integer>> queue = new LinkedList<Pair<Integer, Integer>>();

		public void push(int val) {
			int count = 0;
			while (!queue.isEmpty() && queue.peekLast().first < val) {
				count += queue.peekLast().second + 1; // 1 for the last elem
														// itself;
				queue.pollLast();
			}
			queue.addLast(new Pair<Integer, Integer>(val, count));
		}

		public void pop() {
			if (!queue.isEmpty()) {
				Pair<Integer, Integer> firstElem = queue.peekFirst();
				if (firstElem.second > 0) {
					firstElem.second--;
				} else {
					queue.pollFirst();
				}
			}
		}

		public int max() {
			return queue.peekFirst().first;
		}
	}

	public int[] maxSlidingWindow(int[] nums, int k) {
		int len = nums.length;
		if (len == 0) {
			return new int[0];
		}
		int[] outputs = new int[len - k + 1];
		if (k == 1) {
			for (int i = 0; i < len; i++) {
				outputs[i] = nums[i];
			}
			return outputs;
		}

		SlideWindowQueue queue = new SlideWindowQueue();
		for (int i = 0; i < len; i++) {
			int val = nums[i];
			queue.push(val);
			if (i >= k - 1) {
				outputs[i - k + 1] = queue.max();
				queue.pop();
			}
		}
		return outputs;
	}
}
