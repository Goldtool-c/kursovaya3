package service;

import context.ControllerContext;
import context.DocumentContext;
import context.ProjectContext;
import entity.Document;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import project.Project;

import java.io.IOException;

public class ConfigureProjectService {
    private static ConfigureProjectService instance;
    private ConfigureProjectService() { }
    public static ConfigureProjectService getInstance()
    {
        if(instance==null)
        {
            instance = new ConfigureProjectService();
        }
        return instance;
    }
    public void configure(String companyName, String projectName, String checksum, String version)
    {
        Project project = new Project(companyName,projectName, version, checksum);
        ProjectContext.getInstance().setProject(project);
        SaveService.getInstance().save(project);
        Stage stage = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/stages/ProjectStage.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setTitle("Project");
        stage.setScene(new Scene(root));
        stage.show();
        ControllerContext.getInstance().getMainController().close();
    }

}
