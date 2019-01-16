package com.ridhwaan.rssfeed.model;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ridhwaan.rssfeed.R;

import java.util.List;

public class RssAdapter extends RecyclerView.Adapter<RssAdapter.RSSViewItemHolder> {

    private List<FeedListItem> mDataSet;

    // ViewHolder represents the actual view object
    public static class RSSViewItemHolder extends RecyclerView.ViewHolder {

        public TextView mTitle;
        public RSSViewItemHolder(@NonNull View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.tv_title_item_view);

        }

        public void bindData(FeedListItem item){
            mTitle.setText(item.getTitle());
        }
    }


    public RssAdapter(List<FeedListItem> mDataSet){
        this.mDataSet = mDataSet;
    }


    @NonNull
    @Override
    public RSSViewItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_view,viewGroup,false);
        RSSViewItemHolder vh = new RSSViewItemHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RSSViewItemHolder rssViewItemHolder, int i) {
        rssViewItemHolder.bindData(mDataSet.get(i));
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}
