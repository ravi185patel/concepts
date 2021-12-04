package Java8Demo;

import java.util.function.Supplier;

public class SupplierDemo {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> {
            String s1[] = {"rav", "pat", "her"};
            return s1[0];
        };
        System.out.println(supplier.get());
        Supplier<String> s = () -> {
            String symbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZ#$@";
            Supplier<Integer> d = () -> {
                return (int) (Math.random() * 10);
            };
            Supplier<Character> c = () -> {
                return symbols.charAt((int) (Math.random() * 29));
            };
            String pwd = "";
            for (int i = 0; i < 8; i++) {
                if (i % 2 == 0) pwd = pwd + d.get();
                else pwd = pwd + c.get();
            }
            return pwd;
        };
        System.out.println(s.get());

    }
}
