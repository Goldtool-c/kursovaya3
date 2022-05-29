package entity;

import java.util.ArrayList;
import java.util.List;

public class Document {
    private static int ID;
    private int id;
    private String name = "NA";
    private String checkSum = "NA";
    private String date;
    private List<Method> methods = new ArrayList<>();
    public Document(){
        id=ID;
        ID++;
    }
    public Document(String name) {
        id=ID;
        ID++;
        this.name=name;
    }
    public Document(String name, String checkSum) {
        id=ID;
        ID++;
        this.name = name;
        this.checkSum = checkSum;
    }
    public void addMethod(Method method)
    {
        methods.add(method);
    }

    public List<Method> getMethods() {
        return methods;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCheckSum() {
        return checkSum;
    }

    public void setCheckSum(String checkSum) {
        this.checkSum = checkSum;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", checkSum='" + checkSum + '\'' +
                ", date='" + date + '\'' +
                ", methods=" + methods +
                '}';
    }
}

