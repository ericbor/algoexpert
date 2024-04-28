package binarysearch;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/koko-eating-bananas
public class KokoBananas {
	public int minEatingSpeed(int[] piles, int h) {
		// Initalize the start and end boundaries
		int start = 1;
		int end = 1;
		for (int pile : piles) {
			end = Math.max(end, pile);
		}

		while (start < end) {
			// Get the middle index between start and end boundary indexes.
			// hourSpent stands for the total hour Koko spends.
			int middle = (start + end) / 2;
			int hourSpent = 0;

			// Iterate over the piles and calculate hourSpent.
			// We increase the hourSpent by ceil(pile / middle)
			for (int pile : piles) {
				hourSpent += Math.ceil((double) pile / middle);
			}

			// Check if middle is a workable speed, and cut the search space by half.
			if (hourSpent <= h) {
				end = middle;
			} else {
				start = middle + 1;
			}
		}

		// Once the start and end boundaries coincide, we find the target value,
		// that is, the minimum workable eating speed.
		return end;
	}

	@Test
	public void verify() {
		Assert.assertEquals(4, minEatingSpeed(new int[] { 3,6,7,11 }, 8));
	}
}
