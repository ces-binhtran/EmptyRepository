package com.tranhiep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Util {

    public static String rootPath = "http://localhost:8080/EmptyRepository_war/";
    public static List<Book> books = new ArrayList<>(Arrays.asList(
            new Book(1,"Java concurrency in practice", "Doug lea"),
            new Book(2,"Java core", "Bear Tur"),
            new Book(3,"Code Java"),
            new Book(4,"Java function", "Code stu"),
            new Book(5, "Reactive programing", "Code stu")));


    public static Book findBookById (int id){
        return books.stream().filter(e -> e.getId() == id).findAny().get();
    }


}
