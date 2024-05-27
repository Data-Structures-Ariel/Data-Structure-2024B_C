package L05;


import L03.BinNode;

import java.util.*;


public class Mahat_Summer_2023A {

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

                    Queue<Integer> q = new LinkedList<>() {{
                        add(2);
                        add(10);
                        add(12);
                        add(3);
                        add(7);
                        add(4);
                        add(1);
                    }};

                    System.out.println(q);
                    int index = putInPlace(q, 9);
                    System.out.println("index -> " + index);
                    System.out.println(q);


                    Queue<Integer> q1 = new LinkedList<>() {{
                        add(7);
                        add(2);
                        add(5);
                        add(4);
                        add(6);
                        add(8);
                        add(10);
                        add(12);

                    }};
                    System.out.println(q1);
                    moveToFront(q1, 5);
                    System.out.println(q1);
                    break;
                case 2:
                    BinNode<Integer> chain = new BinNode<>(1);
                    BinNode<Integer> e = new BinNode<>(11);
                    chain.setRight(e);
                    BinNode<Integer> f = new BinNode<>(4);
                    chain.getRight().setRight(f);
                    BinNode<Integer> s = new BinNode<>(6);
                    chain.getRight().getRight().setRight(s);
                    BinNode<Integer> t = new BinNode<>(3);
                    chain.getRight().getRight().getRight().setRight(t);

                    chain.getRight().setLeft(chain);
                    chain.getRight().getRight().setLeft(e);
                    chain.getRight().getRight().getRight().setLeft(f);
                    chain.getRight().getRight().getRight().getRight().setLeft(s);


                    print(chain);
//                    printRev(chain.getRight().getRight().getRight().getRight());
                    order(chain);
                    print(chain);
                    break;
                case 3:
                    Flower first = new Rose(20, "RED");
                    Flower second = new Flower(93);

                    boolean b;
//                   boolean b = first. validHeight();// קומפילציה
//                   boolean b = second. validHeight(); // קומפילציה
//                   b = ((Rose) first).validHeight();// קוד תקין
                    b = ((Rose) second).validHeight(); // זמן ריצה
//                   b = first.getPrice() == second.price; // קומפילציה
                    Object[] objects = new Object[20];
                    for (int i = 0; i < 20; i++) {
                        int type = new Random().nextInt(3);
                        switch (type) {

                            case 0:
//                                objects[i] = new Rose();
                            case 1:
                            case 2:
                        }

                    }
                    cntObjects(objects);

                    break;
                case 4:
                    Actor actor1 = new Actor("Bob", 25);
                    Actor actor2 = new Actor("Alice");

                    Dancer dancer1 = actor1;
                    dancer1.coupleDance(actor2);

//                    Singer singer2 = new Singer(); // קומפילציה
//                    singer2.sing();
//
                    Singer singer3 = new Actor("Clark", 30);
                    Dancer dancer3 = (Actor) singer3;
//
//                    Singer actor4 = new Actor("Danny");// קומפילציה
//                    actor4.play();
//
                    Dancer actor5 = new Actor("Eddie");
                    Singer singer5 = (Singer) actor5;
                    singer5.sing();

                    Musician musician6 = new Actor("Freddie", 45);
                    ((Actor) musician6).lonelyDance();
                    ((Singer) musician6).sing();

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

    private static void print(BinNode<Integer> chain) {

        if (chain == null)
            return;


        while (chain != null) {
            System.out.print(chain.getValue() + " -> ");
            chain = chain.getRight();
        }
        System.out.println("null");
    }

    private static void printRev(BinNode<Integer> chain) {

        if (chain == null)
            return;


        while (chain != null) {
            System.out.print(chain.getValue() + " -> ");
            chain = chain.getLeft();
        }
        System.out.println("null");
    }

    private static void cntObjects(Object[] objects) {
        if (objects == null)
            return;
        int isF = 0, isR = 0, isFnR = 0;

        for (int i = 0; i < objects.length; i++) {
            Object obj = objects[i];
            if (obj instanceof Flower && !(obj instanceof Rose))
                isFnR++;
            else if (obj instanceof Rose)
                isR++;
            else if (obj instanceof Flower)
                isF++;

        }
        System.out.println("isFlower -> " + isF);
        System.out.println("isRose -> " + isR);
        System.out.println("isFlower not Rose -> " + isFnR);

    }

    // O(n) מכיוון ובכל לולאה עברנו פעם אחת על כל איבר סה"כ 3 לולאות ולכן נקבל
    public static void moveToFront(Queue<Integer> q, int k) {
        if (q == null || q.isEmpty())
            return;

        Queue<Integer> temp = new LinkedList<>();
        int n = 0;

        while (!q.isEmpty()) {
            temp.add(q.remove());
            n++;
        }
        while (!temp.isEmpty())
            q.add(temp.remove());

        int c = n - k;

        for (int i = 0; i < c; i++) {
            int item = q.remove();
            q.add(item);
        }
    }

    //3n ~ O(n) מכיוון ובכל לולאה עברנו פעם אחת על כל איבר סה"כ 3 לולאות ולכן נקבל
    public static int putInPlace(Queue<Integer> q, int num) {

        if (q == null)
            return -1;

        Queue<Integer> big = new LinkedList<>();
        Queue<Integer> small = new LinkedList<>();

        //O(n)
        while (!q.isEmpty()) {
            int item = q.remove();
            if (item >= num)
                big.add(item);
            else
                small.add(item);
        }
        int index = 1;

        //O(n)
        while (!small.isEmpty()) {
            index++;
            q.add(small.remove());
        }
        q.add(num);

        //O(n)
        while (!big.isEmpty())
            q.add(big.remove());


        return index;

    }

    //O(n^2)
    public static void order(BinNode<Integer> chain)
    {
        if(chain == null)
            return;

        for (BinNode<Integer> i = chain; i !=null ; i=i.getRight()) {
            if(i.getValue()%2==0)
                continue;
            for (BinNode<Integer> j = i; j !=null ; j=j.getRight()) {

                if(j.getValue()%2==0) {
                    int item = i.getValue();
                    i.setValue(j.getValue());
                    j.setValue(item);
                    break;
                }
            }
        }


    }
}


class Flower {
    protected int height;
    private int price;

    public Flower(int val) {
        this.height = val;
        this.price = 10;
    }

    public int getHeight() {
        return this.height;
    }

    public int getPrice() {
        return this.price;
    }
}

class Rose extends Flower {
    private String color;

    public Rose(int val, String col) {
        super(val);
        this.color = col;
    }

    public boolean validHeight() {
        return this.height > 10 && this.height < 30;
    }
}

interface Dancer {
    void lonelyDance();

    void coupleDance(Dancer d);
}

interface Singer {
    void sing();
}

interface Musician {
    void play();
}

class Actor implements Dancer, Singer, Musician {
    private String name;
    private int age;


    public Actor(String name) {
        this.name = name;
    }

    public Actor(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void lonelyDance() {

    }

    @Override
    public void coupleDance(Dancer d) {

    }

    @Override
    public void sing() {

    }

    @Override
    public void play() {

    }

}