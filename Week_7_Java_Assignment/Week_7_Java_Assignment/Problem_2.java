import java.util.Arrays;

/**
 * Problem 2 - The Playlist
 * getSongs() always returns a brand-new copy of the internal array, so
 * editing the returned array can never change the playlist's real contents.
 */
class Playlist {
    private String[] songs;
    private int count;

    public Playlist(int maxSize) {
        songs = new String[maxSize];
        count = 0;
    }

    public void addSong(String title) {
        songs[count] = title;
        count++;
    }

    public String[] getSongs() {
        String[] copy = new String[count];
        for (int i = 0; i < count; i++) {
            copy[i] = songs[i];
        }
        return copy;
    }

    public int getSongCount() {
        return count;
    }
}

public class Problem_2 {
    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        System.out.println("Playlist: " + Arrays.toString(copy));

        copy[0] = "Hacked";
        System.out.println("After editing the returned copy, copy[0] = " + copy[0]);
        System.out.println("But p.getSongs()[0] is still: " + p.getSongs()[0]);
        System.out.println("Song count: " + p.getSongCount());
    }
}
