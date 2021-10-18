package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/logger-rate-limiter/
public class LoggerRateLimiter {
    Map<String, Integer> logs = new HashMap();

    public LoggerRateLimiter() {
    }

    public boolean shouldPrintMessage(int timestamp, String message) {

        if (!logs.containsKey(message)) {
            logs.put(message, timestamp);
            return true;
        }

        Integer oldTimestamp = logs.get(message);
        if (timestamp - oldTimestamp >= 10) {
            logs.put(message, timestamp);
            return true;
        }

        return false;
    }

    @Test
    public void test(){
        LoggerRateLimiter logger = new LoggerRateLimiter();
        Assert.assertTrue(logger.shouldPrintMessage(0, "A"));
        Assert.assertTrue(logger.shouldPrintMessage(0, "B"));  // return true, next allowed timestamp for "foo" is 1 + 10 = 11// return true, next allowed timestamp for "bar" is 2 + 10 = 12
        Assert.assertTrue(logger.shouldPrintMessage(0, "C"));  // 3 < 11, return false
        Assert.assertFalse(logger.shouldPrintMessage(0, "A"));  // 8 < 12, return false
        Assert.assertFalse( logger.shouldPrintMessage(0, "B")); // 10 < 11, return false
        Assert.assertFalse(logger.shouldPrintMessage(0, "C"));
        Assert.assertTrue(logger.shouldPrintMessage(11, "A"));
        Assert.assertTrue(logger.shouldPrintMessage(11, "B"));
        Assert.assertTrue(logger.shouldPrintMessage(11, "C"));
        Assert.assertFalse(logger.shouldPrintMessage(11, "A"));
    }
}
