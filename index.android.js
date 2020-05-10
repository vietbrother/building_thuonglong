/**
* This is the start point of the app on the Android platform
* You can ignore this file since it only links to the src/Main.js file
**/

import { AppRegistry, Platform } from 'react-native';
import Main from './src/Main';
import BackgroundMessageFirebase from './src/services/BackgroundMessageFirebase';
import './polyfills.js';

if (Platform.OS === 'android') {
    if (typeof Symbol === 'undefined') {
        if (Array.prototype['@@iterator'] === undefined) {
            Array.prototype['@@iterator'] = function () {
                let i = 0;
                return {
                    next: () => ({
                        done: i >= this.length,
                        value: this[i++],
                    }),
                };
            };
        }
    }
}

AppRegistry.registerComponent('ThuongLongJSC', () => Main);
AppRegistry.registerHeadlessTask('RNFirebaseBackgroundMessage', () => BackgroundMessageFirebase);
