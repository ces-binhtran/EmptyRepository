package com.ces.task3.util;

import java.util.List;
import java.util.stream.Collectors;

public class QueryUtils {

    // exp : (1,2,3)
    public static String createValueSQL(List<String> values){
        return values.stream()
                .map(Object::toString)
                .collect(Collectors.joining(",", "(", ")"));
    }

    public static StringBuilder buildInsertQuery(String tableName, List<String> fieldNames, List<String> values){
        StringBuilder queryStatement = new StringBuilder("insert into "+tableName);
        queryStatement.append(createValueSQL(fieldNames));
        queryStatement.append(" values");

        String valuesSQL = values
                .stream()
                .collect(Collectors.joining(",", "",";"));
        queryStatement.append(valuesSQL);
        return queryStatement;
    }


    public static StringBuilder buildDeleteQuery(String tableName, List<String> conditions){
        StringBuilder queryStatement = new StringBuilder("delete from "+ tableName +" where");
        String whereConditions = conditions.stream().collect(Collectors.joining(" and ", " ", ";"));
        queryStatement.append(whereConditions);
        return queryStatement;
    }


}
