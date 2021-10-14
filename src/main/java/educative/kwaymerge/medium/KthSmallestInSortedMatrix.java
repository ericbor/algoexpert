package educative.kwaymerge.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Queue;

/*
Given an N * N matrix where each row and column is sorted in ascending order, find the Kth smallest element in the matrix.

Input: Matrix=[
    [2, 6, 8],
    [3, 7, 10],
    [5, 8, 11]
  ],
  K=5
Output: 7

 */
public class KthSmallestInSortedMatrix {
    public static int findKthSmallest(int[][] matrix, int k) {
        Queue<Node> minHeap = new PriorityQueue<>((n1, n2) -> matrix[n1.row][n1.col] - matrix[n2.row][n2.col]);

        // put the 1st element of each row in the min heap
        // we don't need to push more than 'k' elements in the heap
        for (int i = 0; i < matrix.length && i < k; i++) {
            minHeap.add(new Node(i, 0));
        }

        // take the smallest (top) element form the min heap, if the running count is equal to k return the number
        // if the row of the top element has more elements, add the next element to the heap
        int result = -1;
        while (!minHeap.isEmpty() && k > 0) {
            Node curr = minHeap.poll();
            result = matrix[curr.row][curr.col];
            k--;

            curr.col++;
            if (matrix[0].length > curr.col) {
                minHeap.add(new Node(curr.row, curr.col));
            }

        }

        return result;
    }

    @Test
    public void main() {
        int[][] matrix = { { 2, 6, 8 }, { 3, 7, 10 }, { 5, 8, 11 } };
        Assert.assertEquals(7, findKthSmallest(matrix, 5));
    }
}

class Node {
    int row;
    int col;

    public Node(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
