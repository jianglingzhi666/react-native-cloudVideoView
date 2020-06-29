//
//  RNTXVodPlayerView.m
//  video
//
//  Created by jianglingzhi on 2020/6/4.
//

#import "RNTXVodPlayerView.h"
//#import "TXVodPlayListener.h"
@implementation RNTXVodPlayerView
- (instancetype)initWithFrame:(CGRect)frame
{
  self = [super initWithFrame:frame];
  if (self) {
    _player = [[TXVodPlayer alloc] init];
    [_player setupVideoWidget:self insertIndex:0];
    [_player setVodDelegate:self];
  }
  return self;
}
- (void) setSrc:(NSString *)str{ //设置播放路径
  [_player startPlay:str];
}
-(void)setMode:(NSString *)str{ //设置渲染模式
  if([str isEqualToString:@"cover"]){
    [_player setRenderMode:RENDER_MODE_FILL_EDGE];
  }else{
     [_player setRenderMode:RENDER_MODE_FILL_SCREEN];
  }
}
-(void) setBearing:(NSString *)str{//设置屏幕方向
  if([str isEqualToString:@"transverse"]){
    [_player setRenderRotation:HOME_ORIENTATION_RIGHT];
  }else{
    [_player setRenderRotation:HOME_ORIENTATION_UP];
  }
}
-(void) setRate:(float) rate{
   [_player setRate:rate];
}
-(void) setCache:(int)cache{
  if(cache != 0){
    TXVodPlayConfig * _config = [[TXVodPlayConfig alloc] init];
    // 设置缓存路径
    _config.cacheFolderPath =
    [NSSearchPathForDirectoriesInDomains(NSDocumentDirectory, NSUserDomainMask, YES) objectAtIndex:0];

    // 设置最多缓存多少个文件，避免缓存太多数据
    _config.maxCacheItems = cache;

    [_player setConfig: _config];
  }
}
-(void)setPreload:(BOOL)preload{
  _player.isAutoPlay = preload;
}
-(void)setRepeat:(BOOL)repeat{
  _player.loop = repeat;
  self.loop = repeat;
}
-(void) onPlayEvent:(TXVodPlayer *)player event:(int)EvtID withParam:(NSDictionary*)param {
    if (EvtID == PLAY_EVT_PLAY_PROGRESS) {
            // 加载进度, 单位是秒, 小数部分为毫秒
            float duration = [param[EVT_PLAYABLE_DURATION] intValue];
            // 播放进度, 单位是秒, 小数部分为毫秒
            float progress = [param[EVT_PLAY_PROGRESS] intValue];
            // 视频总长, 单位是秒, 小数部分为毫秒
            float total = [param[EVT_PLAY_DURATION] intValue];
            NSDictionary * dic = @{
              @"duration":@(duration),
              @"progress":@(progress),
              @"total":@(total)
            };
            self.onPlayProgress(dic);
    }else{
      NSDictionary * dic = @{
        @"playState":@(EvtID)
      };
      self.onPlayState(dic);
    }
}
-(void) onNetStatus:(TXVodPlayer *)player withParam:(NSDictionary*)param {
  
}
-(void)dealloc{
  [_player stopPlay];
  [_player removeVideoWidget];
}
@end
