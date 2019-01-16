package com.ridhwaan.rssfeed.respository;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.rtp.AudioStream;
import android.provider.MediaStore;

import java.io.IOException;
import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;


public class PodcastStreamerRepository {
    final private MediaPlayer player;



    public PodcastStreamerRepository(){
        player = new MediaPlayer();
        AudioAttributes a = new AudioAttributes.Builder().setContentType(AudioAttributes.CONTENT_TYPE_MUSIC).build();
        player.setAudioAttributes(a);

    }

    public Observable<MediaPlayer> startPlayer(final String path){
            return Observable.defer(new Callable<ObservableSource<MediaPlayer>>() {
                @Override
                public ObservableSource<MediaPlayer> call() throws Exception {
                    // prepare media player and return only when its ready
                    preparePlayer(player, path);
                    return Observable.just(player);
                }
            });
    }

    private static void preparePlayer(final MediaPlayer player, final String path){
        try{
            player.setDataSource(path);
            player.prepare();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
