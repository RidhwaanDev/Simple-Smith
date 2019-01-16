package com.ridhwaan.rssfeed.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.io.Serializable;
import java.util.List;

@Root(name="item", strict = false)
public class FeedListItem implements Serializable {

    @Element(name = "title")
    private String title;
    @Element(name ="description")
    private String description;
    @Element(name = "pubDate")
    private String pubDate;


    public FeedListItem(String title, String date, String content) {
        this.title = title;
        this.pubDate = date;
        this.description = content;

    }

    public FeedListItem(){

    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return pubDate;
    }



    public String getContent() {
        return description;
    }


}
