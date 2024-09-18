package com.example.reviews.model;

import java.util.List;
public interface Searchable <I, O> {
    public List<O> search(I input) throws ImplementationNotAvailableException;

}
