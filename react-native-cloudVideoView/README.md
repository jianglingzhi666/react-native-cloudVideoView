
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

## 可配置属性
**repeat**</br>
***是否开启循环播放***</br>
* ***false(默认)*** 关闭循环播放</br>
* ***ture*** 开启循环播放</br>

**mode**</br>
***设置视频沾满方式***</br>
* ***cover(默认)*** 将图像等比例缩放，适配最长边，缩放后的宽和高都不会超过显示区域，居中显示，画面可能会留有黑边。</br>
* ***contain*** 将图像等比例铺满整个屏幕，多余部分裁剪掉，此模式下画面不会留黑边，但可能因为部分区域被裁剪而显示不全。 </br>

**bearing**</br>
***设置视频渲染方向***</br>
* ***transverse*** 将视屏设置为横向
* ***vertical(默认)*** 将视频设置为竖向

**src**</br>
***设置视频地址***</br>

**cache**</br>
***设置视屏缓存数量（默认为0）***</br>

**preload**</br>
***是否开启预加载***
* ***false(默认)*** 关闭预加载</br>
* ***ture*** 开启预加载</br>

**onPlayProgress**</br>
***返回播放进度、视频总长度、已加载进度，已毫秒为单位***</br>
* ***duration*** 加载进度
* ***progress*** 播放进度
* ***total*** 视频总长度
