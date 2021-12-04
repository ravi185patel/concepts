package Java8Demo;

import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
        Predicate<Integer> divisable = (a) -> a % 2 == 0 && a > 1;
        Predicate<Integer> forEquality = null;
        for (int i = 0; i <= 10; i++) {
            System.out.println(divisable.test(i) + " " + i + " ");
//            divisable.negate(); // learn on website;
//            divisable.and((a) -> a==5);
            divisable = divisable.or((a) -> a == 7);// you need to assign into same predicate.
            System.out.println(divisable.test(i) + " <> " + i);
            forEquality = Predicate.isEqual(10);
            System.out.println(" for equality " + forEquality.test(i));
        }
    }
}
