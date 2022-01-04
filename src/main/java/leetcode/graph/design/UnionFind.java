package leetcode.graph.design;

import org.junit.Assert;

//Quick Find
public class UnionFind {
    private final int[] root;

    public UnionFind(int size) {
        root = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
        }
    }

    // O(1)
    public int find(int x) {
        return root[x];
    }

    // O(N)
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            for (int i = 0; i < root.length; i++) {
                if (root[i] == rootY) {
                    root[i] = rootX;
                }
            }
        }
    }

    // O(1)
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    public static void main(String[] args) throws Exception {
        UnionFind uf = new UnionFind(10);
        // 1-2-5-6-7 3-8-9 4
        uf.union(1, 2);
        uf.union(2, 5);
        uf.union(5, 6);
        uf.union(6, 7);
        uf.union(3, 8);
        uf.union(8, 9);
        Assert.assertTrue(uf.connected(1, 5)); // true
        Assert.assertTrue(uf.connected(5, 7)); // true
        Assert.assertFalse(uf.connected(4, 9)); // false
        // 1-2-5-6-7 3-8-9-4
        uf.union(9, 4);
        Assert.assertTrue(uf.connected(4, 9)); // true
    }
}
