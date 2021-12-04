package Java8Demo;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class BiFunctionalInterfaceDemo {
    public static void main(String[] args) {
        BiPredicate<Integer, Integer> p = (a, b) -> (a + b) % 2 == 0;
        System.out.println(p.test(10, 20));

        BiFunction<Integer, Integer, Integer> f = (a, b) -> a * b;
        System.out.println(f.apply(2, 4));

    }
}
