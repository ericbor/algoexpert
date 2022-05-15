package other;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period/
public class AlertUsingSameKeyCard {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> hash = new HashMap<>();
        for (int i = 0; i < keyName.length; i++) {
            String name = keyName[i];
            if (!hash.containsKey(name)) {
                hash.put(name, new ArrayList<>());
            }

            hash.get(name).add(getMinutes(keyTime[i]));
        }

        List<String> results = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> entry : hash.entrySet()) {
            if (hasAlert(entry.getValue())) {
                results.add(entry.getKey());
            }
        }

        Collections.sort(results);
        return results;
    }

    private boolean hasAlert(List<Integer> times) {
        if (times.size() < 3) {
            return false;
        }

        Collections.sort(times);

        for (int i = 2; i < times.size(); i++) {
            if (times.get(i) - times.get(i - 2) <= 60) {
                return true;
            }
        }

        return false;
    }

    private int getMinutes(String time) {
        String[] parts = time.split(":");
        return 60 * Integer.parseInt(parts[0]) + Integer.parseInt(parts[1]);
    }

    @Test
    public void test() {
        Assert.assertEquals(List.of("daniel"), alertNames(new String[] { "daniel", "daniel", "daniel", "luis", "luis", "luis", "luis" }, new String[] { "10:00", "10:40", "11:00", "09:00", "11:00", "13:00", "15:00" }));
    }
}
