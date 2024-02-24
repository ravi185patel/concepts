package interview;
/*

 */

import java.time.LocalTime;
import java.util.*;

final class Employee{
    private final String name;
    private final Integer id;
    private final List<String> certification;

    public Employee(String name,Integer id,List<String> certification){
        this.name= name;
        this.id = id;
        this.certification=new ArrayList<>(certification); //
    }

    public String getName(){
        return this.name;
    }

    public Integer getId(){
        return this.id;
    }

    public List<String> getCertification(){
        List<String> newCertification = new ArrayList<>(certification);
        return newCertification;
    }
    /*
     1] null -> employee
     2] xyz -> this.getName()
     3] xyz -> this.getName()
     */

    @Override
    public boolean equals(Object o) {
        System.out.println(this.toString()+" eq "+o.toString());
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return name.equals(employee.name);
    }

    @Override
    public int hashCode() {
        return 1;//Objects.hash(name);
    }

    //    public boolean equals(Object o){
//        if(o instanceof Employee){
//            Employee employee = (Employee) o;
//            if(employee.getName() != null && this.getName() != null){
//                return employee.getName().equals(this.getName());
//            }
//        }
//        return false;
//    }
//
//    public int hashCode(){
//        if(this.getName() == null){
//            return 1;
//        }
//        int length = this.getName().length();
//        return 13*length;
//    }


    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", certification=" + certification +
                '}';
    }
}

/*
create cash which store <Employee,String> entry with time.
Entry got expired after each 10 second based on threshold + entry time.
 */

class CustomMap{
//    HashMap<Employee, Map<String, LocalTime>> hmap;
//    HashMap<LocalTime,HashMap<Employee,String>> hmap;
    HashMap<Employee,LocalTime> employeeLocalTimeHashMap;
    HashMap<Employee,String> employeeStringHashMap;
    int timeThreshold;
    LocalTime localTime;

    public CustomMap(){
        timeThreshold=10;
        localTime = LocalTime.now();
        employeeLocalTimeHashMap = new HashMap<>();
        employeeStringHashMap = new HashMap<>();
    }

    public CustomMap(int timeThreshold){
        this.timeThreshold = timeThreshold;
        employeeLocalTimeHashMap = new HashMap<>();
        employeeStringHashMap = new HashMap<>();
    }


    public String put(Employee key,String value){
        employeeLocalTimeHashMap.put(key,LocalTime.now());
        employeeStringHashMap.put(key,value);
        return null;
    }


    /* call for every 10 to 1hr time interval. */
    public void refreshMap(){
        for(Employee key:employeeLocalTimeHashMap.keySet()){
            if(employeeLocalTimeHashMap.get(key).plusSeconds(timeThreshold).isAfter(LocalTime.now())){
                employeeLocalTimeHashMap.remove(key);
                employeeStringHashMap.remove(key);
            }
        }
    }

    public String get(Employee key){
        if(employeeLocalTimeHashMap.get(key).plusSeconds(timeThreshold).isAfter(LocalTime.now())){
            return null;
        }
        return employeeStringHashMap.get(key);
    }

}

/*
 1,2,3,4
 11, -> th-11 = 1
 12
 */

public class InterviewInternalProject {
    public static void main(String[] args) {
        Employee employee= new Employee(null,1,Arrays.asList("1"));
        HashMap<Employee,String> hmap = new HashMap<>();
        hmap.put(employee,"ravi");

        Employee employee1= new Employee("ravi",1,Arrays.asList("1"));
        hmap.put(employee1,"ravi1");

        Employee employee2= new Employee("ravid",1,Arrays.asList("1"));
        hmap.put(employee2,"ravi1");

        System.out.println(hmap);
    }
}
