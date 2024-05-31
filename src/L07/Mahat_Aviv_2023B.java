package L07;

import java.util.Random;
import java.util.Scanner;


public class Mahat_Aviv_2023B {

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

    public static void balance(Node<Integer> chain) {

        if (chain == null)
            return;

        int sum = 0;
        int size = 0;

        while (chain.hasNext()) {
            sum += chain.getValue();
            size++;
            chain = chain.getNext();
        }
        sum += chain.getValue();
        size++;

        if (size % 2 != 0)
            chain.setNext(new Node<>(-sum));
        else if (sum != 0)
            chain.setNext(new Node<>(-sum, new Node<>(0)));

    }

    public static boolean isSuper(Node<Integer> n) {
        if (n == null)
            return false;
        int sum = 0;

        while (n != null) {
            if (n.getValue() <= sum)
                return false;
            sum += n.getValue();
            n = n.getNext();
        }

        return true;
    }

    //1->2->3
    //inaert 4
    // after 1->4->2->3
    private static void insert(Node<Integer> chain, int num){
        Node<Integer> next = chain.getNext();
        chain.setNext(new Node<>(num,next));
    }

    private static void remove(Node<Integer> chain){
        chain.setNext(chain.getNext().getNext());
    }
    public static boolean addToSuper1(Node<Integer> n, int num){

        if(n==null)
            return false;
        while (n!=null) {
            insert(n,num);
            if(isSuper(n))
                return true;
            remove(n);
            n = n.getNext();
        }
        return false;
    }


    public static boolean addToSuper(Node<Integer> n, int num){

        if(n==null)
            return false;

        Node<Integer> temp = n;
        int sum=0;
        boolean flag=false;
        Node<Integer> current=null;
        while (temp.hasNext()){

            if (temp.getValue() <= sum)
                return false;
            sum+=temp.getValue();
            if ( !flag && num>sum && num+sum < temp.getNext().getValue() ){
                flag=true;
                sum+=num;
                current=temp;
            }
            temp= temp.getNext();
        }
        sum+=temp.getValue();
        if ( !flag && num>sum ){
            temp.setNext(new Node<>(num));
            return true;
        }
        if(current!=null){
            temp=current.getNext();
            current.setNext(new Node<>(num,temp));
        }

        return flag;
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
