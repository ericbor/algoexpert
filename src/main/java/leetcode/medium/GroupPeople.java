package leetcode.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/
public class GroupPeople {
    public List<List<Integer>> groupThePeople2(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < groupSizes.length; i++) {
            if (map.containsKey(groupSizes[i])) {
                map.get(groupSizes[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(groupSizes[i], list);
            }
        }

        List<List<Integer>> results = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int expectedSize = entry.getKey();
            List<Integer> group = entry.getValue();

            while (group.size() != expectedSize) {
                List<Integer> newGroup = new ArrayList<>(expectedSize);
                while (newGroup.size() != expectedSize) {
                    newGroup.add(0, group.get(group.size() - 1));
                    group.remove(group.size() - 1);
                }
                results.add(newGroup);
            }

            results.add(group);
        }

        return results;
    }

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> results = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < groupSizes.length; i++) {
            int current = groupSizes[i];
            List<Integer> temp = map.getOrDefault(current, new ArrayList<>());
            temp.add(i);
            map.put(current, temp);

            if (temp.size() == current) {
                results.add(temp);
                map.remove(current);
            }
        }

        return results;
    }

    @Test
    public void test() {
        Assert.assertEquals(List.of(List.of(5), List.of(7, 8, 9), List.of(3, 4, 6), List.of(0, 1, 2)), groupThePeople(new int[] { 3, 3, 3, 3, 3, 1, 3, 3, 3, 3 }));
    }

    @Test
    public void test2() {
        Assert.assertEquals(List.of(List.of(5), List.of(3, 4, 6), List.of(0, 1, 2)), groupThePeople(new int[] { 3, 3, 3, 3, 3, 1, 3 }));
    }
}
