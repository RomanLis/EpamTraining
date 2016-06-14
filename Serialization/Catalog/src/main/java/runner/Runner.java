package runner;

import binaryserializer.BinarySerializerDeserializer;
import catalogutils.CatalogFiller;
import catalogutils.CatalogPrinter;
import model.Album;
import model.Artist;
import model.Catalog;
import model.Song;
import textserializer.TxtSerializerDeserializer;
import validator.Validator;

import java.io.Serializable;

/**
 * Created by Р on 12.06.2016.
 */
public class Runner implements Serializable {

    public static final String BINARY_FILE_NAME = "binaryfile.bin";
    public static final String TXT_FILE_NAME = "txtfile.txt";

    public static void run() {
        Catalog catalog = new Catalog();
        CatalogFiller.fillCatalog(catalog);
        System.out.println("************************\nBefore serializing:");
        CatalogPrinter.printCatalog(catalog);

        TxtSerializerDeserializer.serializeCatalog(catalog, TXT_FILE_NAME);
        Catalog deserializedCatalog = TxtSerializerDeserializer.deserializeCatalog(TXT_FILE_NAME);
        System.out.println("************************\nAfter txt deserializing:");
        CatalogPrinter.printCatalog(deserializedCatalog);

        BinarySerializerDeserializer.serializeCatalog(catalog, BINARY_FILE_NAME);
        deserializedCatalog = BinarySerializerDeserializer.deserializeCatalog(BINARY_FILE_NAME);
        System.out.println("************************\nAfter binary deserializing:");
        CatalogPrinter.printCatalog(deserializedCatalog);

        Artist artist = new Artist("Artist");
        Album album = new Album("Album","Genre");
        Song song = new Song();
        album.addSong(song);
        artist.addAlbum(album);
        catalog.addArtist(artist);
        System.out.println("************************\nInvalid catalog before validation:");
        CatalogPrinter.printCatalog(catalog);

        Validator.validateCatalog(catalog);
        System.out.println("************************\nAfter validation:");
        CatalogPrinter.printCatalog(catalog);
    }


}
