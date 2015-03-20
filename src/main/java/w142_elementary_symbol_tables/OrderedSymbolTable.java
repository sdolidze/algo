package w142_elementary_symbol_tables;

/**
 * Created by sandro on 3/15/15.
 */
public interface OrderedSymbolTable<Key extends Comparable<Key>, Value> extends SymbolTable<Key, Value> {
    public void deleteMin();
    public void deleteMax();

    public Key min();
    public Key max();
    public Key floor(Key key);
    public Key ceiling(Key key); // smallest key greater than or equal to key
    public int rank(Key key); // number of keys less than key
    public Key select(int k); // key of rank k
    int size(Key lo, Key hi);
    Iterable<Key> keys(Key lo, Key hi);
}
