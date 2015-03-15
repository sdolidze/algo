package w11_union_find;

/**
 * Created by sandro on 1/25/15.
 */
public interface UnionFind {
    public void union(int p, int q);
    public boolean connected(int p, int q);
    // what the hell does find do?
    public int find(int p);
    public int count();
}
