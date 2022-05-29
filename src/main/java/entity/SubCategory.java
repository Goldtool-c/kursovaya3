package entity;

import java.util.ArrayList;
import java.util.List;

public class SubCategory {
    private String name;
    private List<Method> methods = new ArrayList<>();
    private boolean singleMethod;
    private boolean accord = false;

    public SubCategory() { }

    public SubCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Method> getMethods() {
        return methods;
    }

    public void setMethods(List<Method> methods) {
        this.methods = methods;
    }

    public boolean isSingleMethod() {
        return singleMethod;
    }

    public void setSingleMethod(boolean singleMethod) {
        this.singleMethod = singleMethod;
    }
    public Method getMethod(int id)
    {
        return methods.get(id);
    }
    public void addMethod(Method method)
    {
        methods.add(method);
    }
    public void addAllMethods(List<Method> list)
    {
        methods = list;
    }

    public boolean isAccord() {
        return accord;
    }

    public void setAccord(boolean accord) {
        this.accord = accord;
    }
}
