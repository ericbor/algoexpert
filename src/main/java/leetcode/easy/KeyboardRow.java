package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/keyboard-row/
public class KeyboardRow {
    public String[] findWords(String[] words) {
        String[] rows = new String[3];
        rows[0] = "qwertyuiop";
        rows[1] = "asdfghjkl";
        rows[2] = "zxcvbnm";

        List<String> results = new ArrayList<>();
        for (String word : words) {
            if (canPrint(rows, word.toLowerCase())) {
                results.add(word);
            }
        }

        return results.toArray(new String[0]);
    }

    private boolean canPrint(String[] rows, String word) {
        int row1counter = 0;
        int row2counter = 0;
        int row3counter = 0;
        for (char c : word.toCharArray()) {
            if (rows[0].indexOf(c) != -1) {
                row1counter++;
            }
            if (rows[1].indexOf(c) != -1) {
                row2counter++;
            }
            if (rows[2].indexOf(c) != -1) {
                row3counter++;
            }
        }

        return word.length() == row1counter || word.length() == row2counter || word.length() == row3counter;
    }


    @Test
    public void test() {
        Assert.assertArrayEquals(new String[] { "Alaska", "Dad" }, findWords(new String[] { "Hello", "Alaska", "Dad", "Peace" }));
    }
}
