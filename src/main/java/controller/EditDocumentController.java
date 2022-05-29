package controller;

import context.ControllerContext;
import context.DocumentContext;
import entity.Document;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.FindMethodService;
import service.SaveDocumentService;

import java.net.URL;
import java.util.ResourceBundle;

public class EditDocumentController implements Initializable {
    @FXML
    private Label docName;

    @FXML
    private TextField docNameField;

    @FXML
    private Label methodName;

    @FXML
    private TextField methodNameField;

    @FXML
    private Button findMethod;

    @FXML
    private Button saveDoc;

    @FXML
    private Label methodList;

    private Document document;

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    {
        ControllerContext.getInstance().setEditDocumentController(this);
        document = DocumentContext.getInstance().getDocument();
    }

    public void close()
    {
        ((Stage)methodList.getScene().getWindow()).close();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        docNameField.setText(document.getName());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < document.getMethods().size(); i++) {
            sb.append(document.getMethods().get(i).getName());
            sb.append('\n');
        }
        methodList.setText(sb.toString());
        findMethod.setOnAction(event -> FindMethodService.getInstance().findMethod(methodNameField.getText()));
        saveDoc.setOnAction(event -> SaveDocumentService.getInstance().saveEdited(document, docNameField.getText()));
    }//todo в едите не отображаются новые методы
}
