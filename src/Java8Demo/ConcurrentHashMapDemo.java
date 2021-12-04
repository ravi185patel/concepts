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
        this.name =new String(name);
    }

    @Override
    public boolean equals(Object object){
        if(object instanceof EmployeeKey){
            if(object == this){
                EmployeeKey employeeKey=(EmployeeKey) object;
                return employeeKey.getName().equals(this.getName());
            }
        }
        return false;
    }
    @Override
    public int hashCode(){
        int prime=31;
        return prime+this.getName().length();
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
        System.out.println(hmap.keySet().iterator().next().getName());
        System.out.println(employeeKey);
        System.out.println(hmap.get(employeeKey));
        System.out.println(1 >>> 16);
        int hash = System.identityHashCode(employeeKey);
        System.out.println(hash);
        System.out.println(hash(employeeKey)+" "+((16-1) & employeeKey.hashCode()));
    }
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
