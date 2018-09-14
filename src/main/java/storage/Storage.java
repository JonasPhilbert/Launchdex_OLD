package storage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import model.Destination;

public class Storage {
	
	private static ArrayList<Destination> destinations = new ArrayList<Destination>();

	public static void load() throws Exception {
		File f = new File("destinations.json");
		if (!f.exists()) {
			f.createNewFile();
			return;
		}
		
		FileReader fr = new FileReader(f);
		
		Gson gson = new Gson();
		
		BufferedReader br = new BufferedReader(fr);
		StringBuilder sb = new StringBuilder();
		String line = br.readLine();
		
		while (line != null) {
			sb.append(line);
			line = br.readLine();
		}
		
    	Type listType = new TypeToken<ArrayList<Destination>>() {}.getType();
    	destinations = gson.fromJson(sb.toString(), listType);
		
		fr.close();
	}
	
	public static void save() throws Exception {
		FileWriter fw = new FileWriter("destinations.json");
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		fw.write(gson.toJson(destinations));
		fw.close();
	}
	
	public static void addDestination(Destination d) throws Exception {
		destinations.add(d);
		save();
	}
	
	public static void removeDestination(Destination d) throws Exception {
		destinations.remove(d);
		save();
	}
	
	public static ArrayList<Destination> getDestinations(){
		return new ArrayList<Destination>(destinations);
	}
	
}
