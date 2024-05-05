package L04;

import L03.BinNode;

import java.util.LinkedList;
import java.util.Queue;

public class Main {


    public static void main(String[] args) {

        BinNode<Integer> root = new BinNode<>(17); // deg = 0

        // ------------------ deg-1 ---------------------
        root.setRight(new BinNode<>(7));
        root.setLeft(new BinNode<>(36));

        // ------------------ deg-2 ---------------------
        root.getRight().setRight(new BinNode<>(0));
        root.getRight().setLeft(new BinNode<>(28));

        root.getLeft().setLeft(new BinNode<>(12));

        // ------------------ deg-3 ---------------------
        root.getLeft().getLeft().setLeft(new BinNode<>(10));
        root.getLeft().getLeft().setRight(new BinNode<>(42));

        root.getRight().getRight().setRight(new BinNode<>(1));

        // ------------------ deg-4 ---------------------
        root.getRight().getRight().getRight().setRight(new BinNode<>(70));

        levelOrder(root);

    }

    private static void levelOrder(BinNode<Integer> root) {
        if (root == null)
            return;
        Queue<BinNode<Integer>> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            BinNode<Integer> temp = q.poll();
            System.out.print(temp.getValue() + " ");

            if (temp.hasLeft()) {
                q.add(temp.getLeft());
            }

            if (temp.hasRight()) {
                q.add(temp.getRight());
            }

        }
        System.out.println();
    }
}
