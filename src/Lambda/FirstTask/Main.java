package Lambda.FirstTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Supplier<Integer> supplier = () -> {
            return (Integer) random.nextInt(10);
        };

        List<Integer> randomList = generateRandomList(10, supplier);
        consumeList(randomList, number -> System.out.print(number + " "));
    }

    private static <T> List<T> generateRandomList(int numberOfObjects, Supplier<T> supplier) {
        List<T> randomList = new ArrayList<>();
        for (int i = 0; i < numberOfObjects; i++) {
            randomList.add(supplier.get());
        }
        return randomList;
    }

    private static <T> void consumeList(List<T> list, Consumer<T> consumer) {
        for (T t : list) {
            consumer.accept(t);
        }
    }
}
