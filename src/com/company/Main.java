package com.company;

import com.company.prt.HttpRouter;
import com.company.prt.exception.EndpointNotFoundException;
import com.company.prt.req.HttpMethod;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    static HttpRouter router = new HttpRouter();
    static AtomicInteger numTests = new AtomicInteger();
    static AtomicInteger successTests = new AtomicInteger();

    public static void main(String[] args) throws Exception {
        testSuccess(HttpMethod.GET, "api/locations", "get_locations");
        testSuccess(HttpMethod.GET, "/api/locations/", "get_locations");
        testSuccess(HttpMethod.GET, "api/internal/locations", "get_internal_locations");
        testSuccess(HttpMethod.GET, "api/locations/123abc", "get_locations_by_id[id:123abc]");
        testSuccess(HttpMethod.GET, "api/locations/search?name=foo", "get_locations_search[name:foo]");
        testSuccess(HttpMethod.GET, "api/locations/123abc/rooms", "get_rooms_by_location_id[locationId:123abc]");
        testSuccess(HttpMethod.GET, "api/locations/123abc/rooms/456def", "get_room_by_id[locationId:123abc,roomId:456def]");

        testNotFound(HttpMethod.GET, "/locations");
        testNotFound(HttpMethod.GET, "api/locations/foo/bar");
        testNotFound(HttpMethod.POST, "api/locations");

        // --
        System.out.println("=======");
        System.out.println(successTests + "/" + numTests + " tests passed");
    }

    static void testNotFound(HttpMethod method, String path) {
        numTests.incrementAndGet();
        System.out.print("-- TEST (expect not found) : " + method.name() + " " + path + " -- ");

        try {
            router.handleRequest(method, path);
            System.out.println("FAIL | request should not have succeeded");
        } catch (EndpointNotFoundException e) {
            System.out.println("PASS");
            successTests.incrementAndGet();
        } catch (Exception e) {
            System.out.println("FAIL | exception=");
            e.printStackTrace(System.out);
        }
    }

    static void testSuccess(HttpMethod method, String path, String expectedResult) {
        numTests.incrementAndGet();
        System.out.print("-- TEST (expect success): " + method.name() + " " + path + " -- ");

        try {
            String actualResult = router.handleRequest(method, path);

            if (expectedResult.equals(actualResult)) {
                System.out.println("PASS");
                successTests.incrementAndGet();
            } else {
                System.out.println("FAIL | expected='" + expectedResult + "' actual='" + actualResult + "'");
            }
        } catch (Exception e) {
            System.out.println("FAIL | exception=");
            e.printStackTrace(System.out);
        }
    }
}
