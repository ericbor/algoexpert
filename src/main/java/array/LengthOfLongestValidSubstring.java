package array;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/length-of-the-longest-valid-substring/
public class LengthOfLongestValidSubstring {
	public int longestValidSubstring(String word, List<String> forbidden) {
		Set<String> set = new HashSet<>(forbidden);
		int maxLen = 0;
		int r = word.length();

		for (int i = word.length() - 1; i >= 0; i--) {
			for (int j = i; j < r && j < 10 + i; j++) {
				String sub = word.substring(i, j);

				if (set.contains(sub)) {
					r = j;
					break;
				}
			}
			maxLen = Math.max(maxLen, r - i);
		}

		return maxLen;
	}

	@Test
	public void test2() {
		Assert.assertEquals(4, longestValidSubstring("cbaaaabc", List.of("aaa","cb")));
		//Assert.assertEquals(4, longestValidSubstring("leetcode", List.of("de","le","e")));
	}
}
