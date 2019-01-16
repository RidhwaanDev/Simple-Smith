package com.ridhwaan.rssfeed.api;


import com.ridhwaan.rssfeed.model.Feed;
import com.ridhwaan.rssfeed.model.FeedListItem;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface RssService {

    @GET("/{api}}")
    Observable<FeedListItem> getFeed(@Path("api") String api);
    @GET()
    Call<Feed> getRssFeed(@Url String url);
    @GET()
    Observable<Feed> getObservableRssFeed(@Url String url);
    @GET()
    Observable<Feed> getSingleRssFeed(@Url String url);




}
