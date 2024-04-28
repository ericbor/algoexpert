package other;

import java.util.PriorityQueue;

//https://leetcode.com/problems/sequentially-ordinal-rank-tracker
public class OrdinalRankTracker {
	private final PriorityQueue<Location> minHeap;
	private final PriorityQueue<Location> maxHeap;

	public OrdinalRankTracker() {
		minHeap = new PriorityQueue<>((a,b) -> {
			if(a.score - b.score == 0) {
				return a.site.compareTo(b.site);
			}

			return b.score - a.score;
		});
		maxHeap = new PriorityQueue<>((a,b) -> {
			if(a.score - b.score == 0) {
				return b.site.compareTo(a.site);
			}

			return a.score - b.score;
		});
	}

	public void add(String name, int score) {
		Location location = new Location(name, score);
		minHeap.add(location);
		maxHeap.add(minHeap.poll());
	}

	public String get() {
		Location location = maxHeap.poll();
		minHeap.add(location);

		return location.site;
	}
}

class Location {
	public final String site;
	public final int score;
	public Location(String site, int score) {
		this.site = site;
		this.score = score;
	}
}
