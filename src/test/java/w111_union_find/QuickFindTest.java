package w111_union_find;

import junit.framework.TestCase;

public class QuickFindTest extends TestCase {
    public void testQuickFind() {
        UnionFind uf = new WeightedQuickUnionWithPassCompression(10);
        uf.union(0, 1);
        uf.union(1, 2);
        uf.union(8, 9);
        assertTrue(uf.connected(0, 1));
        assertTrue(uf.connected(0, 2));
        assertFalse(uf.connected(0, 8));
        assertFalse(uf.connected(5, 6));
    }
}