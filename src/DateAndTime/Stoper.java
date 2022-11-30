package DateAndTime;

import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

public class Stoper {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        String pressedKey;
        do {
            System.out.println("Press enter to start the program: ");
            pressedKey = userInput.nextLine();
        } while (!pressedKey.equals(""));
        Instant startTime = Instant.now();
        do {
            System.out.println("Press enter to end the program: ");
            pressedKey = userInput.nextLine();
        } while (!pressedKey.equals(""));
        Instant finishTime = Instant.now();

        Duration measuredTime = Duration.between(startTime, finishTime);
        System.out.println("Measured time: " + measuredTime.getNano());
    }
}
