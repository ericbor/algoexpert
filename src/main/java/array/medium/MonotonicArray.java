package array.medium;

public class MonotonicArray {
    public static boolean isMonotonic(int[] array) {
        boolean isGoingUp = true;
        boolean isGoingDown = true;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                isGoingUp = false;
            }
            if (array[i] > array[i - 1]) {
                isGoingDown = false;
            }
        }

        return isGoingUp || isGoingDown;
    }
}
