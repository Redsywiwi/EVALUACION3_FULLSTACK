package com.Tienda.Addidas.exception;

public class InventarioNotFoundException extends RuntimeException {
    public InventarioNotFoundException(String message) {
        super(message);
    }
}