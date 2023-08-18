package array;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/count-vowel-substrings-of-a-string
public class CountVowelSubstrings {
    private final Set<Character> dict = Set.of('a', 'e', 'i', 'o', 'u');

    public int countVowelSubstrings(String word) {
        int count = 0;

        for (int i = 0; i < word.length() - 4; i++) {
            Set<Character> set = new HashSet<>();

            for (int j = i; j < word.length(); j++) {
                char c = word.charAt(j);
                if (dict.contains(c)) {
                    set.add(c);
                    if (set.size() == 5) {
                        count++;
                    }
                } else {
                    break;
                }
            }
        }

        return count;
    }

    @Test
    public void test3() {
        Assert.assertEquals(7, countVowelSubstrings("cuaieuouac"));
    }

    @Test
    public void test2() {
        Assert.assertEquals(0, countVowelSubstrings("unicornarihan"));
    }

    @Test
    public void test() {
        Assert.assertEquals(2, countVowelSubstrings("aeiouu"));
    }
}
