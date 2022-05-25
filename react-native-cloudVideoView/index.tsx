import React from 'react'
import { requireNativeComponent, findNodeHandle, UIManager, ViewStyle } from 'react-native'

const RNCloudVideo = requireNativeComponent('RNCloudVideoView')

interface videoProgress {
  duration: number
  progress: number
  total: number
}
interface RNCloudVideoViewProps {
  repeat?: Boolean
  mode?: 'cover' | 'contain'
  bearing?: 'vertical' | 'transverse'
  cache?: number
  rate?: number
  onPlayProgress?: (event: videoProgress) => {}
  onPlayState?: (state: number) => {}
  src: string
  paused?: Boolean
  style: ViewStyle
}
export default class RNCloudVideoView extends React.Component<RNCloudVideoViewProps, any> {
  static defaultProps = {
    repeat: false,
    mode: 'cover',
    bearing: 'vertical',
    cache: 0,
    preload: false,
    rate: 1.0,
    onPlayProgress: () => { },
    onPlayState: () => { },
    paused: false
  }
  //调节播放进度
  seek = (nubmer: number) => {
    UIManager.dispatchViewManagerCommand(findNodeHandle(this.refs.RNCloudVideo), UIManager.RNCloudVideoView.Commands.seek, [nubmer])
  }
  //暂停播放
  pause = () => {
    UIManager.dispatchViewManagerCommand(findNodeHandle(this.refs.RNCloudVideo), UIManager.RNCloudVideoView.Commands.pause, [])
  }
  //继续播放
  resume = () => {
    UIManager.dispatchViewManagerCommand(findNodeHandle(this.refs.RNCloudVideo), UIManager.RNCloudVideoView.Commands.resume, [])
  }
  render() {
    const { onPlayProgress, onPlayState, ...other } = this.props
    return (
      <RNCloudVideo
        ref="RNCloudVideo"
        onPlayProgress={event => {
          onPlayProgress && onPlayProgress(event.nativeEvent)
        }}
        onPlayState={event => {
          onPlayState && onPlayState(event.nativeEvent)
        }}
        {...other}
      />
    )
  }
}
