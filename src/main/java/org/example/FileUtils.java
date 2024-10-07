package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileUtils {
    public static ArrayList<File> listFilesForFolder(final File folder) {
        ArrayList<File> files = new ArrayList<>();
        File[] fileList = folder.listFiles();

        if (fileList != null) {
            for (File fileEntry : fileList) {
                if (fileEntry.isDirectory()) {
                    files.addAll(listFilesForFolder(fileEntry));
                } else {
                    files.add(fileEntry);
                }
            }
        }
        return files;
    }

    public static String readFile(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }
}
