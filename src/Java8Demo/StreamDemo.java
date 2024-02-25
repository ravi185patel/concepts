package Java8Demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.Map;

class Book {
    private String title;
    private String author;
    
    private String year;

    private String city;

    public Book(String title, String author,String year,String city) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.city = city;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year='" + year + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
public class StreamDemo {
    public static void main(String[] args) {
        ArrayList<Integer> l1 = new ArrayList<Integer>();
        l1.add(0);        l1.add(15);        l1.add(10);        l1.add(5);        l1.add(30);        l1.add(25);        l1.add(20);
        System.out.println(l1);
        //change data and store in collection.
        List<Integer> l2 = l1.stream().map(i -> i + 10).collect(Collectors.toList());
        System.out.println(l2);
        // filter data from collections.
        List<Integer> l3 = l1.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
        System.out.println(l3);
        // count data which statisfied condition in collections.
        Long count = l1.stream().filter(i -> i % 10 == 0).count();// count intermediate op // filter terminal
        System.out.println(count);
        // Sorting in list
        List<Integer> l4 = l1.stream().sorted().collect(Collectors.toList());
        System.out.println(l4);

        //Sorting using comparator;
        List<Integer> l5 = l1.stream().sorted((s1, s2) -> -s1.compareTo(s2)).collect(Collectors.toList());
        System.out.println(l5);
        Integer max = l1.stream().max((s1, s2) -> s1.compareTo(s2)).get();
        Integer min = l1.stream().min((s1, s2) -> s1.compareTo(s2)).get();
        System.out.println(max + "<>" + min);
        System.out.println("method reference");
        l1.stream().forEach(System.out::print);
        System.out.println("\nlambda expression");
        l1.stream().forEach(i -> System.out.print(i));
        System.out.println();
        // copy elements from stream into specified array.
        Integer[] arr = l1.stream().toArray(Integer[]::new); //terminal opn
        for (Integer i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        Stream s = Stream.of(1, 2, 3, 4, 5, 6, 7, 8);
        s.forEach(System.out::print); // intermediate
        System.out.println(); 
        s = Stream.of(arr); 
        s.forEach(System.out::print);

        List<Integer> lstInt=IntStream.range(5,25).map(i->i*i).limit(5).boxed().collect(Collectors.toList());
        System.out.println("\n"+lstInt);

        lstInt.removeIf(elem->( elem < 36));
        System.out.println(lstInt);
        // Queue queue=new PrioriyQueue<>();

        /* convert stream into map*/ 
        Map<Integer,Integer> mapc=lstInt.stream().collect(Collectors.toMap(i->i, i->i*i));
        System.out.println(mapc);


        // grouping by

        List<Book> books = new ArrayList<>();

        books.add(new Book("Java", "James Gosling","2000","Mumbai"));
        books.add(new Book("C++", "Bjourn Stroustup","2000","Mumbai"));
        books.add(new Book("C", "Denish Ritche","2000","Surat"));
        books.add(new Book("Database", "C J Date","2001","Surat"));
        books.add(new Book("Java", "James Gosling","2000","Valsad"));
        books.add(new Book("C", "Yashavant Kanetkar","2001","Valsad"));

        Map<String, List<Book>> bookMap = books.stream().collect(Collectors.groupingBy(Book::getTitle));

        bookMap.forEach((k, v) -> System.out.println(k + " => " + v));

        bookMap = books.stream().collect(Collectors.groupingBy(Book::getYear));

        bookMap.forEach((k, v) -> System.out.println(k + " => " + v));

        List<Book> lst= books.stream().filter(book -> book.getYear().equalsIgnoreCase("2000")).collect(Collectors.toList());

        System.out.println(lst.toString());

        Map<String, Map<String, Long>> bookMapS = books.stream().collect(Collectors.groupingBy(Book::getYear,Collectors.groupingBy(Book::getTitle,Collectors.counting())));
        System.out.println(bookMapS.toString());


        Map<String,Map<String,List<String>>> bookMap1 = books
                .stream()
                .collect(
                        Collectors.groupingBy(Book::getCity
                                ,Collectors.groupingBy(Book::getAuthor
                                        ,Collectors.mapping(Book::getTitle,Collectors.toList()))));
        System.out.println(bookMap1);


        // partition by
        Map<Boolean,List<String>> bookMap2 = books
                .stream()
                .collect(Collectors.partitioningBy(book->book.getCity().equalsIgnoreCase("mumbai"),Collectors.mapping(book -> book.getTitle(),Collectors.toList()))); //
        System.out.println(bookMap2);

    }
}
