package array;

import org.junit.Assert;
import org.junit.Test;

import java.util.TreeMap;

//https://leetcode.com/problems/plates-between-candles
public class PlatesBetweenCandles {
	public int[] platesBetweenCandles(String s, int[][] queries) {
		int n = s.length();
		TreeMap<Integer, Integer> idxToCountMap = new TreeMap<>();
		int candleCount = 1;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '|') {
				idxToCountMap.put(i, candleCount);
				candleCount++;
			}
		}
		int[] ans = new int[queries.length];
		for (int i = 0; i < queries.length; i++) {
			Integer index1 = idxToCountMap.ceilingKey(queries[i][0]);
			Integer index2 = idxToCountMap.floorKey(queries[i][1]);
			if (index1 == null || index2 == null || index1 >= index2) {
				continue;
			}
			int candlesCount1 = idxToCountMap.get(index1);
			int candlesCount2 = idxToCountMap.get(index2);
			ans[i] = index2 - index1 - (candlesCount2 - candlesCount1);
		}
		return ans;
	}

	@Test
	public void test1() {
		Assert.assertArrayEquals(new int[]{9, 0, 0, 0, 0}, platesBetweenCandles("***|**|*****|**||**|*", new int[][]{{1, 17}, {4, 5}, {14, 17}, {5, 11}, {15, 16}}));
	}
}
