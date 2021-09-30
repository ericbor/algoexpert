package educative.mergeintervals.hard;

import educative.mergeintervals.Job;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/*
We are given a list of Jobs. Each job has a Start time, an End time, and a CPU load when it is running. Our goal is to find the maximum CPU load at any time if all the jobs are running on the same machine.

Jobs: [[1,4,3], [2,5,4], [7,9,6]] ... Output: 7
Since [1,4,3] and [2,5,4] overlap, their maximum CPU load (3+4=7) will be when both the
jobs are running at the same time i.e., during the time interval (2,4).

Jobs: [[6,7,10], [2,4,11], [8,12,15]] ... Output: 15
None of the jobs overlap, therefore we will take the maximum load of any job which is 15.
 */
public class MaximumCPULoad {
    public static int findMaxCPULoad(List<Job> jobs) {
        if(jobs == null || jobs.isEmpty()){
            return 0;
        }
        jobs.sort(Comparator.comparingInt(a -> a.start));

        LinkedList<Job> merged = new LinkedList<>();
        for(Job job : jobs) {
            if(merged.isEmpty()){
                merged.add(job);
            } else if (merged.getLast().end <= job.start){
                merged.add(job);
            } else {
                merged.getLast().end = Math.max(merged.getLast().end, job.end);
                merged.getLast().cpuLoad += job.cpuLoad;
            }
        }

        int maxCpu = 0;
        for (Job job: merged){
            maxCpu = Math.max(maxCpu, job.cpuLoad);
        }

        return maxCpu;
    }

    public static int findMaxCPULoad2(List<Job> jobs) {
        if(jobs == null || jobs.isEmpty()){
            return 0;
        }
        jobs.sort(Comparator.comparingInt(job -> job.start));

        PriorityQueue<Job> minHeap = new PriorityQueue<>(jobs.size(), Comparator.comparingInt(job -> job.end));

        int maxCpu = 0;
        int currentCpu = 0;
        for(Job job: jobs) {
            // remove all jobs that have ended
            while (!minHeap.isEmpty() && job.start > minHeap.peek().end){
                currentCpu -= minHeap.poll().cpuLoad;
            }

            // add the current job into the minHeap
            minHeap.offer(job);
            currentCpu += job.cpuLoad;
            maxCpu = Math.max(maxCpu, currentCpu);

        }

        return maxCpu;
    }

    @Test
    public void verify() {
        List<Job> input = new ArrayList<>(Arrays.asList(new Job(1, 4, 3), new Job(2, 5, 4), new Job(7, 9, 6)));
        Assert.assertEquals(7, findMaxCPULoad2(input));

        input = new ArrayList<>(Arrays.asList(new Job(6, 7, 10), new Job(2, 4, 11), new Job(8, 12, 15)));
        Assert.assertEquals(15, findMaxCPULoad2(input));

        input = new ArrayList<>(Arrays.asList(new Job(1, 4, 2), new Job(2, 4, 1), new Job(3, 6, 5)));
        Assert.assertEquals(8, findMaxCPULoad2(input));
    }
}
