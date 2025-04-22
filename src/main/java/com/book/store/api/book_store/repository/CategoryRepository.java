package com.book.store.api.book_store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.book.store.api.book_store.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
