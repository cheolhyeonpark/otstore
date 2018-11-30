package com.otstore.web.json;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.otstore.domain.Cart;
import com.otstore.service.CartService;

@RestController
public class CartController {

	@Autowired
	CartService cartService;

	@RequestMapping("/insertCart")
	public Object insertCart(Cart cart) throws Exception {
		return cartService.insertCart(cart);
	}
	
	@GetMapping("/cartList")
	public Object cartList(int userNumber) throws Exception {
		return cartService.cartList(userNumber);
	}
	
	@GetMapping("/removeCart")
	public Object removeCart(int cartNo) throws Exception {
		return cartService.removeCart(cartNo);
	}
}
