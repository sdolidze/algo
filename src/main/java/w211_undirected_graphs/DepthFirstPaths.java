package w211_undirected_graphs;

import w121_stacks_and_queues.LinkedListStack;
import w121_stacks_and_queues.Stack;

/**
 * Created by sandro on 3/20/15.
 */
public class DepthFirstPaths {
    private int startVertex;
    private boolean[] marked;
    private int[] edgeTo;

    public DepthFirstPaths(Graph g, int startVertex) {
        this.startVertex = startVertex;
        this.marked = new boolean[g.vertices()];
        this.edgeTo = new int[g.vertices()];
        dfs(g, startVertex);
    }

    private void dfs(Graph g, int vertex) {
        marked[vertex] = true;
        for (int neighbor: g.adjacent(vertex)) {
            if (!marked[neighbor]) {
                edgeTo[neighbor] = vertex;
                dfs(g, neighbor);
            }
        }
    }

    public boolean hasPathTo(int vertex) {
        return marked[vertex];
    }

    public Iterable<Integer> pathTo(int vertex) {
        if (hasPathTo(vertex)) {
            throw new RuntimeException("no path");
        }
        Stack<Integer> path = new LinkedListStack<>();
        path.push(vertex);
        while (vertex != startVertex) {
            vertex = edgeTo[vertex];
            path.push(vertex);

        }
        // careful check this
        return path;
    }
}
