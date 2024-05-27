package L05;

import L03.BinNode;

import static L03.Main.inOrder;

public class Main {

    public static void main(String[] args) {
        BinNode<Integer> root = new BinNode<>(1, new BinNode<>(2, new BinNode<>(4), new BinNode<>(5)),
                new BinNode<>(3, new BinNode<>(6), new BinNode<>(7)));

        inOrder(root);
        mirror(root);
        System.out.println();
        inOrder(root);
    }

    private static void mirror(BinNode<Integer> root) {

        if(root==null)
            return;

        BinNode<Integer> temp = root.getRight();
        root.setRight(root.getLeft());
        root.setLeft(temp);

        mirror(root.getLeft());
        mirror(root.getRight());


    }
}
