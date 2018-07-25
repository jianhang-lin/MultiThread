package Immutable;

/**
 * Person类
 * 声明了final类型，表示无法创建Person类的子类
 */
public final class Person {
    /**
     * 声明了final，意即一旦字段被赋值一次，就不会再被赋值
     */
    private final String name;
    private final String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "[ Person: name = " + name + ", address = " + address + "]";
    }
}
