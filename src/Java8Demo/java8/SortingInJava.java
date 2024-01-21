package Java8Demo.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class SortingInJava {
    public static void sortStrings() {
        String[] names = {"One", "Two", "Three", "Four", "Five", "Six"};
        Stream.of(names).sorted(String::compareToIgnoreCase).forEach(System.out::println);
    }
    public static void sortStringsBasedOnLength() {
        String[] names = {"One", "Two", "Three", "Four", "Five", "Six", "Seven"};
        Stream.of(names)
                .sorted((o1, o2) -> Integer.compare(o1.length(), o2.length()))
                .forEach(System.out::println);
    }
// Parallel Sort
    public static void sortEmployees(){
        String[] names = {"One", "Two", "Three", "Four", "Five", "Six", "Seven"};
        List<String> employees=Arrays.asList(names);
        employees.parallelStream()
                .sorted((o1, o2) -> o1.compareTo(o2))
                .forEach(employee -> System.out.println("employee = " + employee));
    }

    public static void sortEmployees2() {
        String[] names = {"One", "Two", "Three", "Four", "Five", "Six", "Seven"};
        List<String> employees=Arrays.asList(names);
        employees.parallelStream()
                .sorted(Comparator.comparing(String::length))
                .forEach(employee -> System.out.println("employee = " + employee));
    }

//    public void multiple_sort(List<Employee> employees) {
//        Comparator<Employee> byFirstName = (e1, e2) -> e1.getFirstName().compareTo(e2.getFirstName());
//        Comparator<Employee> byLastName = (e1, e2) -> e1.getLastName().compareTo(e2.getLastName());
//        employees.stream()
//                .sorted(byFirstName.thenComparing(byLastName))
//                .forEach(e -> System.out.println(e));
//    }

    public static void main(String[] args) {
        sortStrings();
        sortStringsBasedOnLength();
        sortEmployees();
        sortEmployees2();
    }

}
