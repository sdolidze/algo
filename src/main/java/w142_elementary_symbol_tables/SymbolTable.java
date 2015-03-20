package w142_elementary_symbol_tables;

/**
 * Created by sandro on 3/15/15.
 */
public interface SymbolTable<Key, Value> extends Iterable<Key> {
    public void put(Key key, Value value);
    public void delete(Key key);

    public Value get(Key key);
    public boolean contains(Key key);
    public boolean isEmpty();
    public int size();
}
