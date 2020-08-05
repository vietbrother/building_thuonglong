/**
 * This is the Home page
 **/

// React native and others libraries imports
import React, {Component} from 'react';
import {
    Image,
    ActivityIndicator,
    AsyncStorage,
    ScrollView,
    StyleSheet,
    TouchableOpacity,
    NativeModules,
    Dimensions, FlatList, Picker
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
    Row,
    CardBody, H3, Body, Label, Grid, Col, Item, List, ListItem, Text, DatePicker
} from 'native-base';
import {Actions} from 'react-native-router-flux';


import Navbar from '../../component/Navbar';
import SideMenu from '../../component/SideMenu';
import SideMenuDrawer from '../../component/SideMenuDrawer';
import Colors from "../../Colors";
import Config from "../../Config";
import styles from '../../styles/ContractStyles';
import Utils from "../../utils/Utils";
import moment from 'moment';


export default class StatisticDetailItem extends Component {

    constructor(props) {
        super(props);

        this.state = {
            // isLoading: true,
            isSearching: false,
            error: null,
            dataDetailList: [],
            fund: [],
            concretes: [],
            bricks: [],
            bricksManufacture: [],
            materialIn: [],
        };
    }


    componentWillMount(): void {
        this.setState({
            branchSelected: this.props.branchSelected,
            currentDate: this.props.currentDate,
        });
        this._loadData();
    }

    componentWillReceiveProps(nextProps: Readonly<P>, nextContext: any): void {
        this.getSessionKey();
        this.setState({componentKey: new Date().valueOf().toString(), searchText: ''});

    }

    componentDidMount() {
    }

    _loadData() {
        let dataDetailType = this.state.dataDetailType;
        if (dataDetailType == 'fund') {
            this._loadDataFunds();
        } else if (dataDetailType == 'concretes') {
            this._loadDataConcretes();
        } else if (dataDetailType == 'bricks') {
            this._loadDataBricks();
        } else if (dataDetailType == 'bricksManufacture') {
            this._loadDataBricks();
        } else if (dataDetailType == 'materialIn') {
            this._loadDataBricks();
        }
    }

    async _loadDataFunds() {
        this.setState({isSearching: true});
        this.setState({fund: []});
        let fund = [];
        try {
            var currentDate = this.state.currentDate;
            console.log(currentDate);
            var param = {ngayThang: currentDate, idchiNhanh: this.state.branchSelected.id};
            console.log(param);
            let response = await fetch(global.hostAPI[0] + Config.api.apiStatisticDaily, {
                method: 'POST',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(param)
            });
            var responseObj = await response.json();
            console.log(responseObj);
            if (responseObj != null && responseObj.length > 0) {
                fund.push({
                    name: Config.statisticDaily.fundTotalIn,
                    value: Utils.numberWithCommas(responseObj[0].tongThu)
                });
                fund.push({
                    name: Config.statisticDaily.fundTotalOut,
                    value: Utils.numberWithCommas(responseObj[0].tongChi)
                });
                fund.push({
                    name: Config.statisticDaily.fundLiabilitiesCollection,
                    value: Utils.numberWithCommas(responseObj[0].congNoThu)
                });
                fund.push({
                    name: Config.statisticDaily.fundLiabilitiesPay,
                    value: Utils.numberWithCommas(responseObj[0].congNoTra)
                });
            }
        } catch (e) {
            console.log(e);
        }
        this.setState({isSearching: false});
        this.setState({fund: fund});
    }

    async _loadDataConcretes(branchId) {
        this.setState({isSearching: true});
        this.setState({concretes: []});
        let concretes = [];
        try {
            var currentDate = this.state.currentDate;
            console.log(currentDate);
            var param = {ngayThang: currentDate, idchiNhanh: this.state.branchSelected.id};
            console.log(param);
            let response = await fetch(global.hostAPI[0] + Config.api.apiStatisticDaily, {
                method: 'POST',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(param)
            });
            var responseObj = await response.json();
            console.log(responseObj);

            if (responseObj != null && responseObj.length > 0) {
                concretes.push({
                    name: Config.statisticDaily.concreteOut,
                    value: Utils.numberWithCommas(responseObj[0].klbeTongBan)
                });
                concretes.push({
                    name: Config.statisticDaily.concreteMix,
                    value: Utils.numberWithCommas(responseObj[0].klbeTongDaTron)
                });
                concretes.push({
                    name: Config.statisticDaily.concretePlan,
                    value: Utils.numberWithCommas(responseObj[0].klbeTongDuKien)
                });

            }
        } catch (e) {
            console.log(e);
        }
        this.setState({isSearching: false});
        this.setState({concretes: concretes});
    }

    async _loadDataBricks(branchId) {
        this.setState({isSearching: true});
        var bricks = [];
        var bricksManufacture = [];
        var materialIn = [];
        this.setState({
            bricks: bricks,
            bricksManufacture: bricksManufacture,
            materialIn: materialIn,
        });
        try {
            var currentDate = this.state.currentDate;
            console.log(currentDate);
            var param = {ngayThang: currentDate, idchiNhanh: this.state.branchSelected.id};
            console.log(param);
            let response = await fetch(global.hostAPI[0] + Config.api.apiStatisticBricks, {
                method: 'POST',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(param)
            });
            var responseObj = await response.json();
            console.log(responseObj);
            if (responseObj != null && responseObj.length > 0) {
                for (var i = 0; i < responseObj.length; i++) {
                    if (responseObj[i].type == 'BanGach') {
                        bricks.push(responseObj[i]);
                    } else if (responseObj[i].type == 'NKVL') {
                        materialIn.push(responseObj[i]);
                    } else {
                        bricksManufacture.push(responseObj[i]);
                    }
                }
            }

        } catch (e) {
            console.log(e);
        }
        this.setState({isSearching: false});
        this.setState({
            bricks: bricks,
            bricksManufacture: bricksManufacture,
            materialIn: materialIn
        });
    }


    _renderMainContent() {
        let dataDetailType = this.state.dataDetailType;
        if (dataDetailType == 'fund') {
            return (
                <StatisticDetailList dataDetailList={this.state.fund}
                                     dataDetailType={dataDetailType}></StatisticDetailList>
            );
        } else if (dataDetailType == 'concretes') {
            return (
                <StatisticDetailList dataDetailList={this.state.concretes}
                                     dataDetailType={dataDetailType}></StatisticDetailList>
            );
        } else if (dataDetailType == 'bricks') {
            return (
                <StatisticDetailList dataDetailList={this.state.bricks}
                                     dataDetailType={dataDetailType}></StatisticDetailList>
            );
        } else if (dataDetailType == 'bricksManufacture') {
            return (
                <StatisticDetailList dataDetailList={this.state.brickManufacture}
                                     dataDetailType={dataDetailType}></StatisticDetailList>
            );
        } else if (dataDetailType == 'materialIn') {
            return (
                <StatisticDetailList dataDetailList={this.state.materialIn}
                                     dataDetailType={dataDetailType}></StatisticDetailList>
            );
        } else {
            return [];
        }
    }


    render() {

        var left = (
            <Left style={{flex: 1}}>
                <Button onPress={() => this._sideMenuDrawer.open()} transparent>
                    <Icon name='ios-menu-outline'/>
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

            <View style={styles.main}>
                <CardItem header>
                    <Body>
                        <Text style={styles.titleBranch}>
                            <Icon active name="cube"
                                  style={styles.titleBranch}/> {this.state.branchSelected.tenChiNhanh}
                        </Text>
                    </Body>
                </CardItem>
                {this.state.isSearching ?
                    <View style={styles.loadingActivity}>
                        <ActivityIndicator
                            animating={this.state.isSearchingBricks}
                            color={Config.mainColor}
                            size="large"
                        />
                    </View>
                    : <Text></Text>}
                {this._renderMainContent()}
            </View>
        );

    }

}

