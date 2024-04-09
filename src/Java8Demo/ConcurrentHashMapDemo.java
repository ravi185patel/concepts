package Java8Demo;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

class EmployeeKey{
    private String name;

//    public EmployeeKey(String name){
//        this.name=name;
//    }
    public String getName() {
        return name;
    }
//
    public void setName(String name) {
        this.name =name;
    }

    @Override
    public boolean equals(Object object){

        if(this == object) return true;
        if(object == null || getClass() != object.getClass()) return false; // handel null value
        System.out.println("in equals "+name+" : "+((EmployeeKey) object).name);
        return name.equals(((EmployeeKey) object).name);
    }
    @Override
    public int hashCode(){
        if(this.getName() != null){
            int prime=31;
            return prime+this.getName().length();
        }
        return 1;
    }
}
public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
//        ConcurrentHashMap<String,String> concurrentHashMap=new ConcurrentHashMap<>();
//        concurrentHashMap.put("ravi","patel");

        HashMap<EmployeeKey,Integer> hmap=new HashMap<>();
        EmployeeKey employeeKey=new EmployeeKey();
        employeeKey.setName("ravi");
        hmap.put(employeeKey,1);

        System.out.println(employeeKey);
        System.out.println(hmap.get(employeeKey));
//        employeeKey=new EmployeeKey("ravid");

        employeeKey.setName("rdpk");
        hmap.put(employeeKey,10);
        System.out.println(hmap);
//        System.out.println(hmap.keySet().iterator().next().getName());
//        System.out.println(employeeKey);
        System.out.println(hmap.get(employeeKey));
//        System.out.println(1 >>> 16);
//        int hash = System.identityHashCode(employeeKey);
//        System.out.println(hash);
//        System.out.println(hash(employeeKey)+" "+((16-1) & employeeKey.hashCode()));

//        EmployeeKey employeeKey1=new EmployeeKey();
//        employeeKey.setName(null); // raise NullPointerException because we have not checked null in equals method
//        hmap.put(employeeKey1,1);

    }
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
