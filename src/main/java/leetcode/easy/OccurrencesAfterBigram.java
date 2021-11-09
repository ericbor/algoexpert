package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/occurrences-after-bigram/
public class OccurrencesAfterBigram {
    public String[] findOcurrences(String text, String first, String second) {
        String[] words = text.split(" ");

        List<String> thirds = new ArrayList<>();

        for (int i = 2; i < words.length; i++) {
            if (first.equals(words[i - 2]) && second.equals(words[i - 1])) {
                thirds.add(words[i]);
            }
        }

        return thirds.toArray(new String[0]);
    }

    @Test
    public void test() {
        Assert.assertArrayEquals(new String[] {}, findOcurrences("obo jvezipre obo jnvavldde jvezipre jvezipre jnvavldde jvezipre jvezipre jvezipre y jnvavldde jnvavldde obo jnvavldde jnvavldde obo jnvavldde jnvavldde jvezipre","jnvavldde","y"));
    }

    @Test
    public void test2() {
        Assert.assertArrayEquals(new String[] { "girl", "student" }, findOcurrences("alice is a good girl she is a good student", "a", "good"));
    }

    @Test
    public void test3() {
        Assert.assertArrayEquals(new String[] { "student" }, findOcurrences("alice is aa good girl she is a good student", "a", "good"));
    }

    @Test
    public void test4() {
        Assert.assertArrayEquals(new String[] { "we", "rock" }, findOcurrences("we will we will rock you", "we", "will"));
    }

    @Test
    public void test5() {
        Assert.assertArrayEquals(new String[] { "kcyxdfnoa", "kcyxdfnoa", "kcyxdfnoa" }, findOcurrences("jkypmsxd jkypmsxd kcyxdfnoa jkypmsxd kcyxdfnoa jkypmsxd kcyxdfnoa kcyxdfnoa jkypmsxd kcyxdfnoa", "kcyxdfnoa", "jkypmsxd"));
    }
}
