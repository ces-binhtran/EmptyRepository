package com.tranhiep.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AJAXUtils {


    public static void sendJson(HttpServletResponse res, Object data) throws IOException {
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();

        String jsonData = gson.toJson(data);
        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        res.getWriter().write(jsonData);

    }
}
