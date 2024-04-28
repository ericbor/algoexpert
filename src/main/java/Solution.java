import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Solution {
	public static int suitableLocations(List<Integer> center, long d) {
		Collections.sort(center);
		int start = center.get(0) - 1;
		int end = center.get(center.size() - 1) + 1;
		int locationsCount = 0;

		for(int warehouse = start; warehouse < end; warehouse++) {
			long totalDistance = 0;
			for(int i = center.size() - 1; i >= 0; i--) {
				long distance = Math.abs(warehouse - center.get(i)) * 2;
				totalDistance += distance;
				if(totalDistance > d) {
					break;
				}
			}

			if(totalDistance <= d) {
				locationsCount++;
			}
		}

		return locationsCount;
	}

	@Test
	public void test() {
		Assert.assertEquals(3, suitableLocations(new ArrayList<>(List.of(-2, 1, 0)), 8));
		//Assert.assertEquals(1, reduceGifts(List.of(3,2,1,4,6,5), 3, 14));

	}
}
