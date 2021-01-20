package com.ces.task3.dao.impl;

import com.ces.task3.dao.BookDAO;
import com.ces.task3.entity.BookEntity;
import org.springframework.stereotype.Repository;

@Repository
public class BookDAOImpl extends BaseDAOImpl<BookEntity, Integer> implements BookDAO {
}
