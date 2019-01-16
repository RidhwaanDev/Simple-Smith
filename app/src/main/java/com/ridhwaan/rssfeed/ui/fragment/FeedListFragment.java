package com.ridhwaan.rssfeed.ui.fragment;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ridhwaan.rssfeed.R;
import com.ridhwaan.rssfeed.model.RssAdapter;
import com.ridhwaan.rssfeed.ui.viewmodel.FeedListViewModel;
import com.ridhwaan.rssfeed.ui.viewmodel.StreamerViewModel;

public class FeedListFragment extends Fragment {
    private static final String UID_KEY = "uid";

    private FeedListViewModel viewModel;
    private StreamerViewModel streamerViewModel;

    private RecyclerView mRVRssFeed;
    private LinearLayoutManager mLinearLayoutManager;
    private RssAdapter mAdapter;
    private static final String STREAM_URL = "https://hwcdn.libsyn.com/p/e/9/2/e923e00e5b515c86/S01E07_-_" +
            "Human_Evolution_Revised_Timelines_and_Multiregionalism.mp3" +
            "?c_id=29581166&cs_id=29581166&expiration=1547670748&hwt=9dbc43900e81b3ca68de98549449a4a7";


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
            streamerViewModel.prepareWith(STREAM_URL);
            streamerViewModel.startMediaPlayer().subscribe(o -> o.start());
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
