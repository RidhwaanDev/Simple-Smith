package com.ridhwaan.rssfeed;

import android.arch.lifecycle.ViewModel;
import android.media.MediaPlayer;

import io.reactivex.Observable;


public class StreamerViewModel extends ViewModel {

    private PodcastStreamerRepository mStreamer;
    private Observable<MediaPlayer> mediaPlayerObservable;

    public StreamerViewModel(){
        this.mStreamer = new PodcastStreamerRepository();
    }

    public void init(){
        this.mediaPlayerObservable = mStreamer.getPlayer();
    }

    public Observable<MediaPlayer> getMediaPlayerObservable(){
        return mediaPlayerObservable;
    }

}
