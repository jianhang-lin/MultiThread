package Introduction1.AI14;

/**
 * 确认可用余额变为负数的可能性
 */
public class Bank {
    private int money;
    private String name;

    public Bank(String name, int money) {
        this.money = money;
        this.name = name;
    }

    public void deposit(int m) {
        money += m;
    }

    public boolean withdraw(int m) {
        if (money >= m) {
            money -= m;
            check();
            return true;
        } else {
            return false;
        }
    }

    public String getName() {
        return name;
    }

    private void check() {
        if (money < 0) {
            System.out.println("可用余额为负数! money = " + money);
        }
    }
}
