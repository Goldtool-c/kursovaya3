package controller;

import context.ControllerContext;
import context.DocumentContext;
import entity.Document;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import service.CheckAccordanceService;
import service.SaveDocumentService;
import service.ShowDocumentsService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProjectController implements Initializable {
    @FXML
    private Button add;

    @FXML
    private Button check;

    @FXML
    private Button documents;
    {
        ControllerContext.getInstance().setProjectController(this);
    }
    public void close()
    {
        ((Stage)add.getScene().getWindow()).close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        add.setOnAction(event ->
        {
            Stage primaryStage = new Stage();
            DocumentContext.getInstance().setDocument(new Document());
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/stages/DocumentStage.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            primaryStage.setTitle("Create Document");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        });
        check.setOnAction(event -> CheckAccordanceService.getInstance().check());
        documents.setOnAction(event -> ShowDocumentsService.getInstance().show());
    }

}
