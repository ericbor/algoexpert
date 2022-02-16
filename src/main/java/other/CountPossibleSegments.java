package other;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CountPossibleSegments {
    public long countPossibleSegments(int k, List<Integer> weights) {
        int n = weights.size();
        long count = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int w1 = weights.get(i);
                int w2 = weights.get(j);
                min = Math.min(min, Math.min(w1, w2));
                max = Math.max(max, Math.max(w1, w2));

                if (max - min <= k) {
                    count++;
                }
            }

            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
        }

        return count;
    }

    public long countPossibleSegments_2(int k, List<Integer> weights) {
        int n = weights.size();

        int[] min = new int[n];
        min[n - 1] = weights.get(n - 1);
        int[] max = new int[n];
        max[0] = weights.get(0);

        for (int i = 1, j = n - 2; i < n && j >= 0; i++, j--) {
            min[j] = Math.min(min[j + 1], weights.get(j));
            max[i] = Math.max(max[i - 1], weights.get(i));
        }

        long count = n;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (max[j] - min[i] <= k) {
                    count++;
                } else {
                    break;
                }
            }
        }

        return count;
    }

    @Test
    public void test() {
        Assert.assertEquals(5, countPossibleSegments(3, List.of(1, 3, 6)));
        Assert.assertEquals(5, countPossibleSegments_2(3, List.of(1, 3, 6)));
    }

    @Test
    public void test2() {
        Assert.assertEquals(4, countPossibleSegments(3, List.of(1, 5, 4)));
        Assert.assertEquals(4, countPossibleSegments_2(3, List.of(1, 5, 4)));
    }
}
