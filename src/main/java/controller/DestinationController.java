package controller;

import java.util.ArrayList;
import java.util.Comparator;
import model.FileDestination;
import storage.Storage;

public class DestinationController {
	
	public static ArrayList<FileDestination> orderMatch(String searchChars) {
		ArrayList<FileDestination> destinations = Storage.getDestinations();
		
		destinations.sort(new Comparator<FileDestination>() {
			public int compare(FileDestination d1, FileDestination d2) {
				return stringCharMatch(d2.getName(), searchChars) - stringCharMatch(d1.getName(), searchChars);
			};
			
			private int stringCharMatch(String source, String searchChars) {
				int matches = 0;
				for (int i = 0; i < source.length(); i++) {
					for (int j = 0; j < searchChars.length(); j++) {
						if (searchChars.charAt(j) == source.charAt(i)) {
							matches++;
							break;
						}
					}
				}
				
				return matches;
			}
		});

		return destinations;
	}
	
}
