package com.thuonglong;

import android.app.Application;

import com.facebook.react.ReactApplication;
//import com.github.wuxudong.rncharts.MPAndroidChartPackage;
import com.horcrux.svg.SvgPackage;
import fr.bamlab.rnimageresizer.ImageResizerPackage;
import com.swmansion.gesturehandler.react.RNGestureHandlerPackage;
import com.imagepicker.ImagePickerPackage;
//import com.reactlibrary.RNTesseractOcrPackage;
import org.reactnative.camera.RNCameraPackage;
import cl.json.RNSharePackage;
import com.RNFetchBlob.RNFetchBlobPackage;
import com.rnfs.RNFSPackage;
//import com.lwansbrough.RCTCamera.RCTCameraPackage;
import org.reactnative.camera.RNCameraPackage;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;

import io.invertase.firebase.RNFirebasePackage;
import io.invertase.firebase.messaging.RNFirebaseMessagingPackage;
import io.invertase.firebase.notifications.RNFirebaseNotificationsPackage;

import java.util.Arrays;
import java.util.List;

public class MainApplication extends Application implements ReactApplication {

  private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
    @Override
    public boolean getUseDeveloperSupport() {
      return BuildConfig.DEBUG;
    }

    @Override
    protected List<ReactPackage> getPackages() {
      return Arrays.<ReactPackage>asList(
          new MainReactPackage(),
            //new MPAndroidChartPackage(),
            new SvgPackage(),
            new ImageResizerPackage(),
            new RNGestureHandlerPackage(),
            new ImagePickerPackage(),
                      new RNSharePackage(),
                      new RNFetchBlobPackage(),
                      new RNFSPackage(),
                      new RNCameraPackage(),
             new RNFirebasePackage(),
             new RNFirebaseMessagingPackage(),
             new RNFirebaseNotificationsPackage()
      );
    }
  };

  @Override
  public ReactNativeHost getReactNativeHost() {
    return mReactNativeHost;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    SoLoader.init(this, /* native exopackage */ false);
  }
}
