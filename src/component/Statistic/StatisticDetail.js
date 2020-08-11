/**
 * This is the Main file
 **/

// React native and others libraries imports
import React, {Component} from 'react';
import {Image, Dimensions, TouchableWithoutFeedback,
    ActivityIndicator,
    TouchableOpacity, AsyncStorage, Alert} from 'react-native';
import {
    View,
    Container,
    Content,
    Button,
    Left,
    Right,
    Icon
} from 'native-base';
import {Actions} from 'react-native-router-flux';

// Our custom files and classes import
import Config from '../../Config';
import Text from '../../component/Text';
import Navbar from '../../component/Navbar';
import Spinner from 'react-native-loading-spinner-overlay';


import styles from '../../styles/ContractStyles';
import Utils from "../../utils/Utils";
import StatisticDetailItem from "./StatisticDetailItem";

export default class StatisticDetail extends Component {

    constructor(props) {
        super(props);
        this.state = {
            hasError: false,
            errorText: '',
            isLoading: false,
            branchs: [],
            username: '',
            currentDate: '',
            branchSelected: '',
            dataDetailType: '',
        };
    }

    //E:\MyWorks\Project\20200303_stock_app\github\building_thuonglong\node_modules\native-base\src\basic\Icon\NBIcons.json
    componentWillMount() {
        this.setState({
            branchSelected: this.props.branchSelected,
            currentDate: this.props.currentDate,
            dataDetailType: this.props.dataDetailType,
        });
        this._loadBranchData();
    }
    componentWillReceiveProps(nextProps: Readonly<P>, nextContext: any): void {
        this.setState({
            branchSelected: this.props.branchSelected,
            currentDate: this.props.currentDate,
            dataDetailType: this.props.dataDetailType,
        });
        this._loadBranchData();
    }

    componentDidMount() {
    }

    async _loadBranchData() {
        let branchs = [];
        // console.log(this.props.branchSelected);
        if (this.props.branchSelected.id != "BranchIdAll") {
            branchs.push(this.props.branchSelected);
            this.setState({branchs: branchs});
        } else {

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
                this.setState({branchs: responseObj.slice(1)});
                this.setState({isSearching: false});
            } catch (e) {
                console.log(e);
                this.setState({isSearching: false});
            }
        }
    }

    _renderMainContent() {
        var items = [];
        for (var i = 0; i < this.state.branchs.length; i++) {
            var branchItem = this.state.branchs[i];
            items.push(
                <StatisticDetailItem key={branchItem.id}
                                     branchSelected={branchItem}
                                     dataDetailType={this.state.dataDetailType}
                                     currentDate={this.state.currentDate}></StatisticDetailItem>
            );
        }
        return items;
    }

    render() {
        var left = (
            <Left style={{flex: 1}}>
                <Button onPress={() => Actions.pop()} transparent>
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
            <Container style={{backgroundColor: 'white'}}>
                <Spinner
                    //visibility of Overlay Loading Spinner
                    visible={this.state.isLoading}
                    //Text with the Spinner
                    //textContent={'Đang đăng nhập ...'}
                    //Text style of the Spinner Text
                    textStyle={styles.spinnerTextStyle}
                />
                <Navbar left={left} right={right} title={Config.statisticDaily.detail}/>
                <Content contentContainerStyle={{
                    paddingHorizontal: 10,
                    backgroundColor: '#white'
                }}>
                    {this._renderMainContent()}
                    {this.state.isSearching ?
                        <View style={styles.loadingActivity}>
                            <ActivityIndicator
                                animating={this.state.isSearching}
                                color={Config.mainColor}
                                size="large"
                            />
                        </View>
                        : <Text></Text>}

                </Content>

            </Container>
        );
    }


}
