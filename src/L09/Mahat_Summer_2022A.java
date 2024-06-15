package L09;

import java.text.MessageFormat;
import java.util.*;


public class Mahat_Summer_2022A {

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
                    Node<Integer> head = null;
                    differenceList(head);
                    theSurvives(head);
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

    private static int theSurvives(Node<Integer> head) {

        if (!head.hasNext())
            return head.getValue();
        print(head);
        Node<Integer> temp = differenceList(head);
        return theSurvives(temp);
    }

    public static void print(Node<Integer> chain) {

        while (chain != null) {
            System.out.print(chain.getValue() + ",");
            chain = chain.getNext();
        }

    }

    private static Node<Integer> differenceList(Node<Integer> chain) {

        if (chain == null || !chain.hasNext())
            return null;

        int currItem = chain.getValue();
        int nextItem = chain.getNext().getValue();

        Node<Integer> head = new Node<>(Math.abs(currItem - nextItem));
        Node<Integer> temp = head;

        chain = chain.getNext();
        while (chain.hasNext()) {
            currItem = chain.getValue();
            nextItem = chain.getNext().getValue();
            temp.setNext(new Node<>(Math.abs(currItem - nextItem)));
            temp = temp.getNext();
            chain = chain.getNext();

        }


        return head;
    }


    public static int sumQueue(Queue<Integer> q) {

        if (q == null || q.isEmpty())
            return 0;
        int sum = 0;

        Queue<Integer> qTemp = new LinkedList<>();

        while (!q.isEmpty()) {
            sum += q.peek();
            qTemp.add(q.poll());
        }

        while (!qTemp.isEmpty())
            q.add(qTemp.poll());

        return sum;

    }

    public static int sumQueueRec(Queue<Integer> q) {
        if (q == null || q.isEmpty())
            return 0;
        return q.poll() + sumQueueRec(q);
    }

    public static int lastValue(Queue<Integer> q) {
        if (q == null || q.isEmpty())
            return 0;
        Queue<Integer> qTemp = new LinkedList<>();
        int item = 0;
        while (!q.isEmpty()) {
            item = q.poll();
            qTemp.add(item);
        }

        while (!qTemp.isEmpty())
            q.add(qTemp.poll());

        return item;
    }

    public static int lastValueRec(Queue<Integer> q) {
        if (q == null)
            return 0;
        int item = q.remove();

        if (q.isEmpty())
            return item;

        return sumQueueRec(q);


    }

    public static Queue<Integer> NewQueueFromChain(Node<Queue<Integer>> chain) {

        if (chain == null)
            return null;

        Queue<Integer> q = new LinkedList<>();

        while (chain != null) {
            Queue<Integer> qTemp = chain.getValue();
            if (qTemp != null && !qTemp.isEmpty()) {
                if (qTemp.peek() % 2 == 0) {
                    int item = lastValue(qTemp);
                    q.add(item);
                } else {
                    int item = sumQueue(qTemp);
                    q.add(item);
                }
            }
            chain = chain.getNext();
        }

        return q;
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

class Fruit {
    protected int weight;

    public Fruit(int val) {
        weight = val;
    }

    public int getWeight() {
        return weight;
    }
}

class Apple extends Fruit {
    private String color;

    public Apple(int val, String col) {
        super(val);
        color = col;

    }

    public boolean validWeight() {
        return weight > 80 && weight < 140;
    }
}