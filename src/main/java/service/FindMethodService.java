package service;

import context.ControllerContext;
import context.ProjectContext;
import entity.Method;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import repository.MethodRepository;
import repository.UsedMethodRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FindMethodService {
    private static FindMethodService instance;
    private MethodRepository rep = MethodRepository.getInstance();
    private FindMethodService() { }
    public static FindMethodService getInstance()
    {
        if(instance==null)
        {
            instance = new FindMethodService();
        }
        return instance;
    }
    public void findMethod(String name)
    {
        List<Method> methods = find(name);
        Stage stage = new Stage();
        Label[] labels = new Label[methods.size()];
        for (int i = 0; i < labels.length; i++) {
            labels[i] = new Label();
            labels[i].setText(methods.get(i).getName());
            Label temp = labels[i];
            labels[i].setOnMouseClicked(mouseEvent ->event(temp, stage));
        }
        FlowPane root = new FlowPane(Orientation.VERTICAL, 10, 10);
        root.getChildren().addAll(labels);
        root.setPadding(new Insets(10));
        stage.setScene(new Scene(root, 400, 400));
        stage.show();
    }
    private List<Method> find(String name)
    {
        List<Method> res = new ArrayList<>();
        for (int i = 0; i < rep.getAll().size(); i++) {
            if(rep.get(i).getName().contains(name))
            {
                res.add(rep.get(i));
            }
        }
        return res;
    }
    private void event(Label label, Stage stage)
    {
        Method method = new Method(label.getText());
        MethodRepository.getInstance().setCurrentMethod(method);
        Label methods = ControllerContext.getInstance().getDocumentController().getMethodList();
        methods.setText(methods.getText() + label.getText()+"\n");
        stage.close();
        stage = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/stages/addMethodStage.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setTitle("Add Method");
        stage.setScene(new Scene(root));
        stage.show();
    }
}