//package application;
//
//import java.util.Scanner;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//import org.jnativehook.GlobalScreen;
//import org.jnativehook.keyboard.NativeKeyEvent;
//import org.jnativehook.keyboard.NativeKeyListener;
//
//import javafx.application.Application;
//import javafx.application.*;
//import javafx.scene.Scene;
//import javafx.scene.layout.Pane;
//import javafx.stage.Stage;
//
//@SuppressWarnings("restriction")
//public class DEPRECATED_MainApp extends Application implements NativeKeyListener {
//	
//    public static void main(String[] args) {
//        Application.launch(args);
//    }
//    
//    private Stage stage;
//    boolean altDown, spaceDown = false;
//
//    @Override
//    public void start(Stage stage) throws Exception {
//    	// JNativeHook
//		// Set logging level to warnings only;
//		Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
//		logger.setLevel(Level.WARNING);
//		logger.setUseParentHandlers(false);
//		
//		// Register native hook;
//		GlobalScreen.registerNativeHook();
//    	GlobalScreen.addNativeKeyListener(this);
//    	
//    	this.stage = stage;
//    	
//    	Pane root = new Pane();
//        root.setPrefSize(500, 100);
//        buildPane(root);
//        Scene scene = new Scene(root);
//
//        stage.setTitle("Launchdex");
//        stage.setScene(scene);
//        stage.show();
//        
////        Scanner scan = new Scanner(System.in);
////        if (scan.hasNext())
////        	toggleView();
//    }
//    
//    private  void toggleView() {
//    	if (stage.isShowing()) {
//        	Platform.runLater(new Runnable() {
//    			public void run() {
//    				stage.hide();
//    			}
//    		});
//    	} else {
//        	Platform.runLater(new Runnable() {
//    			public void run() {
//    				stage.show();
//    			}
//    		});
//    	}
//    }
//    
//    private void frontView() {
//    	Platform.runLater(new Runnable() {
//			public void run() {
//				stage.toFront();
//			}
//		});
//    }
//
//    private void buildPane(Pane pane) {
//    	// JavaFX
//    }
//
//    // JNativeHook
//	public void nativeKeyPressed(NativeKeyEvent nativeEvent) {
//		switch (nativeEvent.getKeyCode()) {
//		case NativeKeyEvent.VC_CONTROL:
//			altDown = true;
//		case NativeKeyEvent.VC_SPACE:
//			spaceDown = true;
//		default:
//			break;
//		}
//	}
//
//	public void nativeKeyReleased(NativeKeyEvent nativeEvent) {
//		if (altDown && spaceDown) {
//			System.out.println("GO");
//			frontView();
//		}
//		
//		switch (nativeEvent.getKeyCode()) {
//		case NativeKeyEvent.VC_CONTROL:
//			altDown = false;
//		case NativeKeyEvent.VC_SPACE:
//			spaceDown = false;
//		default:
//			break;
//		}
//	}
//	
//	public void nativeKeyTyped(NativeKeyEvent nativeEvent) {
//		return;
//	}
//
//}
