package com.example.cravecart1.features.carts.controller;

import com.example.cravecart1.features.carts.dto.CartRequest;
import com.example.cravecart1.features.carts.entity.Cart;
import com.example.cravecart1.features.carts.service.CartService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cart createCart(@Valid @RequestBody CartRequest request) {
        return cartService.createCart(request);
    }

    @GetMapping
    public List<Cart> listCarts() {
        return cartService.listCarts();
    }

    @GetMapping("/{id}")
    public Cart getCart(@PathVariable Long id) {
        return cartService.getCart(id);
    }

    @PutMapping("/{id}")
    public Cart updateCart(@PathVariable Long id, @Valid @RequestBody CartRequest request) {
        return cartService.updateCart(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCart(@PathVariable Long id) {
        cartService.deleteCart(id);
    }
}
