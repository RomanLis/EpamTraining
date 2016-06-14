package catalogutils;

import model.Catalog;
import textserializer.TxtSerializerDeserializer;

import java.util.List;

/**
 * Created by Р on 14.06.2016.
 */
public class CatalogPrinter {
    public static void printCatalog(Catalog catalog) {
        List<String> stringList = TxtSerializerDeserializer.getCatalogAsStringList(catalog);
        for (String string : stringList) {
            System.out.println(string);
        }
    }
}
