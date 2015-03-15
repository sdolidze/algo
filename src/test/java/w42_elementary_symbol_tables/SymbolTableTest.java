package w42_elementary_symbol_tables;

import junit.framework.TestCase;

import java.util.Iterator;

public class SymbolTableTest extends TestCase {
    private SymbolTable<Integer, String> st;

    @Override
    public void setUp() {
        st = new OrderedListSymbolTable<>();
    }

    public void testSymbolTable() {
        assertFalse(st.contains(1));
        st.put(1, "sandro");
        assertTrue(st.contains(1));
        assertEquals("sandro", st.get(1));
        st.delete(1);
        assertFalse(st.contains(1));
    }

    public void testOverwrite() {
        st.put(1, "sandro");
        st.put(1, "dolidze");
        assertEquals("dolidze", st.get(1));
    }

    public void testMultiple() {
        st.put(3, "sandro");
        st.put(1, "sandro");
        st.put(2, "sandro");
        st.delete(2);
        st.put(4, "sandro");
        st.put(2, "dolidze");

        assertEquals("dolidze", st.get(2));
        assertEquals("sandro", st.get(3));
        assertEquals("sandro", st.get(4));

        if (st instanceof OrderedSymbolTable) {
            Iterator<Integer> it = st.iterator();
            for (int i = 1; i <= 4; i++) {
                assertEquals(i, (int) it.next());
            }
        }
    }

    public void testThrowsExceptionOnNullKeyOrValue() {
        try {
            st.put(null, "sandro");
            fail();
        } catch (NullPointerException e) {/* ignored */}

        try {
            st.put(1, null);
            fail();
        } catch (NullPointerException e) {/* ignored */}
    }
}