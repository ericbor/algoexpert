package leetcode.medium.trie;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

//https://leetcode.com/problems/search-suggestions-system/
public class SearchSuggestionsSystem {
    public List<List<String>> suggestedProducts2(String[] products, String searchWord) {
        Arrays.sort(products);

        List<List<String>> results = new ArrayList<>();

        for (int i = 1; i <= searchWord.length(); i++) {
            String substring = searchWord.substring(0, i);
            List<String> result = new ArrayList<>(3);

            for (String prod : products) {
                if (prod.startsWith(substring)) {
                    result.add(prod);
                    if (result.size() == 3) {
                        break;
                    }
                }
            }

            results.add(result);
        }

        return results;
    }

    public List<List<String>> suggestedProducts3(String[] products, String searchWord) {
        Arrays.sort(products);
        int start = 0;
        int end = products.length - 1;

        List<List<String>> results = new ArrayList<>(searchWord.length());

        for (int i = 0; i < searchWord.length() && start <= end; i++) {
            while (start <= end &&
                // Skip products[start] if index i is not a match
                (products[start].length() <= i || products[start].charAt(i) != searchWord.charAt(i))
            ) {
                ++start;
            }

            while (start <= end &&
                // Skip products[end] if index i is not a match
                (products[end].length() <= i || products[end].charAt(i) != searchWord.charAt(i))
            ) {
                --end;
            }

            // Pick the first 3 starting from start, but not going over end
            List<String> result = new ArrayList<>(3);
            for (int k = start; k <= end && k < start + 3; k++) {
                result.add(products[k]);
            }
            results.add(result);
        }

        return results;
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        PriorityQueue<String> queue = new PriorityQueue<>(Comparator.reverseOrder());
        List<List<String>> results = new ArrayList<>();

        for (int i = 1; i <= searchWord.length(); i++) {
            String substring = searchWord.substring(0, i);
            for (String product : products) {
                if (product.startsWith(substring)) {
                    queue.offer(product);

                    if (queue.size() > 3) {
                        queue.poll();
                    }
                }
            }

            List<String> result = new ArrayList<>(queue.size());
            while (!queue.isEmpty()) {
                result.add(0, queue.poll());
            }
            results.add(result);
        }

        return results;
    }

    @Test
    public void test() {
        Assert.assertEquals(List.of(List.of("mobile", "moneypot", "monitor"), List.of("mobile", "moneypot", "monitor"),
                List.of("mouse", "mousepad"), List.of("mouse", "mousepad"), List.of("mouse", "mousepad")),
            suggestedProducts(new String[] { "mobile", "mouse", "moneypot", "monitor", "mousepad" }, "mouse"));
    }
}
