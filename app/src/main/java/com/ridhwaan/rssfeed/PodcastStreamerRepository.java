package com.ridhwaan.rssfeed;

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
    private static final String STREAM_URL = "https://hwcdn.libsyn.com/p/e/9/2/e923e00e5b515c86/S01E07_-_" +
            "Human_Evolution_Revised_Timelines_and_Multiregionalism.mp3" +
            "?c_id=29581166&cs_id=29581166&expiration=1547670748&hwt=9dbc43900e81b3ca68de98549449a4a7";



    public PodcastStreamerRepository(){
        player = new MediaPlayer();
        AudioAttributes a = new AudioAttributes.Builder().setContentType(AudioAttributes.CONTENT_TYPE_MUSIC).build();
        player.setAudioAttributes(a);

    }

    public Observable<MediaPlayer> getPlayer(){
            return Observable.defer(new Callable<ObservableSource<MediaPlayer>>() {
                @Override
                public ObservableSource<MediaPlayer> call() throws Exception {
                    // prepare media player
                    preparePlayer(player);
                    return Observable.just(player);
                }
            });


    }

    private static void preparePlayer(final MediaPlayer player){
        try{
            player.setDataSource(STREAM_URL);
            player.prepare();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
