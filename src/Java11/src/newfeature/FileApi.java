package Java11.src.newfeature;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileApi {
    public static void main(String[] args) {
        String path = "C:\\Users\\ravi patel\\backend\\JavaLearn\\Java11\\src\\newfeature\\data.txt";
        try{
            Files.writeString(Path.of(path)," ravi d patel", StandardOpenOption.APPEND);
            String data = Files.readString(Path.of(path));
            System.out.println(data);
            Files.writeString(Path.of(path)," ravi d patel", StandardOpenOption.CREATE_NEW);
            data = Files.readString(Path.of(path));
            System.out.println(data);
        }catch (Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
