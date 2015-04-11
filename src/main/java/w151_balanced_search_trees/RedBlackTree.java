package w151_balanced_search_trees;

import w121_stacks_and_queues.ArrayQueue;
import w121_stacks_and_queues.Queue;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by sandro on 4/2/15.
 */
public class RedBlackTree<Key extends Comparable<Key>, Value> {
    private enum Color { RED, BLACK }

    private class Node {
        private Key key;
        private Value value;
        private Node left;
        private Node right;
        private Color color; // color is stored in the bottom

        private Node(Key key, Value value, Color color) {
            this.key = key;
            this.value = value;
            this.color = color;
        }
    }

    private Node root;

    public void put(Key key, Value value) {
        root = put(root, key, value);
        root.color = Color.BLACK;
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) return new Node(key, value, Color.RED);
        int cmp = key.compareTo(node.key);

             if (cmp < 0)   node.left  = put(node.left, key, value);
        else if (cmp > 0)   node.right = put(node.right, key, value);
        else /* cmp == 0 */ node.value = value;

        if (isRed(node.right) && !isRed(node.left))      node = rotateLeft(node);
        if (isRed(node.left)  &&  isRed(node.left.left)) node = rotateRight(node);
        if (isRed(node.left)  &&  isRed(node.right))     flipColors(node);

        return node;
    }

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

    public void delete(Key key) {

    }

    private boolean isRed(Node node) {
        if (node == null) {
            return false; // null links are black
        }
        return node.color == Color.RED;
    }

    private Node rotateLeft(Node h) {
        assert isRed(h.right);
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color; // careful, not Color.BLACK
        h.color = Color.RED;
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = Color.RED;
        return x;
    }

    private void flipColors(Node h) {
        assert !isRed(h);
        assert isRed(h.left);
        assert isRed(h.right);
        h.color = Color.RED;
        h.left.color = Color.BLACK;
        h.right.color = Color.BLACK;
    }

    private void inOrder(Node node, Consumer<Node> consumer) {
        if (node == null) {
            return;
        }
        inOrder(node.left, consumer);
        consumer.accept(node);
        inOrder(node.right, consumer);
    }

    public void inOrder(Consumer<Node> consumer) {
        inOrder(root, consumer);
    }

    public void levelOrder(Consumer<Node> consumer) {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new ArrayQueue<>();
        queue.enqueue(root);

        while (!queue.isEmpty()) {
            Node cur = queue.dequeue();
            consumer.accept(cur);
            if (cur.left != null) {
                queue.enqueue(cur.left);
            }
            if (cur.right != null) {
                queue.enqueue(cur.right);
            }
        }
    }

    public Iterable<Key> keys() {
        return fromConsumer(this::inOrder, (Node node) -> node.key);
    }

    public Iterable<Value> values() {
        return fromConsumer(this::inOrder, (Node node) -> node.value);
    }

    public Iterable<Key> levelOrder() {
        return fromConsumer(this::levelOrder, (Node node) -> node.key);
    }

    private String toString(Node node, int level) {
        if (node == null) {
            return space(level) + "-";
        }
        if (node.left == null && node.right == null) {
            return space(level) + node.key + " " + node.color;
        }
        return String.format(
            "%s\n%s\n%s",
            toString(node.right, level + 1),
            space(level) + node.key + " " + node.color,
            toString(node.left, level + 1)
        );
    }

    private String space(int num) {
        String res = "";
        for (int i = 0; i < num; i++) {
            res += ' ';
        }
        return res;
    }

    @Override
    public String toString() {
        return toString(root, 0);
    }

    private static<T, U> Iterable<U> fromConsumer(Consumer<Consumer<T>> consumer, Function<T, U> mapper) {
        List<U> list = new ArrayList<>();
        consumer.accept(t -> list.add(mapper.apply(t)));
        return list;
    }
}
