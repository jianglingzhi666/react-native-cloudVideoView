//
//  RNCloudVideoView.h
//  RNCloudVideoView
//
//  Created by jianglingzhi on 2020/6/28.
//  Copyright © 2020 jianglingzhi. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface RNCloudVideoView : UIView <TXVodPlayListener>
@property (nonatomic, strong)TXVodPlayer * player;
@property (nonatomic)BOOL  loop;
@property (nonatomic, copy) RCTBubblingEventBlock onPlayProgress;
@property (nonatomic, copy) RCTBubblingEventBlock onPlayState;
@end
