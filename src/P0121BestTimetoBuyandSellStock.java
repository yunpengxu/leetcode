/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * @author yunpeng
 *
 */
public class P0121BestTimetoBuyandSellStock {
	public int maxProfit(int[] prices) {
		int profit = 0;
		int len = prices.length;
		if (len > 0) {
			int[] min = new int[len];
			min[0] = prices[0];
			for (int i = 1; i < len; i++) {
				if (prices[i] < min[i - 1]) {
					min[i] = prices[i];
				} else {
					min[i] = min[i - 1];
				}
				int diff = prices[i] - min[i];
				if (diff > profit) {
					profit = diff;
				}
			}
		}
		return profit;
	}
}
