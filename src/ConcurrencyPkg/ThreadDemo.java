package ConcurrencyPkg;

class ThreadCustom extends Thread{

}
public class ThreadDemo {
    public static void main(String[] args) {
        ThreadCustom threadCustom = new ThreadCustom();
        threadCustom.start();
    }
}
