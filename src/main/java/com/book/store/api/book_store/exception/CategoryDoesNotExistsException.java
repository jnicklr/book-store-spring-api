package com.book.store.api.book_store.exception;

public class CategoryDoesNotExistsException extends RuntimeException {
    public CategoryDoesNotExistsException() { 
        super("Esta categoria não existe!"); 
    }

    public CategoryDoesNotExistsException(String message) { 
        super(message); 
    }
}
