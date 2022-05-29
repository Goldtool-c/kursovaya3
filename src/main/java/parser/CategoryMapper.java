package parser;

import entity.Category;
import entity.Method;
import entity.SubCategory;
import org.springframework.jdbc.core.RowMapper;
import repository.CategoryRepository;
import repository.MethodRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryMapper implements RowMapper<SubCategory> {
    @Override
    public SubCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
        String subName = rs.getString("subcategory");
        String name = rs.getString("category");
        int isSingle = rs.getInt("issingle");
        List<Method> methods = parse(rs);
        SubCategory subCategory = new SubCategory();
        subCategory.setName(subName);
        subCategory.addAllMethods(methods);
        if(isSingle==0)
        { subCategory.setSingleMethod(false);}
        else {subCategory.setSingleMethod(true);}
        if(CategoryRepository.getInstance().search(name)==null)
        {
            Category category = new Category();
            category.setName(name);
            category.addSubCategory(subCategory);
            CategoryRepository.getInstance().add(category);
        } else {
            Category category = CategoryRepository.getInstance().search(name);
            category.addSubCategory(subCategory);
        }
        return subCategory;
    }
    private List<Method> parse(ResultSet rs) throws SQLException {
        List<Method> res = new ArrayList<>();
        String content = rs.getString("methods");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < content.length(); i++) {
            if(content.charAt(i)==',')
            {
                res.add(new Method(sb.toString()));
                MethodRepository.getInstance().addMethod(sb.toString());
                sb = new StringBuilder();
            } else
            {
                sb.append(content.charAt(i));
            }
        }
        res.add(new Method(sb.toString()));
        MethodRepository.getInstance().addMethod(sb.toString());
        return res;
    }
}
