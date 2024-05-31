package L04;

import L03.BinNode;

public class BST<E extends Comparable<E>> {

    private BinNode<E> root;
    private int size;


    public BST() {

        root = null;
        size = 0;
    }

    public boolean add(E value) {
        size++;
        if (root == null)
            root = new BinNode<>(value);
        else
            return add(root, value);
        return true;
    }

    private boolean add(BinNode<E> root, E value) {

        if (root == null)
            return true;

        if (root.getValue().compareTo(value) >= 0) {
            add(root.getLeft(), value);
            root.setLeft((root.hasLeft()) ? root.getLeft() : new BinNode<>(value));
        } else {
            add(root.getRight(), value);
            root.setRight((root.hasRight()) ? root.getRight() : new BinNode<>(value));
        }

        return true;
    }
}
