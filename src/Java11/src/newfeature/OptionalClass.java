package Java11.src.newfeature;

import java.util.Optional;

public class OptionalClass {
    public static void main(String[] args) {
        String a="hi";
        System.out.println(a);

        Optional optional=Optional.empty();
        System.out.println(optional.isEmpty());

        optional = Optional.of(" ");
        System.out.println(optional.get()+" <> "+ optional.isEmpty());

        optional = Optional.of(" hi ");
        System.out.println(optional.get()+" <> "+ optional.isEmpty());

        optional = Optional.ofNullable("   ");
        System.out.println(optional.get()+" <> "+ optional.isEmpty());

        optional = Optional.ofNullable("kk");
        System.out.println(optional.get()+" <> "+ optional.isEmpty());
    }
}
