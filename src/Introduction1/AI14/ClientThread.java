package Introduction1.AI14;

/**
 * 反复取出、存入1000日元的ClientThread类
 */
public class ClientThread extends Thread {
    private Bank bank;

    public ClientThread(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        while (true) {
            boolean ok = bank.withdraw(1000);
            if (ok) {
                bank.deposit(1000);
            }
        }
    }
}
