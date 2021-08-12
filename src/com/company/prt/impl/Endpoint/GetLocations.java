package com.company.prt.impl.Endpoint;

import com.company.prt.req.Context;
import com.company.prt.req.HttpMethod;

public class GetLocations extends Endpoint {

    @Override
    public String execute(Context context) {
        return "get_locations";
    }

    @Override
    public HttpMethod getMethod() {
        return HttpMethod.GET;
    }

    @Override
    public String getPath() {
        return "api/locations";
    }

}
