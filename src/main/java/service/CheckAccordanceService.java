package service;

import context.ProjectContext;
import controller.ProjectController;
import entity.Category;
import entity.Document;
import entity.Method;
import entity.SubCategory;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import project.Project;
import repository.CategoryRepository;
import repository.MethodRepository;

import java.util.ArrayList;
import java.util.List;

public class CheckAccordanceService {
    private static CheckAccordanceService instance;
    private CheckAccordanceService() { }
    public static CheckAccordanceService getInstance()
    {
        if(instance==null)
        {
            instance = new CheckAccordanceService();
        }
        return instance;
    }
     public void check()
     {
         Project project = ProjectContext.getInstance().getProject();
         List<Method> required = MethodRepository.getInstance().getAll();
         List<Method> used = new ArrayList<>();
         List<Document> docs = ProjectContext.getInstance().getProject().getDocuments();
         for (int i = 0; i < docs.size(); i++) {
             for (int j = 0; j < docs.get(i).getMethods().size(); j++) {
                 used.add(docs.get(i).getMethods().get(j));
             }
         }
         boolean flag = true;
         for (int i = 0; i < CategoryRepository.getInstance().size(); i++) {
             Category temp = CategoryRepository.getInstance().get(i);
             for (int j = 0; j < temp.getSubCategoryList().size(); j++) {
                 SubCategory sc = temp.getSubCategory(j);
                 if(!sc.isSingleMethod())
                 {
                     flag = checkCategoryReqAll(sc.getMethods(), used);
                     sc.setAccord(flag);
                 } else {
                     flag = checkCategoryRequireSingle(sc.getMethods(), used);
                     sc.setAccord(flag);
                 }
                 //if(!flag) {break;}
             }
             //if(!flag) {break;}
         }
         StringBuilder sb = new StringBuilder();
         if(flag)
         {
             sb.append("Соответствует");
         } else {
             sb.append("Не соответствует по следующим критериям:");
             sb.append('\n');
             for (int i = 0; i < CategoryRepository.getInstance().size(); i++) {
                 Category temp = CategoryRepository.getInstance().get(i);
                 if(!temp.isAccord())
                 {
                     sb.append(temp.getName());
                     sb.append('\n');
                     for (int j = 0; j < temp.getSubCategoryList().size(); j++) {
                         SubCategory tsc = temp.getSubCategoryList().get(j);
                         if(!tsc.isAccord())
                         {
                             sb.append("     ").append(tsc.getName());
                             sb.append('\n');
                         }
                     }
                 }
             }
         }
         generateScene(sb.toString());

     }
     private boolean checkCategoryReqAll(List<Method> required, List<Method> used)
     {
         for (int i = 0; i < required.size(); i++) {
             boolean flag1 = false;
             for (int j = 0; j < used.size(); j++) {

                 if(required.get(i).getName().equals(used.get(j).getName()))
                 {
                     flag1=true;
                     break;
                 }
             }
             if(!flag1)
             {
                 return false;
             }
         }
         return true;
     }
     private boolean checkCategoryRequireSingle(List<Method> required, List<Method> used)
     {
         for (Method method : required) {
             for (Method value : used) {
                 if (method.getName().equals(value.getName())) {
                     return true;
                 }
             }
         }
         return false;
     }
     private void generateScene(String content)
     {
         Stage stage = new Stage();
         Label label = new Label();
         label.setText(content);
         label.setStyle("-fx-alignment: center");
         FlowPane root = new FlowPane(Orientation.VERTICAL, 10, 10);
         root.getChildren().addAll(label);
         root.setPadding(new Insets(10));
         stage.setScene(new Scene(root, 450, 200));
         stage.show();
     }
}
