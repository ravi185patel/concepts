package Java8Demo;

import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String[] args) {
        Consumer<String> c = s -> System.out.println(s);
        c.accept("ravi");
        /*
        it has default method andThen()
         */
        c = c.andThen(s -> System.out.println(s.length()));
        c.accept("ravi");
    }
}
