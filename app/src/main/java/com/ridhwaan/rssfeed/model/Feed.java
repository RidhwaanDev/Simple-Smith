package com.ridhwaan.rssfeed.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;

@Root(name="rss", strict = false)
public class Feed implements Serializable {
    @Element(name = "channel")
    private FeedChannel mChannel;

    public FeedChannel getmChannel(){
        return mChannel;
    }

    public Feed(){

    }

    public Feed(FeedChannel mChannel){
         this.mChannel = mChannel;
    }

}
