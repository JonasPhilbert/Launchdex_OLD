package model;

public class FileDestination extends Destination{

	private String name;
	
	public FileDestination(String name, String path) {
		super(path, true);
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
}
