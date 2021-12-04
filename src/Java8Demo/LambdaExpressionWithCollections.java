package Java8Demo;

import java.util.*;

class Employee
//        implements  Comparable<Employee>
{
    Integer id;
    String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @Override
//    public int compareTo(Employee o) {
////        if(o.getId() != this.getId()){
////            return o.getName().compareTo(this.getName()) >= 1 ? 1:-1;
////        }
//        return (o.getId() > this.getId() ? -1:(o.getId() < this.getId() ? 1:0));
//    }
}

class ComparatorImp implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getId().compareTo(o2.getId());
    }
}

class ComparatorImpKey implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
    }
}

public class LambdaExpressionWithCollections {
    public static void main(String[] args) {

        /*** for list *****/
        List lst = new ArrayList<>();
        Employee employee = new Employee();
        employee.setId(2);
        employee.setName("ravi");
        lst.add(employee);
        employee = new Employee();
        employee.setId(1);
        employee.setName("patel");
        lst.add(employee);

//        System.out.println(lst);
        System.out.println("print list");
        lst.stream().forEach(emp -> System.out.println(((Employee) emp).getId()));

//        // using comparable interface
//        Collections.sort(lst);
////        System.out.println(lst);
//        System.out.println("comparable(i) list");
//        lst.stream().forEach(emp->System.out.println(((Employee)emp).getId()));

        // using comparator interface;
        Collections.sort(lst, new ComparatorImp());
//        System.out.println(lst);
        System.out.println("comparator(i) list");
        lst.stream().forEach(emp -> System.out.println(((Employee) emp).getId()));

        // using lambda expression
        Collections.sort(lst, (Employee o1, Employee o2) -> -1 * (o1.getId() < o2.getId() ? 1 : o1.getId() > o2.getId() ? -1 : 0));
//        System.out.println(lst);
        System.out.println("lambda expression list");
        lst.stream().forEach(emp -> System.out.println(((Employee) emp).getId()));

        /*** for Set *****/
        System.out.println("Set logic start");
        Set set = new HashSet<>();
        set.add(employee);
        employee = new Employee();
        employee.setId(2);
        employee.setName("ravi");
        set.add(employee);
        // normal set
        set.stream().forEach(emp -> System.out.println(((Employee) emp).getId()));
//        Collections.sort(set);
       /* Set treeSet=new TreeSet();
        treeSet.add(employee);
        employee=new Employee();
        employee.setId(1);
        employee.setName("patel");
        treeSet.add(employee);
        treeSet.stream().forEach(emp->System.out.println(((Employee)emp).getId()));*/

        System.out.println("Comparator with set");
        Set treeSetCompT = new TreeSet(new ComparatorImp());
        treeSetCompT.add(employee);
        employee = new Employee();
        employee.setId(1);
        employee.setName("patel");
        treeSetCompT.add(employee);
        treeSetCompT.stream().forEach(emp -> System.out.println(((Employee) emp).getId()));

        System.out.println("Lambda Expression with set");
        Set treeSetLambda = new TreeSet((o1, o2) -> {
            Employee emp1 = (Employee) o1;
            Employee emp2 = (Employee) o2;
            return -1 * (emp1.getId() < emp2.getId() ? 1 : emp1.getId() > emp2.getId() ? -1 : 0);
        });
        treeSetLambda.add(employee);
        employee = new Employee();
        employee.setId(2);
        employee.setName("ravi");
        treeSetLambda.add(employee);
        treeSetLambda.stream().forEach(emp -> System.out.println(((Employee) emp).getId()));

        System.out.println("hashmap");
        Map hmap = new HashMap();
        hmap.put(employee.getId(), employee);
        employee = new Employee();
        employee.setId(1);
        employee.setName("patel");
        hmap.put(employee.getId(), employee);
        hmap.keySet().stream().forEach(i -> {
            Employee emp = (Employee) hmap.get(i);
            System.out.println(emp.getId() + " <> " + emp.getName());
        });

        System.out.println("treemap");
        Map treeMap = new TreeMap();
        treeMap.put(employee.getId(), employee);
        employee = new Employee();
        employee.setId(2);
        employee.setName("ravi");
        treeMap.put(employee.getId(), employee);
        treeMap.keySet().stream().forEach(i -> {
            Employee emp = (Employee) hmap.get(i);
            System.out.println(emp.getId() + " <> " + emp.getName());
        });

        System.out.println("Comparator with Treemap");
        Map treeMapCom = new TreeMap(new ComparatorImpKey());
        treeMapCom.put(employee.getId(), employee);
        employee = new Employee();
        employee.setId(3);
        employee.setName("patel");
        treeMapCom.put(employee.getId(), employee);
        treeMapCom.keySet().stream().forEach(i -> {
            Employee emp = (Employee) treeMapCom.get(i);
            System.out.println(i);
            System.out.println(emp.getId() + " <> " + emp.getName());
        });

        System.out.println("lambda with Treemap");
        Map treeMapLm = new TreeMap((o1, o2) -> {
            Integer emp1 = (Integer) o1;
            Integer emp2 = (Integer) o2;
            return -1 * (emp1 < emp2 ? 1 : emp1 > emp2 ? -1 : 0);
        });
        treeMapLm.put(employee.getId(), employee);
        employee = new Employee();
        employee.setId(1);
        employee.setName("patel");
        treeMapLm.put(employee.getId(), employee);
        treeMapLm.keySet().stream().forEach(i -> {
            Employee emp = (Employee) treeMapLm.get(i);
            System.out.println(emp.getId() + " <> " + emp.getName());
        });

        Map treeMapKey = new TreeMap(new ComparatorImp());
        treeMapKey.put(employee, employee.getId());


    }
}
