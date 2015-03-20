package w142_elementary_symbol_tables;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by sandro on 3/15/15.
 */
public class OrderedListSymbolTable<Key extends Comparable<Key>, Value> implements OrderedSymbolTable<Key, Value> {
    private List<Key> keys;
    private List<Value> values;

    public OrderedListSymbolTable() {
        keys = new ArrayList<>();
        values = new ArrayList<>();
    }

    @Override
    public void put(Key key, Value value) {
        if (key == null || value == null) {
            throw new NullPointerException();
        }
        int pos = Collections.binarySearch(keys, key);
        // pos = (-(insertionIndex) - 1) careful may run out of bounds
        if (pos >= 0) {
            values.set(pos, value);
        } else {
            int insertIndex = -(pos+1);
            keys.add(insertIndex, key);
            values.add(insertIndex, value);
        }
    }

    @Override
    public void delete(Key key) {
        int pos = Collections.binarySearch(keys, key);
        if (pos >= 0) {
            keys.remove(pos);
            values.remove(pos);
        }
    }

    @Override
    public Value get(Key key) {
        int pos = Collections.binarySearch(keys, key);
        if (pos >= 0) {
            return values.get(pos);
        } else {
            return null;
        }
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

    @Override
    public void deleteMin() {

    }

    @Override
    public void deleteMax() {

    }

    @Override
    public Key min() {
        return null;
    }

    @Override
    public Key max() {
        return null;
    }

    @Override
    public Key floor(Key key) {
        return null;
    }

    @Override
    public Key ceiling(Key key) {
        return null;
    }

    @Override
    public int rank(Key key) {
        return 0;
    }

    @Override
    public Key select(int k) {
        return null;
    }

    @Override
    public int size(Key lo, Key hi) {
        return 0;
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        return null;
    }
}
