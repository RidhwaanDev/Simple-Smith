package com.ridhwaan.rssfeed.ui.viewmodel;

import android.arch.lifecycle.ViewModel;

import com.ridhwaan.rssfeed.respository.RssXMLRepository;
import com.ridhwaan.rssfeed.model.Feed;

import io.reactivex.Observable;

public class FeedListViewModel extends ViewModel {


    private Observable<Feed> item;
    private RssXMLRepository repo;

    public FeedListViewModel(RssXMLRepository repo){
        this.repo = repo;
    }
    public FeedListViewModel(){
        this.repo = new RssXMLRepository();
    }
    public void init(){
        this.item = repo.getXML();


    }

    public Observable<Feed> getItem(){
        return item;
    }

}
