package controller;

import context.ControllerContext;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import repository.MethodRepository;
import service.FindMethodService;
import service.SaveDocumentService;
import service.SaveService;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ResourceBundle;

public class DocumentController implements Initializable {
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

    @FXML
    private TextField dateField;
    {
        ControllerContext.getInstance().setDocumentController(this);
    }
    public void close()
    {
        ((Stage)methodList.getScene().getWindow()).close();
    }

    public TextField getDateField() {
        return dateField;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        findMethod.setOnAction(event -> FindMethodService.getInstance().findMethod(methodNameField.getText()));
        saveDoc.setOnAction(event -> SaveDocumentService.getInstance().save(docNameField.getText()));
    }

    public Label getMethodList() {
        return methodList;
    }
}
