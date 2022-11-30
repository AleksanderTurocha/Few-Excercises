package References.FirstTask;

import java.util.*;

public class RandomPeople {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Mark", "Jason", "Rob", "Yun");

        //Comparator and anonymus class:
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });

        //Lambda:
        Collections.sort(names, (String a, String b) -> a.compareToIgnoreCase(b));

        //Reference:
        Collections.sort(names, String::compareToIgnoreCase);

        names.forEach(System.out::println);
    }
}
