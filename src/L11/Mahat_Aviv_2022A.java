package L11;

import java.util.Random;
import java.util.Scanner;
import java.util.Stack;


public class Mahat_Aviv_2022A {

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
                    Node<Integer> chain = new Node<>(1, new Node<>(2, new Node<>(3, new Node<>(4))));
                    first(chain, 6);
                    print(chain);
                    Node<Integer> chain2 = new Node<>(11, new Node<>(2, new Node<>(30, new Node<>(4))));
                    second(chain2);
                    print(chain2);
                    break;
                case 2:
                    Stack<Integer> st = new Stack(){{
                        add(6);
                        add(12);
                        add(2);
                        add(10);
                        add(7);
                        add(5);
                    }};
                    System.out.println(st);
                    sortAvg(st);
                    System.out.println(st);
                    break;
                case 3:
                    A b = new B();
                    b.a2();
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

    private static void sortAvg(Stack<Integer> st) {

        if (st == null || st.isEmpty())
            return;

        Stack<Integer> big = new Stack<>();
        Stack<Integer> temp = new Stack<>();

        int cnt = 0;
        int sum = 0;

        while (!st.isEmpty()) {
            cnt++;
            int item = st.pop();
            temp.push(item);
            sum += item;
        }
        double avg = (double) sum / cnt;

        while (!temp.isEmpty()) {
            int item = temp.pop();
            if (item <= avg)
                st.push(item);
            else
                big.push(item);
        }
        while (!big.isEmpty()) {
            int item = big.pop();
            st.push(item);
        }

    }

    public static void second(Node<Integer> chain) {

        if (chain == null)
            return;

        Node<Integer> copy = new Node<>(chain.getValue());
        Node<Integer> temp = copy;
        while ((chain = chain.getNext()) != null) {

            temp.setNext(new Node<>(chain.getValue()));
            temp = temp.getNext();

            if (!chain.hasNext()) {
                chain.setNext(copy);
                break;
            }
        }


    }

    private static void print(Node<Integer> chain) {
        while (chain != null) {
            System.out.print(chain.getValue() + " -> ");
            chain = chain.getNext();
        }
        System.out.println("null");
    }

    public static void first(Node<Integer> chain) {
        while (chain != null) {
            Node<Integer> next = chain.getNext();
            chain.setNext(new Node<>(chain.getValue(), next));
            chain = next;
        }

    }


    public static void first(Node<Integer> chain, int num) {
        while (chain != null) {
            Node<Integer> next = chain.getNext();
            for (int i = 0; i < num; i++) {

                chain.setNext(new Node<>(chain.getValue()));
                chain = chain.getNext();
            }
            chain.setNext(next);
            chain = next;

        }

    }
}

 class A
{
    protected void a1()
    {
        System.out.println ("Hello A");
    }
    protected void a2()
    {
        a1();
    }
}

class B extends A
{
    protected void a1()
    {
        System.out.println ("Bye B");
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
