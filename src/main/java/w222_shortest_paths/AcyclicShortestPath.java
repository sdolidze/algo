package w222_shortest_paths;

import w121_stacks_and_queues.LinkedListStack;
import w121_stacks_and_queues.Stack;
import w221_minimum_spanning_trees.Edge;
import w221_minimum_spanning_trees.EdgeWeightedGraph;

import java.util.List;

/**
 * Created by sandro on 4/12/15.
 */
public class AcyclicShortestPath {
    private DirectedEdge[] edgeTo;
    private double[] distTo;

    public AcyclicShortestPath(EdgeWeightedDigraph graph, int startVertex) {
        this.edgeTo = new DirectedEdge[graph.numVertices()];
        this.distTo = new double[graph.numVertices()];
        for (int i = 0; i < distTo.length; i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        distTo[startVertex] = 0.0;

        Iterable<Integer> topological = topological();
        for (int vertex: topological) {
            for (DirectedEdge edge: graph.adjacent(vertex)) {
                relax(edge);
            }
        }
    }

    private Iterable<Integer> topological() {
        return null;
    }

//    private void dfs(int vertex, EdgeWeightedDigraph graph, boolean[] visited, List<Integer> reversePostOrder) {
//        visited[vertex] = true;
//        for (Edge edge: graph.adjacent(vertex)) {
//            if (!visited[edge.]) {
//                dfs(neighborVertex, graph, visited, reversePostOrder);
//            }
//        }
//    }

    public double distTo(int vertex) {
        return distTo[vertex];
    }

    public Iterable<DirectedEdge> pathTo(int vertex) {
        Stack<DirectedEdge> stack = new LinkedListStack<>();
//        while (vertex != startVertex) {
//            DirectedEdge edge = edgeTo[startVertex];
//            stack.push(edge);
//            vertex = edge.from();
//        }
        for (DirectedEdge edge = edgeTo[vertex]; edge != null; edge = edgeTo[edge.from()]) {
            stack.push(edge);
        }
        return stack;
    }

    public boolean hasPathTo(int vertex) {
        return false;
    }

    private void relax(DirectedEdge e) {
        int v = e.from(), w = e.to();
        if (distTo[w] > distTo[v] + e.weight()) {
            distTo[w] = distTo[v] + e.weight();
            edgeTo[w] = e;
        }
    }
}
