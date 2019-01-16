package com.ridhwaan.rssfeed.model;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import java.util.List;

@Root(name = "channel", strict = false)
public class FeedChannel {

    @ElementList(inline = true, name = "item")
    public List<FeedListItem> items;

    public FeedChannel(){

    }

    public FeedChannel(List<FeedListItem> items){
            this.items = items;
    }

    public List<FeedListItem> getItems() {
        return items;
    }
}
