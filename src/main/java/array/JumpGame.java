package array;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/jump-game
public class JumpGame {
    public boolean canJump(int[] nums) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        boolean[] visited = new boolean[nums.length];
        visited[0] = true;


        while(!queue.isEmpty()) {
            int currIndex = queue.poll();

            if(currIndex == nums.length - 1) {
                return true;
            }

            int jumps = nums[currIndex];
            int nextIndex = currIndex;
            while(jumps > 0) {
                nextIndex++;
                if(nextIndex < nums.length && !visited[nextIndex]) {
                    queue.add(nextIndex);
                    visited[nextIndex] = true;
                }
                jumps--;
            }
        }

        return false;
    }

    @Test
    public void test2() {
        Assert.assertTrue(canJump(new int[]{2,3,1,1,4}));
    }

    @Test
    public void test() {
        Assert.assertFalse(canJump(new int[]{3,2,1,0,4}));
    }
}
