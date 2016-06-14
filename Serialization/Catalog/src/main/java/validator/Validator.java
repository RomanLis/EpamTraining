package validator;

import model.Album;
import model.Artist;
import model.Catalog;
import model.Song;

import java.util.List;

/**
 * Created by Р on 14.06.2016.
 */
public class Validator {
    private static boolean validateSong(Song song) {
        if (song.getSongName() == null || song.getSongLength() == 0) {
            return false;
        } else return true;
    }

    private static boolean validateAlbum(List<Song> songs) {
        for (int i = songs.size() - 1; i >= 0; i--) {
            if (songs.get(i) == null ||!validateSong(songs.get(i))) {
                songs.remove(i);
            }
        }
        if (songs.size() == 0) {
            return false;
        } else return true;
    }

    private static boolean validateArtist(List<Album> albums) {
        for (int i = albums.size() - 1; i >= 0; i--) {
            if (albums.get(i) == null || !validateAlbum(albums.get(i).getAlbumSongList())) {
                albums.remove(i);
            }
        }
        if (albums.size() == 0) {
            return false;
        } else return true;
    }

    public static boolean validateCatalog(Catalog catalog) {
        List<Artist> artists = catalog.getArtisiList();
        for (int i = artists.size() - 1; i >= 0; i--) {
            if (artists.get(i) == null || !validateArtist(artists.get(i).getAlbumList())) {
                artists.remove(i);
            }
        }
        if (artists.size() == 0) {
            return false;
        } else return true;
    }
}
