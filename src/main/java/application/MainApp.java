package application;

import model.Destination;
import storage.Storage;

public class MainApp {

	public static void main(String[] args) throws Exception {
		KeyListener.setUp();
		
		Storage.load();
		Destination d1 = new Destination(0, "C:\\Program Files\\Git\\git-bash.exe");
		Destination d2 = new Destination(1, "C:\\M.E.S.S\\Bikkel Milleder.zip");
		Storage.addDestination(d1);
		Storage.addDestination(d2);
	}
	
}
