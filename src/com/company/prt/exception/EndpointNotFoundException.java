package com.company.prt.exception;

import com.company.prt.req.HttpMethod;

public class EndpointNotFoundException extends RuntimeException {
    private final HttpMethod method;
    private final String path;

    public EndpointNotFoundException(HttpMethod method, String path) {
        super("No endpoint found (method='" + method + "', path='" + path + "')");

        this.method = method;
        this.path = path;
    }

    public HttpMethod getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }
}
