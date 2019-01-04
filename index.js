import { DeviceEventEmitter, NativeModules, Platform } from 'react-native';

const RNPushNotification = Platform.OS === 'ios' ? {} : NativeModules.RnPushNotificationsModule;

export default RNPushNotification;
