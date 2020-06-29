
# react-native-cloud-video-view

## 安装

`$ npm install react-native-cloud-video-view --save`

### React Naitve <= 5.9
`$ react-native link react-native-cloud-video-view`

### 注意 iOS 在Podfile文件添加
`pod 'TXLiteAVSDK_Professional', :podspec => 'http://pod-1252463788.cosgz.myqcloud.com/liteavsdkspec/TXLiteAVSDK_Professional.podspec'`




## 用法
```javascript
import RNCloudVideoView from 'react-native-cloud-video-view';
<RNCloudVideoView
   ref="RNCloudVideoView"
   bearing="transverse" //视频方向
   mode="cover" //沾满方式
   repeat={true} //是否循环播放
   src="https://media.w3.org/2010/05/sintel/trailer.mp4" //视频地址
   style={{flex: 1, zIndex: 1}}
   />
```
  
