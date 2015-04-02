package w211_undirected_graphs;

import w121_stacks_and_queues.LinkedListQueue;
import w121_stacks_and_queues.Queue;

import java.util.*;
import java.util.function.Consumer;

/**
 * Created by sandro on 3/20/15.
 */
public class GraphsPrime {
    public static<T> void dfs(GraphPrime<T> graph, T start, Consumer<T> consumer) {
        dfsRec(graph, start, consumer, new HashSet<>(Arrays.asList(start)));
    }

    public static<T> void bfs(GraphPrime<T> graph, T start, Consumer<T> consumer) {
        Queue<T> queue = new LinkedListQueue<>();
        Map<T, Integer> weights = new HashMap<>();

        weights.put(start, 0);
        queue.enqueue(start);

        while (!queue.isEmpty()) {
            T cur = queue.dequeue();
            consumer.accept(cur);
            for (T neighbor: graph.adjacent(cur)) {
                if (!weights.containsKey(neighbor)) {
                    weights.put(neighbor, weights.get(cur) + 1);
                    queue.enqueue(neighbor);
                }
            }
        }

        System.out.println(weights);
    }

    public static<T> void bfsSimple(GraphPrime<T> graph, T start, Consumer<T> consumer) {
        Queue<T> queue = new LinkedListQueue<>();
        Set<T> visited = new HashSet<>();

        visited.add(start);
        queue.enqueue(start);

        while (!queue.isEmpty()) {
            T cur = queue.dequeue();
            consumer.accept(cur); // everyone including start
            for (T neighbor: graph.adjacent(cur)) {
                if (!visited.contains(neighbor)) {
//                    consumer.accept(neighbor); // exclude start
                    visited.add(neighbor);
                    queue.enqueue(neighbor);
                }
            }
        }
    }

    public static<T> void bfsPrime(GraphPrime<T> graph, T start, Consumer<T> consumer) {
        Queue<T> queue = new LinkedListQueue<>();
        Set<T> visited = new HashSet<>();

        queue.enqueue(start);

        while (!queue.isEmpty()) {
            T cur = queue.dequeue();
            consumer.accept(cur); // everyone including start
            visited.add(cur);
            for (T neighbor: graph.adjacent(cur)) {
                if (!visited.contains(neighbor)) {
//                    consumer.accept(neighbor); // exclude start
                    queue.enqueue(neighbor);
                }
            }
        }
    }

    private static<T> void dfsRec(GraphPrime<T> graph, T vertex, Consumer<T> consumer, Set<T> visited) {
        consumer.accept(vertex);
        for (T neighbor: graph.adjacent(vertex)) {
            if (!visited.contains(neighbor)) {
                visited.add(neighbor);
                dfsRec(graph, neighbor, consumer, visited);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("sandro");
        GraphPrime<Integer> g = new GraphPrime<>();
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(0, 6);
        bfsPrime(g, 0, System.out::println);
    }
}
