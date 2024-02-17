package Java8Demo;

interface Car {
    default String get() {
        return "four wheeler";
    }

    public String getName();

    public String getType();
    /*
    can't declare object class method as default in interface.
     */
//    default String toString(){
//        return "ravi toString method";
//    }
}

interface Truck {
    default String get() {
        return "four wheeler";
    }
}

class Sadden implements Car, Truck {

    //    @Override
    public String get() {
        return Car.super.get();
    }

    @Override
    public String getName() {
        return "Doge";
    }

    @Override
    public String getType() {
        return "race car";
    }
}

public class InterfaceNewMethod {
    public static void main(String[] args) {
        Car car = new Sadden();
        System.out.println(car.getName() + " " + car.getType() + " " + car.get());

        Runnable r = Sadden::new;
        Thread thread = new Thread(r);
        thread.start();
    }
}
