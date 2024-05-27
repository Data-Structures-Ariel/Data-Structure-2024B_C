package L06;

public class Main {

    public static void main(String[] args) {
        Flower first = new Rose (20, "RED");
        Flower second = new Flower (93);
        Rose r = new Rose(20,"");
//        ((Flower)r).getPrice();

//        boolean b = ((Rose)second). validHeight();

//        boolean b = first.getPrice() == second.price;
        System.out.println(first);
        System.out.println(second);



    }
}
class A{

    int a;
    boolean c;

}
class Flower {
    protected int height;
    private int price=7;

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

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    protected Object clone(int val) throws CloneNotSupportedException {
        return super.clone();
    }
}
class Rose extends Flower {
    private String color;

    public Rose(int val, String col) {
        super(val);
        this.color = col;
    }
    public int getPrice() {
        return 3;
    }
    public boolean validHeight() {
        return this.height > 10 && this.height < 30;
    }
}

class B extends A{
    int b;
}