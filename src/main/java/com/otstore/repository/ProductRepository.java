package com.otstore.repository;

import java.util.HashMap;
import java.util.List;

import com.otstore.domain.Product;

public interface ProductRepository {

	int insertProduct(Product product);	
	List<Product> selectList(HashMap<String, Integer> map);
	List<Product> bestList();
	int totalProduct(HashMap<String, Integer> map);
	Product viewProduct(int prodNo);
}
