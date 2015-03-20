package w111_union_find;

/**
 * why is this called quick union? union is linear :)
 * if we want union to be quick, we should have done "id[p] = q", instead of "id[find(p)] = find(q)"
 */
public class QuickUnion implements UnionFind {
    private int[] id;
    private int count;

    public QuickUnion(int N) {
        id = new int[N];
        count = N;
        for (int i=0; i<N; i++) {
            id[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {
        id[find(p)] = find(q);
        count--;
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    @Override
    public int count() {
        return count;
    }
}
