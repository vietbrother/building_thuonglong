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
    CardBody, H3, Body, Label, Grid, Col, Item
} from 'native-base';
import {Actions} from 'react-native-router-flux';


import Navbar from '../../component/Navbar';
import SideMenu from '../../component/SideMenu';
import SideMenuDrawer from '../../component/SideMenuDrawer';
import Colors from "../../Colors";
import Config from "../../Config";
import styles from '../../styles/ContractStyles';


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

    }

    componentWillReceiveProps(nextProps: Readonly<P>, nextContext: any): void {
        this.setState({componentKey: new Date().valueOf().toString(), searchText: ''});
    }

    componentDidMount() {

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
                    <Navbar left={left} right={right} title={Config.statisticTitle}/>
                    <Content>
                        <View style={styles.main}>
                            <Grid>
                                <Col size={2}>
                                    <View style={styles.subItem}>
                                        <View style={styles.box}>
                                            <CardItem>
                                                <Body><Text style={{color: 'green', textAlign: 'center', fontSize: 30, fontWeight: 'bold'}}>1,000,000,000</Text></Body>
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
                                    <CardItem style={styles.boxContent}>
                                        <Text style={styles.muted}>{Config.statisticDaily.concreteOut}</Text>
                                    </CardItem>
                                </View>
                            </View>
                            <View style={styles.boxItem}>
                                <View style={styles.box}>
                                    <CardItem style={styles.boxContent}>
                                        <Text style={styles.boxTitle}>100000 {Config.statisticDaily.concreteUnit}</Text>
                                    </CardItem>
                                    <CardItem style={styles.boxContent}>
                                        <Text style={styles.muted}>{Config.statisticDaily.concreteMix}</Text>
                                    </CardItem>
                                </View>
                            </View>
                            <View style={styles.boxItem}>
                                <View style={styles.box}>
                                    <CardItem style={styles.boxContent}>
                                        <Text style={styles.boxTitle}>100000 {Config.statisticDaily.concreteUnit}</Text>
                                    </CardItem>
                                    <CardItem style={styles.boxContent}>
                                        <Text style={styles.muted}>{Config.statisticDaily.concretePlan}</Text>
                                    </CardItem>
                                </View>
                            </View>

                            <Text style={styles.boxTitle}>{Config.statisticDaily.brick}</Text>
                            <View style={styles.box}>
                                <CardItem style={styles.boxContent}>
                                    <Text style={styles.boxTitle}>100000 {Config.statisticDaily.brickUnit}</Text>
                                </CardItem>
                                <CardItem style={styles.boxContent}>
                                    <Text style={styles.muted}>{Config.statisticDaily.brickTazo2040}</Text>
                                </CardItem>
                            </View>
                            <View style={styles.box}>
                                <CardItem style={styles.boxContent}>
                                    <Text style={styles.boxTitle}>100000 {Config.statisticDaily.brickUnit}</Text>
                                </CardItem>
                                <CardItem style={styles.boxContent}>
                                    <Text style={styles.muted}>{Config.statisticDaily.brickTazo3030}</Text>
                                </CardItem>
                            </View>
                            <View style={styles.box}>
                                <CardItem style={styles.boxContent}>
                                    <Text style={styles.boxTitle}>100000 {Config.statisticDaily.brickUnit}</Text>
                                </CardItem>
                                <CardItem style={styles.boxContent}>
                                    <Text style={styles.muted}>{Config.statisticDaily.brickTazo5020}</Text>
                                </CardItem>
                            </View>
                        </View>

                    </Content>
                </Container>
            </SideMenuDrawer>
        );

    }

}

