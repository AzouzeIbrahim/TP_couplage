package org.example;

public class MethodInfo {
    private final String methodName;
    private final int linesOfCode;
    private final int parameterCount;

    public MethodInfo(String methodName, int linesOfCode, int parameterCount) {
        this.methodName = methodName;
        this.linesOfCode = linesOfCode;
        this.parameterCount = parameterCount;
    }

    public int getLinesOfCode() {
        return linesOfCode;
    }

    public int getParameterCount() {
        return parameterCount;
    }

    @Override
    public String toString() {
        return methodName;
    }
}
