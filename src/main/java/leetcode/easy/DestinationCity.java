package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/destination-city/
public class DestinationCity {
    public String destCity(List<List<String>> paths) {
        List<String> destinations = new ArrayList<>();
        for (List<String> path : paths) {
            destinations.add(path.get(1));
        }

        for (List<String> path : paths) {
            destinations.remove(path.get(0));
        }

        return destinations.iterator().next();
    }

    @Test
    public void test() {
        Assert.assertEquals("Sao Paulo", destCity(List.of(List.of("London", "New York"), List.of("New York", "Lima"), List.of("Lima", "Sao Paulo"))));
    }

    @Test
    public void test2() {
        Assert.assertEquals("A", destCity(List.of(List.of("B", "C"), List.of("D", "B"), List.of("C", "A"))));
    }
}
