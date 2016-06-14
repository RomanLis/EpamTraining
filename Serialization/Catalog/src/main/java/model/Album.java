package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Р on 12.06.2016.
 */
public class Album implements Serializable {
    private List<Song> songList;
    private String albumName;
    private String albumGenre;

    public Album() {
        this.songList = new ArrayList<Song>();
    }

    public Album(String newAlbumName, String newAlbumGenre) {
        this.songList = new ArrayList<Song>();
        this.albumGenre = newAlbumGenre;
        this.albumName = newAlbumName;
    }

    public void addSong(Song song) {
        this.songList.add(song);
    }

    public List<Song> getAlbumSongList() {
        return this.songList;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String newName) {
        this.albumName = newName;
    }

    public String getAlbumGenre() {
        return albumGenre;
    }

    public void setAlbumGenre(String newGenre) {
        this.albumGenre = newGenre;
    }
}
