package com.otstore.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otstore.domain.Product;
import com.otstore.repository.ProductRepository;
import com.otstore.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired ProductRepository productRepository;
	
	@Override
	public int insertProduct(Product product) {
		return productRepository.insertProduct(product);
	}
	
	@Override
	public List<Product> selectList(HashMap<String, Integer> map) {
		return productRepository.selectList(map);
	}

	@Override
	public int totalProduct(HashMap<String, Integer> map) {
		return productRepository.totalProduct(map);
	}

	@Override
	public Product viewProduct(int prodNo) {
		return productRepository.viewProduct(prodNo);
	}

	@Override
	public List<Product> bestList() {
		return productRepository.bestList();
	}
}
