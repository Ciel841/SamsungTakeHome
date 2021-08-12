package com.company.prt.impl.Endpoint;

import com.company.prt.req.Context;
import com.company.prt.req.HttpMethod;
import com.company.prt.req.Request;

import java.util.Optional;

public abstract class Endpoint {
    public abstract HttpMethod getMethod();

    public abstract String getPath();

    public abstract String execute(Context context);

    public final Optional<String> pathSegment(int index) {
        String[] segments = getPath().split("/");

        if (index < segments.length) {
            return Optional.of(segments[index]);
        }

        return Optional.empty();
    }

    public final Context parseContext(Request request) {
        Context.Builder builder = new Context.Builder();

        // parse path variables
        String[] endpointPathSegments = getPath().split("/");
        String[] requestPathSegments = request.getRawPath().split("/");

        for (int i = 0; i < endpointPathSegments.length; ++i) {
            String pathSegment = endpointPathSegments[i];
            if (pathSegment.startsWith(":")) {
                String segmentName = pathSegment.substring(1);
                builder.addPathParam(segmentName, requestPathSegments[i]);
            }
        }

        // parse query parameters
        int qIndex = request.getRawPath().indexOf('?');

        if (qIndex != -1) {
            String queryParamString = request.getRawPath().substring(qIndex + 1);
            String[] queryParams = queryParamString.split("&");

            for (String queryParam : queryParams) {
                String[] queryParamSegments = queryParam.split("=");
                if (queryParamSegments.length == 2) {
                    builder.addQueryParam(queryParamSegments[0], queryParamSegments[1]);
                }
            }
        }

        return builder.build();
    }
}
