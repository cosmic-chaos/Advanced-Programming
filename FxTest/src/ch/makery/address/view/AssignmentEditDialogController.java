package ch.makery.address.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import ch.makery.address.model.Assignment;
import ch.makery.address.util.DateUtil;

/**
 * Dialog to edit details of an assignment.
 * 
 */
public class AssignmentEditDialogController {

    @FXML
    private TextField nameField;
    @FXML
    private TextField classField;
    @FXML
    private Slider difficultyField;
    @FXML
    private Slider urgencyField;
    @FXML
    private TextField dateField;


    private Stage dialogStage;
    private Assignment assignment;
    private boolean okClicked = false;

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    	urgencyField.setMajorTickUnit(1.0);
    	difficultyField.setMajorTickUnit(1.0);

    }

    /**
     * Sets the stage of this dialog.
     * 
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
        
        // Set the dialog icon.
        this.dialogStage.getIcons().add(new Image("file:resources/images/edit.png"));
    }

    /**
     * Sets the assignment to be edited in the dialog.
     * 
     * @param assignment
     */
    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;

        nameField.setText(assignment.getName());
        classField.setText(assignment.getClasss());
        difficultyField.adjustValue(assignment.getDifficulty());
        urgencyField.adjustValue(assignment.getUrgency());
        dateField.setText(DateUtil.format(assignment.getDate()));
        dateField.setPromptText("dd.mm.yyyy");
    }

    /**
     * Returns true if the user clicked OK, false otherwise.
     * 
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            assignment.setName(nameField.getText());
            assignment.setClass(classField.getText());
            assignment.setDifficulty(difficultyField.getValue());
            assignment.setUrgency(urgencyField.getValue());
            assignment.setDate(DateUtil.parse(dateField.getText()));

            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Validates the user input in the text fields.
     * 
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (nameField.getText() == null || nameField.getText().length() == 0) {
            errorMessage += "No valid first name!\n"; 
        }
        if (classField.getText() == null || classField.getText().length() == 0) {
            errorMessage += "No valid last name!\n"; 
         
        }

        if (dateField.getText() == null || dateField.getText().length() == 0) {
            errorMessage += "No valid birthday!\n";
        } else {
            if (!DateUtil.validDate(dateField.getText())) {
                errorMessage += "No valid birthday. Use the format dd.mm.yyyy!\n";
            }
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);
            
            alert.showAndWait();
            
            return false;
        }
    }
}