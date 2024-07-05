package L12;

import java.util.LinkedList;
import java.util.Queue;
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
                    Queue<Integer> q= new LinkedList<>(){{
                        add(2);
                        add(5);
                        add(5);
                        add(7);
                        add(2);
                        add(4);
                        add(1);
                        add(3);
                        add(2);
                        add(5);
                        add(5);
                        add(1);
                    }};
                    System.out.println(q);
                    Queue<Integer> filterQ=filterNumber(q);
                    System.out.println(q);
                    System.out.println(filterQ);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    A a = new A();
                    B b = new B();
                    A ab = new B();
                    a.f();
                    ab.f();
                    b.f();
                    a.g();
                    ab.g();
                    b.g();
                    ((B)(ab)).superG();
                    b.superG();

//                    a.superG();
                    ((B)a).superG();
                    break;
                case 6:
                    break;
                case 7:

                Memory memory = new Memory(576);
                memory.firstFit(97);
                memory.firstFit(142);
                memory.print();
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

    private static Queue<Integer> filterNumber(Queue<Integer> q) {
        if(q==null)
            return null;

        Queue<Integer> filter = new LinkedList<>();
        Queue<Integer> temp = new LinkedList<>();
        int size=0;
        while(!q.isEmpty()){
            temp.add(q.poll());
          size++;
        }
        while (!temp.isEmpty()){
            int item = temp.poll();
            int cnt=1;
            size--;

            for (int i = 0; i < size; i++) {
                if(item==temp.peek())
                {
                    cnt++;
                    temp.poll();
                    size--;
                }else
                    temp.add(temp.poll());
            }
            if(cnt>2)
                filter.add(item);
        }
        return filter;
    }


}
class Tablet {
    private String name;
    private String kind;
    private char system;
    private double size;
    private double price;

    public Tablet(String name, String kind, char system, double size, double price) {
        this.name = name;
        this.kind = kind;
        this.system = system;
        this.size = size;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public char getSystem() {
        return system;
    }

    public void setSystem(char system) {
        this.system = system;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isSame(Tablet other){
        return this.name.equals(other.getName()) &&
                this.kind.equals(other.getKind())&&
                this.size==other.getSize();
    }
}

 class Store {
    private Tablet[] tablets;
    private int[] systems;
    public Store()
    {
        tablets = new Tablet[1000];
        systems = new int[3];
    }
     public boolean addTablet(Tablet tab){

        int index = systems[0]+systems[1]+systems[2];
        if(index>=1000)
            return false;

         for (int i = 0; i < index; i++) {

             if(tablets[i].isSame(tab)){
                 tablets[i].setPrice(
                         Math.max(tablets[i].getPrice()
                 ,tab.getPrice()));
                 return true;
             }
         }

        tablets[index]=tab;
         systems[(tab.getSystem()=='W')?0:(tab.getSystem()=='A')?1:2]++;
//        if(tab.getSystem()=='W')
//            systems[0]++;
//        else if (tab.getSystem()=='A')
//            systems[1]++;
//        else
//            systems[2]++;

return true;
     }
     public int sortStore(){

        Tablet[] windows = new Tablet[systems[0]];
        Tablet[] android = new Tablet[systems[1]];
        Tablet[] ios = new Tablet[systems[2]];
         int index = systems[0]+systems[1]+systems[2];
         int w=0,a=0,io=0;
         for (int i = 0; i <index ; i++) {
             if(tablets[i].getSystem()=='W')
             {
                 windows[w++]=tablets[i];
             }
             else if(tablets[i].getSystem()=='A'){
                 android[a++]=tablets[i];
             }
             else
                 ios[io++]=tablets[i];

         }
        // w= 10 , a=8, io=8
         for (int i = 0; i < w; i++) {
             tablets[i]=windows[i];
         }
         for (int i = 0; i < a; i++) {
             tablets[w+i]=android[i];
         }
         for (int i = 0; i < io; i++) {
             tablets[w+a+i]=ios[i];
         }

         return 1000-w-a-io;
     }
}
class A{
    public void f() {
        System.out.println("A.f");
    }
    public void g() {
        System.out.println(this);
        f();
    }
}
 class B extends A{
    public void f(){
        System.out.println("B.f");
    }
    public void g() {
        System.out.println("B.g");
    }
    public void superG() {
        System.out.println(super.toString());
        super.g();
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

    public void print(){

        Node<Data> temp = start;

        while (temp != null) {
            Data data = temp.getValue();
            System.out.println("size -> "+data.getSize() +" isFree -> "+data.isFree());
            temp = temp.getNext();
        }

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
