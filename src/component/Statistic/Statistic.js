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
    Input, List, ListItem,
    // Text
} from 'native-base';
import {Actions} from 'react-native-router-flux';


import Text from '../../component/Text';
import Navbar from '../../component/Navbar';
import SideMenu from '../../component/SideMenu';
import SideMenuDrawer from '../../component/SideMenuDrawer';
import Colors from "../../Colors";
import Config from "../../Config";
import ContractMaterialsItem from "./ContractMaterialItem";
import styles from '../../styles/ContractStyles';


export default class Statistic extends Component {

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

    componentDidMount() {
        // this.callApi();
        //this.getSessionKey();
    }

    componentWillMount(): void {
        // this._searchStage(Config.stage1Vo);
        // this._searchStage(Config.stage2TaiNap);
        // this._searchStage(Config.stage3BinhTon);
        // this._searchStage(Config.stage4BinhDangSuDung);
        // // this._searchStageAll();

        this._searchCountStage();

        var date = new Date();
        var firstDay = new Date(date.getFullYear(), date.getMonth(), 1);
        var lastDay = new Date(date.getFullYear(), date.getMonth() + 1, 0);
        var startDate = firstDay.toISOString().split('T')[0];
        var endDate = lastDay.toISOString().split('T')[0];
    }

    componentWillReceiveProps(nextProps: Readonly<P>, nextContext: any): void {
        this.setState({componentKey: new Date(), searchText: ''});
    }
    componentDidMount() {
        this._loadBranchData();
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
            this.search();
        } catch (e) {
            console.log(e);
            this.setState({isSearching: false});
        }
    }

    _renderBranch() {
        var items = [];
        for (var i = 0; i < this.state.branchs.length; i++) {
            var branchItem = this.state.branchs[i];
            items.push(<Picker.Item label={branchItem.tenChiNhanh} value={branchItem.id}/>);
        }
        return items;
    }

    _renderItemResult(item) {
        console.log(item);
        var key = new Date().valueOf();
        return (
            /*            <View style={{
                            flex: 1,
                            width: '100%', color: Config.mainColor, fontSize: 16,
                            borderBottomColor: Colors.navbarBackgroundColor, borderBottomWidth: 0.5,
                            padding: 5
                        }}>*/
            <ContractMaterialsItem key={key} contract={item}></ContractMaterialsItem>
            /*</View>*/
        );
    }

    _actionSelectBranch(itemValue) {
        console.log("+++++++++++++++++++++++ " + itemValue);
        this.setState({branchSelected: itemValue});
        this.search();
    }

    async search() {
        console.log('ContractMaterialss-----------------search ' + this.state.branchSelected);
        this.setState({isSearching: true});
        this.setState({contracts: []});
        let items = [];
        try {
            var param = {idchiNhanh: this.state.branchSelected};
            let response = await fetch(Config.api.url + Config.api.apiGiaBanVatLieu, {
                method: 'POST',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(param)
            });
            var responseObj = await response.json();
            this.setState({isSearching: false});
            this.setState({contracts: responseObj});
        } catch (e) {
            console.log(e);
            this.setState({isSearching: false});
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
                // key={new Date().valueOf()}
                key={this.state.componentKey}
                // fetchData={'1'}
                //             sessionLoginKey={this.props.sessionLoginKey}
            >
                <Container>
                    <Navbar left={left} right={right} title={Config.statisticTitle}/>
                    <Content>
                        <View style={{
                            flex: 1,
                            justifyContent: 'center',
                            alignItems: 'center',
                            color: Config.mainColor
                        }}>

                        </View>

                    </Content>
                </Container>
            </SideMenuDrawer>);

    }

}



