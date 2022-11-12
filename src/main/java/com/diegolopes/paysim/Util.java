package com.diegolopes.paysim;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Util {

    public static class Response<T> {
        private int code;
        private T data;

        public Response(int code, T data) {
            this.code = code;
            this.data = data;
        }

        public int getCode() {
            return code;
        }

        public T getData() {
            return data;
        }
    }
    
    public static Response<String> httpGetString(String url) {
        final HttpClient client = new HttpClient();
        final GetMethod get = new GetMethod(url);

        try {
            final int status = client.executeMethod(get);
            final String body = get.getResponseBodyAsString();
            return new Response<String>(status, body);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> Response<T> httpGetJSON(String url) {
        final Response<String> stringResponse = httpGetString(url);
        if (stringResponse != null && stringResponse.code == 200) {
            final ObjectMapper mapper = new ObjectMapper();
            final TypeReference<T> typeRef = new TypeReference<T>() {};
            try {
                final T parsed = mapper.readValue(stringResponse.data, typeRef);
                return new Response<T>(200, parsed);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                return new Response<T>(400, null);
            }
        }

        // forward response code if not null
        if (stringResponse != null) {
            return new Response<T>(stringResponse.code, null);
        }

        return new Response<T>(400, null);
    }

}
