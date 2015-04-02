package w211_undirected_graphs;

/**
 * Created by sandro on 3/20/15.
 */
public class Graphs {
    public static int degree(Graph g, int v) {
        // g.adjacent(v).size()
        int degree = 0;
        for (int _: g.adjacent(v)) {
            degree++;
        }
        return degree;
    }

    public static int maxDegree(Graph g) {
        // range(0, g.vertices()).map(n -> degree(g, n).max()
        int max = 0;
        for (int v = 0; v < g.vertices(); v++) {
            if (degree(g, v) > max) {
                max = degree(g, v);
            }
        }
        return max;
    }

    public static int numberOfSelfLoops(Graph g) {
        throw new UnsupportedOperationException();
    }

    public static double averageDegree(Graph g) {
        return 2.0 * g.edges() / g.vertices();
    }
}
