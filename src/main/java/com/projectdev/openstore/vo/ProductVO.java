package com.projectdev.openstore.vo;

public class ProductVO {
	
	private Integer product_id;
	
	private String name;
	
	private int department;
	
	private double price;
	
	private boolean isImported;
	

	public Integer getProductId() {
		return product_id;
	}

	public void setProductId(Integer product_id) {
		this.product_id = product_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDepartment() {
		return department;
	}

	public void setDepartment(int department) {
		this.department = department;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isImported() {
		return isImported;
	}

	public void setImported(boolean isImported) {
		this.isImported = isImported;
	}

}
