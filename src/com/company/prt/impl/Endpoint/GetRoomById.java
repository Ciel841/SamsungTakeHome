package com.company.prt.impl.Endpoint;

import com.company.prt.req.Context;
import com.company.prt.req.HttpMethod;

public class GetRoomById extends Endpoint {
    @Override
    public HttpMethod getMethod() {
        return HttpMethod.GET;
    }

    @Override
    public String getPath() {
        return "api/locations/:locationId/rooms/:roomId";
    }

    @Override
    public String execute(Context context) {
        String locationId = context.getPathParam("locationId").orElse(null);
        String roomId = context.getPathParam("roomId").orElse(null);
        return "get_room_by_id[locationId:" + locationId + ",roomId:" + roomId + "]";
    }
}
