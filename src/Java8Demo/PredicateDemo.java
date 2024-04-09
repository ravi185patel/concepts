package Java8Demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
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

            HashMap<Course,String> map=new HashMap<>();
            Course course=new Course("ravi");
            map.put(course,"ravi");
            System.out.println(map.get(course));
            course.setName("ravi1");
            System.out.println(map.get(course));

            /*
             Very imp point
             -> equals method first check reference if both reference are same then they are consider equal no matter their contents are mismatched or matched.
             -> For the same reason it is strictly follow to make object immutable,so it will not create any issue
                like content of key got changed which is stored in MAP.
             */
            HashMap<EmployeeKey,String> map1=new HashMap<>();
            EmployeeKey employeeKey=new EmployeeKey();
            employeeKey.setName("ravi");
            map1.put(employeeKey,"1");
            map1.put(employeeKey,"2");
            map1.put(employeeKey,"3");
            map1.put(employeeKey,"4");

            System.out.println(map1.get(employeeKey));
//        employeeKey=new EmployeeKey("ravid");
            employeeKey.setName("rdpk");
            System.out.println(map1.get(employeeKey));
//            System.out.println(employeeKey);
//            System.out.println(hmap.get(employeeKey));
//            System.out.println(1 >>> 16);
//            int hash = System.identityHashCode(employeeKey);
//            System.out.println(hash);
//            System.out.println(hash(employeeKey)+" "+((16-1) & employeeKey.hashCode()));

        }
        Set<Integer> set=new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(15);
        set.add(16);
        set.add(100);
        System.out.println(set);


        set.add(1001);
        set.add(1011);
        set.add(1100);
        set.add(1101);
        set.add(1100);
//        set.add(1110);
        set.add(1000);

        System.out.println(set);
        set.add(10000);
        set.add(-10000);
        set.add(20000);
        System.out.println(set);



        set.add(100000000);
        set.add(110100000);
        set.add(110000000);
        System.out.println(set);

    }
}
