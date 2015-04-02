package w211_undirected_graphs;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GraphsTest {
    private Graph g;

    @Before
    public void setUp() {
        g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
    }

    @Test
    public void testDegree() {
        assertEquals(2, Graphs.degree(g, 0));
        assertEquals(1, Graphs.degree(g, 1));
        assertEquals(0, Graphs.degree(g, 3));
    }

    @Test
    public void testMaxDegree() {
        assertEquals(2, Graphs.maxDegree(g));
    }
}