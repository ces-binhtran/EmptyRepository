package com.ces.service.impl;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ces.model.BookModel;
import com.ces.service.BookService;

public class BookServiceImpl implements BookService{
	static Integer count =1;
	static List<BookModel> books = new ArrayList<>(Arrays.asList(new BookModel(count++,"Harry Potter", "Join Thame"),
			new BookModel(count++, "This summer", "Jack Love"), new BookModel(count++, "Family", "Black Back")));

	@Override
	public List<BookModel> findAllBooks() {
		return books;
	}

	@Override
	public void add(BookModel bookModel) {
		if(bookModel.getId() == null) {
			books.add(new BookModel(count++, bookModel.getName(), bookModel.getAuthor()));
		}
		else {
			for(int i=0; i<books.size(); i++) {
				if(books.get(i).getId() == bookModel.getId()) {
					books.set(i, bookModel);
				}
			}
		}
	}

	@Override
	public void delete(Integer id) {
		for(int i=0; i<books.size(); i++) {
			if(books.get(i).getId() == id) {
				books.remove(i);
			}
		}
	}

	@Override
	public BookModel findById(Integer id) {
		return books.stream().filter(e -> e.getId() == id).findFirst().get();
	}

}
