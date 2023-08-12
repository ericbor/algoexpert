package array.medium;

import java.util.Random;

//https://leetcode.com/problems/shuffle-an-array
public class ShuffleArray {
    private int[] array;
    private int[] original;
    private final Random random;

    public ShuffleArray(int[] nums) {
        this.array = nums;
        this.original = nums.clone();
        this.random = new Random();
    }

    public int[] reset() {
        this.array = original;
        this.original = original.clone();

        return original;
    }

    public int[] shuffle() {
        for (int i = 0; i < array.length; i++) {
            swap(i, randRange(i, array.length));
        }

        return array;
    }

    private int randRange(int min, int max) {
        return min + random.nextInt(max - min);
    }

    private void swap(int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ShuffleArray sa = new ShuffleArray(arr);
        sa.shuffle();
        sa.shuffle();
        sa.reset();
    }
}
