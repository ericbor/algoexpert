package leetcode.amazon;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/design-twitter/
public class TwitterTest {
    @Test
    public void test() {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        Assert.assertEquals(List.of(5), twitter.getNewsFeed(1));

        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        Assert.assertEquals(List.of(6, 5), twitter.getNewsFeed(1));

        twitter.unfollow(1, 2);
        Assert.assertEquals(List.of(5), twitter.getNewsFeed(1));
    }

    @Test
    public void test2() {
        Twitter twitter = new Twitter();

        twitter.follow(1, 2);
        Assert.assertEquals(Collections.emptyList(), twitter.getNewsFeed(1));
        Assert.assertEquals(Collections.emptyList(), twitter.getNewsFeed(2));
    }

    @Test
    public void test3() {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 4);
        twitter.postTweet(2, 5);
        twitter.unfollow(1, 2);
        Assert.assertEquals(List.of(4), twitter.getNewsFeed(1));
        Assert.assertEquals(List.of(5), twitter.getNewsFeed(2));
    }

    @Test
    public void test4() {
        Twitter2 twitter = new Twitter2();
        twitter.postTweet(1, 5);
        Assert.assertEquals(List.of(5), twitter.getNewsFeed(1));

        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        Assert.assertEquals(List.of(6, 5), twitter.getNewsFeed(1));

        twitter.unfollow(1, 2);
        Assert.assertEquals(List.of(5), twitter.getNewsFeed(1));
    }

    @Test
    public void test5() {
        Twitter2 twitter = new Twitter2();

        twitter.follow(1, 2);
        Assert.assertEquals(Collections.emptyList(), twitter.getNewsFeed(1));
        Assert.assertEquals(Collections.emptyList(), twitter.getNewsFeed(2));
    }

    @Test
    public void test6() {
        Twitter2 twitter = new Twitter2();
        twitter.postTweet(1, 4);
        twitter.postTweet(2, 5);
        twitter.unfollow(1, 2);
        Assert.assertEquals(List.of(4), twitter.getNewsFeed(1));
        Assert.assertEquals(List.of(5), twitter.getNewsFeed(2));
    }
}
