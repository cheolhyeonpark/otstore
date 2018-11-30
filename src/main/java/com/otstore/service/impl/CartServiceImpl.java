package com.otstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otstore.domain.Cart;
import com.otstore.repository.CartRepository;
import com.otstore.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartRepository cartRepository;

	@Override
	public int insertCart(Cart cart) {
		
		return cartRepository.insertCart(cart);
	}

	@Override
	public List<Cart> cartList(int userNumber) {
		return cartRepository.cartList(userNumber);
	}

	@Override
	public int removeCart(int cartNo) {
		return cartRepository.removeCart(cartNo);
	}

}
