package leetcode.easy.design;

import java.util.LinkedList;

public class Bucket {
    private final LinkedList<Integer> container;

    public Bucket() {
        container = new LinkedList<>();
    }

    public void insert(Integer key) {
        int index = container.indexOf(key);
        if (index == -1) {
            container.addFirst(key);
        }
    }

    public void delete(Integer key) {
        container.remove(key);
    }

    public boolean exists(Integer key) {
        int index = container.indexOf(key);

        return index != -1;
    }
}
