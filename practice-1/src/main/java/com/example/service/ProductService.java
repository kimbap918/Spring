package com.example.service;

import java.util.*;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.example.dao.ProductDAO;

// 실질적으로 사용자의 요청을 수행하는 곳 
@Service("productService")
public class ProductService {
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="ProductDAO")
	private ProductDAO productDAO;
	
	public List<Map<String, Object >> getList(Map<String, Object> map){ 
		return productDAO.getList(map);
	}
}