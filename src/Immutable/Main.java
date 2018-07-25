package Immutable;

public class Main {
    public static void main(String[] args) {
        Person alice = new Person("Alice", "Alaska");
        new PrintPersionThread(alice).start();
        new PrintPersionThread(alice).start();
        new PrintPersionThread(alice).start();
    }
}
