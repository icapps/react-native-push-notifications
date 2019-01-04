
# react-native-push-notifications

## Getting started

`$ npm install react-native-push-notifications --save`

### Mostly automatic installation

`$ react-native link react-native-push-notifications`

### Manual installation

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNPushNotificationsPackage;` to the imports at the top of the file
  - Add `new RNPushNotificationsPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-push-notifications'
  	project(':react-native-push-notifications').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-push-notifications/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-push-notifications')
  	```

## Usage
```javascript
import RNPushNotifications from 'react-native-push-notifications';

RNPushNotifications;
```

## Advanced use

### In combination with Kotlin

export a variable
`kotlinVersion` in your gradle variables (mostly build.gradle)

  
