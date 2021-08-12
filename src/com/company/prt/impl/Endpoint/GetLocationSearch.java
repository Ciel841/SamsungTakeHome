package com.company.prt.impl.Endpoint;

import com.company.prt.req.Context;
import com.company.prt.req.HttpMethod;

public class GetLocationSearch extends Endpoint {
    @Override
    public HttpMethod getMethod() {
        return HttpMethod.GET;
    }

    @Override
    public String getPath() {
        return "api/locations/search";
    }

    @Override
    public String execute(Context context) {
        return "get_locations_search[name:" + context.getQueryParam("name").orElse(null) + "]";
    }
}
