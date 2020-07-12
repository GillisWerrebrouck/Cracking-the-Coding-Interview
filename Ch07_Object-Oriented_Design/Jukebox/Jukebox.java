import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

/**
 * Object-oriented design of a jukebox.
 * 
 * @author Gillis Werrebrouck
 */

class Song {
    String title;
    int duration; // seconds

    public Song(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }
}

class CD {
    ArrayList<Song> songs = new ArrayList<Song>();
    ArrayList<String> artists = new ArrayList<String>();

    public CD(ArrayList<Song> songs, ArrayList<String> artists) {
        this.songs = songs;
        this.artists = artists;
    }
}

class Playlist {
    Queue<Song> songs = new LinkedList<Song>();

    public Playlist() {}

    public void addSong(Song song) {
        this.songs.add(song);
    }

    public void removeSong(Song song) {
        this.songs.remove(song);
    }

    public void shuffle() {
        // TODO: add implementation
    }
}

public class Jukebox {
    Playlist playlist = new Playlist();
    ArrayList<CD> cdCollection = new ArrayList<CD>();
    CD selectedCD = null;
    Song currentPlayingSong = null;

    public Jukebox(ArrayList<CD> cdCollection) {
        this.cdCollection = cdCollection;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public ArrayList<CD> getCdCollection() {
        return cdCollection;
    }

    public void setCdCollection(ArrayList<CD> cdCollection) {
        this.cdCollection = cdCollection;
    }

    public void selectCD(CD cd) {
        // TODO: add implementation
    }

    public void addSongToPlaylistFromSelectedCD(Song song) {
        // TODO: add implementation
        // select song from selected CD
    }

    public void removeSongFromPlaylist(Song song) {
        // TODO: add implementation
    }

    public void shufflePlaylist() {
        this.playlist.shuffle();
    }

    public void playPlaylist() {
        // TODO: add implementation
    }

    public void pausePlaylist() {
        // TODO: add implementation
    }
    
    public void nextSongFromPlaylist() {
        // TODO: add implementation
    }
    
    public void previousSongFromPlaylist() {
        // TODO: add implementation
    }
}


