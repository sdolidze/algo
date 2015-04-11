package w212_directed_graphs;

import w121_stacks_and_queues.LinkedListQueue;
import w121_stacks_and_queues.Queue;

import java.util.function.Consumer;
import java.util.stream.IntStream;

/**
 * Created by sandro on 4/7/15.
 */
public class Digraphs {
    public int[] bfs(Digraph digraph, int startVertex, Consumer<Integer> consumer) {
        Queue<Integer> queue = new LinkedListQueue<>();

        int[] visited = new int[digraph.vertices()];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = -1;
        }
        IntStream.generate(() -> 5);

        queue.enqueue(startVertex);
        visited[startVertex] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.dequeue();
            consumer.accept(cur);
            for (int neighbor: digraph.adjacent(cur)) {
                if (visited[neighbor] == -1) {
                    visited[neighbor] = visited[cur] + 1;
                    queue.enqueue(neighbor);
                }
            }
        }

        return visited;
    }

    public void dfs(Digraph digraph, int startVertex, Consumer<Integer> consumer) {
        dfs(digraph, startVertex, consumer, new boolean[digraph.vertices()]);
    }

    private void dfs(Digraph digraph, int vertex, Consumer<Integer> consumer, boolean[] visited) {
        consumer.accept(vertex);
        visited[vertex] = true;
        for (int neighbor: digraph.adjacent(vertex)) {
            if (!visited[neighbor]) {
                dfs(digraph, neighbor, consumer, visited);
            }
        }
    }

    public Iterable<Integer> topologicalOrder(Digraph digraph) {
        return null;
    }
}
