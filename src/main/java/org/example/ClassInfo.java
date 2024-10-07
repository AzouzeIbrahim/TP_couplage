package org.example;

import java.util.ArrayList;
import java.util.List;

 class ClassInfo {
    private final String className;
    private int numberOfAttributes;
    private final List<MethodInfo> methods = new ArrayList<>();

    public ClassInfo(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public void setNumberOfAttributes(int numberOfAttributes) {
        this.numberOfAttributes = numberOfAttributes;
    }

    public int getNumberOfAttributes() {
        return numberOfAttributes;
    }

    public void addMethod(MethodInfo method) {
        methods.add(method);
    }

    public int getNumberOfMethods() {
        return methods.size();
    }

    public List<MethodInfo> getMethods() {
        return methods;
    }
}
