package oop.fridge;

import java.util.LinkedList;
import java.util.Queue;

public class QueueFactory {

    public static Queue<Product> getQueue() {
        return new LinkedList<>();
    }
}
