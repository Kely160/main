package utilities;

import java.util.ArrayList;
import java.util.List;

public class Mapping {
    private String controllerClass;
    private List<String> methodNames;

    public Mapping(String controllerClass) {
        this.controllerClass = controllerClass;
        this.methodNames = new ArrayList<>();
    }

    public String getControllerClass() {
        return controllerClass;
    }

    public void setControllerClass(String controllerClass) {
        this.controllerClass = controllerClass;
    }

    public List<String> getMethodNames() {
        return methodNames;
    }

    public void addMethodName(String methodName) {
        this.methodNames.add(methodName);
    }
}