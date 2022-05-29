package repository;

import entity.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryRepository {
    private static CategoryRepository instance;
    private List<Category> categories = new ArrayList<>();
    private CategoryRepository(){}
    public static CategoryRepository getInstance()
    {
        if(instance==null)
        {
            instance = new CategoryRepository();
        }
        return instance;
    }
    public List<Category> getAll()
    {
        return categories;
    }
    public Category get(int id)
    {
        return categories.get(id);
    }
    public void add(Category category)
    {
        categories.add(category);
    }
    public Category search(String name)
    {
        for (int i = 0; i < categories.size(); i++) {
            if(categories.get(i).getName().equals(name))
            {
                return categories.get(i);
            }
        }
        return null;
    }
    public int size() { return categories.size(); }
}
