package com.otstore.repository;

import java.util.List;

import com.otstore.domain.Cart;

public interface CartRepository {

	int insertCart(Cart cart);
	List<Cart> cartList(int userNumber);
	int removeCart(int cartNo);
}
