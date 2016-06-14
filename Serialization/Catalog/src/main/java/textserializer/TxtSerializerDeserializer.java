package textserializer;

import fileworker.FileWorker;
import model.Album;
import model.Artist;
import model.Catalog;
import model.Song;
import validator.Validator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Р on 13.06.2016.
 */
public class TxtSerializerDeserializer {

    public static final String TXT_FILE_NAME = "txtfile.txt";


    private static String getAlbumAsString(Album album) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Album: ").append(album.getAlbumName()).append(" ").append(album.getAlbumGenre()).append("\n");
        for (Song song : album.getAlbumSongList()) {
            stringBuilder.append(song.toString()).append("\n");
        }
        return stringBuilder.toString();
    }

    private static List<String> getArtistAsStringList(Artist artist) {
        List<String> albumStringList = new ArrayList<String>();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Artist: ").append(artist.getAristName()).append("\n");
        albumStringList.add(stringBuilder.toString());
        for (Album album : artist.getAlbumList()) {
            albumStringList.add(getAlbumAsString(album));
        }
        return albumStringList;
    }

    public static List<String> getCatalogAsStringList(Catalog catalog) {
        List<String> artistStringList = new ArrayList<String>();
        artistStringList.add("Catalog:\n");
        for (Artist artist : catalog.getArtisiList()) {
            artistStringList.addAll(getArtistAsStringList(artist));
        }
        return artistStringList;
    }

    public static void serializeCatalog(Catalog catalog, String fileName) {
        FileWorker.writeToFile(fileName, TxtSerializerDeserializer.getCatalogAsStringList(catalog));
    }

    public static Catalog deserializeCatalog(String fileName) {
        ArrayList<String> catalogStringList = FileWorker.readFromFile(fileName);
        if (!catalogStringList.get(0).equals("Catalog:")) {
            throw new RuntimeException(fileName + " invalid or corrupted file");
        } else {
            catalogStringList.remove(0);
            Catalog catalog = new Catalog();
            ArrayList<Artist> artistList = new ArrayList();
            for (String string : catalogStringList) {
                String[] substring = string.split(": ");
                switch (substring[0]) {
                    case "Artist":
                        Artist artist = new Artist(substring[1]);
                        artistList.add(artist);
                        //System.out.println("Artist");
                        break;
                    case "Album":
                        String[] albumParameters = substring[1].split(" ");
                        Album album = new Album(albumParameters[0], albumParameters[1]);
                        artistList.get(artistList.size() - 1).addAlbum(album);
                        //System.out.println("Album");
                        break;
                    case "Song":
                        String[] songParameters = substring[1].split(" ");
                        Song song = new Song(songParameters[0], parseLength(songParameters[1]));
                        List<Album> lastArtistAlbumList = artistList.get(artistList.size() - 1).getAlbumList();
                        lastArtistAlbumList.get(lastArtistAlbumList.size() - 1).addSong(song);
                        //System.out.println("Song");
                        break;
                    default:
                        throw new RuntimeException(fileName + "invalid or corrupted file");
                }
            }
            catalog.setArtistList(artistList);
            if (!Validator.validateCatalog(catalog)) {
                throw new RuntimeException("Invalid file " + fileName);
            } else return catalog;
        }

    }

    private static int parseLength(String string) {
        String[] lengthElements = string.split("\\.");
        int min = Integer.parseInt(lengthElements[0]);
        int sec = Integer.parseInt(lengthElements[1]);
        int length = min * 60 + sec;
        return length;
    }
}
