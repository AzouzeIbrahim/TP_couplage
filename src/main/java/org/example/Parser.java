package org.example;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Parser {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the path to the source code folder (e.g., C:\\path\\to\\src):");
        String projectSourcePath = scanner.nextLine().trim();

        // Validation du dossier
        File folder = new File(projectSourcePath);
        if (!folder.exists() || !folder.isDirectory()) {
            System.err.println("The provided path does not exist or is not a directory.");
            return;
        }

        // Liste des fichiers Java
        ArrayList<File> javaFiles = FileUtils.listFilesForFolder(folder);

        ProjectAnalyzer analyzer = new ProjectAnalyzer();

        for (File file : javaFiles) {
            if (file.getName().endsWith(".java")) {
                String content = FileUtils.readFile(file.getAbsolutePath());
                analyzer.addLinesOfCode(content.split("\n").length);
                analyzer.parseJavaFile(content);
            }
        }

        analyzer.printMetrics();

        System.out.println("Enter a threshold for the number of methods (X):");
        int X = scanner.nextInt();
        analyzer.printClassesWithMethodsGreaterThan(X);
    }
}
