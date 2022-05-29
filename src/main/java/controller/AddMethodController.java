package controller;

import context.ControllerContext;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import repository.MethodRepository;
import service.ConfigureMethodService;

import java.net.URL;
import java.util.ResourceBundle;

public class AddMethodController implements Initializable {
    @FXML
    private TextField pageField;

    @FXML
    private Label pageLabel;

    @FXML
    private Label method;

    @FXML
    private Button save;

    @FXML
    private Button cancel;
    {
        ControllerContext.getInstance().setAddMethodController(this);
    }
    public void close()
    {
        ((Stage)cancel.getScene().getWindow()).close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        method.setText(MethodRepository.getInstance().getCurrentMethod().getName());
        cancel.setOnAction(event -> ((Stage)cancel.getScene().getWindow()).close());
        save.setOnAction(event -> ConfigureMethodService.getInstance().configure(pageField.getText()));
    }
}
