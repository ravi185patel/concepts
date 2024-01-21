package oop;
/*
When we have to use abstract
1] when you need to depend on other vendor/apis for partial dependency.
i.e. makemytrip have multiple users and each user have same or different vendor sim card
so makemytrip knows what are the ticket nos and other details or say message body but don't know
how to connect with tower and send message so for this requirement it has to depend on other vendors
so it will create abstarct class.

abstract class SendNotification{
  abstract public boolean openConnection(); // implementation provided by vendors.
  abstract public boolean sendNotification(); // implementation provided by vendors.
  abstract public boolean closedConnection(); // implementation provided by vendors.
  public Message generateMessage(){ // implementation provided by makemytrip.
  }
}

 */
abstract class A{
    abstract int getNo();
    public void printNo(){
        System.out.println("print by A");
    }
}
class DerivedA extends  A{

    @Override
    int getNo() {
        return 1;
    }

    public void printNo(){
        // if you not override this method it will call parent method directly because child acquire property of parent
        super.printNo(); // called parent method
        System.out.println("print by DerivedA");
    }

    public int setAndPrintNo(){
        return getNo()*100;
    }
}

abstract class B{
    abstract int getNo();
    public void printNo(){
        System.out.println("print by B");
    }
}

abstract class Bchild extends B{
    abstract public void printNo();
}
class DerivedB extends Bchild{

    @Override
    int getNo() {
        return 0;
    }

    @Override
    public void printNo() {
//        super.printNo(); // here you get error because printNo is abstract method, so you can also hide implementation of method by using abstract.
        System.out.println("print by DerivedB");
    }
}
public class AbstractClassDemo {
    public static void main(String[] args) {
        DerivedA derivedA=new DerivedA();
        derivedA.getNo();
        derivedA.printNo();
        System.out.println(derivedA.setAndPrintNo()); // call child method

        A a=new DerivedA();
        a.getNo();
        a.printNo(); // will call child method because here parent have same method which acquire by child , it is called overriding and
        // in overriding, method called happen based on object type not reference variable type.
        // System.out.println(a.setAndPrintNo()); // gives error because parent have no idea what properties child have.


        B b=new DerivedB();
        b.getNo();
        b.printNo(); // will call child method because here parent have same method which acquire by child , it is called overriding and
        // in overriding, method called happen based on object type not reference variable type.
        // System.out.println(a.setAndPrintNo()); // gives error because parent have no idea what properties child have.
    }
}
