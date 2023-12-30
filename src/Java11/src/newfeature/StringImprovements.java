package Java11.src.newfeature;

import java.util.Arrays;

public class StringImprovements {
    public static void main(String[] args) {
        String a=" ";
        // isBlank()
        System.out.println(a.isBlank()); // will return false if String contains space or character.

        // isEmpty()
        System.out.println(a.isEmpty()); // total empty or say string has or contains no character and not even space.
        // what is difference between isBlank and isEmpty ?
        //

        // lines()
        a="ravi d patel\n aryanrdp \n ravidpatel\n"; // convert into array based on new lines
        a.lines().forEach(System.out::println);
        // split also will work in same manner.

        //split() // already in java 7
        String arr[]=a.split("\n");
        System.out.println(Arrays.toString(arr));

        // Strip(); Strip
        a="           ravi  patel             ";
        System.out.println("< >"+a+"< >");
        System.out.println("< >"+a.strip()+"< >");
        System.out.println("< >"+a.stripLeading()+"< >");
        System.out.println("< >"+a.stripTrailing()+"< >");

        System.out.println("< >"+a.trim()+"< >");

//        difference between trim and strip;
        /*
            strip() is "Unicode-aware" evolution of trim().
            Meaning trim() removes only characters <= U+0020 (space);
            strip() removes all Unicode whitespace characters (but not all control characters, such as \0)
         */

        Character c = '\u2000';
        String s = c + "abc" + c;

        System.out.println("String with \\u");
        System.out.println(Character.isWhitespace(c));
        System.out.println(s+" <> "+s.trim());
        System.out.println("abc" +"<>"+ s.strip());

        s = "\t abc \n";

        System.out.println("String with \\t and \\n");
        System.out.println("abc" +"<>"+ s.trim());
        System.out.println("abc" +"<>"+ s.strip());

        // repeat()
        String re="ravi";
        System.out.println(re.repeat(6));


    }
}
