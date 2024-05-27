package L06;


import L03.BinNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;


public class Mahat_Summer_2023B {

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


                    First[] arr = new First[5];
                    arr[0] = new First (13);
                    arr[1] = new First ();
                    arr[2] = new Second();
                    arr[3] = new Second(5, arr[0]);
                    arr[4] = new Second(2, 3.7, arr[2]);

                    for (int i = 0; i < 5; i++) {
                        System.out.println(arr[i]);
                    }

                    Shape s1 = new Shape();
                    Shape s2 = new Circle();
                    Shape s3 = new Cylinder();
                    Circle c = new Cylinder();

//                    Circle c0 = new Shape();
//                    Circle c1 = s1;
                    Circle c2 = (Circle) s2;
                    Circle c3 = (Circle) s3;

                    System.out.println(s2);
                    System.out.println(s3);



// שאלה ראשונה - מאיזה טיפוס s3? והאם הטיפוס הנ"ל יכול להכיל את הטיפוס שמנסה לבצע המרה (שאלת קומפילציה).
// שאלה שניה - איזה אובייקט באמת נוצר בs3? לפי זה נשאל האם יש מסלול מהאובייקט האמיתי שנמצא בs3 לטיפוס שמבצע המרה (שאלת זמן ריצה) .
// שאלה שלישית - האם קיים מסלול מצד ימין לאחר ההמרה לטיפוס שנמצא בצד שמאל (שאלת זמן ריצה) .


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
    public static void order(BinNode<Integer> chain) {
        if (chain == null)
            return;

        for (BinNode<Integer> i = chain; i != null; i = i.getRight()) {
            if (i.getValue() % 2 == 0)
                continue;
            for (BinNode<Integer> j = i; j != null; j = j.getRight()) {

                if (j.getValue() % 2 == 0) {
                    int item = i.getValue();
                    i.setValue(j.getValue());
                    j.setValue(item);
                    break;
                }
            }
        }


    }
}


class First
{
    protected int num;

    public First(int num) {
        this.num = num;
    }

    public First() {
        this.num=10;
    }

    @Override
    public String toString() {
        return "First{" +
                "num=" + num +
                '}';
    }
}
class Second extends First
{
    private double x;
    private First f;

    public Second() {
        this.x=1.1;
        this.f=null;
    }

    public Second(int num, First f) {
        super(num);
        this.x=this.num*1.1;
        this.f = f;
    }

    public Second(int num, double x, First f) {
        super((int)(num+x));
        this.x = this.num*1.1;
        this.f = f;
    }

    @Override
    public String toString() {
        return "Second{" +
                "x=" + x +
                ", f=" + f +
                ", num=" + num +
                '}';
    }
}


