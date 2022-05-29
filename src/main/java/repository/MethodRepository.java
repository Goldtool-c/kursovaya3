package repository;

import entity.Method;

import java.util.ArrayList;
import java.util.List;

public class MethodRepository {
    private static MethodRepository instance;
    private List<Method> methods = new ArrayList<>();
    private Method currentMethod;
    private MethodRepository(){}
    public static MethodRepository getInstance()
    {
        if(instance==null)
        {
            instance = new MethodRepository();
        }
        return instance;
    }
    public void addMethod(String name)
    {
        methods.add(new Method(name));
    }
    public List<Method> getAll()
    {
        return methods;
    }
    public Method get(int id)
    {
        return methods.get(id);
    }

    public Method getCurrentMethod() {
        return currentMethod;
    }

    public void setCurrentMethod(Method currentMethod) {
        this.currentMethod = currentMethod;
    }
}
