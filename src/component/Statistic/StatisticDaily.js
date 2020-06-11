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
    Dimensions, Text
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

import {Circle, G} from 'react-native-svg';
import {
    AreaChart, Grid, PieChart,
    XAxis, YAxis
} from 'react-native-svg-charts';
import * as scale from 'd3-scale';
import PureChart from 'react-native-pure-chart';
import { //PieChart,
    BarChart, LineChart
} from "react-native-chart-kit";

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
            componentKey: new Date().valueOf().toString()
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
        this.setState({componentKey: new Date().valueOf().toString(), searchText: ''});
    }

    componentDidMount() {
        this.loadDataSumary();
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
            let response = await fetch(global.hostAPI[0] + Config.api.apiGiaBanVatLieu, {
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
            let response = await fetch(global.hostAPI[0] + Config.api.apiStatisticTotal, {
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
                    item['svg'] = {
                        fill: this.state.summaryColors[i],
                        onPress: () => alert('press ' + item.idchiNhanh)
                    };
                    item['color'] = this.state.summaryColors[i];
                    item['key'] = 'pie-' + i + 1;
                    item['amount'] = item.total;
                    items.push(item);
                }

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
                // styleTemp['width'] = 20;
                // styleTemp['height'] = 20;

                console.log(styleTemp);
                items.push(
                    <Label
                        style={styleTemp}>{this.state.summaryData[i].tenChiNhanh} : {this.state.summaryData[i].total}</Label>
                );
            }
        }
        return items;
    }

    renderTest() {
        const screenWidth = Dimensions.get("window").width;
        const pieData = [
            {
                name: "tram tron thuong lau",
                value: 12,
                color: "skyblue",
                legendFontColor: "#181818",
                legendFontSize: 15
            },
            {
                name: "Data 2",
                value: 24,
                color: "blue",
                legendFontColor: "#181818",
                legendFontSize: 15
            },
            {
                name: "Data 3",
                value: 31,
                color: "red",
                legendFontColor: "#181818",
                legendFontSize: 15
            },
            {
                name: "Data 4",
                value: 43,
                color: "green",
                legendFontColor: "#181818",
                legendFontSize: 15
            }
        ];
        const chartConfig = {
            backgroundGradientFrom: "#1E2923",
            backgroundGradientFromOpacity: 0,
            backgroundGradientTo: "#08130D",
            backgroundGradientToOpacity: 0.5,
            color: (opacity = 1) => `rgba(26, 255, 146, ${opacity})`,
            strokeWidth: 2, // optional, default 3
            barPercentage: 0.5
        };


        const data = {
            labels: ["January", "February", "March", "April", "May", "June"],
            datasets: [
                {
                    data: [20, 45, 28, 80, 99, 43]
                }
            ]
        };

        return (
            <View style={{flex: 1, justifyContent: 'space-evenly', alignItems: 'center'}}>
                {/*<Text style={{ fontSize: 30 }}>Pie Chart Data</Text>*/}
                {/*<PieChart*/}
                {/*data={pieData}*/}
                {/*width={screenWidth}*/}
                {/*height={220}*/}
                {/*chartConfig={chartConfig}*/}
                {/*accessor="value"*/}
                {/*backgroundColor="transparent"*/}
                {/*paddingLeft="20"*/}
                {/*absolute*/}
                {/*/>*/}

                <LineChart
                    data={{
                        labels: [
                            'January',
                            'February',
                            'March',
                            'April',
                            'May',
                            'June',
                        ],
                        datasets: [
                            {
                                data: [20, 45, 28, 80, 99, 43],
                                strokeWidth: 2,
                            },
                        ],
                    }}
                    width={Dimensions.get('window').width - 16}
                    height={220}
                    chartConfig={{
                        backgroundColor: '#1cc910',
                        backgroundGradientFrom: '#eff3ff',
                        backgroundGradientTo: '#efefef',
                        decimalPlaces: 2,
                        color: (opacity = 1) => `rgba(0, 0, 0, ${opacity})`,
                        style: {
                            borderRadius: 16,
                        },
                    }}
                    style={{
                        marginVertical: 8,
                        borderRadius: 16,
                    }}
                />

                <Text style={{fontSize: 30}}>Bar Chart Data</Text>
                <BarChart
                    data={{
                        labels: [
                            'January',
                            'February',
                            'March',
                            'April',
                            'May',
                            'June',

                        ],
                        datasets: [
                            {
                                data: [20, 45, 28, 80, 99, 43],
                            },
                        ],
                    }}
                    width={Dimensions.get('window').width - 16}
                    height={220}
                    yAxisLabel={'$'}
                    chartConfig={{
                        backgroundColor: '#1cc910',
                        backgroundGradientFrom: '#152b78',
                        backgroundGradientTo: '#223b97',
                        decimalPlaces: 2,
                        color: (opacity = 1) => `rgba(255, 255, 255, ${opacity})`,
                        style: {
                            borderRadius: 16,
                            color: 'white'
                        },
                    }}
                    style={{
                        marginVertical: 8,
                        borderRadius: 16,
                        backgroundColor: 'white'
                    }}
                />
            </View>
        );
    }

    render() {
        //var data = this.state.summaryData;

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
                        <View style={styles.main}>
                            <Grid>
                                <Col size={2}>
                                    <View style={styles.subItem}>
                                        <View style={styles.box}>
                                            <CardItem>
                                                <Body><Text style={styles.boxTitle}>100000</Text></Body>
                                            </CardItem>
                                            <CardItem>
                                                <Body><Text style={styles.muted}>Thu</Text></Body>
                                            </CardItem>
                                        </View>
                                    </View>
                                </Col>
                                <Col size={2}>
                                    <View style={styles.subItem}>
                                        <View style={styles.box}>
                                            <CardItem>
                                                <Body><Text style={styles.boxTitle}>100000</Text></Body>
                                            </CardItem>
                                            <CardItem>
                                                <Body><Text style={styles.muted}>Thu</Text></Body>
                                            </CardItem>
                                        </View>
                                    </View>
                                </Col>
                            </Grid>

                            <Text style={styles.boxTitle}>{Config.statisticDaily.concrete}</Text>
                            <View style={styles.boxItem}>
                                <View style={styles.box}>
                                    <CardItem style={styles.boxContent}>
                                        <Text style={styles.boxTitle}>100000 {Config.statisticDaily.concreteUnit}</Text>
                                    </CardItem>
                                    <Item style={styles.boxContent}>
                                        <Text style={styles.muted}>{Config.statisticDaily.concreteOut}</Text>
                                    </Item>
                                </View>
                            </View>
                            <View style={styles.boxItem}>
                                <View style={styles.box}>
                                    <CardItem style={styles.boxContent}>
                                        <Text style={styles.boxTitle}>100000 {Config.statisticDaily.concreteUnit}</Text>
                                    </CardItem>
                                    <Item style={styles.boxContent}>
                                        <Text style={styles.muted}>{Config.statisticDaily.concreteMix}</Text>
                                    </Item>
                                </View>
                            </View>
                            <View style={styles.boxItem}>
                                <View style={styles.box}>
                                    <CardItem style={styles.boxContent}>
                                        <Text style={styles.boxTitle}>100000 {Config.statisticDaily.concreteUnit}</Text>
                                    </CardItem>
                                    <Item style={styles.boxContent}>
                                        <Text style={styles.muted}>{Config.statisticDaily.concretePlan}</Text>
                                    </Item>
                                </View>
                            </View>

                            <Text style={styles.boxTitle}>{Config.statisticDaily.brick}</Text>
                            <View style={styles.box}>
                                <CardItem style={styles.boxContent}>
                                    <Text style={styles.boxTitle}>100000 {Config.statisticDaily.brickUnit}</Text>
                                </CardItem>
                                <Item style={styles.boxContent}>
                                    <Text style={styles.muted}>{Config.statisticDaily.brickTazo2040}</Text>
                                </Item>
                            </View>
                            <View style={styles.box}>
                                <CardItem style={styles.boxContent}>
                                    <Text style={styles.boxTitle}>100000 {Config.statisticDaily.brickUnit}</Text>
                                </CardItem>
                                <Item style={styles.boxContent}>
                                    <Text style={styles.muted}>{Config.statisticDaily.brickTazo3030}</Text>
                                </Item>
                            </View>
                            <View style={styles.box}>
                                <CardItem style={styles.boxContent}>
                                    <Text style={styles.boxTitle}>100000 {Config.statisticDaily.brickUnit}</Text>
                                </CardItem>
                                <Item style={styles.boxContent}>
                                    <Text style={styles.muted}>{Config.statisticDaily.brickTazo5020}</Text>
                                </Item>
                            </View>
                        </View>

                    </Content>
                </Container>
            </SideMenuDrawer>
        );

    }

}

