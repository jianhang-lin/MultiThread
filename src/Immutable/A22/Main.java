package Immutable.A22;

/**
 * 确认replace方法已新建其他实例的程序
 */
public class Main {
    public static void main(String[] args) {
        String s = "BAT";
        String t = s.replace('B', 'C');
        System.out.println("s=" + s);
        System.out.println("t=" + t);
        if (s == t) {
            System.out.println("s==t");
        } else {
            System.out.println("s!=t");
        }
    }
}
