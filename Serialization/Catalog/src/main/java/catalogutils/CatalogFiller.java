package catalogutils;

import model.Album;
import model.Artist;
import model.Catalog;
import model.Song;

/**
 * Created by Р on 13.06.2016.
 */
public class CatalogFiller {

    public static void fillCatalog(Catalog catalog) {
        for (int k = 0; k < 2; k++) {
            catalog.addArtist(getNewArtist(k));
        }
    }

    private static Artist getNewArtist(int k) {
        Artist artist = new Artist();
        artist.setArtistName("ArtistName" + k);
        for (int j = 0; j < 2; j++) {
            artist.addAlbum(getNewAlbum(j, k));
        }
        return artist;
    }

    private static Album getNewAlbum(int j, int k) {
        Album album = new Album();
        album.setAlbumGenre("Genre" + k + j);
        album.setAlbumName("Name" + k+ j);
        for (int i = 0; i < 2; i++) {
            album.addSong(getNewSong(i, j, k));
        }
        return album;
    }

    private static Song getNewSong(int i, int j, int k) {
        Song song = new Song();
        song.setSongName("SongName" + k + j + i);
        song.setSongLength(100);
        return song;
    }


}
