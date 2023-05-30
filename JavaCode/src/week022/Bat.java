package week022;

public class Bat extends Animal implements Winged {
    public Bat(String name) {
        super(name);
    }

    @Override
    public String speak() {
        return null;
    }

    @Override
    public void fuck() {

    }

    @Override
    public int numWings() {
        return 2;
    }
}
