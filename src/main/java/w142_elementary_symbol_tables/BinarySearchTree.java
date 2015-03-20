package w142_elementary_symbol_tables;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by sandro on 3/15/15.
 */
public class BinarySearchTree<Key extends Comparable<Key>, Value> implements OrderedSymbolTable<Key, Value> {
    private class Node {
        private Key key;
        private Value value;
        private Node left;
        private Node right;
        private int count;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            count = 1;
        }

    }

    private Node root;

    @Override
    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        node.count = 1 + size(node.left) + size(node.right);
        return node;
    }

    @Override
    public void deleteMax() {
        root = deleteMax(root);
    }

    private Node deleteMax(Node node) {
        if (node.right == null) {
            return node.left;
        }
        node.right = deleteMax(node.right);
        node.count = 1 + size(node.left) + size(node.right);
        return node;
    }

    @Override
    public Key min() {
        Node cur = root;
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur.key;
    }

    @Override
    public Key max() {
        Node cur = root;
        while (cur.right != null) {
            cur = cur.right;
        }
        return cur.key;
    }

    @Override
    public Key floor(Key key) {
        Node node = floor(root, key);
        if (node == null) {
            return null;
        }
        return node.key;
    }

    private Node floor(Node node, Key key) {
        // todo: understand this very well
        // todo: write on paper
        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.key);

        if (cmp == 0) {
            return node;
        } else if (cmp < 0) {
            return floor(node.left, key);
        } else {
            Node t = floor(node.right, key);
            if (t != null) {
                return t;
            } else {
                return node;
            }
        }
    }

    @Override
    public Key ceiling(Key key) {
        Node node = ceiling(root, key);
        if (node == null) {
            return null;
        }
        return node.key;
    }

    private Node ceiling(Node node, Key key) {
        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.key);

        if (cmp == 0) {
            return node;
        } else if (cmp < 0) {
            Node t = floor(node.left, key);
            if (t != null) {
                return t;
            } else {
                return node;
            }
        } else {
            return floor(node.right, key);
        }
    }

    @Override
    public int rank(Key key) {
        return rank(key, root);
    }

    private int rank(Key key, Node node) {
        if (node == null) {
            return 0;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return rank(key, node.left);
        } else if (cmp > 0) {
            return 1 + size(node.left) + rank(key, node.right);
        } else /* cmp == 0 */ {
            return size(node.left);
        }
    }

    @Override
    public Key select(int k) {
        return null;
    }

    @Override
    public int size(Key lo, Key hi) {
       if (contains(hi)) {
           return rank(hi) - rank(lo) + 1;
       } else {
           return rank(hi) - rank(lo);
       }
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        // todo: do same with binary search: find left endpoint and find right endpoint
        List<Key> queue = new ArrayList<>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node node, List<Key> list, Key lo, Key hi) {
        // todo: write on your own
        if (node == null) return;
        int cmpLo = lo.compareTo(node.key);
        int cmpHi = hi.compareTo(node.key);
        if (cmpLo < 0) {
            keys(node.left, list, lo, hi);
        }
        if (cmpLo <= 0 && cmpHi >= 0) {
            list.add(0, node.key);
        }
        if (cmpHi > 0) {
            keys(node.right, list, lo, hi);
        }
    }

    @Override
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) {
            return new Node(key, value);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else /* cmp == 0 */ {
            node.value = value;
        }
        node.count = 1 + size(node.left) + size(node.right);
        return node;
    }

    @Override
    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node node, Key key) {
        // todo: do this carefully
        // Hibbard deletion
        // lack of symmetry degenerates it
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = delete(node.left, key);
        } else if (cmp > 0) {
            node.right = delete(node.right, key);
        } else /* cmp == 0 */ {
            if (node.right == null) {
                return node.left;
            } else if (node.left == null) {
                return node.right;
            }

            Node t = node;
            node = min(t.right);
            node.right = deleteMin(t.right);
            node.left = t.left;
        }
        node.count = 1 + size(node.left) + size(node.right);
        return node;
    }

    private Node min(Node node) {
        throw new UnsupportedOperationException("not implemented");
    }

    @Override
    public Value get(Key key) {
        Node node = root;
        while (node != null) {
            int cmp = key.compareTo(node.key);
            if (cmp < 0) {
                node = node.left;
            } else if (cmp > 0) {
                node = node.right;
            } else /* cmp == 0 */ {
                return node.value;
            }
        }
        return null;
    }

    @Override
    public boolean contains(Key key) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return node.count;
        }
    }

    @Override
    public Iterator<Key> iterator() {
        List<Key> keys = new ArrayList<>();
        inOrder(root, keys);
        return keys.iterator();
    }

    private void inOrder(Node node, List<Key> keys) {
        if (node == null) {
            return;
        }
        inOrder(node.left, keys);
        keys.add(node.key);
        inOrder(node.right, keys);
    }
}
