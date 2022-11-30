package ProcessingCollections.SecondTask;

import java.util.List;
import java.util.stream.Collectors;

class MusicCollection {
    public static void main(String[] args) {
        List<Song> songs = List.of(
                new Song("Nothing Else Matters", 386, "Metallica", Song.Genre.METAL),
                new Song("No One", 248, "Alicia Keys", Song.Genre.POP),
                new Song("Nothing Else Matters", 386, "Metallica", Song.Genre.METAL),
                new Song("Believer", 216, "Imagine Dragons", Song.Genre.ROCK),
                new Song("Fear of The Dark", 438, "Iron Maiden", Song.Genre.METAL),
                new Song("Enter Sandman", 346, "Metallica", Song.Genre.METAL),
                new Song("The Unforgiven", 348, "Metallica", Song.Genre.METAL),
                new Song("Girl on Fire", 404, "Alicia Keys", Song.Genre.POP)
        );

        System.out.println("Amount of time on a playlist: ");
        System.out.println(getTimeOfKind(songs, Song.Genre.POP));

        System.out.println("Amount of Metallica songs on a playlist: ");
        System.out.println(numberOfArtistSongs(songs, "Metallica"));

        System.out.println("Songs without pop: ");
        System.out.println(songsWithoutGivenGenre(songs, Song.Genre.POP));
    }

    //First task
    private static int getTimeOfKind(List<Song> songs, Song.Genre genre) {
        return songs.stream()
                .filter(song -> song.getGenre().equals(genre))
                .mapToInt(Song::getLength)
                .sum();
    }

    //Second task
    private static long numberOfArtistSongs(List<Song> songs, String artist) {
        return songs.stream()
                .filter(song -> song.getArtist().equals(artist))
                .count();
    }

    //Third task
    private static List<Song> songsWithoutGivenGenre(List<Song> songs, Song.Genre genre) {
        return songs.stream()
                .filter(song -> !song.getGenre().equals(genre))
                .distinct()
                .collect(Collectors.toList());
    }
}
