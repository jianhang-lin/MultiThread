package Introduction1.AI14;

/**
 * 用于确认可用余额变为负数的可能性的Main类
 */
public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("A Bad Bank", 1000);//创建一个1000日元的银行账户
        new ClientThread(bank).start();
        new ClientThread(bank).start();
    }
}
