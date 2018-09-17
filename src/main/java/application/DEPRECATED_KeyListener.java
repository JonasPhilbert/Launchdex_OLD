//package application;
//
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//import org.jnativehook.GlobalScreen;
//import org.jnativehook.NativeHookException;
//import org.jnativehook.keyboard.NativeKeyEvent;
//import org.jnativehook.keyboard.NativeKeyListener;
//
//public class DEPRECATED_KeyListener implements NativeKeyListener, Runnable {
//	
//	private static final DEPRECATED_KeyListener instance = new DEPRECATED_KeyListener();
////	private static MainApp mainApp;
//	private static boolean altDown = false;
//	private static boolean spaceDown = false;
//	
//	// Called when a key is pressed down;
//	public void nativeKeyPressed(NativeKeyEvent e) {
//		if (e.getKeyCode() == NativeKeyEvent.VC_ALT)
//			altDown = true;
//		
//		if (e.getKeyCode() == NativeKeyEvent.VC_SPACE)
//			spaceDown = true;
//		
//		if (altDown && spaceDown) {
////			MainApp.toggleView();
//		}
//		
//		System.out.println(altDown + " " + spaceDown);
//			
////		System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
////
////		if (e.getKeyCode() == NativeKeyEvent.VC_ESCAPE) {
////			try {
////				GlobalScreen.unregisterNativeHook();
////			} catch (NativeHookException e1) {
////				e1.printStackTrace();
////			}
////		}
//	}
//
//	// Called when a key is released;
//	public void nativeKeyReleased(NativeKeyEvent e) {
//		if (e.getKeyCode() == NativeKeyEvent.VC_ALT)
//			altDown = false;
//		
//		if (e.getKeyCode() == NativeKeyEvent.VC_SPACE)
//			spaceDown = false;
//	}
//	
//	// Called when? What? I don't know...
//	public void nativeKeyTyped(NativeKeyEvent e) {
//		System.out.println("THE TYPE HAPPENED!");
//	}
//	
//	public static DEPRECATED_KeyListener getInstance() {
//		return instance;
//	}
//	
//	public static void setUp() {		
//		try {
//			// Set logging level to warnings only;
//			Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
//			logger.setLevel(Level.WARNING);
//			logger.setUseParentHandlers(false);
//			
//			// Register native hook;
//			GlobalScreen.registerNativeHook();
//		}
//		catch (NativeHookException ex) {
//			System.err.println("There was a problem registering the native hook.");
//			System.err.println(ex.getMessage());
//
//			System.exit(1);
//		}
//		
//		GlobalScreen.addNativeKeyListener(instance);
//	}
//
//	public void run() {}
//	
//}
