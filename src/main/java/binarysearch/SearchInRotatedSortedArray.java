package binarysearch;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/search-in-rotated-sorted-array/
public class SearchInRotatedSortedArray {
	public int search(int[] nums, int target) {
		if (nums.length == 1) {
			return nums[0] == target ? 0 : -1;
		}

		int start = 0;
		int end = nums.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (nums[mid] == target) {
				return mid;
			}

			if (nums[mid] >= nums[start]) {
				if (target >= nums[start] && target < nums[mid]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else {
				if (target <= nums[end] && target > nums[mid]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}

		return -1;

	}

	@Test
	public void test() {
		Assert.assertEquals(4, search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
	}

	@Test
	public void test2() {
		Assert.assertEquals(-1, search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
	}

	@Test
	public void test3() {
		Assert.assertEquals(-1, search(new int[]{1}, 0));
	}
}
