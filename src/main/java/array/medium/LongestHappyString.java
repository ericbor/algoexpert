package array.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/longest-happy-string/
public class LongestHappyString {

    public String longestDiverseString(int a, int b, int c) {

        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p2.count - p1.count);

        if (a > 0) {
            pq.add(new Pair('a', a));
        }
        if (b > 0) {
            pq.add(new Pair('b', b));
        }
        if (c > 0) {
            pq.add(new Pair('c', c));
        }

        StringBuilder sb = new StringBuilder();
        while (pq.size() > 1) {

            Pair p1 = pq.poll();
            if (p1.count >= 2) {
                sb.append(p1.ch);
                sb.append(p1.ch);
                p1.count -= 2;
            } else {
                sb.append(p1.ch);
                p1.count -= 1;
            }

            Pair p2 = pq.poll();
            if (p2.count >= 2 && p1.count < p2.count) {
                sb.append(p2.ch);
                sb.append(p2.ch);
                p2.count -= 2;
            } else {
                sb.append(p2.ch);
                p2.count -= 1;
            }

            if (p1.count > 0) {
                pq.add(p1);
            }
            if (p2.count > 0) {
                pq.add(p2);
            }
        }

        if (!pq.isEmpty()) {
            if (sb.length() == 0 || sb.charAt(sb.length() - 1) != pq.peek().ch) {
                if (pq.peek().count >= 2) {
                    sb.append(pq.peek().ch);
                    sb.append(pq.peek().ch);
                } else {
                    sb.append(pq.peek().ch);
                }
            }
        }

        return sb.toString();
    }

    class Pair {
        public Character ch;
        int count;

        public Pair(Character ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }

    public String longestDiverseString2(int a, int b, int c) {
        Map<Character, Integer> map = new HashMap<>();
        if (a > 0) {
            map.put('a', a);
        }
        if (b > 0) {
            map.put('b', b);
        }
        if (c > 0) {
            map.put('c', c);
        }

        Queue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());
        maxHeap.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();

        while (maxHeap.size() > 1) {
            Map.Entry<Character, Integer> e1 = maxHeap.poll();
            Map.Entry<Character, Integer> e2 = maxHeap.poll();
            int e1Length = e1.getValue();
            int e2Length = e2.getValue();

            int diff = e1Length - e2Length;
            if (diff > 1) {
                sb.append(e1.getKey());
                e1Length--;
            }
            sb.append(e1.getKey());
            e1Length--;
            sb.append(e2.getKey());
            e2Length--;

            if (e1Length > 0) {
                e1.setValue(e1Length);
                maxHeap.add(e1);
            }
            if (e2Length > 0) {
                e2.setValue(e2Length);
                maxHeap.add(e2);
            }
        }

        if (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> e1 = maxHeap.poll();
            int size = Math.min(2, e1.getValue());
            for (int i = 0; i < size; i++) {
                sb.append(e1.getKey());
            }

        }

        return sb.toString();
    }

    @Test
    public void test() {
        Assert.assertEquals("cc", longestDiverseString(0, 0, 7));
    }

    @Test
    public void test4() {
        Assert.assertEquals("ccbccbccbbccbbccbbc", longestDiverseString(0, 8, 11));
    }

    @Test
    public void test3() {
        Assert.assertEquals("aabaa", longestDiverseString(7, 1, 0));
    }

    @Test
    public void test2() {
        Assert.assertEquals("ccaccbcc", longestDiverseString(1, 1, 7));
        Assert.assertEquals("ccaccbcc", longestDiverseString2(1, 1, 7));
    }
}
