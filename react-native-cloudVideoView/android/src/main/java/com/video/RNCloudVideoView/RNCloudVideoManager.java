package com.video.RNCloudVideoView;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

import java.util.HashMap;
import java.util.Map;

import static com.tencent.rtmp.TXLiveConstants.RENDER_MODE_ADJUST_RESOLUTION;
import static com.tencent.rtmp.TXLiveConstants.RENDER_MODE_FULL_FILL_SCREEN;
import static com.tencent.rtmp.TXLiveConstants.RENDER_ROTATION_LANDSCAPE;
import static com.tencent.rtmp.TXLiveConstants.RENDER_ROTATION_PORTRAIT;

public class RNCloudVideoManager extends SimpleViewManager <RNCloudVideoView>{
    ReactApplicationContext mCallerContext;

    public RNCloudVideoManager(ReactApplicationContext reactContext) {
        mCallerContext = reactContext;
    }

    @NonNull
    @Override
    public String getName() {
        return "RNCloudVideoView";
    }

    @NonNull
    @Override
    protected RNCloudVideoView createViewInstance(@NonNull ThemedReactContext reactContext) {
        return new RNCloudVideoView(reactContext);
    }
    @ReactProp(name = "src")
    public void setSrc(RNCloudVideoView view, String src) {
       view.tXLivePlayer.startPlay(src);
       view.tXLivePlayer.pause();
    }
    @ReactProp(name = "mode")
    public void setRenderMode(RNCloudVideoView view, String mode){
        if(mode.equals("cover")){ //剧中
            view.tXLivePlayer.setRenderMode(RENDER_MODE_ADJUST_RESOLUTION);

        }else { //铺满
            view.tXLivePlayer.setRenderMode(RENDER_MODE_FULL_FILL_SCREEN);

        }
    }
    @ReactProp(name = "bearing")
    public void setDirection(RNCloudVideoView view, String direction){
        if(direction.equals("transverse")){ //横向
            view.tXLivePlayer.setRenderRotation(RENDER_ROTATION_LANDSCAPE);
        }else {
            view.tXLivePlayer.setRenderRotation(RENDER_ROTATION_PORTRAIT);
        }
    }
    @ReactProp(name = "rate",defaultInt = 1)
    public void setRate(RNCloudVideoView view, int rate){ //设置播放倍数
       view.tXLivePlayer.setRate(rate);
    }
    @ReactProp(name = "cache",defaultInt = 0)
    public void setCache(RNCloudVideoView view, int length){ //缓存视频数量默认为0
        view.cache(length);
    }
    @ReactProp(name = "preload",defaultBoolean = false)
    public void setPreload(RNCloudVideoView view, boolean preload){
        view.tXLivePlayer.setAutoPlay(preload);
    }
    @ReactProp(name = "repeat", defaultBoolean = false)
    public void setRepeat(RNCloudVideoView view, boolean repeat){
        view.repeat = repeat;
    }
    @Override
    public void onDropViewInstance(@NonNull RNCloudVideoView view) {
        view.destroy();
        super.onDropViewInstance(view);
    }

    public Map getExportedCustomBubblingEventTypeConstants() {
        return MapBuilder.builder()
                .put("onPlayProgress", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onPlayProgress")))
                .put("onPlayState", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onPlayState")))
                .build();
    }

    @Override
    public @Nullable
    Map<String, Integer> getCommandsMap() {
        HashMap map = new HashMap();
        map.put("seek", 0);
        map.put("pause", 1);
        map.put("resume", 2);
        return map;
    }

    @Override
    public void receiveCommand(RNCloudVideoView view, int commandId, @Nullable ReadableArray args) {
        Log.d("触发原生时间",commandId+"");
        switch (commandId){
            case 0:view.tXLivePlayer.seek(args.getInt(0));break;
            case 1:view.tXLivePlayer.pause();break;
            case 2:view.tXLivePlayer.resume();break;
        }
    }
}
