//
//  RNTXVodPlayerViewManager.m
//  video
//
//  Created by jianglingzhi on 2020/6/4.
//

#import "RNTXVodPlayerViewManager.h"

@implementation RNTXVodPlayerViewManager
RCT_EXPORT_MODULE(RNCloudVideoView)
- (UIView *)view{
  
  return [[RNTXVodPlayerView alloc] init];
}
//RCT_EXPORT_VIEW_PROPERTY(preload, BOOL)
RCT_EXPORT_VIEW_PROPERTY(src, NSString)
RCT_EXPORT_VIEW_PROPERTY(mode, NSString)
RCT_EXPORT_VIEW_PROPERTY(bearing, NSString)
RCT_EXPORT_VIEW_PROPERTY(rate, float)
RCT_EXPORT_VIEW_PROPERTY(cache, int)
RCT_EXPORT_VIEW_PROPERTY(repeat, BOOL)
RCT_EXPORT_VIEW_PROPERTY(paused, BOOL)
RCT_EXPORT_VIEW_PROPERTY(onPlayProgress, RCTBubblingEventBlock)
RCT_EXPORT_VIEW_PROPERTY(onPlayState, RCTBubblingEventBlock)

RCT_EXPORT_METHOD(seek:(nonnull NSNumber *)reactTag y:(NSInteger)time) {
  [self.bridge.uiManager addUIBlock:^(RCTUIManager *uiManager, NSDictionary<NSNumber *,UIView *> *viewRegistry) {
   RNTXVodPlayerView * vodPlayerView = (RNTXVodPlayerView *) viewRegistry[reactTag];
    [vodPlayerView.player seek:time];
  }];
}
RCT_EXPORT_METHOD(pause:(nonnull NSNumber *)reactTag) {
  [self.bridge.uiManager addUIBlock:^(RCTUIManager *uiManager, NSDictionary<NSNumber *,UIView *> *viewRegistry) {
   RNTXVodPlayerView * vodPlayerView = (RNTXVodPlayerView *) viewRegistry[reactTag];
    [vodPlayerView.player pause];
  }];
}
RCT_EXPORT_METHOD(resume:(nonnull NSNumber *)reactTag) {
  [self.bridge.uiManager addUIBlock:^(RCTUIManager *uiManager, NSDictionary<NSNumber *,UIView *> *viewRegistry) {
   RNTXVodPlayerView * vodPlayerView = (RNTXVodPlayerView *) viewRegistry[reactTag];
    [vodPlayerView.player resume];
  }];
}
@end
