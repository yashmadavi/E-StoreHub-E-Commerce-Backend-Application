package com.my.Ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.Ecommerce.dao.CartDao;
import com.my.Ecommerce.dao.CartItemsDao;
import com.my.Ecommerce.dao.ProductDao;
import com.my.Ecommerce.dto.Cart;
import com.my.Ecommerce.dto.CartItems;
import com.my.Ecommerce.dto.Product;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class CartItemsService {

	@Autowired
	private CartItemsDao dao;
	
	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private ProductDao productDao;
	
	
	public CartItems saveCartItems(CartItems items) {
		
		Cart cart = cartDao.getCart(items.getCart().getCart_id());
		
		Product product = productDao.findProduct(items.getProduct().getProduct_id());
		if(cart!=null  || product!=null) {
			items.setCart(cart);
			items.setProduct(product);
			return dao.saveCartItems(items);
		}else {
			return null;
		}
	}
}
