package Java8Demo;

@FunctionalInterface
interface MyFunctionalInterface{
    String getName();
}

public class FunctionalInterfaceDemo {
    public static void main(String[] args) {
        MyFunctionalInterface object=new MyFunctionalInterface(){
        
            @Override
            public String getName() {
                return "ravi";
            }
        };
        MyFunctionalInterface object1=()->"ravi";
        System.out.println(object.getName()+" <> "+object1.getName());
    }
}