package leetcode.graph.design;

import org.junit.Assert;

// Quick Union
public class UnionFind2 {
    private final int[] root;

    public UnionFind2(int size) {
        root = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
        }
    }

    public int find(int x) {
        while (x != root[x]) {
            x = root[x];
        }
        return x;
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            root[rootY] = rootX;
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    public static void main(String[] args) throws Exception {
        UnionFind2 uf = new UnionFind2(10);
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
