package leetcode.easy.design;

import java.util.LinkedList;
import java.util.List;

public class MapBucket implements MBacket<Integer, Integer> {
    private final List<Pair<Integer, Integer>> container;

    public MapBucket() {
        container = new LinkedList<>();
    }

    @Override
    public Integer get(Integer key) {
        for (Pair<Integer, Integer> pair : container) {
            if (pair.key.equals(key)) {
                return pair.value;
            }
        }

        return -1;
    }

    @Override
    public void update(Integer key, Integer value) {
        boolean found = false;
        for (Pair<Integer, Integer> pair : container) {
            if (pair.key.equals(key)) {
                pair.value = value;
                found = true;
            }
        }

        if (!found) {
            container.add(new Pair<>(key, value));
        }
    }

    @Override
    public void remove(Integer key) {
        for (Pair<Integer, Integer> pair : container) {
            if (pair.key.equals(key)) {
                container.remove(pair);
                break;
            }
        }
    }
}
