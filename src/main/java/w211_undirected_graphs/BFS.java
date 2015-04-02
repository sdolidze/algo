package w211_undirected_graphs;

import w121_stacks_and_queues.ArrayQueue;
import w121_stacks_and_queues.Queue;

import java.util.Arrays;

/**
* Created by sandro on 3/20/15.
        */
public class BFS {
    private int[] weights;

    public BFS(Graph g, int startVertex) {
        weights = new int[g.vertices()];
        for (int i = 0; i < weights.length; i++) {
            weights[i] = -1;
        }

        Queue<Integer> queue = new ArrayQueue<>();

        weights[startVertex] = 0;
        queue.enqueue(startVertex);

        // probably there is another way to organize things
        // is there an advantage to one of them?
        while (!queue.isEmpty()) {
            int vertex = queue.dequeue();
            System.out.println(vertex);
            for (int neighbor: g.adjacent(vertex)) {
                if (weights[neighbor] == -1) {
                    weights[neighbor] = weights[vertex] + 1;
                    queue.enqueue(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 4);
        g.addEdge(2, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        BFS  bfs = new BFS(g, 0);
        System.out.println(Arrays.toString(bfs.weights));
    }
}
