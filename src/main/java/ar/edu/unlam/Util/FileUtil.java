package ar.edu.unlam.Util;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class FileUtil {

    public static List<List<String>> readFolder(String folderPath) {
        List<List<String>> resultList = new ArrayList<>();
        try {
            File file = new File(folderPath);
            if (!file.isDirectory()) {
                throw new InvalidPathException(folderPath, "La ruta no es un directorio...");
            }

            for(File itemFile : file.listFiles()) {
                List<String> lines = Collections.emptyList();

                try {
                    lines = Files.readAllLines(Paths.get(itemFile.getAbsolutePath()), StandardCharsets.UTF_8);
                }
                catch (IOException e) {
                    // do something
                    e.printStackTrace();
                }
                resultList.add(lines);
            }
            return resultList;
        } catch (InvalidPathException | NullPointerException ex) {
            return resultList;
        }
    }
    public static List<String> readFileInList(String fileName) {
        List<String> lines = Collections.emptyList();
        try {
            lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        }
        catch (IOException e) {
            // do something
            e.printStackTrace();
        }
        return lines;
    }

    public static String readFile(String fileName) {
        String text = "";
        try {
            text = Files.readString(Paths.get(fileName), StandardCharsets.UTF_8);
        }
        catch (IOException e) {
            // do something
            e.printStackTrace();
        }
        return text;
    }

    public static boolean isValidPath(String path) {
        try {
            File file = new File(path);
            if (!file.isDirectory())
                file = file.getParentFile();
            if (file.exists()){
                return true;
            }
        } catch (InvalidPathException | NullPointerException ex) {
            return false;
        }
        return true;
    }

}
