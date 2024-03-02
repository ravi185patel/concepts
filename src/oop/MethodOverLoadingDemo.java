package oop;

class MethodOverLoading{

    public void m1(String str){
        System.out.println(" String :- "+str);
    }

    public void m1(StringBuffer sb){
        System.out.println(" StringBuffer :- "+sb.toString());
    }

    public void m1(StringBuilder sb){
        System.out.println(" StringBuilder :- "+sb.toString());
    }

    public void m2(int i,int j){
        System.out.println("ony int");
    }

    public void m2(long i,long j){
        System.out.println("ony long");
    }
}


public class MethodOverLoadingDemo {
    public static void main(String[] args) {
        MethodOverLoading methodOverriding=new MethodOverLoading();
        methodOverriding.m1("ravi");
        methodOverriding.m1(new StringBuffer("ravi"));
        methodOverriding.m1(new StringBuilder("ravi"));

        methodOverriding.m2(1,1);
        methodOverriding.m2(1l,1l);
        methodOverriding.m2(1l,1);
        methodOverriding.m2(1,1l);

//        methodOverriding.m1(null);
//        methodOverriding.m1(new Object());
    }
}
