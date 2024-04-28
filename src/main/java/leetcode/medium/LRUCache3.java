package leetcode.medium;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LRUCache3 {
    private final int capacity;
    private final Queue<Integer> queue = new LinkedList<>();
    private final Map<Integer, Integer> map = new HashMap<>();

    public LRUCache3(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        queue.remove(key);//O(n)
        queue.add(key);//O(1)
        return map.get(key);//O(1)
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            //if key is present in the map, key has to be searched and deleted and then enqueue the key into the queue, according to LRU principal
            queue.remove(key);//O(n)
            queue.add(key);//O(1)
            map.put(key, value);//O(1)
        } else {
            if (queue.size() < capacity) {
                queue.add(key);//inserting the new key into the queue
            } else {
                //q.size() == capacity
                map.remove(queue.poll());//removing the least recently used key
                queue.add(key);//appending the new key to the queue
            }
            map.put(key, value);//putting the key value pair
        }
    }


	public static void main(String[] args) {
			LRUCache3 cache = new LRUCache3(3);
			cache.put(111, 1); // cache is {1=1}
			cache.put(222, 2); // cache is {1=1, 2=2}
			cache.get(111);    // return 1
			cache.put(333, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
			cache.get(222);    // returns -1 (not found)
			cache.put(444, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
			cache.get(111);    // return -1 (not found)
			cache.get(333);    // return 3
			cache.get(444);    // return 4
		}
}
