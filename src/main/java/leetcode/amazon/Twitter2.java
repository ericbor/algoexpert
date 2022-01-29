package leetcode.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

//https://leetcode.com/problems/design-twitter/
public class Twitter2 {
    Map<Integer, Set<Integer>> userFollowees;
    Map<Integer, List<Tweet>> userTweets;
    private int timestamp = 0;
    private static final Integer MAX_FEED = 10;

    public Twitter2() {
        this.userFollowees = new HashMap<>();
        this.userTweets = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        userTweets.computeIfAbsent(userId, value -> new LinkedList<>());
        userTweets.get(userId).add(0, new Tweet(tweetId, timestamp));
        follow(userId, userId);
    }

    public List<Integer> getNewsFeed(int userId) {

        List<Integer> feed = new ArrayList<>();
        Set<Integer> followees = userFollowees.get(userId);
        if (followees == null || followees.isEmpty()) {
            return feed;
        }

        Queue<Tweet> minHeap = new PriorityQueue<>((a, b) -> a.time - b.time);
        for (Integer followeeId : followees) {
            if (userTweets.containsKey(followeeId)) {
                for (Tweet tweet : userTweets.get(followeeId)) {
                    minHeap.add(tweet);
                    if (minHeap.size() > MAX_FEED) {
                        minHeap.poll();
                    }
                }
            }
        }

        while (!minHeap.isEmpty()) {
            feed.add(0, minHeap.poll().id);
        }

        return feed;
    }

    public void follow(int followerId, int followeeId) {
        userFollowees.computeIfAbsent(followerId, value -> new HashSet<>());
        userFollowees.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (userFollowees.containsKey(followerId)) {
            userFollowees.get(followerId).remove(followeeId);
        }
    }

    class Tweet {
        int id;
        int time;

        public Tweet(Integer id, Integer time) {
            this.id = id;
            this.time = time;
            timestamp++;
        }
    }
}
