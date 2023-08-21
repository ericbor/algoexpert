package other;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/find-servers-that-handled-most-number-of-requests
public class FindServersThatHandledMostNumberOfRequests {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        Map<Integer, Integer> serverToRequests = new HashMap<>();
        int[] arr = new int[k];
        int maxConnections = 0;

        for(int i = 0; i < arrival.length; i++) {
            for(int j = 0; j < arr.length; j++) {
                if(arr[j] == 0) {
                    arr[j] = load[i];
                    serverToRequests.put(j, serverToRequests.getOrDefault(j, 0) + 1);
                    if(serverToRequests.get(j) > maxConnections) {
                        maxConnections = serverToRequests.get(j);
                    }
                    break;
                } else {
                    arr[j]--;
                }
            }
        }

        List<Integer> results = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: serverToRequests.entrySet()) {
            if(entry.getValue() == maxConnections) {
                results.add(entry.getKey());
            }
        }

        return results;
    }

    @Test
    public void test() {
        Assert.assertEquals(List.of(1), busiestServers(3, new int[]{1,2,3,4,8,9,10}, new int[]{5,2,10,3,1,2,2}));
    }
}
