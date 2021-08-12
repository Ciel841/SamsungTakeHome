# Request Router Task

This project is an HTTP router. Simply put, a request is passed in (HTTP method and path) and then a response is returned.
The functionality that maps a request to an endpoint/action needs to be implemented.

The mapping between a request and endpoint is handled by a class called `EndpointMap`. This is an abstract class with
the primary implementation in `EndpointMapImpl`. Your task is to complete the implementation in `EndpointMapImpl`.
In particular, you need to implement the `void addEndpoint(Endpoint)` and `Endpoint getEndpoint(Request)` methods.

For example, upon successful implementation, when the request `GET api/locations` is made, the `GetLocations` endpoint
will be invoked and the response 'get_locations' will be returned. The class `Main` contains a series of tests that you
can run to help you validate your implementation. Feel free to add additional tests!

### Implementation Details
- If an endpoint is not found, an `EndpointNotFoundException` should be thrown.
- Leading and trailing slashes - `/` - should be stripped. For example, if the request `GET /api/locations` is received,
  it should be corrected to `GET api/locations`.
- When an endpoint defines its path (see `Endpoint#getPath`), path variables are prefixed with a colon. For example, a
  path defined as `api/foo/:id` would resolve to request paths like `api/foo/123` and `api/foo/456`.

### Notes
- Don't stress if you don't get all the tests to pass. Do the best you can. :)
- Don't pull in any external frameworks. We want to see what you can come up with.
- Feel free to use any and all resources available to you.
- You WILL be asked to explain your solution, so be sure you know how and why your solution works.

### Project Directory
```
prt
└── requestrouter 
    ├── EndpointMap.java                   # Abstract class that handles the routing between a request to a task
    ├── HttpRouter.java                    # Primary entry point for managing requests and endpoints
    ├── Main.java                          # Executable that contains test cases to validate functionality
    ├── exception 
    │   └── EndpointNotFoundException.java # Exception used to indicate an endpoint could not be found for a request
    ├── impl 
    │   ├── EndpointMapImpl.java           # <-- PUT YOUR IMPLEMENTATION HERE!
    │   ├── endpoint                       # This directory contains the tasks that are mapped by paths
    │       ├── Endpoint.java              # Abstract class that all endpoint implementations inherit
    │       ├── GetInternalLocations.java  # Endpoint to get internal locations - 'GET api/internal/locations`
    │       ├── GetLocationById.java       # Endpoint to get a location by ID - 'GET api/locations/:id'
    │       ├── GetLocationSearch.java     # Endpoint to search for locations - 'GET api/locations/search'
    │       ├── GetLocations.java          # Endpoint to get all locations - 'GET api/locations'
    │       ├── GetRoomById.java           # Endpoint to get a room by location and room ID - 'GET api/locations/:locationId/rooms/:roomId
    |       └── GetRoomsByLocationId.java  # Endpoint to get all rooms for a specific location - 'GET api/locations/:locationId/rooms
    └── req                                            
        ├── Context.java                   # Utility to pass request context info (e.g. query params)
        ├── HttpMethod.java                # Enum for the accept HTTP Methods (e.g. GET)
        └── Request.java                   # Utility to pass raw request info (e.g. HTTP method and raw path)
```