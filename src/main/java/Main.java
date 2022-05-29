import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import parser.MethodDAO;

import java.io.FileReader;
import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        initialize();
        Parent root = FXMLLoader.load(getClass().getResource("stages/MainStage.fxml"));
        primaryStage.setTitle("Configure Project");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    public static void main(String ...args)
    {
        launch(args);
    }
    private void initialize()
    {
        StringBuilder sb = new StringBuilder();
        try (FileReader reader = new FileReader("src/main/resources/methods.txt")) {
            int c;
            while ((c = reader.read()) != -1) {
                sb.append((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        MethodDAO.getInstance().getMethods(sb.toString());
    }
}
