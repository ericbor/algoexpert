package array;

import org.junit.Assert;
import org.junit.Test;

public class FindDuplicateNumber {
	public int findDuplicate(int[] nums) {
		// [4,1,2,3,2]
		while (nums[0] != nums[nums[0]]) {
			int idx = nums[0];

			int nxt = nums[idx];//4
			nums[idx] = nums[0];//3 = 1
			nums[0] = nxt;
		}
		return nums[0];
	}

	public int findDuplicate2(int[] nums) {

		// Find the intersection point of the two runners.
		int slow = nums[0];
		int fast = nums[0];

		do {
			slow = nums[slow];
			fast = nums[nums[fast]];
		} while (slow != fast);

		// Find the "entrance" to the cycle.
		slow = nums[0];

		while (slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}

		return fast;
	}

	@Test
	public void test() {
		Assert.assertEquals(2, findDuplicate(new int[]{1,3,4,2,2}));
		Assert.assertEquals(2, findDuplicate2(new int[]{1,3,4,2,2}));
	}

}
