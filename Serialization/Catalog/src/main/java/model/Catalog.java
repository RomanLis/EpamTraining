package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Р on 12.06.2016.
 */
public class Catalog implements Serializable {

    private List<Artist> artistList;

    public Catalog() {
        this.artistList = new ArrayList();
    }

    public List<Artist> getArtisiList() {
        return this.artistList;
    }

    public void setArtistList(ArrayList<Artist> artistsList) {
        this.artistList = artistsList;
    }

    public void addArtist(Artist artist) {
        this.artistList.add(artist);
    }


}
