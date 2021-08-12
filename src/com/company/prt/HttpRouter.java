package com.company.prt;

import com.company.prt.impl.Endpoint.*;
import com.company.prt.impl.EndpointMapImpl;
import com.company.prt.req.HttpMethod;
import com.company.prt.req.Request;

public class HttpRouter {

    private final EndpointMap endpointMap = new EndpointMapImpl();

    public HttpRouter() {
        endpointMap.addEndpoint(new GetLocations());
        endpointMap.addEndpoint(new GetLocationById());
        endpointMap.addEndpoint(new GetInternalLocations());
        endpointMap.addEndpoint(new GetLocationSearch());
        endpointMap.addEndpoint(new GetRoomsByLocationId());
        endpointMap.addEndpoint(new GetRoomById());
    }

    public String handleRequest(HttpMethod method, String path) {
        return endpointMap.execute(new Request(method, path));
    }

}
