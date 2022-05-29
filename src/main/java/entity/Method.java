package entity;

public class Method {
    private String name;
    private short page;
    public Method(String name) {
        this.name = name;
    }
    public Method(String name, short page) {
        this.name = name;
        this.page = page;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getPage() {
        return page;
    }

    public void setPage(short page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "Method{" +
                "name='" + name + '\'' +
                ", page=" + page +
                '}';
    }
}
