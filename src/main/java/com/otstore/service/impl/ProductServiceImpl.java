package com.otstore.service.impl;

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
}
