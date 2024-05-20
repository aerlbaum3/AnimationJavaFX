package application;
import java.time.Duration;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class StackController {
    private StackModel stackModel;

    
    
    @FXML
    private VBox rootVBox; // Inject the root VBox node

    @FXML
    private TextField inputField;

    public void setStackModel(StackModel stackModel) {
        this.stackModel = stackModel;
    }
    @FXML void pushButtonClicked() {
        try {
            String inputText = inputField.getText();
            if (inputText.isEmpty()) {
                showAlert("Error", "Empty Input", "Please enter an integer.");
                return;
            }

            int item = Integer.parseInt(inputText);

            // Create a new Text node to represent the item
            Text itemNode = new Text(inputText);

            // Add the itemNode to the UI (assuming rootPane is the root node of your UI)
            rootVBox.getChildren().add(itemNode);

            // Specify the final position within the stack representation
            double finalX = 100; // Example: X position within the stack representation
            double finalY = 100; // Example: Y position within the stack representation

            // Set the layout properties of the itemNode to the final position
            itemNode.setLayoutX(finalX);
            itemNode.setLayoutY(finalY);

            // Perform the push operation on the stack model
            stackModel.push(item);

            inputField.clear(); // Clear input field after push
        } catch (NumberFormatException e) {
            showAlert("Error", "Invalid Input", "Please enter a valid integer.");
        } catch (Exception e) {
            showAlert("Error", "Unexpected Error", "An unexpected error occurred.");
            e.printStackTrace(); // Print stack trace for debugging
        }
    }



    @FXML void popButtonClicked() {
        try {
            int poppedItem = stackModel.pop();

            // Find and remove the visual representation of the popped item from the UI
            for (Node node : rootVBox.getChildren()) {
                if (node instanceof Text && ((Text) node).getText().equals(String.valueOf(poppedItem))) {
                    rootVBox.getChildren().remove(node);
                    break;
                }
            }

            showAlert("Popped Item", null, "Popped item: " + poppedItem);
        } catch (IllegalStateException e) {
            showAlert("Error", "Empty Stack", "Stack is empty.");
        } catch (Exception e) {
            showAlert("Error", "Unexpected Error", "An unexpected error occurred.");
            e.printStackTrace(); // Print stack trace for debugging
        }
    }


    private void showAlert(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
