package array;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/first-bad-version
public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int end = n;
        int start = 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            //int mid = (end + start) / 2;
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    private boolean isBadVersion(int version) {
        return version > 1024;
    }

    @Test
    public void test() {
        Assert.assertEquals(1025, firstBadVersion(Integer.MAX_VALUE));
    }
}
