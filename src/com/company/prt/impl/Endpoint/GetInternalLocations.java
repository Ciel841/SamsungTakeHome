package com.company.prt.impl.Endpoint;

import com.company.prt.req.Context;
import com.company.prt.req.HttpMethod;

public class GetInternalLocations extends Endpoint {
    @Override
    public HttpMethod getMethod() {
        return HttpMethod.GET;
    }

    @Override
    public String getPath() {
        return "api/internal/locations";
    }

    @Override
    public String execute(Context context) {
        return "get_internal_locations";
    }

}
