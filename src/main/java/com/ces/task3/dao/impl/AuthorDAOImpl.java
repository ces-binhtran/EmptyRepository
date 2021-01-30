package com.ces.task3.dao.impl;

import com.ces.task3.contrain.ResponseMessage;
import com.ces.task3.dao.AuthorDAO;
import com.ces.task3.dao.BookDAO;
import com.ces.task3.entity.AuthorEntity;
import com.ces.task3.entity.BookEntity;
import com.ces.task3.model.exception.NotFoundException;
import com.ces.task3.model.response.Response;
import com.ces.task3.util.QueryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Repository
public class AuthorDAOImpl extends BaseDAOImpl<AuthorEntity, Integer> implements AuthorDAO {

    private final BookDAO bookDAO;

    @Autowired
    public AuthorDAOImpl(BookDAO bookDAO){
        this.bookDAO = bookDAO;
    }



    @Override
    public Response addAuthorsToBook(Integer bookId, List<Integer> addedAuthorIds) throws NotFoundException {
        BookEntity bookEntity = bookDAO.getById(bookId)
                .orElseThrow(() ->new NotFoundException("bookId", bookId.toString()));

        // filter author not exist and create Values in insert statement
        List<String> values = _getAuthorsById(addedAuthorIds)
                .stream()
                .filter(author -> !bookEntity.getAuthors().contains(author))
                .map(author ->
                        QueryUtils.createValueSQL(Arrays.asList(author.getId().toString(), bookId.toString())))
                .collect(Collectors.toList());

        if(values.isEmpty()) return new Response(ResponseMessage.NOT_FOUND_RECORD);

        // build a insert multiple query.
        String queryStatement = QueryUtils
                .buildInsertQuery("book_author",
                        Arrays.asList("author_id", "book_id"),
                        values)
                .toString();
        entityManager
                .createNativeQuery(queryStatement)
                .executeUpdate();
        return new Response(ResponseMessage.API_ADD_SUCCESS);
    }

    @Override
    public Response deleteAuthorsFromBook(Integer bookId, List<Integer> deleteAuthorIds) throws NotFoundException {
        BookEntity bookEntity = bookDAO.getById(bookId)
                .orElseThrow(() ->new NotFoundException("bookId", bookId.toString()));

        // filter AuthorId exist in book
        List<String> authorIds = _getAuthorsById(deleteAuthorIds)
                .stream()
                .filter(author -> bookEntity.getAuthors().contains(author))
                .map(author -> author.getId().toString())
                .collect(Collectors.toList());

        if(authorIds.isEmpty()) return new Response(ResponseMessage.NOT_FOUND_RECORD);

        // make where condition
        String condition1 = "book_id =" +bookId;
        String condition2 = "author_id in"+QueryUtils.createValueSQL(authorIds);
        List<String> conditions = Arrays.asList(condition1, condition2);
        // make a multiple insert query.
        String queryStatement =  QueryUtils
                .buildDeleteQuery("book_author", conditions)
                .toString();
        entityManager
                .createNativeQuery(queryStatement)
                .executeUpdate();
        return new Response(ResponseMessage.API_DELETE_SUCCESS);
    }

    @Override
    public Collection<AuthorEntity> getAllAuthorOfBook(Integer bookId) {
        TypedQuery<AuthorEntity> query = entityManager
                .createNamedQuery("author.getAllAuthorOfBook", AuthorEntity.class);
        query.setParameter("bookId", bookId);
        return query.getResultList();
    }

    protected List<AuthorEntity> _getAuthorsById(List<Integer> authorIds){
        return authorIds.stream()
                .map(this::getById)
                .filter(authorOpt -> authorOpt.isPresent())
                .map(authorOpt -> authorOpt.get())
                .collect(Collectors.toList());
    }
}
