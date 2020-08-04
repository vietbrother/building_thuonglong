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
            contracts: [],
            summaryData: [],
            summaryLabel: [],
            summaryColors: [Config.mainColor, '#d31977', '#508f11', '#5d14a8', '#a85d14'],
            contractsActive: [],
            branchs: [],
            // isLoading: true,
            isSearching: false,
            error: null,
            sessionKey: null,

            extractedText: "",
            searchText: '',
            branchSelected: '',
            componentKey: new Date().valueOf().toString(),

            fundTotalIn: 0,
            fundTotalOut: 0,
            fundCollection: 0,
            fundPay: 0,
            concreateOut: 0,
            concreateMixed: 0,
            concretePlan: 0,
            bricks: [],
            bricksManufacture: [],
            materialIn: [],

            // currentDate: new Date().toISOString().split('T')[0],
            currentDate: moment().utcOffset('+07:00').format('DD/MM/YYYY'),
            isSearchingBricks: false,
            chosenDate: moment().utcOffset('+07:00').format('DD/MM/YYYY')
        };
    }


    componentWillMount(): void {
        this.setState({
            branchSelected: this.props.branchSelected,
            currentDate: this.props.currentDate,

        });
        this._loadData();
        this._loadDataBricks();
    }

    componentWillReceiveProps(nextProps: Readonly<P>, nextContext: any): void {
        this.getSessionKey();
        this.setState({componentKey: new Date().valueOf().toString(), searchText: ''});

    }

    componentDidMount() {
        var date = new Date();
        var firstDay = new Date(date.getFullYear(), date.getMonth(), 1);
        var lastDay = new Date(date.getFullYear(), date.getMonth() + 1, 0);
        var startDate = firstDay.toISOString().split('T')[0];
        var endDate = lastDay.toISOString().split('T')[0];

    }


    async _loadData(branchId) {
        this.setState({isSearching: true});
        this.setState({
            fundTotalIn: 0,
            fundTotalOut: 0,
            fundCollection: 0,
            fundPay: 0,
            concreateOut: 0,
            concreateMixed: 0,
            concretePlan: 0
        });
        try {
            //var temp = new Date().toISOString().split('T')[0];
            //var currentDate = temp.substring(8, 10) + '/' + temp.substring(5, 7) + '/' + temp.substring(0, 4);

            // var currentDate = this.formatDate(this.state.currentDate.toISOString().split('T')[0]);
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
            this.setState({isSearching: false});
            this.setState({
                fundTotalIn: responseObj[0].tongThu,
                fundTotalOut: responseObj[0].tongChi,
                fundCollection: responseObj[0].congNoThu,
                fundPay: responseObj[0].congNoTra,
                concreateOut: responseObj[0].klbeTongBan,
                concreateMixed: responseObj[0].klbeTongDaTron,
                concretePlan: responseObj[0].klbeTongDuKien
            });
        } catch (e) {
            console.log(e);
            this.setState({isSearching: false});
        }
    }

    async _loadDataBricks(branchId) {
        this.setState({isSearchingBricks: true});
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
            this.setState({isSearchingBricks: false});
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
            this.setState({
                bricks: bricks,
                bricksManufacture: bricksManufacture,
                materialIn: materialIn
            });
        } catch (e) {
            console.log(e);
            this.setState({isSearchingBricks: false});
        }
    }

    _renderItemResult(item) {
        var key = new Date().valueOf().toString();
        return (
            <Card transparent>
                <CardItem style={[styles.detailItem]}>
                    <Text style={[styles.boxTitleSecond, styles.labelMain, styles.font18]}>
                        {Utils.numberWithCommas(item.value)} {Config.statisticDaily.brickUnit}
                    </Text>
                </CardItem>
                <CardItem bordered style={[styles.detailItem]}>
                    <Text style={styles.titleUnder}>{item.name}</Text>
                </CardItem>
            </Card>
        );
    }

    _renderItemMaterialInResult(item) {
        return (
            <Card transparent>
                <CardItem style={[styles.detailItem]}>
                    <Text style={[styles.boxTitleSecond, styles.labelMain, styles.font18]}>
                        {Utils.numberWithCommas(item.value)}
                    </Text>
                </CardItem>
                <CardItem  style={[styles.detailItem]} bordered>
                    <Text style={styles.titleUnder}>{item.name}</Text>
                </CardItem>
            </Card>
        );
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


                <List style={{backgroundColor: 'white', marginTop: 20, marginBottom: 20}}>
                    <ListItem itemDivider>
                        <Text style={styles.labelHeader}>{Config.statisticDaily.fund}</Text>
                    </ListItem>
                    <CardItem>
                        <Text style={[styles.boxTitleSecond, styles.labelSuccess, styles.font18]}>
                            {Utils.numberWithCommas(this.state.fundTotalIn)}
                        </Text>
                    </CardItem>
                    <CardItem bordered>
                        <Text style={styles.titleUnder}>{Config.statisticDaily.fundTotalIn}</Text>
                    </CardItem>
                    <CardItem>
                        <Text style={[styles.boxTitleSecond, styles.labelRed, styles.font18]}>
                            {Utils.numberWithCommas(this.state.fundTotalOut)}
                        </Text>
                    </CardItem>
                    <CardItem bordered>
                        <Text style={styles.titleUnder}>{Config.statisticDaily.fundTotalOut}</Text>
                    </CardItem>
                    <CardItem>
                        <Text style={[styles.boxTitleSecond, styles.labelSuccess, styles.font18]}>
                            {Utils.numberWithCommas(this.state.fundCollection)}
                        </Text>
                    </CardItem>
                    <CardItem bordered>
                        <Text style={styles.titleUnder}>{Config.statisticDaily.fundLiabilitiesCollection}</Text>
                    </CardItem>
                    <CardItem>
                        <Text style={[styles.boxTitleSecond, styles.labelRed, styles.font18]}>
                            {' ' + Utils.numberWithCommas(this.state.fundPay)}
                        </Text>
                    </CardItem>
                    <CardItem bordered>
                        <Text style={styles.titleUnder}>{Config.statisticDaily.fundLiabilitiesPay}</Text>
                    </CardItem>


                    <ListItem itemDivider>
                        <Text style={styles.labelHeader}>{Config.statisticDaily.concrete}</Text>
                    </ListItem>
                    <CardItem>
                        <Text style={[styles.boxTitleSecond, styles.labelMain, styles.font18]}>
                            {Utils.numberWithCommas(this.state.concreateOut)} {Config.statisticDaily.concreteUnit}
                        </Text>
                    </CardItem>
                    <CardItem bordered>
                        <Text style={styles.titleUnder}>{Config.statisticDaily.concreteOut}</Text>
                    </CardItem>
                    <CardItem>
                        <Text style={[styles.boxTitleSecond, styles.labelMain, styles.font18]}>
                            {Utils.numberWithCommas(this.state.concreateMixed)} {Config.statisticDaily.concreteUnit}
                        </Text>
                    </CardItem>
                    <CardItem bordered>
                        <Text style={styles.titleUnder}>{Config.statisticDaily.concreteMix}</Text>
                    </CardItem>
                    <CardItem>
                        <Text style={[styles.boxTitleSecond, styles.labelMain, styles.font18]}>
                            {Utils.numberWithCommas(this.state.concretePlan)} {Config.statisticDaily.concreteUnit}
                        </Text>
                    </CardItem>
                    <CardItem bordered>
                        <Text style={styles.titleUnder}>{Config.statisticDaily.concretePlan}</Text>
                    </CardItem>


                    <ListItem itemDivider>
                        <Text style={styles.labelHeader}>{Config.statisticDaily.brick}</Text>
                    </ListItem>

                    {this.state.isSearching ?
                        <View style={styles.loadingActivity}>
                            <ActivityIndicator
                                animating={this.state.isSearchingBricks}
                                color={Config.mainColor}
                                size="large"
                            />
                        </View>
                        : <Text></Text>}
                    <FlatList
                        key={'statisticDailyBricksId'}
                        style={{width: '100%'}}
                        data={this.state.bricks}
                        renderItem={({item}) => this._renderItemResult(item)}
                    />

                    {this.state.bricksManufacture.length > 0 ?
                        <ListItem itemDivider>
                            <Text style={styles.labelHeader}>{Config.statisticDaily.brickManufacture}</Text>
                        </ListItem>
                        : <Text></Text>}
                    <FlatList
                        key={'statisticDailyBricksManufactureId'}
                        style={{width: '100%'}}
                        data={this.state.bricksManufacture}
                        renderItem={({item}) => this._renderItemResult(item)}
                    />

                    <ListItem itemDivider>
                        <Text style={styles.labelHeader}>{Config.statisticDaily.materialIn}</Text>
                    </ListItem>
                    <FlatList
                        key={'statisticDailyMaterialInId'}
                        style={{width: '100%'}}
                        data={this.state.materialIn}
                        renderItem={({item}) => this._renderItemMaterialInResult(item)}
                    />
                    <Text style={styles.labelHeader}></Text>

                </List>

            </View>
        );

    }

}

