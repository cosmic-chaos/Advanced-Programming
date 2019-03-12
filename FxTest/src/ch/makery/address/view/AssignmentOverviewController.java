package ch.makery.address.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import ch.makery.address.MainApp;
import ch.makery.address.model.Assignment;
import ch.makery.address.util.DateUtil;

public class AssignmentOverviewController {
    @FXML
    private TableView<Assignment> assignmentTable;
    @FXML
    private TableColumn<Assignment, String> firstNameColumn;
    @FXML
    private TableColumn<Assignment, String> lastNameColumn;

    @FXML
    private Label nameLabel;
    @FXML
    private Label classLabel;
    @FXML
    private Label dateLabel;
    @FXML
    private Label difficultyLabel;
    @FXML
    private Label urgencyLabel;

    // Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public AssignmentOverviewController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the assignment table with the two columns.
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().classProperty());
        
        // Clear assignment details.
        showAssignmentDetails(null);

        // Listen for selection changes and show the assignment details when changed.
        assignmentTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showAssignmentDetails(newValue));
    }

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        assignmentTable.setItems(mainApp.getAssignmentData());
    }
    
    /**
     * Fills all text fields to show details about the assignment.
     * If the specified assignment is null, all text fields are cleared.
     * 
     * @param assignment the assignment or null
     */
    private void showAssignmentDetails(Assignment assignment) {
        if (assignment != null) {
            // Fill the labels with info from the assignment object.
            nameLabel.setText(assignment.getName());
            classLabel.setText(assignment.getClasss());
            difficultyLabel.setText(Double.toString(assignment.getDifficulty()));
            urgencyLabel.setText(Double.toString(assignment.getUrgency()));
            dateLabel.setText(DateUtil.format(assignment.getDate()));
        } else {
            // Assignment is null, remove all the text.
        	nameLabel.setText("");
        	classLabel.setText("");
        	difficultyLabel.setText("");
        	urgencyLabel.setText("");
        	dateLabel.setText("");
        }
    }
    
    /**
     * Called when the user clicks on the delete button.
     */
    @FXML
    private void handleDeleteAssignment() {
        int selectedIndex = assignmentTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            assignmentTable.getItems().remove(selectedIndex);
        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Assignment Selected");
            alert.setContentText("Please select a assignment in the table.");
            
            alert.showAndWait();
        }
    }
    
    /**
     * Called when the user clicks the new button. Opens a dialog to edit
     * details for a new assignment.
     */
    @FXML
    private void handleNewAssignment() {
        Assignment tempAssignment = new Assignment();
        boolean okClicked = mainApp.showAssignmentEditDialog(tempAssignment);
        if (okClicked) {
            mainApp.getAssignmentData().add(tempAssignment);
        }
    }

    /**
     * Called when the user clicks the edit button. Opens a dialog to edit
     * details for the selected assignment.
     */
    @FXML
    private void handleEditAssignment() {
        Assignment selectedAssignment = assignmentTable.getSelectionModel().getSelectedItem();
        if (selectedAssignment != null) {
            boolean okClicked = mainApp.showAssignmentEditDialog(selectedAssignment);
            if (okClicked) {
                showAssignmentDetails(selectedAssignment);
            }

        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Assignment Selected");
            alert.setContentText("Please select a assignment in the table.");
            
            alert.showAndWait();
        }
    }
}