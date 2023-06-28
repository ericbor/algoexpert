package array;

//https://leetcode.com/discuss/interview-question/2836695/Diabolocom-Backend-Hiring-Test-or-Hackerrank-OA-or-2022-or-Task-Completion-or-Job-Scheduling
//https://www.chegg.com/homework-help/questions-and-answers/m-jobs-schedule-n-processors-schedule-balanced-difference-number-jobs-scheduled-two-neighb-q101064867
import org.junit.Assert;
import org.junit.Test;

public class GetMaximumJobs {
    public int getMaximumJobs(int n, int m, int k) {
        int[] arr = new int[n];
        int jobsLeft = m;
        int maxJobs = 0;

        while (jobsLeft > 0) {
            arr[k - 1]++;//1,2,4,2,1
            maxJobs = arr[k - 1];//4
            jobsLeft--;//1

            for (int i = k - 2; i >= 0; i--) {
                if (arr[i + 1] - arr[i] > 1 && jobsLeft > 0) {
                    arr[i]++;
                    jobsLeft--;
                }
            }

            for (int i = k; i < n; i++) {
                if (arr[i - 1] - arr[i] > 1 && jobsLeft > 0) {
                    arr[i]++;
                    jobsLeft--;
                }
            }
        }

        return maxJobs - 1;
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

    @Test
    public void test4() {
        Assert.assertEquals(2, getMaximumJobs(5, 5, 3));
    }

}
