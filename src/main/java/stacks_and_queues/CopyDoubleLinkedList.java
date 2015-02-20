package stacks_and_queues;

/**
 * Created by sandro on 2/4/15.
 */
public class CopyDoubleLinkedList {
    private static class Node {
        private int elem;
        private Node next;
        private Node random;

        private Node(int elem) {
            this.elem = elem;
        }
    }

    private static void link(Node left, Node mid, Node right) {
        left.next = mid;
        mid.next = right;
    }

    public static Node[] clone(Node head) {
        for (Node cur = head; cur != null; cur = cur.next.next) {
            link(cur, new Node(cur.elem), cur.next);
        }

        for (Node cur = head; cur != null; cur = cur.next.next) {
            cur.next.random = cur.random.next;
        }

        Node oneSentinel = new Node(-1);
        Node twoSentinel = new Node(-1);

        Node oneLast = oneSentinel;
        Node twoLast = twoSentinel;

        for (Node cur = head; cur != null; cur = cur.next.next) {
            oneLast.next = cur;
            oneLast = oneLast.next;

            twoLast.next = cur.next;
            twoLast = twoLast.next;
        }

        return new Node[] {oneSentinel.next, twoSentinel.next};
    }

    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        link(one, two, three);
        one.random = three;
        two.random = two;
        three.random = one;

        Node[] nodes = clone(one);

        System.out.println(nodes[0].random.elem);
    }

}
