package binaryserializer;

import model.Catalog;

import java.io.*;

/**
 * Created by Р on 14.06.2016.
 */
public class BinarySerializerDeserializer {


    public static void serializeCatalog(Catalog catalog, String fileName) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(catalog);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException("IOException while working with " + fileName);
        }
    }

    public static Catalog deserializeCatalog(String fileName) {
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Catalog catalog = (Catalog) objectInputStream.readObject();
            return catalog;
        } catch (IOException e) {
            throw new RuntimeException("IOException while working with " + fileName);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Class \"Catalog\" not found");
        }
    }
}
