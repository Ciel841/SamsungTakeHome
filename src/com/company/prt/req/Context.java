package com.company.prt.req;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Context {
    private final Map<String, String> queryParams;
    private final Map<String, String> pathParameters;

    private Context(Builder b) {
        queryParams = Collections.unmodifiableMap(b.queryParams);
        pathParameters = Collections.unmodifiableMap(b.pathParams);
    }

    public Optional<String> getQueryParam(String name) {
        return Optional.ofNullable(queryParams.get(name));
    }

    public Optional<String> getPathParam(String name) {
        return Optional.ofNullable(pathParameters.get(name));
    }

    public static class Builder {
        private final Map<String, String> queryParams = new HashMap<>();
        private final Map<String, String> pathParams = new HashMap<>();

        public Builder addQueryParam(String name, String value) {
            queryParams.put(name, value);
            return this;
        }

        public Builder addPathParam(String name, String value) {
            pathParams.put(name, value);
            return this;
        }

        public Context build() {
            return new Context(this);
        }
    }
}
