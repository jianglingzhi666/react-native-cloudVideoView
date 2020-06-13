import React from 'react';
import {requireNativeComponent, findNodeHandle, UIManager} from 'react-native';

const RNCloudVideo = requireNativeComponent('RNCloudVideoView');
export default class RNCloudVideoView extends React.Component {
  //调节播放进度
  seek = nubmer => {
    UIManager.dispatchViewManagerCommand(
      findNodeHandle(this.refs.RNCloudVideo),
      UIManager.RNCloudVideoView.Commands['seek'],
      [nubmer],
    );
  };
  //暂停播放
  pause = () => {
    UIManager.dispatchViewManagerCommand(
      findNodeHandle(this.refs.RNCloudVideo),
      UIManager.RNCloudVideoView.Commands['pause'],
      [],
    );
  };
  //继续播放
  resume = () => {
    UIManager.dispatchViewManagerCommand(
      findNodeHandle(this.refs.RNCloudVideo),
      UIManager.RNCloudVideoView.Commands['resume'],
      [],
    );
  };
  render() {
    return <RNCloudVideo ref="RNCloudVideo" {...this.props} />;
  }
}
