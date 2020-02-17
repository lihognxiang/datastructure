package search;


import sort.Queue;

/**
 * @Date 2018-09-11
 * @Author lihongxiang
 */
public class BinarySearchTree<Key extends Comparable<Key>, Value> {

    private Node root;

    private class Node {
        private Key key;
        private Value value;
        private Node left;
        private Node right;
        private int n;

        public Node(Key key, Value value, int n) {
            this.key = key;
            this.value = value;
            this.n = n;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) {
            return 0;
        }
        return x.n;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return get(x.left, key);
        }
        if (cmp > 0) {
            return get(x.right, key);
        }
        return x.value;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node x, Key key, Value value) {
        if (x == null) {
            return new Node(key, value, 1);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, value);
        }
        if (cmp > 0) {
            x.right = put(x.right, key, value);
        }
        x.value = value;
        x.n = size(x.left) + size(x.right) + 1;
        return x;
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

    private Key max() {
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right == null) {
            return x;
        }
        return max(x.right);
    }

    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null) {
            return null;
        }
        return x.key;
    }

    private Node floor(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        }
        if (cmp < 0) {
            return floor(x.left, key);
        }
        Node t = floor(x.right, key);
        if (t == null) {
            return x;
        }
        return t;
    }

    public Key select(int k) {
        return select(root, k).key;
    }

    private Node select(Node x, int k) {
        if (x == null) {
            return null;
        }
        int t = size(x.left);
        if (t > k) {
            return select(x.left, k);
        }
        if (t < k) {
            return select(x.right, k - t - 1);
        }
        return x;
    }

    public int rank(Key key) {
        return rank(key, root);
    }

    private int rank(Key key, Node x) {
        if (x == null) {
            return 0;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return rank(key, x.left);
        }
        if (cmp > 0) {
            return rank(key, x.right) + size(x.left) + 1;
        }
        return size(x.left);
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) {
            return x.right;
        }
        x.left = deleteMin(x.left);
        x.n = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = delete(x.left, key);
        } else if (cmp > 0) {
            x.right = delete(x.right, key);
        } else {
            if (x.right == null) {
                return x.left;
            }
            if (x.left == null) {
                return x.right;
            }
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.n = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    private Iterable<Key> keys(Key min, Key max) {
        Queue<Key> queue = new Queue<Key>();
        keys(root, queue, min, max);
        return queue;
    }

    private void keys(Node x, Queue<Key> queue, Key min, Key max) {
        if (x == null) {
            return;
        }
        int cmpMin = min.compareTo(x.key);
        int cmpMax = max.compareTo(x.key);
        if (cmpMin < 0) {
            keys(x.left, queue, min, max);
        }
        if (cmpMin <= 0 && cmpMax >= 0) {
            queue.enqueue(x.key);
        }
        if (cmpMax > 0) {
            keys(x.right, queue, min, max);
        }
    }


    public static void main(String[] args) {
        String[] arr = new String[]{"n", "a", "e", "f", "c", "b", "x", "y", "m", "p", "d"};
        BinarySearchTree<String, String> tree = new BinarySearchTree<>();
        for (String s : arr) {
            tree.put(s, s);
        }
        Iterable<String> keys = tree.keys();
        for (Object key : keys) {
            System.out.print(key + " ");
        }
        tree.delete("f");
        Iterable<String> keys1 = tree.keys();
        System.out.println();
        for (Object key : keys1) {
            System.out.print(key + " ");
        }
    }
}
