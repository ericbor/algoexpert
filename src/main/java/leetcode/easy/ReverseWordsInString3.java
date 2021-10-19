package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/reverse-words-in-a-string-iii/
public class ReverseWordsInString3 {
    public String reverseWords(String s) {
        List<String> words = split(s);

        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(reverse(word));
            sb.append(" ");
        }

        return sb.toString().trim();
    }

    private String reverse(String word) {
        char[] result = word.toCharArray();
        int start = 0;
        int end = word.length() - 1;
        while (start < end) {
            swap(result, start, end);
            start++;
            end--;
        }

        return String.valueOf(result);
    }

    private void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private List<String> split(String str) {
        List<String> results = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                results.add(sb.toString());
                sb.setLength(0);
            }  else {
                sb.append(c);
            }
        }
        //last word
        results.add(sb.toString());

        return results;
    }

    public String reverseWords2(String s) {
        char[] words = s.toCharArray();

        int start = 0;
        int end = 0;
        while (start < words.length) {
            while (words[end] != ' ' && end < words.length - 1){
                end++;
            }
            if(end == words.length - 1) {
                end++;
            }

            reverse(words, start, end - 1);
            end++;
            start = end;
        }

        return String.valueOf(words);
    }

    private void reverse(char[] arr, int i, int j){
        int start = i;
        int end = j;
        while (start < end){
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    @Test
    public void test() {
        Assert.assertEquals("s'teL ekat edoCteeL tsetnoc", reverseWords("Let's take LeetCode contest"));
    }

    @Test
    public void test2() {
        Assert.assertEquals("s'teL ekat edoCteeL tsetnoc", reverseWords2("Let's take LeetCode contest"));
    }
}
