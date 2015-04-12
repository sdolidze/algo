package w221_minimum_spanning_trees;

/**
 * Created by sandro on 4/11/15.
 */
public class Edge implements Comparable<Edge> {
    private final int v, w;
    private final double weight;

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int either() {
        return v;
    }

    public int other(int v) {
        if (this.v == v) {
            return this.w;
        } else {
            return this.v;
        }
    }

    public double weight() {
        return weight;
    }

    @Override
    public int compareTo(Edge that) {
        return Double.compare(this.weight, that.weight);
    }

    @Override
    public String toString() {
        return String.format("%d-%d %f)", v, w, weight);
    }
}
