package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CallGraphUtils {
    public static void generateCallGraph(Map<String, List<String>> callGraph) throws IOException {
        FileWriter writer = new FileWriter("callgraph.dot");

        // Écrire l'en-tête du fichier DOT
        writer.write("digraph G {\n");

        // Parcourir le graphe d'appel et écrire les connexions sous forme d'arcs dans le fichier DOT
        for (String caller : callGraph.keySet()) {
            List<String> callees = callGraph.get(caller);
            for (String callee : callees) {
                writer.write("    \"" + caller + "\" -> \"" + callee + "\";\n");
            }
        }

        // Fermer le graphe
        writer.write("}\n");
        writer.close();

        System.out.println("Call graph generated in 'callgraph.dot'");
    }
}

