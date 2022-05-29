package service;

import context.DocumentContext;
import context.ProjectContext;
import entity.Document;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.IOException;


public class ShowDocumentsService {
    private static ShowDocumentsService instance;
    private ShowDocumentsService() { }
    public static ShowDocumentsService getInstance()
    {
        if(instance==null)
        {
            instance = new ShowDocumentsService();
        }
        return instance;
    }
    public void show()
    {
        Stage stage = new Stage();
        Label[] docs = new Label[ProjectContext.getInstance().getProject().getDocuments().size()];
        for (int i = 0; i < docs.length; i++) {
            docs[i] = new Label();
            docs[i].setText(ProjectContext.getInstance().getProject().getDocuments().get(i).getName()+
                    " "+ProjectContext.getInstance().getProject().getDocuments().get(i).getDate());
            Document temp = ProjectContext.getInstance().getProject().getDocuments().get(i);
            docs[i].setOnMouseClicked(mouseEvent -> event(temp, stage));
        }
        FlowPane root = new FlowPane(Orientation.VERTICAL, 10, 10);
        root.getChildren().addAll(docs);
        root.setPadding(new Insets(10));
        stage.setScene(new Scene(root, 400, 400));
        stage.show();
    }
    private void event(Document temp, Stage stage)
    {
        stage.close();
        Stage primaryStage = new Stage();
        DocumentContext.getInstance().setDocument(temp);
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/stages/EditDocument.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        primaryStage.setTitle("Edit Document");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
