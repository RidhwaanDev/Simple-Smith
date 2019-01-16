package com.ridhwaan.rssfeed.ui.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.media.MediaPlayer;

import com.ridhwaan.rssfeed.respository.PodcastStreamerRepository;

import io.reactivex.Observable;


public class StreamerViewModel extends ViewModel {

    private PodcastStreamerRepository mStreamer;
    private Observable<MediaPlayer> mediaPlayerObservable;

    public StreamerViewModel(){
    }

    public void init(){
        this.mStreamer = new PodcastStreamerRepository();
    }

    public void prepareWith(String stream){
        this.mediaPlayerObservable = mStreamer.startPlayer(stream);
    }

    public Observable<MediaPlayer> startMediaPlayer(){
        return mediaPlayerObservable;
    }

}
