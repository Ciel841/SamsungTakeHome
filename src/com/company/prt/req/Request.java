package com.company.prt.req;

public class Request {
    private final HttpMethod method;
    private final String rawPath;

    public Request(HttpMethod method, String rawPath) {
        this.method = method;
        this.rawPath = rawPath;
    }

    public HttpMethod getMethod() {
        return method;
    }

    public String getRawPath() {
        return rawPath;
    }


}
