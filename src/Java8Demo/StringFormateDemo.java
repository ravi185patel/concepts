package Java8Demo;

import java.util.Scanner;
import java.util.stream.IntStream;

public class StringFormateDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("================================");
        /*for(int k=0;k<3;k++)
        {
            String s1=sc.next();
            int x=sc.nextInt();
            String res="";
            for(int i=0;i<15-s1.length();i++){
                res+=" ";
            }
            System.out.println(res.length());
            s1=s1+res;
            res=x+"";
            System.out.println(res);
            if(x==0) res="000";
            else if(res.length() <=2){
                for(int i=0;i<3-res.length();i++)
                    res="0"+res;
            }
            System.out.println(s1+""+res);
        }*/
        System.out.println("================================");

        int range = sc.nextInt();
        IntStream.range(0, 11).forEach(i -> System.out.println(range + " x " + i + " = " + (range * i)));
    }
}
