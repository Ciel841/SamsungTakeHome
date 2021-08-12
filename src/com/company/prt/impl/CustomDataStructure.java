package com.company.prt.impl;

import com.company.prt.req.HttpMethod;

import java.util.HashMap;
import java.util.Map;

public class CustomDataStructure
{
    private HashMap<String,HttpMethod> url_checkers = new HashMap<>();

    public void addEntry(String s, HttpMethod m)
    {
        //So I want to check if there are any params in the url
        int char_index = s.indexOf(':');


    }

    public boolean checkEntry(String path,HttpMethod m)
    {
        return false;
    }

}
