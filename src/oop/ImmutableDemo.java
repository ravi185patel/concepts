package oop;

class MutableDemo{
    private String add;

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }
}

final class Immutable{
    private final String name;
    private final MutableDemo mutableDemo;

    public Immutable(String name, MutableDemo mutableDemo) {
        this.name = name;
        this.mutableDemo = mutableDemo;
    }

    public String getName() {
        return name;
    }

    public MutableDemo getMutableDemo() {
        MutableDemo mutableDemo1 = new MutableDemo();
        return mutableDemo1;
    }

    public void getHashCode(){
        System.out.println(mutableDemo.hashCode());
    }
}

public class ImmutableDemo {
    public static void main(String[] args) {
        MutableDemo mutableDemo = new MutableDemo();
        Immutable immutable = new Immutable("ravi",mutableDemo);
        System.out.println(immutable.hashCode());
        System.out.println(mutableDemo.hashCode()+" <> "+immutable.getMutableDemo().hashCode());
        immutable.getHashCode();
    }
}
