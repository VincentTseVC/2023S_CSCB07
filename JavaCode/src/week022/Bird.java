package week022;

public class Bird extends Animal implements Winged, Fuckable {
    public Bird(String name, int age) {
        super(name, age);
    }

    public Bird(String name) {
        super(name);
    }

    @Override
    public String speak() {
        return "唧唧唧";
    }

    @Override
    public int numWings() {
        return 2;
    }

    @Override
    public void fuck() {

    }
}
