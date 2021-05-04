package com.projectdev.openstore.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.projectdev.openstore.vo.OrderVO;
import com.projectdev.openstore.vo.ProductOrderVO;
import com.projectdev.openstore.vo.ProductVO;

public class OrderAction extends ActionSupport {
	
	private List<ProductVO> products;
	
	private List<ProductOrderVO> selectedProducts;
	
	private OrderVO order;
	
	
	public String execute(){
		
		selectedProducts.isEmpty();
		
		return SUCCESS;
	}

	public List<ProductVO> getProducts() {
		return products;
	}

	public void setProducts(List<ProductVO> products) {
		this.products = products;
	}

	public List<ProductOrderVO> getSelectedProducts() {
		return selectedProducts;
	}

	public void setSelectedProducts(List<ProductOrderVO> selectedProducts) {
		this.selectedProducts = selectedProducts;
	}

	public OrderVO getOrder() {
		return order;
	}

	public void setOrder(OrderVO order) {
		this.order = order;
	}
	
	
}
