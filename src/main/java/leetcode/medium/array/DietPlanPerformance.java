package leetcode.medium.array;

//https://leetcode.com/problems/diet-plan-performance/
public class DietPlanPerformance {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {

        int start = 0;

        int runningSum = 0;
        int points = 0;

        for(int i = 0; i < calories.length; i++) {
            runningSum += calories[i];

            if(i - start + 1 == k) {
                if(runningSum < lower) {
                    points--;
                } else if (runningSum > upper) {
                    points++;
                }

                runningSum -= calories[start];
                start++;
            }
        }

        return points;
    }
}
