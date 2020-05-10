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
    Dimensions
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
    CardBody, H3, Body, Label
} from 'native-base';
import {Actions} from 'react-native-router-flux';


import Navbar from '../../component/Navbar';
import SideMenu from '../../component/SideMenu';
import SideMenuDrawer from '../../component/SideMenuDrawer';
import Colors from "../../Colors";
import Config from "../../Config";
import styles from '../../styles/ContractStyles';

import {Circle, G, Text} from 'react-native-svg';
import {AreaChart, BarChart, Grid, PieChart, XAxis, YAxis} from 'react-native-svg-charts';
import * as scale from 'd3-scale';
import PureChart from 'react-native-pure-chart';

export default class Statistic extends Component {

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
            componentKey: new Date()
        };
    }


    componentWillMount(): void {
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
        this.loadDataSumary();
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
            //this.search();
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

    async loadDataSumary() {
        this.setState({isSearching: true});
        this.setState({summaryData: [], summaryLabel: []});
        let items = [];
        let itemsLabel = [];
        try {
            var param = {};
            let response = await fetch(Config.api.url + Config.api.apiStatisticTotal, {
                method: 'POST',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(param)
            });
            var responseObj = await response.json();
            this.setState({isSearching: false});
            if (responseObj != null && responseObj.length > 0) {
                for (var i = 0; i < responseObj.length; i++) {
                    var item = responseObj[i];
                    item['svg'] = {fill: this.state.summaryColors[i]};
                    item['color'] = this.state.summaryColors[i];
                    item['key'] = i + 1;
                    item['amount'] = item.total;
                    items.push(item);
                }
                console.log(items);
                this.setState({summaryData: items});
            }
        } catch (e) {
            console.log(e);
            this.setState({isSearching: false});
        }
    }

    _renderLabel() {
        var items = [];
        if (this.state.summaryData.length > 0) {
            for (var i = 0; i < this.state.summaryData.length; i++) {

                var styleTemp = {};
                styleTemp['color'] = this.state.summaryData[i].color;
                styleTemp['width'] = 20;
                styleTemp['height'] = 20;

                console.log(styleTemp);
                items.push(<CardItem key={i}>
                    <Button style={{styleTemp}}></Button>
                    <Label>{this.state.summaryData[i].tenChiNhanh}</Label>
                </CardItem>);
            }
        }
        return items;
    }

    render() {
        // const data = [50, 10, 40, 95, -4, -24, 85, 91, 35, 53, -53, 24, 50, -20, -80]
        //
        // const randomColor = () => ('#' + ((Math.random() * 0xffffff) << 0).toString(16) + '000000').slice(0, 7)
        //
        // const pieData = data
        //     .filter((value) => value > 0)
        //     .map((value, index) => ({
        //         value,
        //         svg: {
        //             fill: randomColor(),
        //             onPress: () => console.log('press', index),
        //         },
        //         key: `pie-${index}`,
        //     }));
        //
        // let sampleData = [
        //     {
        //         value: 50,
        //         label: 'Marketing',
        //         color: 'orange',
        //     }, {
        //         value: 20,
        //         label: 'Sales',
        //         color: 'yellow'
        //     }, {
        //         value: 30,
        //         label: 'Support',
        //         color: 'green'
        //     }
        //
        // ];

        // const data1 = [
        //     {
        //         key: 1,
        //         amount: 50,
        //         svg: {fill: '#600080'},
        //     },
        //     {
        //         key: 2,
        //         amount: 50,
        //         svg: {fill: '#cc784c'}
        //     },
        //     {
        //         key: 3,
        //         amount: 40,
        //         svg: {fill: '#c61aff'}
        //     },
        //     {
        //         key: 4,
        //         amount: 95,
        //         svg: {fill: '#8aff28'}
        //     },
        //     {
        //         key: 5,
        //         amount: 35,
        //         svg: {fill: '#ecb3ff'}
        //     }
        // ];

        var data = this.state.summaryData;

        var Labels = ({slices, height, width}) => {
            return slices.map((slice, index) => {
                var {labelCentroid, pieCentroid, data} = slice;
                return (
                    <Text
                        key={index}
                        x={pieCentroid[0]}
                        y={pieCentroid[1]}
                        fill={'white'}
                        textAnchor={'middle'}
                        alignmentBaseline={'middle'}
                        fontSize={16}
                        stroke={'black'}
                        strokeWidth={0.1}
                        onPress={() => alert(`onPressIn clicked ${index}`)}
                    >
                        {data.amount}
                    </Text>
                )
            })
        };


        const dataBar = [10, 5, 25, 1115, 20];

        const CUT_OFF = 20
        const LabelsBar = ({x, y, bandwidth, data}) => (
            data.map((value, index) => (
                <Text
                    key={index}
                    x={x(index) + (bandwidth / 2)}
                    y={value < CUT_OFF ? y(value) - 10 : y(value) + 15}
                    fontSize={16}
                    fill={value >= CUT_OFF ? 'white' : 'black'}
                    alignmentBaseline={'middle'}
                    textAnchor={'middle'}
                >
                    {value}
                </Text>
            ))
        );


        const dataBarChart = [
            {date: 1577421956000, value: 0.36},
            {date: 1577940356000, value: 0.36},
            {date: 1577508356000, value: 0.36},
            {date: 1577594756000, value: 0.36},
            {date: 1577681156000, value: 0.36},
            {date: 1577767556000, value: 0.36},
            {date: 1577853956000, value: 0.36},
            {date: 1578026756000, value: 0.34},
            {date: 1578113156000, value: 0.36},
            {date: 1578199556000, value: 0.29},
            {date: 1578285956000, value: 0.26},
            {date: 1578458756000, value: 0.48},
        ];

        // const data = [14, 80, 100, 55, 30]

        const axesSvg = {fontSize: 10, fill: 'blue'};
        const verticalContentInset = {top: 10, bottom: 10}
        const xAxisHeight = 30
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
                        {/*<PieChart style={{height: 200, marginTop: 10}} data={pieData}/>*/}
                        <CardItem>
                            <Body>
                            <H3>{Config.titleReportHopDongBeTong}</H3>
                            </Body>
                        </CardItem>

                        <PieChart
                            style={{height: 200, padding: 16}}
                            valueAccessor={({item}) => item.amount}
                            data={data}
                            spacing={10}
                            outerRadius={'100%'}
                        >
                            <Labels/>
                        </PieChart>

                        {this._renderLabel()}


                        <View style={{height: 200, paddingVertical: 16, paddingHorizontal: 16}}>

                            <BarChart
                                style={{flex: 1}}
                                data={dataBar}
                                svg={{fill: Config.mainColor}}
                                contentInset={{top: 10, bottom: 10}}
                                spacing={0.2}
                                gridMin={0}
                            >
                                <Grid direction={Grid.Direction.HORIZONTAL}/>
                                <LabelsBar/>
                            </BarChart>
                            <XAxis
                                style={{marginTop: 10}}
                                data={dataBar}
                                xAccessor={({item}) => item}
                                scale={scale.scaleBand}
                                formatLabel={(value, index) => value}
                                labelStyle={{color: 'black'}}
                            />
                        </View>

                        <View style={{height: 200, padding: 20}}>
                            <BarChart
                                style={{flex: 1}}
                                data={dataBarChart}
                                yAccessor={({item}) => item.value}
                                xAccessor={({item}) => item.date}
                                xScale={scale.scaleTime}
                                contentInset={{top: 10, bottom: 10}}
                                svg={{fill: 'rgba(134, 65, 244, 0.5)'}}
                            ></BarChart>
                            <XAxis
                                data={dataBarChart}
                                svg={{
                                    fill: 'black',
                                    fontSize: 8,
                                    fontWeight: 'bold',
                                    rotation: 20,
                                    originY: 30,
                                    y: 5,
                                }}
                                xAccessor={({item}) => item.date}
                                scale={scale.scaleTime}

                                style={{marginHorizontal: -15, height: 20}}
                                contentInset={{left: 10, right: 25}}
                                formatLabel={(value) => value}
                            />
                        </View>
                        <View style={{
                            flex: 1,
                            justifyContent: 'center',
                            alignItems: 'center',
                            color: Config.mainColor
                        }}>
                            {/*<Text>123123</Text>*/}
                            {/*<PureChart data={sampleData} type='pie'/>*/}

                        </View>

                    </Content>
                </Container>
            </SideMenuDrawer>
        );

    }

}



