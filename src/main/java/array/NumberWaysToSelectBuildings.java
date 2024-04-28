package array;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/number-of-ways-to-select-buildings/solutions/1907002/010-or-101-java-easy-to-understand/
public class NumberWaysToSelectBuildings {
	public long numberOfWays(String s) {
		int zero = 0;
		int one = 0;
		int zeroOne = 0;
		int oneZero = 0;
		int total = 0;

		for(char c: s.toCharArray()) {
			if(c == '0') {
				zero++;
				oneZero += one; // Each of the previously found 1s can pair up with the current 0 to form 10
				total += zeroOne; // Each of the previously formed 01 can form a triplet with the current 0 to form 010
			} else {
				one++;
				zeroOne += zero; // Each of the previously found 0s can pair to form 01
				total += oneZero; // Each of the previously formed 10 can form 101
			}
		}

		return total;
	}

	@Test
	public void test1() {
		Assert.assertEquals(6, numberOfWays("001101"));
	}
}
