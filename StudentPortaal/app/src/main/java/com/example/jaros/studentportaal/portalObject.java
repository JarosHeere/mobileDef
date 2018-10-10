package com.example.jaros.studentportaal;

import java.io.Serializable;

public class portalObject implements Serializable{

    private String title;
    private String url;


    public portalObject(String title, String url) {
        this.title = title;
        this.url = url;
    }
    public String getTitle() {
        return title;
    }
    public String getUrl() {
        return url;
    }
}
