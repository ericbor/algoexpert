package leetcode.easy.matrix;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/flood-fill/submissions/
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        int oldColor = image[sr][sc];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { sr, sc });

        while (!queue.isEmpty()) {
            int[] pixel = queue.poll();
            image[pixel[0]][pixel[1]] = newColor;

            //north
            if (pixel[0] > 0) {
                if (image[pixel[0] - 1][pixel[1]] == oldColor) {
                    if(oldColor != newColor) {
                        queue.add(new int[] { pixel[0] - 1, pixel[1] });
                    }
                }
            }

            //south
            if (pixel[0] < image.length - 1) {
                if (image[pixel[0] + 1][pixel[1]] == oldColor) {
                    if(oldColor != newColor) {
                        queue.add(new int[] { pixel[0] + 1, pixel[1] });
                    }
                }
            }

            //west
            if (pixel[1] > 0) {
                if (image[pixel[0]][pixel[1] - 1] == oldColor) {
                    if(oldColor != newColor) {
                        queue.add(new int[] { pixel[0], pixel[1] - 1 });
                    }
                }
            }

            //east
            if (pixel[1] < image[0].length - 1) {
                if (image[pixel[0]][pixel[1] + 1] == oldColor) {
                    if(oldColor != newColor) {
                        queue.add(new int[] { pixel[0], pixel[1] + 1 });
                    }
                }
            }
        }

        return image;

    }

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[][] { { 0, 0, 0 }, { 0, 1, 1 } }, floodFill(new int[][] { { 0, 0, 0 }, { 0, 1, 1 } }, 1, 1, 1));
    }

    @Test
    public void test2() {
        Assert.assertArrayEquals(new int[][] { { 2, 2, 2 }, { 2, 2, 0 }, { 2, 0, 1 } }, floodFill(new int[][] { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } }, 1, 1, 2));
    }

    @Test
    public void test3() {
        Assert.assertArrayEquals(new int[][] { { 2, 2, 2 }, { 2, 2, 2 } }, floodFill(new int[][] { { 0, 0, 0 }, { 0, 0, 0 } }, 0, 0, 2));
    }
}
