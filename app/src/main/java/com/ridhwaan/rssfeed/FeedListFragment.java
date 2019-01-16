package com.ridhwaan.rssfeed;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ridhwaan.rssfeed.model.RssAdapter;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class FeedListFragment extends Fragment {
    private static final String UID_KEY = "uid";

    private FeedListViewModel viewModel;
    private StreamerViewModel streamerViewModel;

    private RecyclerView mRVRssFeed;
    private LinearLayoutManager mLinearLayoutManager;
    private RssAdapter mAdapter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
            viewModel = ViewModelProviders.of(this).get(FeedListViewModel.class);
            viewModel.init();
            viewModel.getItem().subscribe(
                result -> {
                    mAdapter = new RssAdapter(result.getmChannel().getItems());
                    mRVRssFeed.setAdapter(mAdapter);

                }
        );

            streamerViewModel = ViewModelProviders.of(this).get(StreamerViewModel.class);
            streamerViewModel.init();
            streamerViewModel.getMediaPlayerObservable().subscribe(o -> o.start());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_feedlist,container,false);
        mRVRssFeed = v.findViewById(R.id.rv_rss_feed);
        mRVRssFeed.setHasFixedSize(true);

        mLinearLayoutManager = new LinearLayoutManager(getActivity());
        mRVRssFeed.setLayoutManager(mLinearLayoutManager);



        return v;
    }
}
