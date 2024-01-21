package Java11.src.newfeature;

interface Sum1{
    public int sum(int a,int b);
}

interface Sum{
    public int sum(int a,int b);
    public int sum(String a, String b);
}

class ChildSum implements Sum{

    @Override
    public int sum(int a, int b) {
        return a+b;
    }

    @Override
    public int sum(String a, String b) {
        return a.length()+b.length();
    }
}
public class LocalVariable {
    public static void main(String[] args) {
        var x=1;
        var y=1;
//        Sum sum =(int p1,int p2) -> p1*p2;
//        Sum sum1 =(String p1,String p2) -> p1.length()*p2.length();
//        System.out.println(sum.sum(1,2));
//        System.out.println(sum.sum(1.0d,2));

        // when overloading method inherited and access vai class there is no issue with call both
        //below methods.
        Sum sum=new ChildSum();
        System.out.println(sum.sum(1,2));
        System.out.println(sum.sum("ravi","hi"));

        // call using lambda expression.
        // there is a rule of lambda expression
        // you can apply or use lambda expression only for the functional interface
        // and function interface has only one abstract method in its interface.
        Sum1 sum1 =(p1,p2) -> p1*p2;
//        Sum sum1 =(String p1,String p2) -> p1.length()*p2.length();
        System.out.println(sum1.sum(1,2));
//        System.out.println(sum.sum(1.0d,2));



    }
}
