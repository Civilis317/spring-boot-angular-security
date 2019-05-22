package net.playground.productsbackend.exception;

public class ProductServiceApplicationException extends RuntimeException {
    public ProductServiceApplicationException(String message) {
        super(message);
    }

    public ProductServiceApplicationException(String message, Throwable cause) {
        super(message, cause);
    }
}
