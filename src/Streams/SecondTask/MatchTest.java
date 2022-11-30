package Streams.SecondTask;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatchTest {
    public static void main(String[] args) {
        //1
        Stream<MatchResult> results = createStream();
        System.out.println("All results sorted:");
        results = createStream();
        printResultsSorted(results);

        //2
        results = createStream();
        System.out.println("Input country name to filter:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(returnCountryList(results, input));

        //3
        results = createStream();
        System.out.println("Number of teams: " + countUniqueTeams(results));

        //4
        results = createStream();
        System.out.println("All goals: " + countGoals(results));
    }

    private static Stream<MatchResult> createStream() {
        return Stream.of(
                new MatchResult("Polska", "Irlandia", 2, 0),
                new MatchResult("Brazylia", "Francja", 0, 3),
                new MatchResult("Włochy", "Polska", 2, 1),
                new MatchResult("Brazylia", "Argentyna", 2, 2),
                new MatchResult("Anglia", "Niemcy", 1, 2),
                new MatchResult("Anglia", "Francja", 3, 0),
                new MatchResult("Polska", "Portugalia", 1, 0),
                new MatchResult("Brazylia", "Niemcy", 3, 3)
        );
    }

    private static void printResultsSorted(Stream<MatchResult> stream) {
        stream
                .sorted(Comparator.comparing(MatchResult::getGoalDifference).reversed())
                .forEach(System.out::println);
    }

    private static List<MatchResult> returnCountryList(Stream<MatchResult> results, String country) {
         return results.filter(result -> result.getGuestName().equals(country) || result.getHostName().equals(country))
                 .collect(Collectors.toList());
    }

    private static long countUniqueTeams(Stream<MatchResult> results) {
        return results
                .map(MatchResult::getTeamNames)
                .flatMap(Arrays::stream)
                .distinct()
                .count();
    }

    private static int countGoals(Stream<MatchResult> results) {
        return results
                .mapToInt(MatchResult::getGoals)
                .sum();
    }
}
