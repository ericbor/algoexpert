package educative.subsets.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/*
Given a string, find all of its permutations preserving the character sequence but changing case.

Input: "ab7c"
Output: "ab7c", "Ab7c", "aB7c", "AB7c", "ab7C", "Ab7C", "aB7C", "AB7C"
 */
public class LetterCaseStringPermutation {

    public static List<String> findLetterCaseStringPermutations(String str) {
        List<String> permutations = new ArrayList<>();
        if (str == null) {
            return permutations;
        }

        permutations.add(str);
        // process every character of the string one by one
        for (int i = 0; i < str.length(); i++) {
            // only process characters, skip digits
            if (Character.isLetter(str.charAt(i))) {
                // we will take all existing permutations and change the letter case appropriately
                int n = permutations.size();
                for (int k = 0; k < n; k++) {
                    char[] chars = permutations.get(k).toCharArray();
                    // if the current character is in upper case change it to lower case or vice versa
                    if (Character.isUpperCase(chars[i])) {
                        chars[i] = Character.toLowerCase(chars[i]);
                    } else {
                        chars[i] = Character.toUpperCase(chars[i]);
                    }
                    permutations.add(String.valueOf(chars));
                }
            }
        }
        return permutations;
    }

    @Test
    public void main() {
        List<String> result = findLetterCaseStringPermutations("ab7c");
        assertEquals(8, result.size());
        assertTrue(result.contains("ab7c"));
        assertTrue(result.contains("Ab7c"));
        assertTrue(result.contains("aB7c"));
        assertTrue(result.contains("AB7c"));
        assertTrue(result.contains("ab7C"));
        assertTrue(result.contains("Ab7C"));
        assertTrue(result.contains("aB7C"));
        assertTrue(result.contains("AB7C"));
    }
}
