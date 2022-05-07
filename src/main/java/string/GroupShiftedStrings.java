package string;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/group-shifted-strings/
public class GroupShiftedStrings {
    public List<List<String>> groupStrings_2(String[] strings) {
        Map<String, Integer> hash = new HashMap<>();
        for (String s : strings) {
            hash.put(s, hash.getOrDefault(s, 0) + 1);
        }

        List<List<String>> results = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            if (!hash.containsKey(strings[i])) {
                continue;
            }

            List<String> result = new ArrayList<>();
            result.add(strings[i]);
            updateMap(hash, strings[i]);

            char[] arr = strings[i].toCharArray();
            for (int k = 0; k <= 26; k++) {
                for (int j = 0; j < arr.length; j++) {
                    if (arr[j] == 'z') {
                        arr[j] = 'a';
                    } else {
                        arr[j] += 1;
                    }
                }
                String shifted = String.valueOf(arr);

                if (hash.containsKey(shifted)) {
                    result.add(shifted);
                    updateMap(hash, shifted);
                }
            }

            results.add(result);
        }

        return results;
    }

    private void updateMap(Map<String, Integer> hash, String key) {
        if (hash.get(key) > 1) {
            hash.put(key, hash.get(key) - 1);
        } else {
            hash.remove(key);
        }
    }



    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> mapHashToList = new HashMap<>();

        // Create a hash_value (hashKey) for each string and append the string
        // to the list of hash values i.e. mapHashToList["abc"] = ["abc", "bcd"]
        for (String str : strings) {
            String hashKey = getHash(str);
            if (mapHashToList.get(hashKey) == null) {
                mapHashToList.put(hashKey, new ArrayList<>());
            }
            mapHashToList.get(hashKey).add(str);
        }

        // Iterate over the map, and add the values to groups
        List<List<String>> groups = new ArrayList<>();
        for (List<String> group : mapHashToList.values()) {
            groups.add(group);
        }

        return groups;
    }

    private char shiftLetter(char letter, int shift) {
        return (char) ((letter - shift + 26) % 26 + 'a');
    }

    // Create a hash value
    private String getHash(String s) {
        char[] chars = s.toCharArray();

        // Calculate the number of shifts to make the first character to be 'a'
        int shift = chars[0];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = shiftLetter(chars[i], shift);
        }

        return String.valueOf(chars);
    }

    @Test
    public void test3() {
        Assert.assertEquals(List.of(List.of("a", "a")), groupStrings(new String[] { "a", "a" }));
    }

    @Test
    public void test2() {
        Assert.assertEquals(List.of(List.of("ab"), List.of("ba")), groupStrings(new String[] { "ab", "ba" }));
    }

    @Test
    public void test() {
        Assert.assertEquals(List.of(List.of("abc", "bcd", "xyz"), List.of("acef"), List.of("az", "ba"), List.of("a", "z")), groupStrings(new String[] { "abc", "bcd", "acef", "xyz", "az", "ba", "a", "z" }));
    }
}
