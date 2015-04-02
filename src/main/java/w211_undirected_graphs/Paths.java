package w211_undirected_graphs;

/**
 * Created by sandro on 3/25/15.
 */
public interface Paths {
    public boolean hasPathTo(int vertex);
    public Iterable<Integer> pathTo(int vertex);
}
