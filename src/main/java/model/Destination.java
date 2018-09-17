package model;

public class Destination {

	private String path;
	private boolean runnable;
	
	public Destination(String path, boolean runnable) {
		this.path = path;
		this.runnable = runnable;
	}
	
	public String getPath() {
		return path;
	}
	
	public boolean isRunnable() {
		return runnable;
	}
	
	@Override
	public String toString() {
		return path;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Destination) {
			if (((Destination) obj).getPath() == this.path) {
				return true;
			}
		}
		
		return false;
	}
	
}
