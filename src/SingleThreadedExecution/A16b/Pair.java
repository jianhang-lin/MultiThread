package SingleThreadedExecution.A16b;

public class Pair {
    private final Tool lefthand;
    private final Tool righthand;

    public Pair(Tool lefthand, Tool righthand) {
        this.lefthand = lefthand;
        this.righthand = righthand;
    }

    @Override
    public String toString() {
        return "[" + lefthand + " and " + righthand + "]";
    }
}
