
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
***设置视频缓存数量（默认为0）***</br>

**

**preload**</br>
***是否开启预加载***
* ***false(默认)*** 关闭预加载</br>
* ***ture*** 开启预加载</br>

**rate**</br>
***设置播放倍数默认为1.0***

**onPlayProgress**</br>
***返回一个JSON对象包含 播放进度、视频总长度、已加载进度，已毫秒为单位***</br>
* ***duration*** 加载进度
* ***progress*** 播放进度
* ***total*** 视频总长度

**onPlayState**</br>
***返回视频播放状态***</br>
* ***2004*** 视频播放开始
* ***2007*** 视频播放loding
* ***2014*** loding结束视频继续播放
* ***2006*** 视频播放结束
* ***-2301*** 网络断连，且经多次重连亦不能恢复，更多重试请自行重启播放
* ***2101***  当前视频帧解码失败
* ***2102***  当前音频帧解码失败
* ***2103***  网络断连，已启动自动重连（重连超过三次就直接抛送 -2301 了）
* ***2106***  硬解启动失败，采用软解
* ***2013***  播放器已准备完成，可以播放
* ***2003***  网络接收到首个可渲染的视频数据包


## 方法

**pause()** 暂停播放</br>
**resume()** 继续播放</br>
**seek(time)**  设置播放进度,参数以秒为单位float类型</br>
