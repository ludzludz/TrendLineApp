package com.cjp.controller;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/* 
 * Created by ldziedzic on 2015-07-20.
 */
public class CompanyData {
    Map<String, String> companies = new TreeMap<String, String>();

    CompanyData(){
        companies.put("Apple Inc.", "AAPL");
        companies.put("Google Inc.", "GOOGL");
        companies.put("Microsoft Corporation", "MSFT");
        companies.put("Oracle Corporation", "ORCL");
        companies.put("International Business Machines Corporation", "IBM");
    }
    public Map<String, String> getCompanies(){
        return Collections.unmodifiableMap(companies);
    }
}