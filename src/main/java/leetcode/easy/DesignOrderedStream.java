package leetcode.easy;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/design-an-ordered-stream/
public class DesignOrderedStream {
    private String[] values;
    private int ptr;

    public DesignOrderedStream(int n) {
        values = new String[n];
        ptr = 0;
    }

    public List<String> insert(int id, String value) {
        values[id - 1] = value;

        List<String> result = new ArrayList<>();
        while (ptr < values.length && values[ptr] != null) {
            result.add(values[ptr]);
            ptr++;
        }

        return result;
    }

    public static void main(String[] args) {
        DesignOrderedStream os = new DesignOrderedStream(5);
        Assert.assertEquals(Collections.emptyList(), os.insert(3, "ccc"));
        Assert.assertEquals(List.of("aaa"), os.insert(1, "aaa"));
        Assert.assertEquals(List.of("bbb", "ccc"), os.insert(2, "bbb"));
        Assert.assertEquals(Collections.emptyList(), os.insert(5, "eee"));
        Assert.assertEquals(List.of("ddd", "eee"), os.insert(4, "ddd"));
    }
}
