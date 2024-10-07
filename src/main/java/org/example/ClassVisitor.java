package org.example;

import org.eclipse.jdt.core.dom.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ClassVisitor extends ASTVisitor {
    private final List<ClassInfo> classes;
    private final Set<String> packages;
    private final Map<String, List<String>> callGraph;
    private final CompilationUnit cu;
    private final ProjectAnalyzer analyzer;

    public ClassVisitor(List<ClassInfo> classes, Set<String> packages, Map<String, List<String>> callGraph, CompilationUnit cu, ProjectAnalyzer analyzer) {
        this.classes = classes;
        this.packages = packages;
        this.callGraph = callGraph;
        this.cu = cu;
        this.analyzer = analyzer;
    }

    @Override
    public boolean visit(PackageDeclaration node) {
        packages.add(node.getName().getFullyQualifiedName());
        return super.visit(node);
    }

    @Override
    public boolean visit(TypeDeclaration node) {
        ClassInfo classInfo = new ClassInfo(node.getName().getIdentifier());
        FieldDeclaration[] fields = node.getFields();
        classInfo.setNumberOfAttributes(fields.length);

        MethodDeclaration[] methods = node.getMethods();
        for (MethodDeclaration method : methods) {
            int methodLines = cu.getLineNumber(method.getStartPosition() + method.getLength()) - cu.getLineNumber(method.getStartPosition());
            MethodInfo methodInfo = new MethodInfo(method.getName().getIdentifier(), methodLines, method.parameters().size());
            classInfo.addMethod(methodInfo);
            analyzer.addMethod();

            method.accept(new MethodCallVisitor(callGraph, method.getName().getIdentifier()));
        }

        classes.add(classInfo);
        return super.visit(node);
    }
}
