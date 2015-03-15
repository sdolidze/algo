package w11_union_find;

public class WeightedQuickUnionWithPassCompression implements UnionFind {
    private int[] id;
    private int[] sz;
    private int count;

    public WeightedQuickUnionWithPassCompression(int N) {
        id = new int[N];
        sz = new int[N];
        count = N;
        for (int i=0; i<N; i++) {
            id[i] = i;
            sz[i] = 0;
        }
    }

    @Override
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ) {
            return;
        }

        if (sz[rootP] < rootQ) {
            id[rootP] = rootQ;
            sz[rootQ] += sz[rootP];
        } else {
            id[rootQ] = rootP;
            sz[rootP] += sz[rootQ];
        }

        count--;
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int find(int p) {
        while (p != id[p]) {
            id[p] = id[id[p]]; // pass compression, make p point to it's grandparent, halves path
            p = id[p];
        }
        return p;
    }

    @Override
    public int count() {
        return count;
    }
}
