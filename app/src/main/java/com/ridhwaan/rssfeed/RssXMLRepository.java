package com.ridhwaan.rssfeed;

import android.util.Log;

import com.ridhwaan.rssfeed.model.Feed;
import com.ridhwaan.rssfeed.model.FeedListItem;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class RssXMLRepository {

    private RssService rssService;

    public RssXMLRepository(){
        Retrofit r = new Retrofit.Builder()
                .baseUrl("https://www.reddit.com/r/jokes/")
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

                rssService = r.create(RssService.class);

    }

    public void test()  {



        Observable<Feed> items = rssService.getObservableRssFeed("http://lukesmith.xyz/rss.xml");
        Log.d("ABC" , "MAKIGN REQUEST");
        items.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(result ->
                               Observable.fromIterable(result.getmChannel().getItems())
                                 .map( obj -> Log.d("ABC", "   RESULT   " +  obj.getTitle())).subscribe());


    }




    public Observable<Feed> getXML() {
        Observable<Feed> items = rssService.getObservableRssFeed("http://lukesmith.xyz/rss.xml");
        return items.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());

    }
//                Observable.fromIterable(result.getmChannel().getItems())
//                        .map( obj -> Log.d("ABC", "   RESULT   " +  obj.getTitle())).subscribe());

}
