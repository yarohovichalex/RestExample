package webSpringSimple.web.controller;

public class CarService {
	
	private  String model;
	private String brande;
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getBrande() {
		return brande;
	}
	public void setBrande(String brande) {
		this.brande = brande;
	}
	
	
	public CarService() {
		super();
	}
	public CarService(String model, String brande) {
		super();
		this.model = model;
		this.brande = brande;
	}
	@Override
	public String toString() {
		return "CarService [model=" + model + ", brande=" + brande + "]";
	}
	
	
	
	
}
