
/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * @author yunpeng
 *
 */
public class P0122BestTimetoBuyandSellStockII {
	public int maxProfit(int[] prices) {
        int profit = 0;
		int len = prices.length;
		int nextp = 0;
		boolean buy = false;
		int preholding = 0;
		for (int i = 0; i < len; i++) {
			if (i == len - 1) {
				if (buy) {
					profit += prices[len-1] - preholding;
				}
				break;
			}

			int curp = prices[i];
			nextp = prices[i + 1];
			if (curp == nextp) {
				continue;
			}
			if (curp < nextp) {
				if (!buy) {
					preholding = curp;
					buy = true;
				} else {
					continue;
				}
			} else {
				if (!buy) {
					continue;
				} else {
					profit += curp - preholding;
					preholding = 0;
					buy = false;
				}
			}
		}

		return profit > 0 ? profit : 0;
    }
}
