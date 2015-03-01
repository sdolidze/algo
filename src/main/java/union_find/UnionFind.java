package union_find;

/**
 * Created by sandro on 1/25/15.
 */
public interface UnionFind {
    public void union(int p, int q);
    public boolean connected(int p, int q);
    // returns color of the p
    public int find(int p);
    public int count();
}
