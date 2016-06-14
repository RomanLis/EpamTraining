package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Р on 12.06.2016.
 */
public class Artist implements Serializable {
    private String artistName;
    private List<Album> albumList;

    public Artist() {
        this.artistName = "defaultArtist";
        this.albumList = new ArrayList<Album>();
    }

    public Artist(String newName) {
        this.artistName = newName;
        this.albumList = new ArrayList<Album>();
    }

    public void setArtistName(String newName) {
        this.artistName = newName;
    }

    public String getAristName() {
        return artistName;

    }

    public List<Album> getAlbumList() {
        return this.albumList;
    }

    public void addAlbum(Album album) {
        albumList.add(album);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Artist: ").append(artistName).append("\n");
        return (stringBuilder.toString());
    }

    public List<String> getAlbumListAsStringList() {
        List<String> stringAlbumList = new ArrayList();
        for (Album album : albumList) {
            stringAlbumList.add(album.toString());
        }
        return stringAlbumList;
    }
}
