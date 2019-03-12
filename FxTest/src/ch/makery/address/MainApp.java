package ch.makery.address;

import java.io.File;
import java.io.IOException;
import java.util.prefs.Preferences;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import ch.makery.address.model.Assignment;
import ch.makery.address.model.AssignmentListWrapper;
import ch.makery.address.view.DueDateStatisticsController;
import ch.makery.address.view.AssignmentEditDialogController;
import ch.makery.address.view.AssignmentOverviewController;
import ch.makery.address.view.RootLayoutController;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    
    /**
     * The data as an observable list of Assignments.
     */
    private ObservableList<Assignment> assignmentData = FXCollections.observableArrayList();

    /**
     * Constructor
     */
    public MainApp() {
        // Add some sample data
        assignmentData.add(new Assignment("Bridges", "Compusci"));
        assignmentData.add(new Assignment("Sorting", "Ad Pro"));
        assignmentData.add(new Assignment("Dankness", "Memeology"));
        assignmentData.add(new Assignment("Integrals", "BC2"));
        assignmentData.add(new Assignment("Art Stuff", "Art"));

    }

    /**
     * Returns the data as an observable list of Assignments. 
     * @return
     */
    public ObservableList<Assignment> getAssignmentData() {
        return assignmentData;
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("AddressApp");
        
        // Set the application icon.
        this.primaryStage.getIcons().add(new Image("file:resources/images/address_book_32.png"));

        initRootLayout();

        showAssignmentOverview();
    }

    /**
     * Initializes the root layout and tries to load the last opened
     * assignment file.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class
                    .getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            // Give the controller access to the main app.
            RootLayoutController controller = loader.getController();
            controller.setMainApp(this);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Try to load last opened assignment file.
        File file = getAssignmentFilePath();
        if (file != null) {
            loadAssignmentDataFromFile(file);
        }
    }

    /**
     * Shows the assignment overview inside the root layout.
     */
    public void showAssignmentOverview() {
        try {
            // Load assignment overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/AssignmentOverview.fxml"));
            AnchorPane assignmentOverview = (AnchorPane) loader.load();

            // Set assignment overview into the center of root layout.
            rootLayout.setCenter(assignmentOverview);

            // Give the controller access to the main app.
            AssignmentOverviewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Opens a dialog to edit details for the specified assignment. If the user
     * clicks OK, the changes are saved into the provided assignment object and true
     * is returned.
     * 
     * @param assignment the assignment object to be edited
     * @return true if the user clicked OK, false otherwise.
     */
    public boolean showAssignmentEditDialog(Assignment assignment) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/assignmentEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit assignment");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the assignment into the controller.
            AssignmentEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setAssignment(assignment);
            
            // Set the dialog icon.
            dialogStage.getIcons().add(new Image("file:resources/images/edit.png"));

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * Opens a dialog to show birthday statistics.
     */
    public void showBirthdayStatistics() {
        try {
            // Load the fxml file and create a new stage for the popup.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/BirthdayStatistics.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Birthday Statistics");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            
            // Set the dialog icon.
            dialogStage.getIcons().add(new Image("file:resources/images/calendar.png"));

            // Set the assignments into the controller.
            DueDateStatisticsController controller = loader.getController();
            controller.setAssignmentData(assignmentData);

            dialogStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Returns the assignment file preference, i.e. the file that was last opened.
     * The preference is read from the OS specific registry. If no such
     * preference can be found, null is returned.
     * 
     * @return
     */
    public File getAssignmentFilePath() {
        Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
        String filePath = prefs.get("filePath", null);
        if (filePath != null) {
            return new File(filePath);
        } else {
            return null;
        }
    }

    /**
     * Sets the file path of the currently loaded file. The path is persisted in
     * the OS specific registry.
     * 
     * @param file the file or null to remove the path
     */
    public void setAssignmentFilePath(File file) {
        Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
        if (file != null) {
            prefs.put("filePath", file.getPath());

            // Update the stage title.
            primaryStage.setTitle("AddressApp - " + file.getName());
        } else {
            prefs.remove("filePath");

            // Update the stage title.
            primaryStage.setTitle("AddressApp");
        }
    }
    
    /**
     * Loads assignment data from the specified file. The current assignment data will
     * be replaced.
     * 
     * @param file
     */
    public void loadAssignmentDataFromFile(File file) {
        try {
            JAXBContext context = JAXBContext
                    .newInstance(AssignmentListWrapper.class);
            Unmarshaller um = context.createUnmarshaller();

            // Reading XML from the file and unmarshalling.
            AssignmentListWrapper wrapper = (AssignmentListWrapper) um.unmarshal(file);

            assignmentData.clear();
            assignmentData.addAll(wrapper.getAssignments());

            // Save the file path to the registry.
            setAssignmentFilePath(file);

        } catch (Exception e) { // catches ANY exception
        	Alert alert = new Alert(AlertType.ERROR);
        	alert.setTitle("Error");
        	alert.setHeaderText("Could not load data");
        	alert.setContentText("Could not load data from file:\n" + file.getPath());
        	
        	alert.showAndWait();
        }
    }

    /**
     * Saves the current assignment data to the specified file.
     * 
     * @param file
     */
    public void saveAssignmentDataToFile(File file) {
        try {
            JAXBContext context = JAXBContext
                    .newInstance(AssignmentListWrapper.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Wrapping our assignment data.
            AssignmentListWrapper wrapper = new AssignmentListWrapper();
            wrapper.setAssignments(assignmentData);

            // Marshalling and saving XML to the file.
            m.marshal(wrapper, file);

            // Save the file path to the registry.
            setAssignmentFilePath(file);
        } catch (Exception e) { // catches ANY exception
        	Alert alert = new Alert(AlertType.ERROR);
        	alert.setTitle("Error");
        	alert.setHeaderText("Could not save data");
        	alert.setContentText("Could not save data to file:\n" + file.getPath());
        	
        	alert.showAndWait();
        }
    }

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}