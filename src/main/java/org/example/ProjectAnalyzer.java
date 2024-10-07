package org.example;

import org.eclipse.jdt.core.dom.CompilationUnit;

import java.io.IOException;
import java.util.*;

public class ProjectAnalyzer {
    private final List<ClassInfo> classes = new ArrayList<>();
    private final Set<String> packages = new HashSet<>();
    private final Map<String, List<String>> callGraph = new HashMap<>();
    private int totalMethods = 0;
    private int totalLinesOfCode = 0;

    public void addLinesOfCode(int lines) {
        totalLinesOfCode += lines;
    }

    public void parseJavaFile(String content) {
        CompilationUnit cu = ASTUtils.parse(content);

        cu.accept(new ClassVisitor(classes, packages, callGraph, cu, this));
    }

    public void addMethod() {
        totalMethods++;
    }

    public void printMetrics() {
        int numberOfClasses = classes.size();
        int numberOfPackages = packages.size();
        double averageMethodsPerClass = (double) totalMethods / numberOfClasses;
        double averageAttributesPerClass = classes.stream().mapToInt(ClassInfo::getNumberOfAttributes).average().orElse(0);
        double averageLinesPerMethod = classes.stream()
                .flatMap(c -> c.getMethods().stream())
                .mapToInt(MethodInfo::getLinesOfCode).average().orElse(0);

        // Affichage des métriques
        System.out.println("Number of classes: " + numberOfClasses);
        System.out.println("Number of packages: " + numberOfPackages);
        System.out.println("Total number of methods: " + totalMethods);
        System.out.println("Total number of lines of code: " + totalLinesOfCode);
        System.out.println("Average methods per class: " + averageMethodsPerClass);
        System.out.println("Average attributes per class: " + averageAttributesPerClass);
        System.out.println("Average lines per method: " + averageLinesPerMethod);

        // Génération du graphe d'appel
        try {
            CallGraphUtils.generateCallGraph(callGraph);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printClassesWithMethodsGreaterThan(int X) {
        classes.stream()
                .filter(c -> c.getNumberOfMethods() > X)
                .forEach(c -> System.out.println("Class with more than " + X + " methods: " + c.getClassName()));
    }
}
