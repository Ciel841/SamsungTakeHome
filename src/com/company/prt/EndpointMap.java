package com.company.prt;

import com.company.prt.exception.EndpointNotFoundException;
import com.company.prt.impl.Endpoint.Endpoint;
import com.company.prt.req.Context;
import com.company.prt.req.Request;

public abstract class EndpointMap {

    /**
     * Add an endpoint to the mapping.
     *
     * @param endpoint the endpoint to add to the map
     */
    public abstract void addEndpoint(Endpoint endpoint);

    /**
     * Get the endpoint that is mapped by the specified request (HTTP method and path).
     *
     * @param request the request parameters
     * @return the (non-null) Endpoint that matches the specified request parameters
     * @throws EndpointNotFoundException if an endpoint matching the request parameters cannot be found
     */
    public abstract Endpoint getEndpoint(Request request) throws EndpointNotFoundException;

    /**
     * Executes a request.
     *
     * @param request the request to execute
     * @return the response
     */
    public String execute(Request request) {
        Endpoint endpoint = getEndpoint(request);
        Context context = endpoint.parseContext(request);

        return endpoint.execute(context);
    }

}

