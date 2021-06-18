package com.example.dao;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
//기록저장소 
@Repository("ProductDAO") 
@SuppressWarnings("unchecked")
public class ProductDAO extends AbstractDAO {

	Logger log = Logger.getLogger(this.getClass());
	
	public List<Map<String, Object>> getList(Map<String, Object> map) {
		return (List<Map<String, Object>>)selectList("product.getList", map);
	} 
}