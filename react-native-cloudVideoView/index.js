import React from 'react';
import {requireNativeComponent, findNodeHandle, UIManager} from 'react-native';
import PropTypes from 'prop-types';

const RNCloudVideo = requireNativeComponent('RNCloudVideoView');
RNCloudVideoView.prototype = {
  repeat:PropTypes.bool,
  mode:PropTypes.string,
  mode:PropTypes.string,
  cache:PropTypes.number,
  preload:PropTypes.bool,
  rate:PropTypes.number,
  onPlayProgress:PropTypes.func,
  onPlayState:PropTypes.func,
  src:PropTypes.string
}
export default class RNCloudVideoView extends React.Component {
  static defaultProps={
    repeat: false,
    mode:"cover",
    bearing:"vertical",
    cache:0,
    preload:false,
    rate:1.0,
    onPlayProgress:()=>{},
    onPlayState:()=>{}
   }
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
    const {
      repeat,
      mode,
      mode,
      cache,
      preload,
      rate,
      onPlayProgress,
      onPlayState,
      src,
      ...props
    }=this.props
    return <RNCloudVideo ref="RNCloudVideo" 
    repeat
    mode
    mode
    cache
    preload
    rate
    onPlayProgress={(event)=>{
      onPlayProgress(event.nativeEvent)
    }}
    onPlayState={(event)=>{
      onPlayState(event.nativeEvent)
    }}
    src 
    {...props} />;
  }
}
