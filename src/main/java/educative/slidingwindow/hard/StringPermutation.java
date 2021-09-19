package educative.slidingwindow.hard;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://www.educative.io/courses/grokking-the-coding-interview/N8vB7OVYo2D
public class StringPermutation {
    public static boolean findPermutation(String str, String pattern) {
        List<Character> patternLetters = new ArrayList<>();
        for (char c : pattern.toCharArray()) {
            patternLetters.add(c);
        }

        int windowStart = 0;
        List<Character> stringLetters = new ArrayList<>();
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            stringLetters.add(str.charAt(windowEnd));

            if (stringLetters.size() == pattern.length()) {
                if (stringLetters.containsAll(patternLetters)) {
                    return true;
                } else {
                    char toRemove = str.charAt(windowStart);
                    stringLetters.remove(Character.valueOf(toRemove));
                    windowStart++;
                }
            }
        }

        return false;
    }

    public static boolean findPermutation2(String str, String pattern) {

        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char chr : pattern.toCharArray()) {
            charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);
        }

        int windowStart = 0;
        int matched = 0;
        // our goal is to match all the characters from the 'charFrequencyMap' with the current window
        // try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            if (charFrequencyMap.containsKey(rightChar)) {
                // decrement the frequency of the matched character
                charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar) - 1);
                if (charFrequencyMap.get(rightChar) == 0) { // character is completely matched
                    matched++;
                }
            }

            if (matched == charFrequencyMap.size()) {
                return true;
            }

            if (windowEnd + 1 >= pattern.length()) { // shrink the window by one character
                char leftChar = str.charAt(windowStart);
                if (charFrequencyMap.containsKey(leftChar)) {
                    if (charFrequencyMap.get(leftChar) == 0) {
                        matched--; // before putting the character back, decrement the matched count
                    }
                    // put the character back for matching
                    charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) + 1);
                }
                windowStart++;
            }
        }

        return false;
    }

    @Test
    public void verify() {
        //Assert.assertTrue(findPermutation("oidbcaf", "abc"));
        //Assert.assertFalse(findPermutation("odicf", "dc"));
        //Assert.assertTrue(findPermutation("bcdxabcdy", "bcdyabcdx"));
        //Assert.assertTrue(findPermutation("aaacb", "abc"));

        //Assert.assertTrue(findPermutation2("oidbcaf", "abc"));
        Assert.assertFalse(findPermutation2("odicf", "dc"));
        //Assert.assertTrue(findPermutation2("bcdxabcdy", "bcdyabcdx"));
        //Assert.assertTrue(findPermutation2("aaacb", "abc"));
    }
}
