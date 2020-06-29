
# react-native-cloud-video-view

## 安装

`$ npm install react-native-cloud-video-view --save`

### Mostly automatic installation

`$ react-native link react-native-cloud-video-view`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-cloud-video-view` and add `RNCloudVideoView.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNCloudVideoView.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.video.RNCloudVideoView.RNCloudVideoViewPackage;` to the imports at the top of the file
  - Add `new RNCloudVideoViewPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-cloud-video-view'
  	project(':react-native-cloud-video-view').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-cloud-video-view/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-cloud-video-view')
  	```


## Usage
```javascript
import RNCloudVideoView from 'react-native-cloud-video-view';

// TODO: What to do with the module?
RNCloudVideoView;
```
  
