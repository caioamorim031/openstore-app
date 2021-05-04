package com.projectdev.openstore.dao;

import java.sql.SQLException;
import java.util.List;

import com.projectdev.openstore.vo.ProductVO;

public interface ProductDAO {
	
	public List<ProductVO> selectAll() throws ClassNotFoundException, SQLException;

	public List<ProductVO> selectByIds(Integer[] array) throws ClassNotFoundException, SQLException;
}
