### React-Native Template with Native Base

### Introduction

> Thượng Long Company


### Installation

> Follow these steps to install and test the app:

```
git clone git@github.com:ATF19/react-native-shop-ui.git
cd react-native-shop-ui
npm install
npm install react-native-woocommerce-api --save

```

> For iOS users:

```
react-native run-ios
```

> For Android users

```
react-native run-android
```
build release
```
react-native bundle --platform android --dev false --entry-file index.android.js --bundle-output android/app/src/main/assets/index.android.bundle --assets-dest android/app/src/main/res/
cd android
gradlew clean
gradlew assembleRelease
```


## Reference

https://github.com/Michaelvilleneuve/react-native-document-scanner
https://github.com/kevin3274/react-native-odoo
https://www.odoo.com/documentation/9.0/reference/orm.html#openerp.models.Model.search
https://snack.expo.io/@rafah-mehfooz/network-requests-with-fetch
https://snack.expo.io/yXR_PueN!
https://snack.expo.io/@rapture112/react-native-svg-charts
https://v5.rnfirebase.io/docs/v5.x.x/installation/android

https://medium.com/@hitensharma1515/create-chart-in-react-native-and-load-dynamic-data-d2e203fad7e3
https://medium.com/skyshidigital/make-chart-in-react-native-671910254e9b
https://medium.com/the-react-native-log/animated-charts-in-react-native-using-d3-and-art-21cd9ccf6c58
https://snack.expo.io/embedded/@aboutreact/react-native-chart-kit?preview=true&platform=ios&iframeId=t099o2svbu&theme=dark
https://stackoverflow.com/questions/40145301/preventing-hardware-back-button-android-for-react-native
https://aboutreact.com/react-native-get-current-date-time/
https://stackoverflow.com/questions/51040637/datepicker-nativebase-format-of-the-picked-date
https://github.com/vishaldhanotiya/react-native-modal-picker

https://kipalog.com/posts/Mot-so-thu-thuat-toi-uu-ung-dung-React-Native-nen-biet
https://viblo.asia/p/mot-vai-tips-su-dung-flatlist-de-cai-tien-performance-trong-react-native-gAm5yBwAKdb
https://medium.com/sanjagh/how-to-optimize-your-react-native-flatlist-946490c8c49b

## Documentation

Updating the codebase will require changes to the `.js` files in the [src/](./src/) folder. Individual pages can be edited by editing the `.js` files in [src/page/](./src/page/). Re-usable components can be edited by editing the `.js` files in [src/component/](./src/component/).

To contribute your changes to the main repository, create a pull request from your fork [here](https://github.com/ATF19/react-native-shop-ui/compare?expand=1) (click the `compare across forks` link make your repository the source repository)
> crash app release 
- https://medium.com/@impaachu/react-native-android-release-build-crash-on-device-14f2c9eacf18
> build release error
- https://medium.com/beesightsoft/react-native-build-release-error-uncompiled-png-file-passed-as-argument-431f0f7baa72

> woocommerce-api 
- https://github.com/sabarnix/woocommerce-api 
- https://github.com/minhcasi/react-native-woocommerce/blob/master/example/Product.js
- http://woocommerce.github.io/woocommerce-rest-api-docs/#list-all-products
- https://stackoverflow.com/questions/48163307/woocommerce-rest-api-product-filters-how-it-works

> note
- gen unique key={new Date().valueOf()} to re-render menu

- react-native link react-native-fs
- react-native bundle --platform android --dev true --entry-file index.android.js --bundle-output android/app/src/main/assets/index.android.bundle --assets-dest android/app/src/main/res/
