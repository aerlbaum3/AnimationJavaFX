package application;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Instantiate StackModel
        StackModel stackModel = new StackModel();
        
        // Load the FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Sample.fxml"));
        Parent root = loader.load();

        // Get the controller and set the stackModel
        StackController controller = loader.getController();
        controller.setStackModel(stackModel);

        primaryStage.setTitle("JavaFX MVC Sample");
        primaryStage.setScene(new Scene(root, 300, 200));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
