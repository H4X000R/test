package com.mike.jsontest;

public class ExampleItem {

    private String mTitle;
    private String mUrl;


    public ExampleItem (String Title, String Url){
        mTitle = Title;
        mUrl = Url;
    }

    public String getTitle(){
         return  mTitle;

    }

    public String getUrl(){
        return mUrl;
    }
}
