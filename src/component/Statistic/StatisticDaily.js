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
    Dimensions, FlatList
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
    CardBody, H3, Body, Label, Grid, Col, Item, List, ListItem, Text
} from 'native-base';
import {Actions} from 'react-native-router-flux';


import Navbar from '../../component/Navbar';
import SideMenu from '../../component/SideMenu';
import SideMenuDrawer from '../../component/SideMenuDrawer';
import Colors from "../../Colors";
import Config from "../../Config";
import styles from '../../styles/ContractStyles';
import Utils from "../../utils/Utils";
import ContractConcretesItem from "../ContractConcrete/ContractConcretes";


export default class StatisticDaily extends Component {

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
            isSearchingActive: false,
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
            concretePlan: 0,
            bricks: [],

            currentDate: new Date().toISOString().split('T')[0],
            isSearchingBricks: false,
        };
    }


    componentWillMount(): void {

    }

    componentWillReceiveProps(nextProps: Readonly<P>, nextContext: any): void {
        this.setState({componentKey: new Date().valueOf().toString(), searchText: ''});
        this._loadData();
        this._loadDataBricks();
    }

    componentDidMount() {
        var date = new Date();
        var firstDay = new Date(date.getFullYear(), date.getMonth(), 1);
        var lastDay = new Date(date.getFullYear(), date.getMonth() + 1, 0);
        var startDate = firstDay.toISOString().split('T')[0];
        var endDate = lastDay.toISOString().split('T')[0];

        // var temp = new Date().toISOString().split('T')[0];
        // var currentDate = temp.substring(8, 10) + '/' + temp.substring(5, 7) + '/' + temp.substring(0, 4);
        // this.setState({currentDate: currentDate});

        this.getSessionKey();
    }

    async getSessionKey() {
        try {
            let userSessionKeyLogin = await AsyncStorage.getItem('userId');
            console.log("========================= session key " + userSessionKeyLogin);
            this.setState({sessionKey: userSessionKeyLogin});
            console.log("========================= session key " + this.state.sessionKey);
            if (userSessionKeyLogin == null || userSessionKeyLogin == '') {
                // We have data!!
                console.log(userSessionKeyLogin);
                Actions.login({sessionLoginKey: '123'});
            } else {
                let lastLoginTime = await AsyncStorage.getItem('lastLoginTime');
                var currentTime = new Date().valueOf();
                if (userSessionKeyLogin != lastLoginTime && userSessionKeyLogin != undefined && currentTime > parseInt(lastLoginTime) + Config.sessionTime) {
                    Actions.login({sessionLoginKey: '123'});
                }
                this._loadData();
                this._loadDataBricks();
                this._loadBranchData();
            }
        } catch (error) {
            // Handle errors here
            console.error(error);
        }
    }

    async _loadData() {
        this.setState({isSearching: true});
        this.setState({
            fundTotalIn: 0,
            fundTotalOut: 0,
            fundCollection: 0,
            fundPay: 0,
            concreateOut: 0,
            concretePlan: 0
        });
        try {
            var temp = new Date().toISOString().split('T')[0];
            var currentDate = temp.substring(8, 10) + '/' + temp.substring(5, 7) + '/' + temp.substring(0, 4);
            console.log(currentDate);
            var param = {ngayThang: currentDate};
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
                concretePlan: responseObj[0].klbeTongDuKien
            });
            // this.search(responseObj[0].id);
        } catch (e) {
            console.log(e);
            this.setState({isSearching: false});
        }
    }

    async _loadDataBricks() {
        this.setState({isSearchingBricks: true});
        this.setState({
            bricks: []
        });
        try {
            var temp = new Date().toISOString().split('T')[0];
            var currentDate = temp.substring(8, 10) + '/' + temp.substring(5, 7) + '/' + temp.substring(0, 4);
            console.log(currentDate);
            var param = {ngayThang: currentDate};
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
            this.setState({
                bricks: responseObj
            });
            // this.search(responseObj[0].id);
        } catch (e) {
            console.log(e);
            this.setState({isSearchingBricks: false});
        }
    }

    _renderItemResult(item) {
        var key = new Date().valueOf().toString();
        return (
            <Card transparent>
                <CardItem>
                    <Text style={[styles.boxTitleSecond, styles.labelMain]}>
                        {Utils.numberWithCommas(item.value)} {Config.statisticDaily.brickUnit}
                    </Text>
                </CardItem>
                <CardItem bordered>
                    <Text style={styles.titleUnder}>{item.name}</Text>
                </CardItem>
            </Card>
        );
    }


    async _loadBranchData() {
        this.setState({isSearching: true});
        this.setState({contracts: []});
        try {
            var param = {};
            let response = await fetch(global.hostAPI[0] + Config.api.apiListBranch, {
                method: 'GET',
                headers: {
                    'Accept': '*/*'
                }
            });
            var responseObj = await response.json();
            this.setState({isSearching: false});
            this.setState({branchs: responseObj});
            if (responseObj != null && responseObj.length > 0) {
                this.setState({branchSelected: responseObj[0].id});
            }
            // this.search(responseObj[0].id);
            this.search(responseObj[0].id, Config.stateCode.wait);
            this.search(responseObj[0].id, Config.stateCode.approved);
        } catch (e) {
            console.log(e);
            this.setState({isSearching: false});
        }
    }

    _renderBranch() {
        var items = [];
        for (var i = 0; i < this.state.branchs.length; i++) {
            var branchItem = this.state.branchs[i];
            items.push(<Picker.Item key={branchItem.id} label={branchItem.tenChiNhanh} value={branchItem.id}/>);
        }
        return items;
    }

    render() {
        //var data = this.state.summaryData;


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
            <SideMenuDrawer ref={(ref) => this._sideMenuDrawer = ref}
                // key={new Date().valueOf()}
                            key={this.state.componentKey}
                // fetchData={'1'}
                //             sessionLoginKey={this.props.sessionLoginKey}
            >
                <Container>

                    <Navbar left={left} right={right} title={Config.statisticDaily.title}/>
                    <Content style={styles.main}>
                        <Card>
                            <CardItem>
                                <Picker
                                    style={styles.branchPicker}
                                    itemStyle={styles.branchPickerItem}
                                    selectedValue={this.state.branchSelected}
                                    onValueChange={(itemValue, itemIndex) => this._actionSelectBranch(itemValue)}>
                                    {this._renderBranch()}
                                </Picker>
                            </CardItem>
                        </Card>

                        <View style={[styles.header, styles.bgMain]}>
                            <CardItem style={styles.bgMain}>
                                <Text
                                    style={[styles.titleAbove, styles.labelWhite]}>{Config.statisticDaily.fundTotalIn}</Text>
                            </CardItem>
                            <CardItem style={styles.bgMain}>
                                <Text style={[styles.boxTitle, styles.labelWhite, styles.mainTitle]}>
                                    <Icon note name="ios-card-outline"
                                          style={[styles.boxTitle, styles.labelWhite, styles.m_r_5, styles.mainTitle]}/>
                                    <Text style={[styles.boxTitle, styles.labelWhite, styles.mainTitle]}>
                                        {/*{ ' ' +  Utils.numberWithCommas(Utils._nFormatter(100000000, 2))}*/}
                                        {' ' + Utils.numberWithCommas(this.state.fundTotalIn)}
                                    </Text>
                                </Text>
                            </CardItem>
                        </View>


                        {/*<View style={styles.boxItem}>*/}
                        {/*<View style={styles.box}>*/}
                        {/*<CardItem style={styles.boxContent}>*/}
                        {/*<Text style={[styles.boxTitle, styles.labelSuccess]}>10,000,000,000,000</Text>*/}
                        {/*</CardItem>*/}
                        {/*<CardItem>*/}
                        {/*<Text style={styles.titleUnder}>12312313</Text>*/}
                        {/*</CardItem>*/}
                        {/*</View>*/}
                        {/*</View>*/}
                        <View style={[styles.boxItem, styles.subHeader]}>
                            <View style={styles.box}>
                                <CardItem style={styles.boxContent}>
                                    <Text style={[styles.boxTitle, styles.labelRed]}>
                                        <Icon name="ios-share-outline"
                                              style={[styles.boxTitle, styles.labelRed, styles.m_r_5]}/>
                                        {' ' + Utils.numberWithCommas(this.state.fundTotalOut)}
                                    </Text>

                                </CardItem>
                                <CardItem bordered>
                                    <Text style={styles.titleUnder}>{Config.statisticDaily.fundTotalOut}</Text>
                                </CardItem>
                                <CardItem>
                                    <Text style={[styles.boxTitle, styles.labelSuccess]}>
                                        <Icon name="ios-add-circle-outline"
                                              style={[styles.boxTitle, styles.labelSuccess, styles.m_r_5]}/>
                                        {' ' + Utils.numberWithCommas(this.state.fundCollection)}
                                    </Text>
                                </CardItem>
                                <CardItem bordered>
                                    <Text style={styles.titleUnder}>
                                        {Config.statisticDaily.fundLiabilitiesCollection}
                                    </Text>
                                </CardItem>
                                <CardItem>
                                    <Text style={[styles.boxTitle, styles.labelRed]}>
                                        <Icon name="ios-remove-circle-outline"
                                              style={[styles.boxTitle, styles.labelRed, styles.m_r_5]}/>
                                        {' ' + Utils.numberWithCommas(Utils._nFormatter(this.state.fundPay, 2))}
                                    </Text>
                                </CardItem>
                                <CardItem style={{paddingBottom: 20}}>
                                    <Text style={styles.titleUnder}>
                                        {Config.statisticDaily.fundLiabilitiesPay}
                                    </Text>
                                </CardItem>
                            </View>
                        </View>

                        {/*<Grid style={{marginTop: 10}}>*/}
                        {/*<Col style={styles.subColItemLeft}>*/}
                        {/*<View style={styles.box}>*/}
                        {/*<CardItem>*/}
                        {/*<Text>*/}
                        {/*<Icon note name="ios-card-outline" style={[styles.m_r_5]}/>*/}
                        {/*{Config.statisticDaily.fundLiabilitiesCollection}*/}
                        {/*</Text>*/}
                        {/*</CardItem>*/}
                        {/*<CardItem>*/}
                        {/*<Text*/}
                        {/*style={[styles.boxTitle, styles.labelSuccess]}>{Utils.numberWithCommas(Utils._nFormatter(1000000000000, 2))}</Text>*/}
                        {/*</CardItem>*/}
                        {/*</View>*/}
                        {/*</Col>*/}
                        {/*<Col style={styles.subColItemRight}>*/}
                        {/*<View style={styles.box}>*/}
                        {/*<CardItem>*/}
                        {/*<Text>*/}
                        {/*<Icon note name="ios-card-outline" style={[styles.m_r_5]}/>*/}
                        {/*{Config.statisticDaily.fundLiabilitiesPay}*/}
                        {/*</Text>*/}
                        {/*</CardItem>*/}
                        {/*<CardItem>*/}
                        {/*<Text*/}
                        {/*style={[styles.boxTitle, styles.labelRed]}>{Utils.numberWithCommas(Utils._nFormatter(1000000000000, 2))}</Text>*/}
                        {/*</CardItem>*/}
                        {/*</View>*/}
                        {/*</Col>*/}
                        {/*</Grid>*/}

                        <List style={{backgroundColor: 'white', marginTop: 20, marginBottom: 20}}>
                            <ListItem itemDivider>
                                <Text style={styles.labelHeader}>{Config.statisticDaily.concrete}</Text>
                            </ListItem>
                            <CardItem>
                                <Text style={[styles.boxTitleSecond, styles.labelMain]}>
                                    {Utils.numberWithCommas(this.state.concreateOut)} {Config.statisticDaily.concreteUnit}
                                </Text>
                            </CardItem>
                            <CardItem bordered>
                                <Text style={styles.titleUnder}>{Config.statisticDaily.concreteOut}</Text>
                            </CardItem>

                            {/*<CardItem>*/}
                                {/*<Text*/}
                                    {/*style={[styles.boxTitleSecond, styles.labelMain]}>{Utils.numberWithCommas(100000)} {Config.statisticDaily.concreteUnit}</Text>*/}
                            {/*</CardItem>*/}
                            {/*<CardItem bordered>*/}
                                {/*<Text style={styles.titleUnder}>{Config.statisticDaily.concreteMix}</Text>*/}
                            {/*</CardItem>*/}

                            <CardItem>
                                <Text style={[styles.boxTitleSecond, styles.labelMain]}>
                                    {Utils.numberWithCommas(this.state.concretePlan)} {Config.statisticDaily.concreteUnit}
                                </Text>
                            </CardItem>
                            <CardItem bordered>
                                <Text style={styles.titleUnder}>{Config.statisticDaily.concretePlan}</Text>
                            </CardItem>

                            {/*<ListItem>*/}
                            {/*<View style={{padding: 5}}>*/}
                            {/*<CardItem>*/}
                            {/*<Text style={[styles.boxTitleSecond, styles.labelSuccess]}>100000 {Config.statisticDaily.concreteUnit}</Text>*/}
                            {/*</CardItem>*/}
                            {/*<CardItem>*/}
                            {/*<Text style={styles.titleUnder}>{Config.statisticDaily.concreteOut}</Text>*/}
                            {/*</CardItem>*/}
                            {/*</View>*/}
                            {/*</ListItem>*/}
                            {/*<ListItem>*/}
                            {/*<Left>*/}
                            {/*<Text>{Config.statisticDaily.concreteOut}</Text>*/}
                            {/*</Left>*/}
                            {/*<Right>*/}
                            {/*<Text style={styles.labelValue}>10000m3</Text>*/}
                            {/*</Right>*/}
                            {/*</ListItem>*/}
                            {/*<ListItem>*/}
                            {/*<Left>*/}
                            {/*<Text><Icon note name="ios-speedometer-outline" style={styles.iconMedium}/>{Config.statisticDaily.concreteOut}</Text>*/}
                            {/*</Left>*/}
                            {/*<Right>*/}
                            {/*<Text style={styles.labelValue}>10000m3</Text>*/}
                            {/*</Right>*/}
                            {/*</ListItem>*/}
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
                            {/*<CardItem>*/}
                                {/*<Text*/}
                                    {/*style={[styles.boxTitleSecond, styles.labelMain]}>{Utils.numberWithCommas(100000)} {Config.statisticDaily.brickUnit}</Text>*/}
                            {/*</CardItem>*/}
                            {/*<CardItem bordered>*/}
                                {/*<Text style={styles.titleUnder}>{Config.statisticDaily.brickTazo2040}</Text>*/}
                            {/*</CardItem>*/}

                            {/*<CardItem>*/}
                                {/*<Text*/}
                                    {/*style={[styles.boxTitleSecond, styles.labelMain]}>{Utils.numberWithCommas(100000)} {Config.statisticDaily.brickUnit}</Text>*/}
                            {/*</CardItem>*/}
                            {/*<CardItem bordered>*/}
                                {/*<Text style={styles.titleUnder}>{Config.statisticDaily.brickTazo3030}</Text>*/}
                            {/*</CardItem>*/}

                            {/*<CardItem>*/}
                                {/*<Text*/}
                                    {/*style={[styles.boxTitleSecond, styles.labelMain]}>{Utils.numberWithCommas(100000)} {Config.statisticDaily.brickUnit}</Text>*/}
                            {/*</CardItem>*/}
                            {/*<CardItem bordered>*/}
                                {/*<Text style={styles.titleUnder}>{Config.statisticDaily.brickTazo5020}</Text>*/}
                            {/*</CardItem>*/}
                        </List>

                    </Content>
                </Container>
            </SideMenuDrawer>
        );

    }

}

