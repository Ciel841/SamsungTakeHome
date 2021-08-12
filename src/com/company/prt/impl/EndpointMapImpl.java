package com.company.prt.impl;

import com.company.prt.req.Context;
import com.company.prt.EndpointMap;
import com.company.prt.exception.EndpointNotFoundException;
import com.company.prt.impl.Endpoint.Endpoint;
import com.company.prt.impl.Endpoint.GetLocations;
import com.company.prt.req.HttpMethod;
import com.company.prt.req.Request;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EndpointMapImpl extends EndpointMap {

    private HashSet<String> endpoints = new HashSet<>();


    @Override
    public void addEndpoint(Endpoint endpoint) {
        // TODO: IMPLEMENT ME!


    }

    @Override
    public Endpoint getEndpoint(Request request) {
        // TODO: IMPLEMENT ME!
        //First Lets Restructure the request
        HttpMethod m = request.getMethod();
        String rawPath = request.getRawPath();
        if(rawPath.charAt(0) == '/')
        {
            rawPath = rawPath.substring(1);
        }
        //lets validate the request urls
        String regex = "^api/";
        Pattern p = Pattern.compile(regex);
        Matcher ma = p.matcher(rawPath);
        System.out.println(ma.matches());

        return null;
    }

}
