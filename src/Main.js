/**
 * This is the Main file
 * This file contains the routes of all the pages
 **/

// React native and others libraries imports
import React, {Component} from 'react';
import {BackHandler, AsyncStorage, Alert} from 'react-native';
import {Root} from 'native-base';
import {Scene, Router, Actions} from 'react-native-router-flux';


// Our custom files and classes import
import Home from './page/Home';
import Homepage from './page/Homepage';
import Search from './page/Search';
import Cart from './page/Cart';
import WishList from './page/WishList';
// import Map from './page/Map';
import Newsletter from './page/Newsletter';
import Contact from './page/Contact';
import Category from './page/Category';
import Product from './page/Product';
import ImageGallery from './page/ImageGallery';
import Login from './page/Login';
import Signup from './page/Signup';
import Checkout from './page/Checkout';
import Profile from './page/Profile';

// import WooCommerceAPI from 'react-native-woocommerce-api';
import WooCommerceAPI from './WooCommerce/WooCommerceAPI';
import OrderItem from "./component/OrderItem";
import Orders from "./page/Orders";
import Config from "./Config";

import Camera from "./component/Camera/Camera";
import Verify from "./component/Verify/Verify";
import Odoo from "./Odoo";
import CameraScanner from "./component/Camera/CameraScanner";
import CameraScannerList from "./component/Camera/CameraScannerList";
import StockAdd from "./component/Stock/StockAdd";
import FlowItem from "./component/Flow/FlowItem";
import StockOut from "./component/Stock/StockOut";
import StockOutMultiple from "./component/Stock/StockOutMultiple";
import Customers from "./component/Customer/Customers";
import CustomerAdd from "./component/Customer/CustomerAdd";
import CustomerDetail from "./component/Customer/CustomerDetail";
import Devices from "./component/Device/Devices";
import DeviceDetail from "./component/Device/DeviceDetail";
import OrderList from "./component/Orders/Orders";
import OrderDetail from "./component/Orders/OrderDetail";
import Bill from "./component/Bill/Bill";
import Statistic from "./component/Statistic/StatisticDaily";
import StockOutMultipleManual from "./component/Stock/StockOutMultipleManual";
import ManualScannerList from "./component/Manual/ManualScannerList";
import StockInList from "./component/Stock/StockInList";
import StockInOutList from "./component/Stock/StockInOutList";
import BillList from "./component/Bill/BillList";

import firebase from 'react-native-firebase';
import ContractConcreteDetail from "./component/ContractConcrete/ContractConcreteDetail";
import ContractConcretes from "./component/ContractConcrete/ContractConcretes";
import CalendarConcretes from "./component/CalendarConcrete/CalendarConcretes";
import CalendarConcreteDetail from "./component/CalendarConcrete/CalendarConcreteDetail";
import ContractMaterials from "./component/ContractMaterial/ContractMaterials";
import ContractMaterialDetail from "./component/ContractMaterial/ContractMaterialDetail";
import ContractBricks from "./component/ContractBrick/ContractBricks";
import ContractBrickDetail from "./component/ContractBrick/ContractBrickDetail";
import ContractBrickTerrazos from "./component/ContractBrickTerrazo/ContractBrickTerrazos";
import ContractBrickTerrazoDetail from "./component/ContractBrickTerrazo/ContractBrickTerrazoDetail";
import ContractBrickTiles from "./component/ContractBrickTiles/ContractBrickTiles";
import ContractBrickTilesDetail from "./component/ContractBrickTiles/ContractBrickTilesDetail";
import BricksContracts from "./component/BricksContracts/BricksContracts";
import BricksContractDetail from "./component/BricksContracts/BricksContractDetail";
import CalendarBricks from "./component/CalendarBrick/CalendarBricks";
import CalendarBrickDetail from "./component/CalendarBrick/CalendarBrickDetail";
import CalendarConcreteAdd from "./component/CalendarConcrete/CalendarConcreteAdd";
import CalendarBrickAdd from "./component/CalendarBrick/CalendarBrickAdd";

export default class Main extends Component {

    constructor() {
        super();
        // global.WooCommerceAPI = new WooCommerceAPI({
        //   url: 'http://103.94.18.249/jstore', // Your store URL
        //   ssl: false,
        //   consumerKey: 'ck_155068b58dd6614b3ace920437df62399bb94503', // Your consumer secret
        //   consumerSecret: 'cs_9fb0b186ea0024bd6d9d497715e88e43b1bf2b6e', // Your consumer secret
        //   //consumerKey: 'ck_29b281d2af61df58dadbeead327b06dd9a53f1be', // Your consumer secret
        //   //consumerSecret: 'cs_a6d53b6572240d483749ee0123d48c76332c0e0d', // Your consumer secret
        //   wpAPI: true, // Enable the WP REST API integration
        //   version: 'wc/v3', // WooCommerce WP REST API version
        //   queryStringAuth: true
        // });
        global.WooCommerceAPI = new WooCommerceAPI({
            // url: 'http://103.94.18.249/jstore', // Your store URL
            //consumerKey: 'ck_155068b58dd6614b3ace920437df62399bb94503', // Your consumer secret
            //consumerSecret: 'cs_9fb0b186ea0024bd6d9d497715e88e43b1bf2b6e', // Your consumer secret
            url: Config.url, // Your store URL
            consumerKey: Config.consumerKey, // Your consumer secret
            consumerSecret: Config.consumerSecret, // Your consumer secret
            // ssl: false,
            //consumerKey: 'ck_29b281d2af61df58dadbeead327b06dd9a53f1be', // Your consumer secret
            //consumerSecret: 'cs_a6d53b6572240d483749ee0123d48c76332c0e0d', // Your consumer secret
            wpAPI: true, // Enable the WP REST API integration
            version: 'wc/v3', // WooCommerce WP REST API version
            queryStringAuth: true
        });

        global.hostAPI = [Config.api.url];
        console.log(global.hostAPI);
        // global.odooAPI = new Odoo({
        //   host: Config.odooUrl,
        //   port: Config.odooPort,
        //   database: Config.odooDb,
        //   username: Config.odooUser,
        //   password: Config.odooPass
        // });
    }

    componentWillMount = () => {
        BackHandler.addEventListener('hardwareBackPress', () => Actions.pop());
    };

    async componentDidMount() {
        this.checkPermission();
        this.createNotificationListeners(); //add this line
    }

    //1
    async checkPermission() {
        const enabled = await firebase.messaging().hasPermission();
        console.log("=======================================================================================");
        console.log(enabled);
        if (enabled) {
            this.getToken();
        } else {
            this.requestPermission();
        }
    }

    //3
    async getToken() {
        let fcmToken = await AsyncStorage.getItem('fcmToken');
        if (!fcmToken) {
            fcmToken = await firebase.messaging().getToken();
            if (fcmToken) {
                // user has a device token
                await AsyncStorage.setItem('fcmToken', fcmToken);
            }
        }
    }

    //2
    async requestPermission() {
        try {
            await firebase.messaging().requestPermission();
            // User has authorised
            this.getToken();
        } catch (error) {
            // User has rejected permissions
            console.log('permission rejected');
        }
    }

////////////////////// Add these methods //////////////////////

    //Remove listeners allocated in createNotificationListeners()
    componentWillUnmount() {
        this.notificationListener();
        this.notificationOpenedListener();
    }

    async createNotificationListeners() {
        /*
        * Triggered when a particular notification has been received in foreground
        * */
        this.notificationListener = firebase.notifications().onNotification((notification) => {
            const {title, body} = notification;
            this.showAlert(title, body);
        });

        /*
        * If your app is in background, you can listen for when a notification is clicked / tapped / opened as follows:
        * */
        this.notificationOpenedListener = firebase.notifications().onNotificationOpened((notificationOpen) => {
            const {title, body} = notificationOpen.notification;
            this.showAlert(title, body);
        });

        /*
        * If your app is closed, you can check if it was opened by a notification being clicked / tapped / opened as follows:
        * */
        const notificationOpen = await firebase.notifications().getInitialNotification();
        if (notificationOpen) {
            const {title, body} = notificationOpen.notification;
            this.showAlert(title, body);
        }
        /*
        * Triggered for data only payload in foreground
        * */
        this.messageListener = firebase.messaging().onMessage((message) => {
            //process data message
            console.log(JSON.stringify(message));
        });
    }

    showAlert(title, body) {
        Alert.alert(
            title, body,
            [
                {text: 'OK', onPress: () => console.log('OK Pressed')},
            ],
            {cancelable: false},
        );
    }


    render() {
        console.disableYellowBox = true;
        return (
            <Root>
                <Router>
                    <Scene key="root">
                        <Scene key="home" component={Home} hideNavBar/>
                        {/*<Scene key="homepage" component={Homepage} hideNavBar />*/}
                        <Scene key="search" component={Search} modal hideNavBar/>
                        <Scene key="cart" component={Cart} modal hideNavBar/>
                        <Scene key="wishlist" component={WishList} modal hideNavBar/>
                        {/*<Scene key="map" component={Map} modal hideNavBar />*/}
                        <Scene key="contact" component={Contact} modal hideNavBar/>
                        <Scene key="newsletter" component={Newsletter} modal hideNavBar/>
                        <Scene key="category" component={Category} hideNavBar/>
                        <Scene key="product" component={Product} hideNavBar/>
                        <Scene key="imageGallery" component={ImageGallery} modal hideNavBar/>
                        <Scene key="login" component={Login} hideNavBar/>
                        <Scene key="signup" component={Signup} hideNavBar/>
                        <Scene key="checkout" component={Checkout} hideNavBar/>
                        {/*<Scene key="orders" component={Orders} hideNavBar />*/}
                        {/*<Scene key="orderItem" component={OrderItem} hideNavBar />*/}
                        <Scene key="profile" component={Profile} hideNavBar/>

                        <Scene key="camera" component={Camera} hideNavBar/>
                        <Scene key="verify" component={Verify} hideNavBar/>
                        <Scene key="cameraScanner" component={CameraScanner} hideNavBar/>
                        <Scene key="cameraScannerList" component={CameraScannerList} hideNavBar/>
                        <Scene key="stockAdd" component={StockAdd} hideNavBar/>
                        <Scene key="flowItem" component={FlowItem} hideNavBar/>
                        <Scene key="stockOut" component={StockOut} hideNavBar/>
                        <Scene key="stockOutMultiple" component={StockOutMultiple} hideNavBar/>
                        <Scene key="stockOutMultipleManual" component={StockOutMultipleManual} hideNavBar/>

                        <Scene key="customers" component={Customers} hideNavBar/>
                        <Scene key="customerAdd" component={CustomerAdd} hideNavBar/>
                        <Scene key="customerDetail" component={CustomerDetail} hideNavBar/>

                        <Scene key="devices" component={Devices} hideNavBar/>
                        <Scene key="deviceDetail" component={DeviceDetail} hideNavBar/>

                        <Scene key="orders" component={OrderList} hideNavBar/>
                        <Scene key="orderDetail" component={OrderDetail} hideNavBar/>

                        <Scene key="bill" component={Bill} modal hideNavBar/>
                        <Scene initial type="reset"  key="statistic" component={Statistic} hideNavBar/>

                        <Scene key="manualScannerList" component={ManualScannerList} hideNavBar/>
                        <Scene key="stockInList" component={StockInList} hideNavBar/>
                        <Scene key="stockInOutList" component={StockInOutList} hideNavBar/>
                        <Scene key="billList" component={BillList} hideNavBar/>


                        <Scene type="reset" key="contractConcretes" component={ContractConcretes} hideNavBar/>
                        <Scene key="contractConcreteDetail" component={ContractConcreteDetail} hideNavBar/>
                        <Scene type="reset" key="calendarConcretes" component={CalendarConcretes} hideNavBar/>
                        <Scene key="calendarConcreteDetail" component={CalendarConcreteDetail} hideNavBar/>
                        <Scene key="calendarConcreteAdd" component={CalendarConcreteAdd} hideNavBar/>
                        <Scene type="reset" key="contractMaterials" component={ContractMaterials} hideNavBar/>
                        <Scene key="contractMaterialDetail" component={ContractMaterialDetail} hideNavBar/>

                        <Scene type="reset" key="contractBricks" component={ContractBricks} hideNavBar/>
                        <Scene key="contractBrickDetail" component={ContractBrickDetail} hideNavBar/>
                        <Scene type="reset" key="contractBrickTerrazos" component={ContractBrickTerrazos} hideNavBar/>
                        <Scene key="contractBrickTerrazoDetail" component={ContractBrickTerrazoDetail} hideNavBar/>
                        <Scene type="reset" key="contractBrickTiles" component={ContractBrickTiles} hideNavBar/>
                        <Scene key="contractBrickTilesDetail" component={ContractBrickTilesDetail} hideNavBar/>

                        <Scene type="reset" key="bricksContracts" component={BricksContracts} hideNavBar/>
                        <Scene key="bricksContractDetail" component={BricksContractDetail} hideNavBar/>

                        <Scene type="reset" key="calendarBricks" component={CalendarBricks} hideNavBar/>
                        <Scene key="calendarBrickDetail" component={CalendarBrickDetail} hideNavBar/>
                        <Scene key="calendarBrickAdd" component={CalendarBrickAdd} hideNavBar/>
                    </Scene>
                </Router>
            </Root>
        );
    }

}
