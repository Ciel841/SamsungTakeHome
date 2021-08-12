package com.company.prt.impl.Endpoint;

import com.company.prt.req.Context;
import com.company.prt.req.HttpMethod;

public class GetRoomsByLocationId extends Endpoint {

    @Override
    public HttpMethod getMethod() {
        return HttpMethod.GET;
    }

    @Override
    public String getPath() {
        return "api/locations/:locationId/rooms";
    }

    @Override
    public String execute(Context context) {
        String locationId = context.getPathParam("locationId").orElse(null);
        return "get_rooms_by_location_id[locationId:" + locationId + "]";
    }

}
