package L08;

import java.text.MessageFormat;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;


public class Mahat_Aviv_2023A {

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
                    Fruit first = new Apple(100, "RED");
                    Fruit second = new Fruit(90);
                    Apple third = new Apple(100, "RED");

//                    boolean b = first. validWeight(); // שגיאת קומפילציה -  מכיוון first הוא מטיפוס fruit ולמחלקת fruit לא קיימת הפונקציה הנ"ל
//                    boolean b1 = second. validWeight(); // שגיאת קומפילציה -  מכיוון first הוא מטיפוס fruit ולמחלקת fruit לא קיימת הפונקציה הנ"ל
                    boolean b2 = ((Apple) first).validWeight(); // תקין
//                    boolean b3 = ((Apple) second).validWeight();// זמן ריצה - ההמרה תעבוד אבל בזמן ריצה התוכנית תגלה כי הטיפוס האמיתי שנמצא second הוא fruit
//                    boolean b4 = ((Apple)first).color.equals(third.color); // שגיאת קומפילציה - מכיוון והתכונה color פרטית
                    Object[] obj = new Object[1000];
                    for (int i = 0; i < 1000; i++) {
                        if (rd.nextBoolean())
                            obj[i] = new Fruit(i);
                        else
                            obj[i] = new Apple(i, "i");
                    }
                    int cntFruit = 0, cntApple = 0, cntFruitNApple = 0;
                    System.out.println(obj);
                    for (int i = 0; i < obj.length; i++) {
                        if (obj[i] instanceof Fruit)
                            cntFruit++;
                        if (obj[i] instanceof Apple) {
                            cntApple++;
                        }
                        if (!(obj[i] instanceof Apple) && obj[i] instanceof Fruit) {
                            cntFruitNApple++;
                        }
                    }

                    System.out.println(MessageFormat.format("{0} - {1} - {2}", cntFruit, cntApple, cntFruitNApple));
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

    public static int numDigits(Node<Integer> n) {
        if (n == null)
            return 0;

        int counter = 0;

        while (n != null) {
            counter++;
            n = n.getNext();
        }
        return counter;

    }

    // n = max(len(n1),len(n2))
    // O(n)
    public static int compare(Node<Integer> n1, Node<Integer> n2) {

        if (n1 == null && n2 == null)
            return 0;

        int sizeN1 = numDigits(n1);
        int sizeN2 = numDigits(n2);

        if (sizeN1 > sizeN2)
            return 1;
        if (sizeN1 < sizeN2)
            return 2;

        while (n1 != null) {
            if (n1.getValue() > n2.getValue())
                return 1;
            if (n1.getValue() < n2.getValue())
                return 2;
            n1 = n1.getNext();
            n2 = n2.getNext();
        }
        return 0;
    }

    //O(n)
    public static int distance(Node<Integer> lst, int num) {
        if (lst == null)
            return -1;

        int firstIndex = indexOf(lst, num);
        int lastIndex = -1;

        int cnt = 0;
        while (lst != null) {
            cnt++;
            if (lst.getValue() == num)
                lastIndex = cnt - 1;
            lst = lst.getNext();
        }
        if (firstIndex == -1)
            return -1;

        return firstIndex + (cnt - (lastIndex + 1));
    }

    //O(n)
    private static int indexOf(Node<Integer> lst, int num) {
        int index = -1;
        while (lst != null) {
            index++;
            if (lst.getValue() == num)
                break;
            lst = lst.getNext();
        }
        return index;
    }
    //O(n) בעבור כל איבר בשרשרת מפעילים את הפונקציה distance ולכן הסיבוכיות היא -
    public static int minDistanceValue(Node<Integer> lst)
    {
        if(lst==null)
            return -1;


        int min= distance(lst,lst.getValue());
        while (lst!=null){

            int nextMin=distance(lst,lst.getValue());
            if(min>nextMin)
                min = nextMin;
            lst=lst.getNext();
        }


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