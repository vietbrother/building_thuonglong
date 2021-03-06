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
            branchSelected: {},
            branchSelectedId: '',
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
        this.getSessionKey();
        this._loadBranchData();
    }

    componentWillReceiveProps(nextProps: Readonly<P>, nextContext: any): void {
        this.getSessionKey();
        this.setState({componentKey: new Date().valueOf().toString(), searchText: ''});
        this._loadData();
        this._loadDataBricks();
        this._loadBranchData();
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
    }

    async getSessionKey() {
        try {
            let userSessionKeyLogin = await AsyncStorage.getItem('userId');
            let lastLoginTime = await AsyncStorage.getItem('lastLoginTime');
            console.log("========================= session key " + userSessionKeyLogin);
            this.setState({sessionKey: userSessionKeyLogin});
            console.log("========================= session key " + this.state.sessionKey);
            if (userSessionKeyLogin == null || userSessionKeyLogin == ''
                || lastLoginTime == null || lastLoginTime == '' || lastLoginTime == undefined) {
                // We have data!!
                console.log(userSessionKeyLogin);
                Actions.login({sessionLoginKey: '123'});
            } else {
                var currentTime = new Date().getTime();
                // console.log("========================= lastLoginTime " + lastLoginTime);
                // console.log("=========================  " + (currentTime - (parseInt(lastLoginTime) + Config.sessionTime)));
                if (userSessionKeyLogin != lastLoginTime && userSessionKeyLogin != undefined
                    && currentTime > parseInt(lastLoginTime) + Config.sessionTime) {
                    Actions.login({sessionLoginKey: '123'});
                }
                //this._loadData();
                //this._loadDataBricks();
                //this._loadBranchData();
            }
        } catch (error) {
            // Handle errors here
            console.error(error);
        }
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
            var param = {ngayThang: currentDate, idchiNhanh: branchId, username: this.state.sessionKey};
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
            // this.search(responseObj[0].id);
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
            //var temp = new Date().toISOString().split('T')[0];
            //var currentDate = temp.substring(8, 10) + '/' + temp.substring(5, 7) + '/' + temp.substring(0, 4);
            // var currentDate = this.formatDate(this.state.currentDate.toISOString().split('T')[0]);
            var currentDate = this.state.currentDate;
            console.log(currentDate);
            var param = {ngayThang: currentDate, idchiNhanh: branchId, username: this.state.sessionKey};
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

    _renderItemMaterialInResult(item) {
        var key = new Date().valueOf().toString();
        return (
            <Card transparent>
                <CardItem>
                    <Text style={[styles.boxTitleSecond, styles.labelMain]}>
                        {Utils.numberWithCommas(item.value)} {item.unit}
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
        this.setState({branchs: []});
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
                this.setState({branchSelected: responseObj[0]});
                this.setState({branchSelectedId: responseObj[0].id});
            }
            console.log(this.state.branchSelected);
            this._actionSelectBranch(responseObj[0].id);
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

    _actionSelectBranch(itemValue) {
        console.log("+++++++++++++++++++++++ " + itemValue);
        this.setState({branchSelectedId: itemValue});
        console.log(this.state.branchSelectedId);
        let branchItem = this.state.branchs.find(branch => branch.id === itemValue);
        this.setState({branchSelected: branchItem});
        this._loadData(itemValue);
        this._loadDataBricks(itemValue);
    }

    setDate(newDate) {
        // this.setState({currentDate: new Date(newDate.getTime() + 1000*60*60*24)});
        this.setState({currentDate: moment(newDate).format('DD/MM/YYYY')});
        console.log('select date ' + newDate);
        console.log('select branch ' + this.state.branchSelectedId);
        this._loadData(this.state.branchSelectedId);
        this._loadDataBricks(this.state.branchSelectedId);
    }

    // formatDate(date) {
    //     var nDate = date.substring(8, 10) + '/' + date.substring(5, 7) + '/' + date.substring(0, 4)
    //     console.log('formatDate ' + nDate);
    //     return nDate;
    // }

    _renderShowDetail(type) {
        return (


            <Button
                transparent
                onPress={() => Actions.statisticDetail({
                    branchSelected: this.state.branchSelected,
                    currentDate: this.state.currentDate,
                    dataDetailType: type
                })}
            >
                <Icon name="ios-arrow-forward"/>
            </Button>

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
            <SideMenuDrawer ref={(ref) => this._sideMenuDrawer = ref}
                // key={new Date().valueOf()}
                            key={this.state.componentKey}
                // fetchData={'1'}
                //             sessionLoginKey={this.props.sessionLoginKey}
            >
                <Container>

                    <Navbar left={left} right={right} title={Config.statisticDaily.title}/>
                    <Content style={styles.main}>
                        {/*<Card style={styles.bgMain}>*/}
                        <Grid>
                            <Col size={1} style={{textAlign: 'center', padding: 5, paddingLeft: 10}}>
                                <Text style={styles.muted}><Icon name="md-calendar"
                                                                 style={styles.muted}/> {Config.calendarConcrete.exportDate}
                                </Text>
                                <DatePicker
                                    defaultDate={new Date()}
                                    //minimumDate={new Date()}
                                    //maximumDate={new Date()}
                                    locale={'en'}
                                    timeZoneOffsetInMinutes={undefined}
                                    modalTransparent={false}
                                    animationType={'fade'}
                                    androidMode={'default'}
                                    placeHolderText={moment().utcOffset('+07:00').format('DD/MM/YYYY')}
                                    textStyle={{color: 'green'}}
                                    placeHolderTextStyle={{color: Config.mainColor}}
                                    onDateChange={(date) => {
                                        this.setDate(date)
                                    }}
                                    disabled={false}
                                    formatChosenDate={(date) => {
                                        // return this.formatDate(new Date(date.getTime() + 1000*60*60*24).toISOString().split('T')[0]);
                                        return moment(date).format('DD/MM/YYYY');
                                    }}
                                >
                                </DatePicker>
                            </Col>
                            <Col size={2} style={{textAlign: 'center', padding: 5}}>
                                <Text style={styles.muted}><Icon name="cube"
                                                                 style={styles.muted}/> {Config.calendarConcrete.branch}
                                </Text>
                                <Picker
                                    style={[styles.branchPicker]}
                                    itemStyle={styles.branchPickerItem}
                                    selectedValue={this.state.branchSelectedId}
                                    onValueChange={(itemValue, itemIndex) => this._actionSelectBranch(itemValue)}>
                                    {this._renderBranch()}
                                </Picker>
                            </Col>
                        </Grid>
                        {/*</Card>*/}

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
                                        {/*{' ' + Utils.numberWithCommas(Utils._nFormatter(this.state.fundPay, 2))}*/}
                                        {' ' + Utils.numberWithCommas(this.state.fundPay)}
                                    </Text>
                                </CardItem>
                                <CardItem bordered>
                                    <Text style={styles.titleUnder}>
                                        {Config.statisticDaily.fundLiabilitiesPay}
                                    </Text>
                                </CardItem>
                                <CardItem>
                                    <Left/>
                                    <Body>
                                    <TouchableOpacity
                                        onPress={() => Actions.statisticDetail({
                                            branchSelected: this.state.branchSelected,
                                            currentDate: this.state.currentDate,
                                            dataDetailType: 'fund'
                                        })}
                                    >
                                        <Icon style={{textAlign: 'center', alignSelf: 'stretch'}}
                                              name="ios-arrow-forward"/>
                                    </TouchableOpacity>
                                    </Body>
                                </CardItem>
                            </View>
                        </View>


                        <List style={{backgroundColor: 'white', marginTop: 20, marginBottom: 20}}>
                            <ListItem itemDivider>
                                <Left>
                                    <Text style={styles.labelHeader}>{Config.statisticDaily.concrete}</Text>
                                </Left>
                                <Right>
                                    {this._renderShowDetail('concretes')}
                                </Right>
                            </ListItem>
                            <CardItem>
                                <Text style={[styles.boxTitleSecond, styles.labelMain]}>
                                    {Utils.numberWithCommas(this.state.concreateOut)} {Config.statisticDaily.concreteUnit}
                                </Text>
                            </CardItem>
                            <CardItem bordered>
                                <Text style={styles.titleUnder}>{Config.statisticDaily.concreteOut}</Text>
                            </CardItem>
                            <CardItem>
                                <Text style={[styles.boxTitleSecond, styles.labelMain]}>
                                    {Utils.numberWithCommas(this.state.concreateMixed)} {Config.statisticDaily.concreteUnit}
                                </Text>
                            </CardItem>
                            <Text style={{color: '#5c6566',
                                fontSize: 16,
                                width: '100%',
                                textAlign: 'center', alignSelf: 'stretch'
                                }}>{Config.statisticDaily.concreteMix}</Text>
                            <CardItem bordered>
                            </CardItem>


                            <CardItem>
                                <Text style={[styles.boxTitleSecond, styles.labelMain]}>
                                    {Utils.numberWithCommas(this.state.concretePlan)} {Config.statisticDaily.concreteUnit}
                                </Text>
                            </CardItem>
                            <CardItem bordered>
                                <Text style={styles.titleUnder}>{Config.statisticDaily.concretePlan}</Text>
                            </CardItem>


                            <ListItem itemDivider>
                                <Left>
                                    <Text style={styles.labelHeader}>{Config.statisticDaily.brick}</Text>
                                </Left>
                                <Right>
                                    {this.state.bricks == null || this.state.bricks.length == 0 ?
                                        <Text></Text> : this._renderShowDetail('bricks')}
                                </Right>
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
                                    <Left>
                                        <Text style={styles.labelHeader}>{Config.statisticDaily.brickManufacture}</Text>
                                    </Left>
                                    <Right>
                                        {this._renderShowDetail('bricksManufacture')}
                                    </Right>
                                </ListItem>
                                : <Text></Text>}
                            <FlatList
                                key={'statisticDailyBricksManufactureId'}
                                style={{width: '100%'}}
                                data={this.state.bricksManufacture}
                                renderItem={({item}) => this._renderItemResult(item)}
                            />

                            <ListItem itemDivider>
                                <Left>
                                    <Text style={styles.labelHeader}>{Config.statisticDaily.materialIn}</Text>
                                </Left>
                                <Right>
                                    {this.state.materialIn == null || this.state.materialIn.length == 0 ?
                                        <Text></Text> :
                                        this._renderShowDetail('materialIn')}
                                </Right>
                            </ListItem>
                            <FlatList
                                key={'statisticDailyMaterialInId'}
                                style={{width: '100%'}}
                                data={this.state.materialIn}
                                renderItem={({item}) => this._renderItemMaterialInResult(item)}
                            />
                            <Text style={styles.labelHeader}></Text>
                        </List>

                    </Content>
                </Container>
            </SideMenuDrawer>
        );

    }

}