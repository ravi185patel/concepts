package designpattern.gofdesignpattern.creationalds.singleton;

import java.io.Serializable;

enum DatabaseEnum {

    INSTANCE;

    public static void getDatabase() {
        // do something
    }
}

final class Database  implements Serializable {

    // The field must be declared volatile so that double check lock would work correctly.
    // We have declared the obj volatile which ensures that multiple threads offer the obj variable correctly
    // when it is being initialized to the Singleton instance.
    // This method drastically reduces the overhead of calling the synchronized method every time.

    // Voltile :  used to mark a Java variable as “being stored in main memory”.
    // Every thread that accesses a volatile variable will read it from main memory, and not from the CPU cache.
    // This way, all threads see the same value for the volatile variable.
    private static volatile Database database;

    private Database(){
    }


    // The approach taken here is called double-checked locking (DCL). It
    // exists to prevent race condition between multiple threads that may
    // attempt to get singleton instance at the same time, creating separate
    // instances as a result.
    //
    // It may seem that having the `Database` variable here is completely
    // pointless. There is, however, a very important caveat when
    // implementing double-checked locking in Java, which is solved by
    // introducing this local variable.
    //
    // You can read more info DCL issues in Java here:
    // https://refactoring.guru/java-dcl-issue

    public static Database getDatabase(){ // two way looking
        if(database == null){
            synchronized (Database.class){
                if(database == null){
                    database = new Database();
                }
            }
        }
        return database;
    }



}
public class SingletonDemo {
}
