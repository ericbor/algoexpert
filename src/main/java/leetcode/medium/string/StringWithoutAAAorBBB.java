package leetcode.medium.string;

import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/longest-happy-string/
public class StringWithoutAAAorBBB {
    public String strWithout3a3b(int a, int b) {
        Queue<Pair> maxHeap = new PriorityQueue<>((p1, p2) -> p2.size - p1.size);
        if (a > 0) {
            maxHeap.add(new Pair('a', a));
        }
        if (b > 0) {
            maxHeap.add(new Pair('b', b));
        }

        StringBuilder sb = new StringBuilder();

        while (maxHeap.size() > 1) {
            Pair p1 = maxHeap.poll();
            if (p1.size <= maxHeap.peek().size || p1.size < 2) {
                sb.append(p1.value);
                p1.size -= 1;
            } else {
                sb.append(p1.value).append(p1.value);
                p1.size -= 2;
            }

            Pair p2 = maxHeap.poll();
            if (p2.size <= p1.size || p2.size < 2) {
                sb.append(p2.value);
                p2.size -= 1;
            } else {
                sb.append(p2.value).append(p2.value);
                p2.size -= 2;
            }

            if (p1.size > 0) {
                maxHeap.add(p1);
            }
            if (p2.size > 0) {
                maxHeap.add(p2);
            }
        }

        if (!maxHeap.isEmpty()) {
            Pair p = maxHeap.poll();
            if (p.value != sb.charAt(sb.length() - 1) && p.size < 3) {
                for (int i = 0; i < p.size; i++) {
                    sb.append(p.value);
                }
            }
        }

        return sb.toString();
    }

    class Pair {
        private char value;
        private int size;

        public Pair(char value, int size) {
            this.value = value;
            this.size = size;
        }
    }
}
