package com.ces.task3.contrain;

public class ResponseMessage {

    //--------------------API-Success---------------

    public static final String API_DELETE_SUCCESS = "Delete successfully";
    public static final String API_ADD_SUCCESS = "Add successfully";
    public static final String API_CREATE_SUCCESS = "Create successfully";
    public static final String API_UPDATE_SUCCESS = "Update successfully";

    //----------------------API-Failed-----------------

    public static final String API_DELETE_FAILED = "Delete failed";
    public static final String API_ADD_FAILED = "Add failed";
    public static final String API_UPDATE_FAILED = "Update failed";
    public static final String API_CREATE_FAILED = "Create failed";

    //---------------------Error---------------------

    public static final String NOT_FOUND_RECORD = "Not Found Record";
    public static final String RECORD_ALREADY_EXISTS = "Record Already Exists";
    public static final String MISSING_REQUIRE_FIELD = "Missing Require Field !";
    public static final String INTERNAL_SERVER_ERROR = "Internal Server Error";
    public static final String USERNAME_PASSWORD_INVALIDATE = "Username or Password Incorrect";

}
