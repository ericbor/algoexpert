package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/build-an-array-with-stack-operations/
public class BuildArrayWithStackOperations {
    public List<String> buildArray(int[] target, int n) {
        List<String> results = new ArrayList<>();

        int targetIndex = 0;
        int nValue = 1;
        while (targetIndex < target.length && nValue <= n) {
            if(target[targetIndex] == nValue) {
                results.add("Push");
                targetIndex++;
            } else {
                results.add("Push");
                results.add("Pop");
            }
            nValue++;
        }

        return results;
    }

    @Test
    public void test() {
        Assert.assertEquals(List.of("Push", "Push", "Pop", "Push"), buildArray(new int[] { 1, 3 }, 3));
    }

    @Test
    public void test2() {
        Assert.assertEquals(List.of("Push","Push","Push"), buildArray(new int[] { 1, 2, 3 }, 3));
    }

    @Test
    public void test3() {
        Assert.assertEquals(List.of("Push","Push"), buildArray(new int[] { 1, 2 }, 4));
    }

    @Test
    public void test4() {
        Assert.assertEquals(List.of("Push","Pop","Push","Push","Push"), buildArray(new int[] { 2,3,4 }, 4));
    }
}
