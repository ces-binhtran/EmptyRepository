package com.ces.service;

import java.util.List;

import com.ces.model.BookModel;

public interface BookService {
	List<BookModel> findAllBooks();
	void add(BookModel bookModel);
	void delete(Integer id);
	BookModel findById(Integer id);
}
