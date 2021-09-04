public class Album {

    // data
    private int numsongs;
    private int length;
    private String title;
    private String artist;
    private Song[] tracks;
    private int counter;

    // operations
    public Album(String title, int numsongs) {
        this.numsongs = numsongs;
        this.title = title;
        this.artist = "carrie underwood";
        this.tracks = new Song[numsongs];
        this.counter = 0;
    }

    public boolean addSong2(Song toAdd) {
        if (counter >= tracks.length) {
            return false;
        }
        tracks[counter] = toAdd;
        counter++;
        return true;
    }

    public boolean addSong(Song toAdd) {
        for (int i = 0; i < tracks.length; i++) {
            if (tracks[i] == null) {
                tracks[i] = toAdd;
                return true;
            }
        }
        return false;
    }

    public boolean addSong(String title, String artist, int length) {
        Song toAdd = new Song(title, artist, length);
        return addSong(toAdd);
    }

    public boolean search(Song s) {
        for (Song track : tracks) {
            if (track.equals(s)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return title + " - " + artist;
    }
}
