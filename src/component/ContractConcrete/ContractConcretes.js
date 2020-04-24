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
    Dimensions,
    Alert,
    FlatList, Picker
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
    Tab, Tabs, TabHeading
    // Text
} from 'native-base';
import {Actions} from 'react-native-router-flux';


import Text from '../../component/Text';
import Navbar from '../../component/Navbar';
// import SideMenu from '../../component/SideMenu';
import SideMenuDrawer from '../../component/SideMenuDrawer';
import Config from "../../Config";
// import HTML from 'react-native-render-html';
import ContractConcretesItem from "./ContractConcreteItem";
import styles from "../../styles/ContractStyles";


export default class ContractConcretes extends Component {

    constructor(props) {
        super(props);

        this.state = {
            contracts: [],
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
            componentKey: new Date()
        };
    }

    componentWillReceiveProps(nextProps: Readonly<P>, nextContext: any): void {
        this.setState({componentKey: new Date()});//refresh menu
        console.log(this.state.branchSelected);
        this.search(this.state.branchSelected, Config.stateCode.wait);
        this.search(this.state.branchSelected, Config.stateCode.approved);
    }

    componentDidMount() {
        this.getSessionKey();
    }

    componentWillMount(): void {
        this._loadBranchData();
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
            }
        } catch (error) {
            // Handle errors here
            console.error(error);
        }
    }

    async _loadBranchData() {
        this.setState({isSearching: true});
        this.setState({contracts: []});
        try {
            var param = {};
            let response = await fetch(Config.api.url + Config.api.apiListBranch, {
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


    _renderItemResult(item) {
        var key = new Date().valueOf();
        return (
            /*            <View style={{
                            flex: 1,
                            width: '100%', color: Config.mainColor, fontSize: 16,
                            borderBottomColor: Colors.navbarBackgroundColor, borderBottomWidth: 0.5,
                            padding: 5
                        }}>*/
            <ContractConcretesItem key={item.id} contract={item}
                                   sessionKey={this.state.sessionKey}></ContractConcretesItem>
            /*</View>*/
        );
    }

    _actionSelectBranch(itemValue) {
        console.log("+++++++++++++++++++++++ " + itemValue);
        this.setState({branchSelected: itemValue});
        console.log(this.state.branchSelected);
        this.search(itemValue, Config.stateCode.wait);
        this.search(itemValue, Config.stateCode.approved);
    }

    async search(branchId, type) {
        console.log('ContractConcretess-----------------search ' + this.state.branchSelected);
        this._switchState(type, [], true);
        try {
            var param = {idchiNhanh: branchId, idTrangThai: type};
            let response = await fetch(Config.api.url + Config.api.apiHopDongBeTong, {
                method: 'POST',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(param)
            });
            var responseObj = await response.json();
            this._switchState(type, responseObj, false);
        } catch (e) {
            console.log(e);
            this._switchState(type, [], false);
        }
    }

    _switchState(type, data, status) {
        if (type == Config.stateCode.approved) {
            this.setState({isSearchingActive: status});
            this.setState({contractsActive: data});
        } else {
            this.setState({isSearching: status});
            this.setState({contracts: data});
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
            <SideMenuDrawer ref={(ref) => this._sideMenuDrawer = ref}
                            key={this.state.componentKey}
                // key={new Date().valueOf()}
                // fetchData={'1'}
                // sessionLoginKey={this.props.sessionLoginKey}
            >
                <Container>
                    <Navbar left={left} right={right} title={Config.contractConcrete.title}/>
                    <Content>
                        <View style={{
                            flex: 1,
                            justifyContent: 'center',
                            alignItems: 'center',
                            // paddingLeft: 10,
                            // paddingRight: 10
                        }}>
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
                            <Tabs tabBarUnderlineStyle={styles.tabActive}>
                                <Tab heading={
                                    <TabHeading style={styles.tabHeading}>
                                        <Icon name="md-lock" style={styles.tabTitle}/>
                                        <Text style={styles.tabTitle}> {Config.state.wait.toUpperCase()}</Text>
                                    </TabHeading>
                                }>
                                    {this.state.isSearching ?
                                        <View style={styles.loadingActivity}>
                                            <ActivityIndicator
                                                animating={this.state.isSearching}
                                                color={Config.mainColor}
                                                size="large"
                                            />
                                        </View>
                                        : <Text></Text>}
                                    <FlatList
                                        key={'contractConcrete_1'}
                                        style={{width: '100%'}}
                                        data={this.state.contracts}
                                        renderItem={({item}) => this._renderItemResult(item)}
                                    />
                                </Tab>
                                <Tab heading={
                                    <TabHeading style={styles.tabHeading}>
                                        <Icon name="md-checkmark" style={styles.tabTitle}/>
                                        <Text style={styles.tabTitle}> {Config.state.active.toUpperCase()}</Text>
                                    </TabHeading>
                                }>
                                    {this.state.isSearchingActive ?
                                        <View style={styles.loadingActivity}>
                                            <ActivityIndicator
                                                animating={this.state.isSearchingActive}
                                                color={Config.mainColor}
                                                size="large"
                                            />
                                        </View>
                                        : <Text></Text>}
                                    <FlatList
                                        key={'contractConcrete_2'}
                                        style={{width: '100%'}}
                                        data={this.state.contractsActive}
                                        renderItem={({item}) => this._renderItemResult(item)}
                                    />
                                </Tab>
                            </Tabs>
                        </View>

                    </Content>
                </Container>
            </SideMenuDrawer>);
    }


}

