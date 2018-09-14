package controller;

import java.io.InputStream;

import model.Destination;

public class LaunchController {

	public static InputStream execDestination(Destination destination) throws Exception {
		return exec(destination.getPath());
	}
	
	private static InputStream exec(String...cmd) throws Exception {
		ProcessBuilder builder = new ProcessBuilder(cmd);
		
		Process p = builder.start();
		return p.getInputStream();
	}
	
}
