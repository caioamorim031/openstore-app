package com.projectdev.openstore.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.projectdev.openstore.service.ProductService;
import com.projectdev.openstore.vo.OrderVO;
import com.projectdev.openstore.vo.ProductOrderVO;
import com.projectdev.openstore.vo.ProductVO;

public class ShopAction extends ActionSupport {
	
	private static List<ProductVO> products;
	
	private static List<ProductOrderVO> selectedProducts;
	
	private static OrderVO order;
	
	private Integer[] checkboxes;
	
	public String execute(){
		
		ProductService ps = ProductService.getInstance();
		
		try {
			this.setProducts(ps.getProductData());
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		
		return SUCCESS;
		
	}
	
	public String sendOrder(){
		
		List<ProductOrderVO> persistProducts = new ArrayList<>();
		
		ProductService ps = ProductService.getInstance();
		
		for (Iterator iterator = selectedProducts.iterator(); iterator.hasNext();) {
			ProductOrderVO productVO = (ProductOrderVO) iterator.next();
			
			for (int i = 0; i < checkboxes.length; i++) {
				if(productVO.getProductId() == checkboxes[i]){
					persistProducts.add(productVO);
					break;
				}
			}	
		}
		
		try {
			this.setProducts(ps.getProductsByIdentifier(checkboxes));
			order = ps.createOrder(persistProducts, this.getProducts());
			
			this.setOrder(order);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		
		this.setSelectedProducts(persistProducts);
		
		return SUCCESS;
	}
	
	

	public List<ProductVO> getProducts() {
		return products;
	}

	public void setProducts(List<ProductVO> products) {
		this.products = products;
	}

	public Integer[] getCheckboxes() {
		return checkboxes;
	}

	public void setCheckboxes(Integer[] checkboxes) {
		this.checkboxes = checkboxes;
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
