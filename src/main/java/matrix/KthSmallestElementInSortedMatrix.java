package matrix;

import org.junit.Assert;
import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
public class KthSmallestElementInSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        Queue<Node> minHeap = new PriorityQueue<>((n1, n2) -> matrix[n1.row][n1.col] - matrix[n2.row][n2.col]);

        for (int i = 0; i < matrix.length && i < k; i++) {
            minHeap.add(new Node(i, 0));
        }

        int result = -1;
        while (k > 0) {
            Node curr = minHeap.poll();
            result = matrix[curr.row][curr.col];
            k--;

            curr.col++;
            if (curr.col < matrix[0].length) {
                minHeap.add(new Node(curr.row, curr.col));
            }
        }

        return result;
    }

    class Node {
        int row;
        int col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    @Test
    public void test() {
        Assert.assertEquals(13, kthSmallest(new int[][] { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } }, 8));
    }
}
