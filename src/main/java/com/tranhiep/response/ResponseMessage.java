package com.tranhiep.response;

import com.google.gson.annotations.Expose;

public class ResponseMessage {

    @Expose(serialize = true)
    private String message;

    public ResponseMessage(String message){
        this.message = message;
    }
}
