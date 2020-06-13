package com.video.RNCloudVideoView;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.util.AttributeSet;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.tencent.rtmp.ITXVodPlayListener;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.rtmp.TXVodPlayConfig;
import com.tencent.rtmp.TXVodPlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;

import static com.tencent.rtmp.TXLiveConstants.PLAY_ERR_NET_DISCONNECT;
import static com.tencent.rtmp.TXLiveConstants.PLAY_EVT_PLAY_END;
import static com.tencent.rtmp.TXLiveConstants.PLAY_EVT_PLAY_LOADING;
import static com.tencent.rtmp.TXLiveConstants.PLAY_EVT_PLAY_PROGRESS;
import static com.tencent.rtmp.TXLiveConstants.PLAY_EVT_VOD_LOADING_END;

public class RNCloudVideoView extends TXCloudVideoView{
    public TXVodPlayer tXLivePlayer;
    public boolean repeat;
    public RNCloudVideoView(Context context) {
        super(context);
        tXLivePlayer = new TXVodPlayer(context);
        tXLivePlayer.setPlayerView(this);
        this.addTXVodPlayerListener();
    }

    public RNCloudVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        tXLivePlayer = new TXVodPlayer(context);
        tXLivePlayer.setPlayerView(this);
        this.addTXVodPlayerListener();
    }

    public void destroy() {
        tXLivePlayer.stopPlay(true); // true 代表清除最后一帧画面
        tXLivePlayer = null;
        this.onDestroy();
    }
    public void cache(int length){
        if(length != 0){
            //指定一个本地mp4缓存目录
            TXVodPlayConfig mConfig = new TXVodPlayConfig();
            mConfig.setCacheFolderPath(Environment.getExternalStorageDirectory().getPath() +"/txcache");
            //指定本地最多缓存多少文件，避免缓存太多数据
            mConfig.setMaxCacheItems(length);
            tXLivePlayer.setConfig(mConfig);
        }
    }
    public void addTXVodPlayerListener(){
        tXLivePlayer.setVodListener(new ITXVodPlayListener(){

            @Override
            public void onPlayEvent(TXVodPlayer txVodPlayer, int event, Bundle bundle) {
                if (event == PLAY_EVT_PLAY_PROGRESS) {
                    // 加载进度, 单位是秒
                    float duration = bundle.getInt(TXLiveConstants.EVT_PLAYABLE_DURATION_MS) / 1000;
                    // 播放进度, 单位是秒
                    float progress = bundle.getInt(TXLiveConstants.EVT_PLAY_PROGRESS_MS) / 1000;
                    // 视频总长, 单位是秒
                    float total = bundle.getInt(TXLiveConstants.EVT_PLAY_DURATION_MS) / 1000;
                    //回调事件给rn
                    WritableMap map = Arguments.createMap();
                    map.putString("duration", duration + "");
                    map.putString("progress", progress + "");
                    map.putString("total", total + "");
                    playProgress(map);
                }else{
                    if(event == PLAY_EVT_PLAY_END){//播放结束重复播放
                        if(repeat){
                            tXLivePlayer.seek(0);
                            txVodPlayer.resume();
                        }
                    }
                    WritableMap state = Arguments.createMap();
                    state.putString("playState",event+"");
                    playState(state);
                }

            }

            @Override
            public void onNetStatus(TXVodPlayer txVodPlayer, Bundle bundle) {

            }
        });
    }
    public void playProgress( WritableMap map) {
        ReactContext reactContext = (ReactContext)getContext();
        reactContext.getJSModule(RCTEventEmitter.class).receiveEvent(
                getId(),
                "onPlayProgress",
                map);
    }
    public void playState(WritableMap map){
        ReactContext reactContext = (ReactContext)getContext();
        reactContext.getJSModule(RCTEventEmitter.class).receiveEvent(
                getId(),
                "onPlayState",
                map);
    }
}
