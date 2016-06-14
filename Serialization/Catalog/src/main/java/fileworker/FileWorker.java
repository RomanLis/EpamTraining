package fileworker;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Р on 13.06.2016.
 */
public class FileWorker {

    public static void writeToFile(String filename, List<String> catalogList) {
        try (FileWriter writer = new FileWriter(filename, false)) {
            for (String string : catalogList) {
                writer.write(string);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<String> readFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader((filename)))) {
            String readLine;
            ArrayList<String> stringList = new ArrayList();
            while ((readLine = reader.readLine()) != null) {
                stringList.add(readLine);
            }
            return stringList;
        } catch (FileNotFoundException e) {
            System.out.println("File " + filename + " not found");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}