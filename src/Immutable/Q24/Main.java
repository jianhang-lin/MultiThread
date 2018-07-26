package Immutable.Q24;

public class Main {
    public static void main(String[] args) {
        //创建实例
        UserInfo userInfo = new UserInfo("Alice", "Alaska");
        //显示
        System.out.println("userinfo=" + userInfo);
        //修改状态
        StringBuffer info = userInfo.getInfo();
        info.replace(12, 17, "Bobby");
        //再次显示
        System.out.println("userinfo=" + userInfo);
    }
}
