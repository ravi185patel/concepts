package Java8Demo;

import java.util.function.Function;

public class FunctionDemo {
    public static void main(String[] args) {
        Function<Integer, Boolean> valid = i -> i != null;
        System.out.println(valid.apply(null));
        System.out.println(valid.apply(10000000));
        Function<Integer, Integer> applyIncomeTax = i -> i - (i / 10);
        System.out.println(applyIncomeTax.apply(50));

        /*
        other methods in Function interface
         */
        Function<Integer, Integer> f1 = i -> i + i;
        Function<Integer, Integer> f2 = i -> i * i * i;
        System.out.println(f1.andThen(f2).apply(2));
        System.out.println(f1.compose(f2).apply(2));

        Function<String, String> f1s = Function.identity();
        String s2 = f1s.apply("durga");
        System.out.println(s2);
    }
}
