package w132_quicksort;

/**
 * Created by sandro on 2/11/15.
 */
public class LinkedLists {
    static class Node {
        int elem;
        Node next;

        Node(int elem) {
            this.elem = elem;
        }

        Node(int elem, Node next) {
            this.elem = elem;
            this.next = next;
        }

        public static Node list(Integer... xs) {
            Node head = null;
            for (int i = xs.length - 1; i >= 0; i--) {
                head = new Node(xs[i], head);
            }
            return head;
        }
    }

    public static boolean same(Node left, Node right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        } else {
            return left.elem == right.elem && same(left.next, right.next);
        }
    }

    public static Node middle(Node head, Node end) {
        Node middle = head;

        while (head != end && head.next != end) {
            head = head.next.next;
            middle = middle.next;
        }

        return middle;
    }

    public static Node merge(Node head, Node middle, Node end) {
        Node sentinel = new Node(-1);
        Node last = sentinel;
        Node left = head;
        Node right = middle;

        while (left != middle && right != end) {
            if (left.elem <= right.elem) {
                last.next = left;
                left = left.next;
            } else {
                last.next = right;
                right = right.next;
            }
            last = last.next;
        }

        if (left != middle) {
            last.next = left;
            while (last != middle) {
                last = last.next;
            }
        }

        if (right != end) {
            last.next = right;
            while (last != end) {
                last = last.next;
            }
        }

        last.next = end;

        return sentinel.next;
    }

    // end is non-inclusive, so end can be null ;)
    public static Node mergeSort(Node head, Node end) {
        if (head == end || head.next == end) {
            return head;
        }

        Node middle = middle(head, end);
        mergeSort(head, middle);
        mergeSort(middle, end);
        return merge(head, middle, end);
    }

}
