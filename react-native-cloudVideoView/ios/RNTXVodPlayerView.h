//
//  RNTXVodPlayerView.h
//  video
//
//  Created by jianglingzhi on 2020/6/4.
//

#import <UIKit/UIKit.h>
#import <TXVodPlayer.h>
#import <React/RCTComponent.h>
NS_ASSUME_NONNULL_BEGIN

@interface RNTXVodPlayerView : UIView <TXVodPlayListener>
@property (nonatomic, strong)TXVodPlayer * player;
@property (nonatomic)BOOL  loop;
@property (nonatomic, copy) RCTBubblingEventBlock onPlayProgress;
@property (nonatomic, copy) RCTBubblingEventBlock onPlayState;
@end

NS_ASSUME_NONNULL_END
