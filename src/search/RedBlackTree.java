package search;

import sort.Queue;

/**
 * @Date 2018-09-13
 * @Author lihongxiang
 */
public class RedBlackTree<Key extends Comparable<Key>, Value> {

    private static final boolean RED = true;

    private static final boolean BLACK = false;

    private Node root;

    private class Node {
        Key key;
        Value value;
        Node left;
        Node right;
        int n;
        boolean color;

        Node(Key key, Value value, int n, boolean color) {
            this.key = key;
            this.value = value;
            this.n = n;
            this.color = color;
        }
    }

    private boolean isRed(Node x) {
        if (x == null) {
            return false;
        }
        return x.color == RED;
    }

    Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.n = h.n;
        h.n = 1 + size(h.left) + size(h.right);
        return x;
    }

    private int size(Node x) {
        if (x == null) {
            return 0;
        }
        return x.n;
    }

    Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.n = h.n;
        h.n = 1 + size(h.left) + size(h.right);
        return x;
    }

    void flipColor(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
        root.color = BLACK;
    }

    private Node put(Node h, Key key, Value value) {
        if (h == null) {
            return new Node(key, value, 1, RED);
        }
        int cmp = key.compareTo(h.key);
        if (cmp < 0) {
            h.left = put(h.left, key, value);
        } else if (cmp > 0) {
            h.right = put(h.right, key, value);
        } else {
            h.value = value;
        }
        if (isRed(h.right) && !isRed(h.left)) {
            h = rotateLeft(h);
        }
        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }
        if (isRed(h.left) && isRed(h.right)) {
            flipColor(h);
        }
        h.n = size(h.right) + size(h.left) + 1;
        return h;
    }

    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    private Key max() {
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right == null) {
            return x;
        }
        return max(x.right);
    }


    public Key min() {
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null) {
            return x;
        }
        return min(x.left);
    }

    private Iterable<Key> keys(Key min, Key max) {
        Queue<Key> queue = new Queue<>();
        keys(root, queue, min, max);
        return queue;
    }

    private void keys(Node x, Queue<Key> queue, Key min, Key max) {
        if (x == null) {
            return;
        }
        int cmpMin = min.compareTo(x.key);
        if (cmpMin < 0) {
            keys(x.left, queue, min, max);
        }
        int cmpMax = max.compareTo(x.key);
        if (cmpMin <= 0 && cmpMax >= 0) {
            queue.enqueue(x.key);
        }
        if (cmpMax > 0) {
            keys(x.right, queue, min, max);
        }
    }

    // todo
    Node delete(Key key) {
        return null;
    }

    // todo
    Node deleteMin() {
        return null;
    }

    public static void main(String[] args) {
        String[] arr = new String[]{"n", "a", "e", "f", "c", "b", "x", "y", "m", "p", "d"};
        RedBlackTree<String, String> tree = new RedBlackTree<>();
        for (String s : arr) {
            tree.put(s, s);
        }
        Iterable<String> keys = tree.keys();
        for (String key : keys) {
            System.out.println(key + " ");
        }
    }
}
