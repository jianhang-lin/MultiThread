package SingleThreadedExecution.Sample2;

/**
 * 表示门的类，它会在人们通过门时记录其姓名与出生地
 */
public class Gate {
    private int counter = 0;
    private String name = "Nobody";
    private String address = "Nowhere";

    public synchronized void pass(String name, String address) {
        this.counter++;
        this.name = name;
        this.address = address;
        check();
    }

    @Override
    public synchronized String toString() {
        return "No." + counter + ": " + name + ", " + address;
    }

    private void check() {
        if (name.charAt(0) != address.charAt(0)) {
            System.out.println("********** BROKEN ********* " + toString());
        }
    }
}
