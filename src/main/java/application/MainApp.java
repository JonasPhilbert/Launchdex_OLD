package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;

import com.melloware.jintellitype.HotkeyListener;
import com.melloware.jintellitype.JIntellitype;

import controller.DestinationController;
import controller.ExecutionController;
import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Destination;
import storage.Storage;

//@SuppressWarnings("restriction")
public class MainApp extends Application {
	
    public static void main(String[] args) throws Exception {
    	Storage.load();
//    	Storage.addDestination(new Destination("Notepad++", "C:\\Program Files (x86)\\Notepad++\\notepad++.exe"));
//    	Storage.addDestination(new Destination("WinDirStat", "C:\\Program Files (x86)\\WinDirStat\\windirstat.exe"));
//    	Storage.addDestination(new Destination("PDFSam", "C:\\Program Files (x86)\\PDFsam Basic\\pdfsam.exe"));
//    	Storage.addDestination(new Destination("GOG", "C:\\Program Files (x86)\\GOG Galaxy\\GalaxyClient.exe"));
        Application.launch(args);
    }
    
    private Stage stage;
    private AddDestinationStage addDestinationStage;
    private EditDestinationStage editDestinationStage;

    @Override
    public void start(final Stage stage) throws Exception {    	
    	this.stage = stage;
    	
    	GridPane root = new GridPane();
    	root.setPadding(new Insets(10d));
    	root.setHgap(10d);
    	root.setVgap(10d);
        root.setPrefSize(400, 600);
        buildPane(root);
        Scene scene = new Scene(root);

        stage.setTitle("Launchdex");
        stage.setScene(scene);
        stage.show();
        
        // Hotkey Related
        JIntellitype.getInstance().addHotKeyListener(new HotkeyListener() {
			public void onHotKey(int identifier) {
				frontView();
			}
		});
        
        JIntellitype.getInstance().registerHotKey(1, JIntellitype.MOD_ALT + JIntellitype.MOD_SHIFT, (int)'Z');
    }
    
    private TextField txfQuery;
    private ListView<String> lvwDestinations;

    private void buildPane(GridPane pane) {
    	builTextField(pane);
    	builListView(pane);
    }
    
    private void builTextField(GridPane pane) {
    	txfQuery = new TextField("Search Query");
    	txfQuery.setMinWidth(400);
    	txfQuery.textProperty().addListener((observable, oldValue, newValue) -> {
    		lvwDestinations.getItems().removeAll(lvwDestinations.getItems());
    		if (txfQuery.getText().charAt(0) == '@') {
    			lvwDestinations.getItems().addAll(ExecutionController.everythingSearch(txfQuery.getText().substring(1, txfQuery.getText().length())));
    		} else {
        		lvwDestinations.getItems().addAll(DestinationController.orderMatch(newValue));
    		}
    		if (lvwDestinations.getItems().size() > 0) {
    			lvwDestinations.getSelectionModel().select(lvwDestinations.getItems().get(0));	
    		}
    	});
    	txfQuery.setOnAction(event -> txfAction());
    	pane.add(txfQuery, 0, 0);
    }
    
    private void builListView(GridPane pane) {
    	lvwDestinations = new ListView<>();
    	lvwDestinations.getItems().addAll(Storage.getDestinations());
    	lvwDestinations.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if (event.getCode().equals(KeyCode.ENTER) && !lvwDestinations.getSelectionModel().isEmpty()) {
					ExecutionController.execDestination(lvwDestinations.getSelectionModel().getSelectedItem());
				}
			}
		});
    	lvwDestinations.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
			@Override
			public void handle(ContextMenuEvent event) {
				ContextMenu cm = new ContextMenu();
				
				MenuItem pathItem = new MenuItem("Open Location");
				pathItem.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						ExecutionController.openExplorerPath(lvwDestinations.getSelectionModel().getSelectedItem().getPath());
					}
				});
				
				MenuItem editItem = new MenuItem("Edit");
				editItem.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						editDestinationStage = new EditDestinationStage("Edit Destination", stage, lvwDestinations.getSelectionModel().getSelectedItem());
						editDestinationStage.showAndWait();
						reloadListView();
					}
				});
				
				MenuItem removeItem = new MenuItem("Remove");
				removeItem.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						Storage.removeDestination(lvwDestinations.getSelectionModel().getSelectedItem());
					}
				});
				
				cm.getItems().addAll(pathItem, editItem, removeItem);
				cm.show(stage);
			}
		});
    	pane.add(lvwDestinations, 0, 1);
    }
    
    private void frontView() {
    	System.out.println("Fronting view...");
    	Platform.runLater(new Runnable() {
    		@Override
			public void run() {
				stage.setIconified(false);
				stage.toFront();
				
				txfQuery.selectAll();
			}
		});
    }
    
    private void backView() {
    	System.out.println("Backing view...");
    	Platform.runLater(new Runnable() {
			@Override
			public void run() {
				stage.toBack();
				stage.setIconified(true);
			}
		});
    }
    
    private void txfAction() {
    	backView();    	
    	ExecutionController.execDestination(lvwDestinations.getItems().get(0));
    }
    
    private void reloadListView() {
    	lvwDestinations.getItems().removeAll(lvwDestinations.getItems());
    	lvwDestinations.getItems().addAll(Storage.getDestinations());
    }

}
