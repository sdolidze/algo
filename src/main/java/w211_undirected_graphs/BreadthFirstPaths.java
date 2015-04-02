package w211_undirected_graphs;

import w121_stacks_and_queues.LinkedListQueue;
import w121_stacks_and_queues.Queue;

import java.util.Arrays;

/**
 * Created by sandro on 3/25/15.
 */
public class BreadthFirstPaths implements Paths {
    private int startVertex;
    private int[] weights;
    private int[] edgeTo;

    public BreadthFirstPaths(Graph graph, int startVertex) {
        this.startVertex = startVertex;
        this.weights = new int[graph.vertices()];
        for (int i = 0; i < weights.length; i++) {
            weights[i] = -1;
        }
        this.edgeTo = new int[graph.vertices()];
        bfs(graph, startVertex);
    }

    private void bfs(Graph graph, int startVertex) {
        Queue<Integer> fringe = new LinkedListQueue<>();

        weights[startVertex] = 0;
        fringe.enqueue(startVertex);

        while (!fringe.isEmpty()) {
            int vertex = fringe.dequeue();
            System.out.println(vertex);
            for (int neighbor: graph.adjacent(vertex)) {
                if (weights[neighbor] == -1) {
                    edgeTo[neighbor] = vertex;
                    weights[neighbor] = weights[vertex] + 1;
                    fringe.enqueue(neighbor);
                }
            }
        }
    }

    @Override
    public boolean hasPathTo(int vertex) {
        return weights[vertex] != -1;
    }

    @Override
    public Iterable<Integer> pathTo(int vertex) {
        return null;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 2);
        graph.addEdge(2, 1);
        graph.addEdge(2, 5);
        graph.addEdge(1, 3);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);

        BreadthFirstPaths bfp = new BreadthFirstPaths(graph, 0);
        System.out.println(Arrays.toString(bfp.weights));
    }
}
