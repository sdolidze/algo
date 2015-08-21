package w222_shortest_paths;

/**
 * Created by sandro on 4/12/15.
 */
public class DirectedEdge {
    private final int from, to;
    private final double weight;

    public DirectedEdge(int from, int to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public int from() {
        return from;
    }

    public int to() {
        return to;
    }

    public double weight() {
        return weight;
    }

    @Override
    public String toString() {
        return String.format("%d-%d %f", from, to, weight);
    }
}
