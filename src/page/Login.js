/**
 * This is the Login Page
 **/

// React native and others libraries imports
import React, {Component} from 'react';
import {Container, View, Left, Right, Button, Icon, Item, Input} from 'native-base';
import {Actions} from 'react-native-router-flux';

// Our custom files and classes import
import Colors from '../Colors';
import Config from '../Config';
import Text from '../component/Text';
import Navbar from '../component/Navbar';

import {
    AlertIOS,
    Alert,
    StyleSheet,
    Image,
    AsyncStorage,
    ScrollView,
    Keyboard,
    TouchableWithoutFeedback,
    TouchableHighlight
} from 'react-native';
import Spinner from 'react-native-loading-spinner-overlay';
import Odoo from "../Odoo";
import Api from "../services/ApiWorker";

import TouchID from "react-native-touch-id";
import Utils from "../utils/Utils";

export default class Login extends Component {
    constructor(props) {
        super(props);
        this.state = {
            username: '',
            password: '',
            hasError: false,
            errorText: '',
            isLoading: false,
            showAdvancedSettings: false,
            newIpAddress: '',
            biometryType: null
        };
    }

    componentWillReceiveProps(nextProps: Readonly<P>, nextContext: any): void {
        this.removeSessionKey();
    }

    componentWillMount() {
        this.removeSessionKey();
        //this._fingerprintLogin();
    }

    async checkLogin() {
        try {
            let userSessionKeyLogin = await AsyncStorage.getItem('userId');
            if (userSessionKeyLogin !== null) {
                // We have data!!
                console.log(userSessionKeyLogin);
                Actions.contractConcretes({sessionLoginKey: '123'});
            }
        } catch (error) {
            // Handle errors here
            console.error(error);
        }
    }

    async removeSessionKey() {
        try {
            let userSessionKeyLogin = await AsyncStorage.getItem('userId');
            if (userSessionKeyLogin !== null) {
                // We have data!!
                console.log(userSessionKeyLogin);
                await AsyncStorage.removeItem('userId');
                console.log("remove session key");
            }
        } catch (error) {
            // Handle errors here
            console.error(error);
        }
    }

    async setSessionKey() {
        try {
            await AsyncStorage.setItem('cookieUserFromApi', responseJson.cookie);
        } catch (error) {
            // Handle errors here
            console.error(error);
        }
    }


    componentDidMount() {
        TouchID.isSupported()
            .then(biometryType => {
                this.setState({biometryType});
                console.log("+++++++++++ " + biometryType);
            })
    }

    //config is optional to be passed in on Android


    async fingerprintHandler() {
        try {
            var optionalConfigObject = {
                title: "Đăng nhập", // Android
                color: "#e00606", // Android,
                fallbackLabel: "Show Passcode" // iOS (if empty, then label is hidden)
            };
            await TouchID.authenticate('Chạm vào vân tay để đăng nhập', optionalConfigObject)
                .then(success => {
                    console.log(success);
                    console.log('Authenticated Successfully');
                    // Utils._alert('Authenticated Successfully');
                    this._fingerprintLogin();
                })
                .catch(error => {
                    console.log(error);
                    console.log('Authentication Failed');
                    Utils._alert('Authentication Failed');
                });
        } catch (error) {
            // Handle errors here
            console.error(error);
            Utils._alert(Config.err_connect);
        }
    }

    async _fingerprintLogin() {
        try {
            let fingerprintUser = await AsyncStorage.getItem('fingerprintUser');
            let fingerprintPass = await AsyncStorage.getItem('fingerprintPass');

            var user = this.state.username;
            var pass = this.state.password;
            if (fingerprintUser == null || fingerprintUser == '' || fingerprintUser == undefined ||
                fingerprintPass == null || fingerprintPass == '' || fingerprintPass == undefined
            ) {
                if ((user == null || user == '' || pass == '' || pass == '')) {
                    Utils._alert('Cần nhập tên đăng nhập và mật khẩu cho lần đầu tiên đăng nhập bằng vân tay');
                } else {
                    console.log(user);
                    console.log(pass);
                    await AsyncStorage.setItem('fingerprintUser', user);
                    await AsyncStorage.setItem('fingerprintPass', pass);
                    this.login();
                }
            } else {
                this.setState({username: fingerprintUser,password: fingerprintPass});
                this.login();
            }

        } catch (error) {
            // Handle errors here
            console.error(error);
        }
    }

    render() {
        var left = (
            <Left style={{flex: 1}}>
                <Button onPress={() => Actions.home({sessionLoginKey: null})} transparent>
                    <Icon name='ios-arrow-back'/>
                </Button>
            </Left>
        );
        var right = (
            <Right style={{flex: 1}}>
                {/*<Button onPress={() => Actions.search()} transparent>*/}
                {/*<Icon name='ios-search-outline'/>*/}
                {/*</Button>*/}
                {/*<Button onPress={() => Actions.cart()} transparent>*/}
                {/*<Icon name='ios-cart'/>*/}
                {/*</Button>*/}
            </Right>
        );
        return (
            <Container style={{backgroundColor: '#fdfdfd'}}>
                {/*<Navbar left={left} right={right} title="Đăng nhập"/>*/}
                <Spinner
                    //visibility of Overlay Loading Spinner
                    visible={this.state.isLoading}
                    //Text with the Spinner
                    //textContent={'Đang đăng nhập ...'}
                    //Text style of the Spinner Text
                    textStyle={styles.spinnerTextStyle}
                />
                <ScrollView contentContainerStyle={{flexGrow: 1}}>
                    <View style={{
                        flex: 1,
                        justifyContent: 'center',
                        alignItems: 'center',
                        paddingLeft: 50,
                        paddingRight: 50
                    }}>
                        <View style={{marginBottom: 15, width: '100%', alignItems: 'center'}}>
                            <Image style={{height: 144, width: 144}} source={require('../images/logo.png')}/>
                            <Text style={{
                                fontSize: 24,
                                fontWeight: 'bold',
                                textAlign: 'center',
                                width: '100%',
                                color: Config.colorBold
                            }}>{Config.titleCompany}<Text
                                style={{fontWeight: '200', color: Config.colorThin}}>{Config.titleCompanySub}</Text>
                            </Text>
                            {/*<Text style={{fontSize: 18, textAlign: 'left', width: '100%', color: '#687373'}}>Thực*/}
                            {/*phẩm*/}
                            {/*sạch*/}
                            {/*Nhật Bản </Text>*/}
                        </View>
                        <Item>
                            <Icon active name='ios-person' style={{color: "#687373"}}/>
                            <Input placeholder='Tên đăng nhập'
                                   onChangeText={(text) => this.setState({username: text})}
                                   placeholderTextColor="#687373"/>
                        </Item>
                        <Item>
                            <Icon active name='ios-lock' style={{color: "#687373"}}/>
                            <Input placeholder='Mật khẩu' onChangeText={(text) => this.setState({password: text})}
                                   secureTextEntry={true} placeholderTextColor="#687373"/>
                        </Item>
                        {this.state.hasError ? <Text style={{
                            color: 'red',
                            textAlign: 'center',
                            marginTop: 10
                        }}>{this.state.errorText}</Text> : null}
                        <View style={{alignItems: 'center', width: '100%'}}>
                            <Button onPress={() => this.login()}
                                    style={styles.buttonLogin}>
                                <Text style={{color: '#fdfdfd', fontSize : 16}}> {Config.btnLogin} </Text>
                            </Button>
                        </View>
                        <View style={styles.container}>
                            {/*<Button onPress={() => this.fingerprintHandler()}*/}
                                    {/*style={{alignItems: 'center', width: '100%', textAlign: 'center', alignSelf: 'stretch'}}*/}
                                    {/*transparent>*/}
                                {/*<Text style={{color: Config.mainColor, fontSize : 16}}>*/}
                                    {/*<Icon active name='ios-finger-print-outline' style={{color: Config.mainColor, fontSize : 20}}/>*/}
                                    {/*{' Đăng nhập bằng vân tay'}*/}
                                {/*</Text>*/}
                            {/*</Button>*/}
                            <TouchableHighlight onPress={() => this.fingerprintHandler()}>
                                <Text style={{color: Config.mainColor, fontSize : 16}}>
                                    <Icon active name='ios-finger-print-outline' style={{color: Config.mainColor, fontSize : 20}}/>
                                    {' Đăng nhập bằng vân tay'}
                                </Text>
                            </TouchableHighlight>
                        </View>
                        <View style={{alignItems: 'flex-end',textAlign: 'center', alignSelf: 'stretch', width: '100%', paddingTop: 100}}>
                            <Button
                                onPress={() => this.setState({showAdvancedSettings: !this.state.showAdvancedSettings})}
                                transparent>
                                <Icon active name='ios-settings' style={{color: "#687373"}}/>
                            </Button>
                            {this.state.showAdvancedSettings ?
                                <Item>
                                    <Input placeholder='Nhập thông tin server'
                                           onChangeText={(text) => this.setState({newIpAddress: text})}
                                           placeholderTextColor="#687373"/>
                                </Item>
                                : <Text></Text>}
                        </View>
                        {/*<View style={{alignItems: 'center', width: '100%'}}>*/}
                        {/*<Button onPress={() => Actions.signup()}*/}
                        {/*style={styles.buttonLogin}>*/}
                        {/*<Text style={{color: '#fdfdfd'}}> Đăng ký </Text>*/}
                        {/*</Button>*/}
                        {/*</View>*/}

                        {/*<Text style={{fontSize: 16, fontWeight: '200', color: Config.colorBold, paddingTop: 100,}}>Bản*/}
                        {/*    quyền thuộc về {Config.titleCopyRight}</Text>*/}
                    </View>
                </ScrollView>

            </Container>
        );
    }

    async login() {

        var user = this.state.username;
        var pass = this.state.password;
        var newIpAddress = this.state.newIpAddress;
        let statusLogin;
        let sessionLoginKey;
        if (user == null || user == '' || pass == '' || pass == '') {
            this.setState({hasError: true, errorText: 'Cần nhập tên đăng nhập và mật khẩu'});
            return;
        }
        if (newIpAddress != null && newIpAddress != '') {
            let match = newIpAddress.match(/((https?:\/\/)|(www.))(?:([a-zA-Z]+)|(\d+\.\d+.\d+.\d+))((.\w+)|:\d{4})/g);
            if (match == null || match == '') {
                this.setState({hasError: true, errorText: 'Địa chỉ server không đúng'});
                return;
            } else {
                global.hostAPI[0] = newIpAddress;
            }
        }
        try {
            this.setState({isLoading: true});
            this.setState({hasError: false, errorText: ''});
            var param = {
                userName: user,
                password: pass
            };
            // var res = Api.login(param);
            // this._getResLogin(res);

            let response = await fetch(global.hostAPI[0] + Config.api.apiLogin, {
                method: 'POST',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(param)
            });
            var responseObj = await response.json();
            this._getResLogin(responseObj);
        } catch (error) {
            console.error(error);
            this.setState({isLoading: false});
            this.setState({hasError: true, errorText: 'Tên đăng nhập hoặc mật khẩu không đúng'});
        }
    }

    _getResLogin(res) {
        this.setState({isLoading: false});
        console.log(res);
        console.log('__________________________');
        if (res == null) {
            this.setState({hasError: true, errorText: Config.err_connect});
            return;
        }
        if (res.code != '0') {
            this.setState({hasError: true, errorText: res.message});
        } else {
            AsyncStorage.setItem('userId', res.data.userName);
            AsyncStorage.setItem('lastLoginTime', new Date().getTime());
            console.log(res.data.userName);
            Actions.statistic({sessionLoginKey: '123'});
        }

    }

}

const styles = StyleSheet.create({
    container: {
        justifyContent: 'center',
        alignItems: 'center',
        marginTop : 20
    },
    buttonLogin: {
        // backgroundColor: '#c40521',
        backgroundColor: Config.mainColor,
        color: 'white',
        marginTop: 20,
        width: '100%',
        justifyContent: 'center',
        borderRadius: 10,
        fontSize: 16,
    },
    buttonSignup: {
        backgroundColor: "transparent",
        color: Config.mainColor,
        marginTop: 20,
        width: '100%',
        justifyContent: 'center',
        borderBottomColor: 'white',
        borderLeftColor: 'white',
        borderRightColor: 'white',
        borderTopColor: 'white'
    }
});
