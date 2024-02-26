package oop;

class MutableDemo{
    private String add;


    public MutableDemo(){

    }
    public MutableDemo(MutableDemo mutableDemo){
        this.add=mutableDemo.add;
    }
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
//        this.mutableDemo = mutableDemo;
        this.mutableDemo = new MutableDemo(mutableDemo);
    }

    public String getName() {
        return name;
    }

    /*
      issue on line no - 40 due to lin-28 because i can change properties of mutable demo.
      to resolve it create new based on properties and assign it to reference;
     */
    public MutableDemo getMutableDemo() {
        MutableDemo mutableDemo1 = new MutableDemo(mutableDemo);
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
        System.out.println(mutableDemo.hashCode()+" <> "+immutable.getMutableDemo().hashCode()+" <> "+immutable.getMutableDemo().getAdd());
        immutable.getHashCode();
        mutableDemo.setAdd("xyz");
        System.out.println(immutable.hashCode());
        System.out.println(mutableDemo.getAdd()+" <> "+immutable.getMutableDemo().getAdd());

    }
}
