/**
 * This is the Side Menu Drawer Component
 **/

// React native and others libraries imports
import React, {Component} from 'react';
import {
    Image,
    ActivityIndicator,
    ScrollView,
    TouchableOpacity,
    NativeModules,
    Dimensions,
    AsyncStorage, Keyboard, StyleSheet
} from 'react-native';
import {
    Container,
    Content,
    View,
    Button,
    Left,
    Right,
    Icon,
    Card,
    CardItem,
    cardBody,
    Row,
    Grid,
    Col,
    Item,
    Input, List, ListItem, Body,
    // Text
} from 'native-base';
import {Actions} from 'react-native-router-flux';


// Our custom files and classes import
import Text from '../../component/Text';
import Navbar from '../../component/Navbar';
import Colors from "../../Colors";
import Config from "../../Config";
import HTML from 'react-native-render-html';
import Spinner from 'react-native-loading-spinner-overlay';

export default class ContractConcreteItem extends Component {
    constructor(props) {
        super(props);

        this.state = {
            categories: [],
            products: [],
            isLoading: false,
            isSearching: false,
            error: null,
            sessionKey: null,

            extractedText: "",
            searchText: '',
            contract: {}
        };
    }

    componentDidMount(): void {
        this.setState({contract: this.props.contract});
        console.log(this.props.contract);
        console.log(this.props.contract.tuNgay);
        console.log(this.props.contract.denNgay);
        console.log(new Date('2020-03-30T17:00:00.000+0000'.toString()).toLocaleDateString());
    }

    render() {
        return (
            <View style={{
                // flex: 1,
                width: '100%', color: Config.mainColor, fontSize: 16,
                // borderBottomColor: Colors.navbarBackgroundColor, borderBottomWidth: 1,
                // paddingLeft: 10,
                // paddingTop: 20, paddingBottom: 20
            }}>
                <Spinner
                    //visibility of Overlay Loading Spinner
                    visible={this.state.isLoading}
                    //Text with the Spinner
                    //textContent={'Đang đăng nhập ...'}
                    //Text style of the Spinner Text
                    textStyle={styles.spinnerTextStyle}
                />
                {this._renderMainContent()}
            </View>
        );
    }

    _renderDateFormat(date) {
        if (date != null && date != undefined) {
            return new Date(date.toString()).toLocaleDateString();
        } else {
            return '';
        }
    }

    _renderMainContent() {
        return (
            <TouchableOpacity
                onPress={() => Actions.contractConcreteDetail({contract: this.props.contract})}
                activeOpacity={0.9}
            >
                <CardItem>
                    <Text>
                        <Icon style={styles.icon} active name="ios-time-outline"/>
                        {this.state.contract.tuNgay}
                    </Text>
                    <Text>{' đến '}</Text>
                    <Text>
                        <Icon style={styles.icon} active name="ios-time-outline"/>
                        {this.state.contract.denNgay}
                    </Text>
                </CardItem>
                <CardItem>
                    <Text>{this.state.contract.tenChiNhanh}</Text>
                </CardItem>
                <CardItem>
                    <Text style={styles.subTitle}>{'NCC'} : </Text>
                    <Text>
                        {this.state.contract.tenNhaCungCap}
                    </Text>
                </CardItem>
                <CardItem>
                    <Text style={styles.subTitle}>{Config.contractConcrete.projectName} : </Text>
                    <Right>
                        <Text>
                            {this.state.contract.tenCongTrinh}
                        </Text>
                    </Right>
                </CardItem>
                <CardItem>
                    <Right>
                        {this._renderStatus(this.state.contract.trangThaiText)}
                    </Right>
                </CardItem>

            </TouchableOpacity>
        );


    }


    _renderStatus(status) {
        if (status == Config.state.wait) {
            return (
                <Button iconLeft transparent primary>
                    <Icon style={styles.icon} name='ios-flag'/>
                    <Text>{Config.state.wait}</Text>
                </Button>
            );
        } else if (status == Config.state.approved) {
            return (
                <Button iconLeft transparent success>
                    <Icon style={styles.icon} name='ios-checkmark-circle-outline'/>
                    <Text>{Config.state.approved}</Text>
                </Button>
            );
        } else {
            return (
                <Button iconLeft transparent primary>
                    <Icon style={styles.icon} name='beer'/>
                    <Text>{status}</Text>
                </Button>
            );
        }

        // if (status == '0') {
        //     return (<Text style={{color: '#ffa505'}}>
        //         <Icon name="ios-help-circle-outline"
        //               style={{fontSize: 13, color: '#ffa505'}}/>
        //         {Config.stageName0KhongXacDinh}</Text>);
        // } else if (status == '4') {
        //     return (<Text style={{color: '#44bc37'}}>
        //         <Icon name="ios-checkmark-circle"
        //               style={{fontSize: 13, color: '#44bc37'}}/>
        //         {Config.stageName4BinhDangSuDung} </Text>);
        // } else if (status == '1') {
        //     return (<Text style={{color: Config.colorThin}}>
        //         <Icon name="ios-battery-dead"
        //               style={{fontSize: 13, color: Config.colorThin}}/>
        //         {Config.stageName0KhongXacDinh} </Text>);
        // } else if (status == '2') {
        //     return (<Text style={{color: '#ff00ff'}}>
        //         <Icon name="ios-refresh-circle"
        //               style={{fontSize: 13, color: '#ff00ff'}}/>
        //         {Config.stageName2TaiNap} </Text>);
        // } else if (status == '3') {
        //     return (<Text style={{color: '#c40521'}}>
        //         <Icon name="ios-warning"
        //               style={{fontSize: 13, color: '#c40521'}}/>
        //         {Config.stageName3BinhTon} </Text>);
        // } else {
        //     return (<Text style={{color: '#26619c'}}>{status}</Text>);
        // }
    }

}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        alignItems: 'center',
        justifyContent: 'center',
        paddingTop: 10,
    },
    scrollContainer: {
        // height: 150,
        marginTop: 5,
        paddingRight: 5,
        paddingLeft: 5,
        paddingBottom: 20
    },
    image: {
        width: 160,
        height: 160,
        borderRadius: 10,
        marginRight: 5,
        borderColor: '#dfe3ee',
        borderWidth: 0.5
    },
    capturePhoto: {
        width: 180,
        height: 180,
        borderRadius: 10,
        // marginRight: 5,
        borderColor: '#dfe3ee',
        borderWidth: 0.5
    },

    line: {
        width: '47%',
        height: 3,
        backgroundColor: '#7f8c8d',
        position: 'absolute',
        bottom: '0%',
        marginLeft: 5
    },
    titleView: {
        flex: 1, width: '97%',
        backgroundColor: Config.mainColor,
        borderRadius: 5,
        borderWidth: 0.5,
        margin: 5,
    },
    title: {
        fontSize: 16, fontFamily: 'Roboto',
        fontWeight: '200',
        // color: 'white',
        margin: 10,
    },
    subTitle: {
        fontFamily: 'Roboto',
        fontWeight: '200',
    },
    icon: {
        fontSize: 14
    },
    buttonChangeState: {
        backgroundColor: 'white',
        borderRadius: 4,
        borderWidth: 0.5,
        borderColor: Config.mainColor
    }
});
