package com.otstore.service;

import java.util.List;

import com.otstore.domain.Cart;

public interface CartService {

	int insertCart(Cart cart);
	List<Cart> cartList(int userNumber);
	int removeCart(int cartNo);
}
