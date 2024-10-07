package org.example;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.MethodInvocation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MethodCallVisitor extends ASTVisitor {
    private final Map<String, List<String>> callGraph;
    private final String caller;

    public MethodCallVisitor(Map<String, List<String>> callGraph, String caller) {
        this.callGraph = callGraph;
        this.caller = caller;
    }

    @Override
    public boolean visit(MethodInvocation node) {
        String callee = node.getName().getIdentifier();

        callGraph.computeIfAbsent(caller, k -> new ArrayList<>()).add(callee);

        return super.visit(node);
    }
}
