package com.projectdev.openstore.vo;

public class ProductOrderVO {
	
	private int order_id;
	private int product_id;
	private int quantity;
	private double price_taxes;
	
	public int getOrderId() {
		return order_id;
	}
	public void setOrderId(int orderId) {
		this.order_id = orderId;
	}
	public int getProductId() {
		return product_id;
	}
	public void setProductId(int productId) {
		this.product_id = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPriceTaxes() {
		return price_taxes;
	}
	public void setPriceTaxes(double priceTaxes) {
		this.price_taxes = priceTaxes;
	}
	
}
