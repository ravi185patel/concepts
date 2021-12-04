package Java8Demo;

interface DemoI {
    public Integer sum(Integer a);
}

interface DemoAnnoyVsLambda {
    public void m1();
}

public class AnonymousVsLambda {
    int x = 7000;

    public static void main(String[] args) {
        DemoI demo = a -> {
            return a;
        };
        demo.sum(1);

        Runnable r = () -> {
            for (int i = 0; i <= 10; i++)
                System.out.println(" in for loop" + i);
        };
        Thread t = new Thread(r);
        t.start();
        ;
        ;
        ;
        ;
        ;
        ;
        AnonymousVsLambda anonymousVsLambda = new AnonymousVsLambda();
        anonymousVsLambda.m2();

        String str = "123.132.123";
        System.out.println(str.split("\\.")[0]);
        System.out.println(Integer.valueOf("3574.95"));//Double.parseDouble("3574.95"));
    }

    public void m2() {
        int y = 0; // declared as final static variable if used inside lambda expression.
        DemoAnnoyVsLambda demoAnnoyVsLambda = () -> {
            int x = 8000;
//            y=100;
            System.out.println(x);
            System.out.println(this.x);
//            System.out.println(y);
        };
        y = 8;
        System.out.println(y);
        demoAnnoyVsLambda.m1();
    }
}
