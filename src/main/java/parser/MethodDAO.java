package parser;

import config.Config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class MethodDAO {
    private static MethodDAO instance;
    private ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
    private JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
    private MethodDAO(){}
    public static MethodDAO getInstance()
    {
        if(instance==null)
        {
            instance = new MethodDAO();
        }
        return instance;
    }
    public void getMethods(String content)
    {
        jdbcTemplate.query("Select * from subcategories", new CategoryMapper());
    }
    public void parseAll()
    {

    }
}
