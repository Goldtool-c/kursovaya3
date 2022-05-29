package controller;

import context.ControllerContext;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.ConfigureProjectService;
import service.CreateDocumentService;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private Label companyLabel;

    @FXML
    private Label projectNameLabel;

    @FXML
    private Label checksumLabel;

    @FXML
    private Label versionLabel;

    @FXML
    private TextField companyField;

    @FXML
    private TextField projectNameField;

    @FXML
    private TextField checksumField;

    @FXML
    private TextField versionField;

    @FXML
    private Button confirmButton;

    private ConfigureProjectService service = ConfigureProjectService.getInstance();
    {
        ControllerContext.getInstance().setMainController(this);
    }
    public void close()
    {
        ((Stage)versionField.getScene().getWindow()).close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        confirmButton.setOnAction(event -> 
                service.configure(companyField.getText(), projectNameField.getText(),
                        checksumField.getText(), versionField.getText())
        );
    }
}
