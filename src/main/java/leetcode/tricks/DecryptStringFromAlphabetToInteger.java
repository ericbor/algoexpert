package leetcode.tricks;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/
public class DecryptStringFromAlphabetToInteger {
    public String freqAlphabets(String s) {

        char[] arr = s.toCharArray();

        StringBuilder sb = new StringBuilder();
        int end = arr.length - 1;
        while(end >= 0) {
            if(arr[end] == '#') {

                int num = Integer.parseInt(s.substring(end - 2, end));
                int asci = (int) 'a' - 1;
                char result = (char) (num + asci);

                sb.append(result);
                end -= 3;
            } else {
                int num = (int) arr[end] - (int) '0';
                int asci = (int) 'a' - 1;
                char result = (char) (num + asci);

                sb.append(result);
                end--;
            }
        }

        return sb.reverse().toString();
    }

    public String freqAlphabets2(String str) {
        Map<String, Character> map = new HashMap<>();
        int k = 1;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (ch < 'j') {
                map.put(String.valueOf(k), ch);
            } else {
                map.put(String.valueOf(k)+"#", ch);
            }
            k++;
        }

        StringBuilder sb = new StringBuilder();
        int end = str.length() - 1;
        while (end >= 0) {
            if (str.charAt(end) == '#') {
                sb.append(map.get(str.substring(end - 2, end+1)));
                end -= 3;
            } else {
                sb.append(map.get(str.substring(end, end + 1)));
                end--;
            }
        }

        return sb.reverse().toString();
    }

    @Test
    public void test() {
        Assert.assertEquals("acz", freqAlphabets("1326#"));
    }

    @Test
    public void test2() {
        Assert.assertEquals("acz", freqAlphabets2("1326#"));
    }
}
