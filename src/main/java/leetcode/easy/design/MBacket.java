package leetcode.easy.design;

public interface MBacket<K,V> {
    V get(K key);
    void update(K key, V value);
    void remove(K key);
}
