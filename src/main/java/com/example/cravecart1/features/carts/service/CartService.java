package com.example.cravecart1.features.carts.service;

import com.example.cravecart1.features.carts.dto.CartItemRequest;
import com.example.cravecart1.features.carts.dto.CartRequest;
import com.example.cravecart1.features.carts.entity.Cart;
import com.example.cravecart1.features.carts.entity.CartItem;
import com.example.cravecart1.features.carts.repo.CartRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CartService {

    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Cart createCart(CartRequest request) {
        Cart cart = new Cart();
        cart.setUserId(request.getUserId());
        cart.setItems(toItems(cart, request.getItems()));
        return cartRepository.save(cart);
    }

    public List<Cart> listCarts() {
        return cartRepository.findAll();
    }

    public Cart getCart(Long id) {
        return cartRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cart not found"));
    }

    public Cart updateCart(Long id, CartRequest request) {
        Cart cart = getCart(id);
        cart.setUserId(request.getUserId());
        cart.getItems().clear();
        cart.getItems().addAll(toItems(cart, request.getItems()));
        return cartRepository.save(cart);
    }

    public void deleteCart(Long id) {
        Cart cart = getCart(id);
        cartRepository.delete(cart);
    }

    private List<CartItem> toItems(Cart cart, List<CartItemRequest> items) {
        List<CartItem> cartItems = new ArrayList<>();
        if (items == null) {
            return cartItems;
        }
        for (CartItemRequest itemRequest : items) {
            CartItem item = new CartItem();
            item.setCart(cart);
            item.setProductId(itemRequest.getProductId());
            item.setQuantity(itemRequest.getQuantity());
            cartItems.add(item);
        }
        return cartItems;
    }
}
