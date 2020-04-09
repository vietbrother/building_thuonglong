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
    FlatList
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
import HTML from 'react-native-render-html';
import ContractConcretesItem from "./ContractConcreteItem";


export default class ContractConcretes extends Component {

    constructor(props) {
        super(props);

        this.state = {
            contracts: [],
            // isLoading: true,
            isSearching: false,
            error: null,
            sessionKey: null,

            extractedText: "",
            searchText: '',
            ContractConcretesSelected: {},
            componentKey: new Date()
        };
    }

    componentWillReceiveProps(nextProps: Readonly<P>, nextContext: any): void {
        this.setState({componentKey: new Date(), searchText: ''});
    }

    componentDidMount() {
        this.search();
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
                <ContractConcretesItem key={key} contract={item}></ContractConcretesItem>
            /*</View>*/
        );
    }

    async search() {
        console.log('ContractConcretess-----------------search');
        this.setState({isSearching: true});
        let items = [];
        try {
            var param = {};
            let response = await fetch(Config.api.url + Config.api.apiHopDongBeTong, {
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
                            {/*<Item>*/}
                                {/*<Input*/}
                                    {/*placeholder="Tìm kiếm bình..."*/}
                                    {/*// value={this.state.searchText}*/}
                                    {/*onChangeText={(text) => this.setState({searchText: text})}*/}
                                    {/*onSubmitEditing={() => this.search(this.state.searchText)}*/}
                                    {/*// style={{marginTop: 9}}*/}
                                {/*/>*/}
                                {/*<Icon name="ios-search" style={Config.mainColor}*/}
                                      {/*onPress={() => this.search(this.state.searchText)}/>*/}
                            {/*</Item>*/}
                            <ActivityIndicator
                                animating={this.state.isSearching}
                                color={Config.mainColor}
                                size="large"
                            />
                            {/*{this._renderResult()}*/}

                            <FlatList
                                style={{width: '100%'}}
                                data={this.state.contracts}
                                renderItem={({item}) => this._renderItemResult(item)}
                            />
                        </View>

                    </Content>
                </Container>
            </SideMenuDrawer>);
    }


}

