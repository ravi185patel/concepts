package Java8Demo;

import java.util.Arrays;

public class StringDemo {
    public static void main(String[] args) {
        String s="";
        String sp[]=s.split("[ !,?._'@]+");
        System.out.println(sp.length);
        for(String i:sp){
            System.out.println(i);
        }
    }
}

