package array;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/make-array-zero-by-subtracting-equal-amounts
public class MakeArrayZeroBySubtractingEqualAmounts {
	public int minimumOperations(int[] nums) {
		int[] indices = new int[101];
		int max = Integer.MIN_VALUE;
		for(int i: nums) {
			indices[i]++;
			max = Math.max(max, i);
		}
		int operations = 0;

		for(int j = 1; j <= max; j++) {
			if(indices[j] > 0) {
				operations++;
			}
		}

		return operations;
	}

	@Test
	public void test2() {
		Assert.assertEquals(3, minimumOperations(new int[]{1,5,0,3,5}));
	}
}
