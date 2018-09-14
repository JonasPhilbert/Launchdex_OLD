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
	
}
