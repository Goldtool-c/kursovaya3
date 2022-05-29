package repository;

import entity.Method;

import java.util.ArrayList;
import java.util.List;

public class UsedMethodRepository {
    private static UsedMethodRepository instance;
    private List<Method> methods = new ArrayList<>();
    private UsedMethodRepository(){}
    public static UsedMethodRepository getInstance()
    {
        if(instance==null)
        {
            instance = new UsedMethodRepository();
        }
        return instance;
    }
    public void addMethod(String name)
    {
        methods.add(new Method(name));
    }
    public void addMethod(Method method) {methods.add(method);}
    public List<Method> getAll()
    {
        return methods;
    }
    public Method get(int id)
    {
        return methods.get(id);
    }
    public void erase()
    {
        methods = new ArrayList<>();
    }
}
