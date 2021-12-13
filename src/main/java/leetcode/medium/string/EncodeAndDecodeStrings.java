package leetcode.medium.string;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/encode-and-decode-strings/
public class EncodeAndDecodeStrings {
    private static final String EMPTY = "$";
    private static final String WORD_DELIMITER = "&";
    private static final String CHAR_DELIMITER = "#";
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for(String str: strs) {
            sb.append(encode(str));
        }

        return sb.toString();
    }

    private String encode(String s) {
        StringBuilder sb = new StringBuilder();
        if(s.isEmpty()) {
            sb.append(EMPTY);
        }

        for(char c : s.toCharArray()) {
            int ascii = (int)c;
            sb.append(ascii).append(CHAR_DELIMITER);
        }

        sb.append(WORD_DELIMITER);

        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        String[] strings = s.split(WORD_DELIMITER);

        List<String> results = new ArrayList<>();
        for(String str: strings) {
            results.add(decodeOne(str));
        }

        return results;
    }

    private String decodeOne(String s) {
        if(EMPTY.equals(s)) {
            return "";
        }
        String[] chars = s.split(CHAR_DELIMITER);
        StringBuilder sb = new StringBuilder();
        for(String ascii: chars) {
            int c = Integer.parseInt(ascii);
            char ch = (char)c;
            sb.append(ch);
        }

        return sb.toString();
    }

    @Test
    public void test() {
        String encoded = encode(List.of("", ""));
        Assert.assertEquals(List.of("", ""), decode(encoded));
    }

    @Test
    public void test3() {
        String encoded = encode(List.of(""));
        Assert.assertEquals(List.of(""), decode(encoded));
    }

    @Test
    public void test2() {
        String encoded = encode(List.of("Hello", "World"));
        Assert.assertEquals(List.of("Hello", "World"), decode(encoded));
    }
}
