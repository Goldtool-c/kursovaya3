package entity;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private String name;
    private List<SubCategory> subCategoryList = new ArrayList<>();
    private boolean accord = false;
    public Category(String name, List<SubCategory> subCategoryList) {
        this.name = name;
        this.subCategoryList = subCategoryList;
    }

    public Category() { }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public SubCategory getSubCategory(int id)
    {
        return subCategoryList.get(id);
    }
    public void addSubCategory(SubCategory subCategory)
    {
        subCategoryList.add(subCategory);
    }
    public List<SubCategory> getSubCategoryList()
    {
        return subCategoryList;
    }

    public boolean isAccord() {
        for (int i = 0; i < subCategoryList.size(); i++) {
            if(!subCategoryList.get(i).isAccord())
            {
                return false;
            }
        }
        return true;
    }

    public void setAccord(boolean accord) {
        this.accord = accord;
    }
}
