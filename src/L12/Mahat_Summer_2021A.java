package L12;

import java.util.Random;
import java.util.Scanner;

public class Mahat_Summer_2021A {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    static Scanner sc = new Scanner(System.in);
    static Random rd = new Random();


    public static void main(String[] args) {
        int ans;
        boolean bool;
        while (true) {
            System.out.println("Enter q number");
            int num = sc.nextInt();
            System.out.println("------------------------------------------");
            switch (num) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:



                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    break;
                case 13:
                    break;
                case 14:
                    break;
                case -1:
                    return;

            }
        }
    }


}

class Memory {
    private Node<Data> start;

    public Memory(int totalSize) {
        this.start = new Node<Data>(new Data(totalSize));
    }

    public boolean isDangerousState() {
        Node<Data> temp = start;

        int totalMemory = 0;
        int totalFree = 0;

        while (temp != null) {
            Data data = temp.getValue();
            totalMemory += data.getSize();
            if (data.isFree())
                totalFree += data.getSize();
            temp = temp.getNext();
        }

        return totalFree < (double) (totalMemory * 0.1);
    }

    public boolean firstFit(int num) {
        if (isDangerousState())
            return false;
        Node<Data> temp = start;

        while (temp != null) {
            Data data = temp.getValue();
            if (data.getSize() >= num)
                break;
            temp = temp.getNext();
        }

        if (temp == null)
            return false;

        Data new_data = new Data(num);
        new_data.setFree(false);
        Node<Data> newNode = new Node<>(new_data);

        Data old_data = temp.getValue();
        old_data.setSize(old_data.getSize()-num);

        newNode.setNext(temp.getNext());
        temp.setNext(newNode);

        if(isDangerousState())
        {
            temp.setNext(newNode.getNext());
            temp.getValue().setSize(old_data.getSize()+num);
            return false;
        }

        return true;
    }
}


class Data {
    private boolean free;
    private int size;

    //constructor
    public Data(int size) {
        this.free = true;
        this.size = size;
    }

    public boolean isFree() {
        return free;
    }

    public int getSize() {
        return size;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

class Node<E> {

    private E value;
    private Node<E> next;

    public Node(E value) {
        this.value = value;
        this.next = null;
    }

    public Node(E value, Node<E> next) {
        this.value = value;
        this.next = next;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public boolean hasNext() {
        return this.next != null;
    }

    @Override
    public String toString() {
        return value + "";
    }
}


class BinNode<E> {

    private E value;
    private BinNode<E> right;
    private BinNode<E> left;


    public BinNode(E value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public BinNode(E value, BinNode<E> right, BinNode<E> left) {
        this.value = value;
        this.right = right;
        this.left = left;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public BinNode<E> getRight() {
        return right;
    }

    public void setRight(BinNode<E> right) {
        this.right = right;
    }

    public boolean hasRight() {
        return right != null;
    }

    public boolean hasLeft() {
        return left != null;
    }

    public BinNode<E> getLeft() {
        return left;
    }

    public void setLeft(BinNode<E> left) {
        this.left = left;
    }


}
