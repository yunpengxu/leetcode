import java.util.*;

/**
 * https://leetcode.com/problems/find-median-from-data-stream/
 * 
 * @author yunpeng
 * 
 */
public class FindMedianfromDataStream {

	private class MedianFinder {

		private PriorityQueue<Integer> maxQueue = new PriorityQueue<Integer>(
				1000, Collections.reverseOrder()); // smaller part
		private PriorityQueue<Integer> minQueue = new PriorityQueue<Integer>(); // larger part

		public void addNum(int num) {
			maxQueue.offer(num);
			minQueue.offer(maxQueue.poll());
			if (maxQueue.size() < minQueue.size()) {
				maxQueue.offer(minQueue.poll());
			}
		}

		public double findMedian() {
			if (maxQueue.size() == minQueue.size()) {
				return ((double) maxQueue.peek() + minQueue.peek()) / 2.0;
			} else
				return maxQueue.peek();
		}
	};
}
