package net.playground.productsbackend.rest.controller;

import net.playground.productsbackend.exception.ProductServiceApplicationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class AbstractController {
    private static final Logger logger = LoggerFactory.getLogger(AbstractController.class);

    @ExceptionHandler
    protected void handleIllegalArgumentException(IllegalArgumentException e, HttpServletResponse response) throws IOException {
        logger.error(e.getMessage(), e);
        response.sendError(HttpStatus.BAD_REQUEST.value(), "The request was not valid: " + e.getMessage());
    }

    @ExceptionHandler
    protected void handleStorageException(ProductServiceApplicationException e, HttpServletResponse response) throws IOException {
        logger.error(e.getMessage(), e);
        response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Please seek assistance from an application maintainer");
    }

}
