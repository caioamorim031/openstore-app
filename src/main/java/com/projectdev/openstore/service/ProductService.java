package com.projectdev.openstore.service;

import java.util.Iterator;
import java.util.List;

import com.projectdev.openstore.dao.ProductDAO;
import com.projectdev.openstore.dao.ProductDAOImpl;
import com.projectdev.openstore.util.DepartmentConstants;
import com.projectdev.openstore.vo.OrderVO;
import com.projectdev.openstore.vo.ProductOrderVO;
import com.projectdev.openstore.vo.ProductVO;

public class ProductService {
	
	public List<ProductVO> getProductData() throws Exception{
		
		ProductDAO pDao = new ProductDAOImpl();
		
		List<ProductVO> products = pDao.selectAll();
		
		
		return products;
	}
	
public List<ProductVO> getProductsByIdentifier(Integer[] ids) throws Exception{
		
		ProductDAO pDao = new ProductDAOImpl();
		
		List<ProductVO> products = pDao.selectByIds(ids);
		
		
		return products;
	}
	
	public OrderVO createOrder(List<ProductOrderVO> productOrderList, List<ProductVO> productList){
		double totalTaxes = 0;
		double totalPrice = 0;
		double total = 0;
		OrderVO order = new OrderVO();
		
		for (Iterator iterator = productOrderList.iterator(); iterator.hasNext();) {
			ProductOrderVO productOrderVo = (ProductOrderVO) iterator.next();
			ProductVO productVo = this.searchProductCollectionById(productList, productOrderVo.getProductId());
			
			productOrderVo.setPriceTaxes(calculateTaxesPerProduct(productVo));
			totalTaxes += productOrderVo.getPriceTaxes();
			totalPrice += productVo.getPrice();
		}
		
		//TO-DO Incluir na tabela para manter o histórico
		
		totalTaxes = Math.round(totalTaxes * 20.0) / 20.0;
		total = totalPrice + totalTaxes;
		order.setTotal(total);
		order.setTotalTaxes(totalTaxes);
		
		return order;
		
	}
	
	public double calculateTaxesPerProduct(ProductVO productVo){
		double taxesPerProduct = 0;
		
		if(productVo.getDepartment() == DepartmentConstants.OTHERS)
			taxesPerProduct = 10;
		
		
		if(productVo.isImported())
			taxesPerProduct += 5;
		
		return productVo.getPrice() * (taxesPerProduct/100);
	}
	
	public ProductVO searchProductCollectionById(List<ProductVO> products, int identifier){
		
		for (Iterator iterator = products.iterator(); iterator.hasNext();) {
			ProductVO productVO = (ProductVO) iterator.next();
			if(productVO.getProductId() == identifier)
				return productVO;
		}
		return null;
	}

}
