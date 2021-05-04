package com.projectdev.openstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.projectdev.openstore.factory.ConnectionFactory;
import com.projectdev.openstore.util.DatabaseUtil;
import com.projectdev.openstore.vo.ProductVO;

public class ProductDAOImpl implements ProductDAO{
	
	private Connection conexao = null;

	@Override
	public List<ProductVO> selectAll() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		String sql = "SELECT * FROM product";
		
		conexao = ConnectionFactory.getConnection();
		
		PreparedStatement stm = conexao.prepareStatement(sql);
		ResultSet rs = stm.executeQuery();
		
		List<ProductVO> products = new ArrayList<>();
		
		while(rs.next()){
			ProductVO product = new ProductVO();
			
			product.setProductId(rs.getInt("product_id"));
			product.setName(rs.getString("name"));
			product.setDepartment(rs.getInt("department"));
			product.setPrice(rs.getDouble("price"));
			product.setImported(rs.getBoolean("imported"));
			
			
			products.add(product);
		}
		
		conexao.close();
		
		return products;
	}
	
	public List<ProductVO> selectByIds(Integer[] array) throws ClassNotFoundException, SQLException{
		// TODO Auto-generated method stub
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM product ");
		sb.append(" WHERE product_id IN ( ");
		sb.append(DatabaseUtil.generateSqlInput(array.length));
		sb.append(" ) ");
		
		conexao = ConnectionFactory.getConnection();
		
		PreparedStatement stm = conexao.prepareStatement(sb.toString());
		
		for (int i = 0; i < array.length; i++) {
			Integer integer = array[i];
			
			stm.setInt(i+1, integer);
		}
		
		ResultSet rs = stm.executeQuery();
		
		List<ProductVO> products = new ArrayList<>();
		
		while(rs.next()){
			ProductVO product = new ProductVO();
			
			product.setProductId(rs.getInt("product_id"));
			product.setName(rs.getString("name"));
			product.setDepartment(rs.getInt("department"));
			product.setPrice(rs.getDouble("price"));
			product.setImported(rs.getBoolean("imported"));
			
			
			products.add(product);
		}
		
		conexao.close();
		
		return products;
	}

}
