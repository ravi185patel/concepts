package Java11.src.newfeature;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ToArrayMethod {
    public static void main(String[] args) {
        List<String> str = Arrays.asList("A","B","C");
        List<Integer> no = Arrays.asList(1,2,3,4,5);
        List<Character> chars = Arrays.asList('a','b','c');

        Integer[] arrNo= no.toArray(Integer[]::new);
        System.out.println(Arrays.toString(arrNo));

//        arrNo= chars.toArray(Integer[]::new);
//        System.out.println(Arrays.toString(arrNo));

        String strArr[]= str.toArray(String[]::new);
        System.out.println(Arrays.toString(strArr));

        Character chArr[]= chars.toArray(Character[]::new);
        System.out.println(Arrays.toString(chArr));
    }
}
