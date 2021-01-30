package com.ces.task3.util;

import com.ces.task3.dto.AuthorDTO;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Utils {
    public static String authorsToString (Collection<AuthorDTO> authors, int maxSize){
        Stream<String> authorNameStream  = authors.stream().map(AuthorDTO::getName);
        if(authors.size() <= maxSize){
            return authorNameStream.collect(Collectors.joining(" - "));
        }
        authorNameStream = authorNameStream.limit(maxSize);
        return authorNameStream.collect(Collectors.joining(" - ", "", "..."));
    }
}
