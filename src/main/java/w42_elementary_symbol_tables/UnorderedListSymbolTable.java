package w42_elementary_symbol_tables;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by sandro on 3/15/15.
 * // todo: sentinel might make code simpler
 */
public class UnorderedListSymbolTable<Key, Value> implements SymbolTable<Key, Value> {
    private List<Key> keys;
    private List<Value> values;

    public UnorderedListSymbolTable() {
        keys = new ArrayList<>();
        values = new ArrayList<>();
    }

    @Override
    public void put(Key key, Value value) {
        if (key == null || value == null) {
            throw new NullPointerException(String.format("key=%s, value=%s", key, value));
        }
        for (int i = 0; i < keys.size(); i++) {
            if (keys.get(i).equals(key)) {
                values.set(i, value);
                return;
            }
        }
        keys.add(key);
        values.add(value);
    }

    @Override
    public void delete(Key key) {
        for (int i = 0; i < keys.size(); i++) {
            if (keys.get(i).equals(key)) {
                keys.remove(i);
                values.remove(i);
                return;
            }
        }
    }

    @Override
    public Value get(Key key) {
        for (int i = 0; i < keys.size(); i++) {
            if (keys.get(i).equals(key)) {
                return values.get(i);
            }
        }
        return null;
    }

    @Override
    public boolean contains(Key key) {
        return get(key) != null;
    }

    @Override
    public boolean isEmpty() {
        return keys.isEmpty();
    }

    @Override
    public int size() {
        return keys.size();
    }

    @Override
    public Iterator<Key> iterator() {
        return keys.iterator();
    }
}
