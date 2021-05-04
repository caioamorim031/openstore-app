package com.projectdev.openstore.vo;

import java.util.List;

public class OrderVO {
	
	private Integer order_id;
	
	private double total;
	
	private double totalTaxes;

	public Integer getOrderId() {
		return order_id;
	}

	public void setOrderId(Integer orderId) {
		this.order_id = orderId;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getTotalTaxes() {
		return totalTaxes;
	}

	public void setTotalTaxes(double totalTaxes) {
		this.totalTaxes = totalTaxes;
	}


}
