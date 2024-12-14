package parsing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ParseInput {
    public static String inputToString(String filename) { //might have to change argument to a filePath
        try {
            return Files.readString(Path.of(filename));
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            return "";
        }
    }
}
