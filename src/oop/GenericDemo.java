package oop;

import java.util.ArrayList;
import java.util.List;

class T1{
    String t1;
}
class T2 extends T1{
    String t2;
}
class T3 extends T2{
    String t3;
}
public class GenericDemo {
    public static void main(String[] args) {
        List<? extends Number> extendList = new ArrayList<>();
        List<? super Number> superList = new ArrayList<>();

//        extendList.add(new Integer(1));
        superList.add(1);


        List<? extends T2> extendsList = new ArrayList<>();
        List<? super T2> supersList = new ArrayList<>();

//        extendsList.add(new T1());
//        extendsList.add(new T3());

//        supersList.add(new T1());
        supersList.add(new T3());
    }
}
