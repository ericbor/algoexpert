package leetcode.medium.string;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/group-shifted-strings/
public class GroupShiftedStrings {

    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strings) {
            int offset = (int) str.charAt(0) - (int) 'a';
            String key = "";
            for (int i = 0; i < str.length(); i++) {
                char c = (char) ((int) str.charAt(i) - offset);
                if (c < 'a') {
                    c += 26;
                }
                key += c;
            }
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }

        List<List<String>> result = new ArrayList<>();
        for (List<String> list : map.values()) {
            Collections.sort(list);
            result.add(list);
        }
        return result;
    }

    @Test
    public void test() {
        Assert.assertEquals(List.of(List.of("abc", "bcd", "xyz"), List.of("a", "z"), List.of("acef"), List.of("az", "ba")), groupStrings(new String[] { "abc", "bcd", "acef", "xyz", "az", "ba", "a", "z" }));
    }
}
