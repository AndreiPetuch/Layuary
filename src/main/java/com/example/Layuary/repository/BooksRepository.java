package com.example.Layuary.repository;

import com.example.Layuary.Books;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BooksRepository extends CrudRepository<Books, Integer> {
    List<Books> findByNamebooks (String namebooks);
}
