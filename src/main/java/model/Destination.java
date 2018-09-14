package model;

public class Destination {

	private int order;
	private String path;
	
	public Destination(int order, String path) {
		this.order = order;
		this.path = path;
	}
	
	public int getOrder() {
		return order;
	}
	
	public String getPath() {
		return path;
	}
	
	@Override
	public String toString() {
		return "(" + order + ") " + path;
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
