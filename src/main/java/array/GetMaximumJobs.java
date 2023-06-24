package array;

//https://leetcode.com/discuss/interview-question/2836695/Diabolocom-Backend-Hiring-Test-or-Hackerrank-OA-or-2022-or-Task-Completion-or-Job-Scheduling
//https://www.chegg.com/homework-help/questions-and-answers/m-jobs-schedule-n-processors-schedule-balanced-difference-number-jobs-scheduled-two-neighb-q101064867
import org.junit.Assert;
import org.junit.Test;

public class GetMaximumJobs {
    public int getMaximumJobs(int n, int m, int k) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = 1; // Fill the array with 1's first
        }
        int sum = n;
        int maxjob = 1;                 // With all 1's, the sum is n and maxjob is 1

        while (sum <= m) {
            // Increase the kth item by 1; this increased value is now maxjob
            arr[k]++;
            maxjob = arr[k];
            // Make sure difference between elements (on left of kth element) is 1 or less (for balanced schedule)
            // If the difference is more than 1, increase element so that difference is 1
            for (int i = k - 1; i >= 0; i--) {
                if ((arr[i + 1] - arr[i]) > 1) {
                    arr[i]++;
                }
            }
            // Do same thing for elements to the right of kth element
            for (int i = k + 1; i < n; i++) {
                if ((arr[i - 1] - arr[i]) > 1) {
                    arr[i]++;
                }
            }

            // Find the new sum of all elements again
            sum = 0;
            for (int i = 0; i < n; i++) {
                sum += arr[i];
            }
        }
        // When we reach here, the sum of the elements is > m, so maxjob is one value too high
        // decrement maxjob and return it
        return maxjob - 1;
    }


    @Test
    public void test() {
        Assert.assertEquals(3, getMaximumJobs(5, 11, 3));
    }

    @Test
    public void test2() {
        Assert.assertEquals(4, getMaximumJobs(5, 11, 5));
    }

    @Test
    public void test3() {
        Assert.assertEquals(4, getMaximumJobs(5, 16, 2));
    }

}
