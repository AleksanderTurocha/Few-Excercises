package ProcessingCollections.FirstTask;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class TextProcessor {
    public static void main(String[] args) {
        try {
            final String fileName = "loremipsum-129.txt";
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            List<String> words = new ArrayList<>();
            String line = null;
            while ((line = reader.readLine()) != null) {
                words.addAll(Arrays.asList(line.split(" ")));
            }
            words = words.stream()
                    .map(x -> x.replaceAll(",", "").replaceAll("\\.", ""))
                    .collect(Collectors.toList());

            long countWords = words.stream()
                    .filter(s -> s.startsWith("s"))
                    //.peek(s -> System.out.println(s + " "))
                    .count();

            System.out.println();

            long fiveLetters = words.stream()
                    .filter(s -> s.length() == 5)
                    //.peek(s -> System.out.println(s + " "))
                            .count();

            System.out.println(words + "\n");
            System.out.println("Words starting from s: " + countWords);
            System.out.println("Words that have 5 letters: " + fiveLetters);

        } catch (FileNotFoundException e) {
            System.out.println("There is no such a file");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
