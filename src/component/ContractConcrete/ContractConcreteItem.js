/**
 * This is the Side Menu Drawer Component
 **/

// React native and others libraries imports
import React, {Component} from 'react';
import {
    Image,
    ActivityIndicator,
    ScrollView,
    TouchableOpacity,
    NativeModules,
    Dimensions,
    AsyncStorage, Keyboard, StyleSheet
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
    Input, List, ListItem, Body,
    // Text
} from 'native-base';
import {Actions} from 'react-native-router-flux';


// Our custom files and classes import
import Text from '../../component/Text';
import Navbar from '../../component/Navbar';
import Colors from "../../Colors";
import Config from "../../Config";
import HTML from 'react-native-render-html';
import Spinner from 'react-native-loading-spinner-overlay';

import styles from '../../styles/ContractStyles';

export default class ContractConcreteItem extends Component {
    constructor(props) {
        super(props);

        this.state = {
            categories: [],
            products: [],
            isLoading: false,
            isSearching: false,
            error: null,
            sessionKey: null,

            extractedText: "",
            searchText: '',
            contract: {}
        };
    }

    componentDidMount(): void {
        this.setState({contract: this.props.contract});
        console.log(this.props.contract);
    }

    render() {
        return (
            // <View style={{
            //     // flex: 1,
            //     width: '100%', color: Config.mainColor, fontSize: 16,
            //     // borderBottomColor: Colors.navbarBackgroundColor, borderBottomWidth: 1,
            //     // paddingLeft: 10,
            //     // paddingTop: 20, paddingBottom: 20
            // }}>
            //     <Spinner
            //         //visibility of Overlay Loading Spinner
            //         visible={this.state.isLoading}
            //         //Text with the Spinner
            //         //textContent={'Đang đăng nhập ...'}
            //         //Text style of the Spinner Text
            //         textStyle={styles.spinnerTextStyle}
            //     />
            // </View>
            <Card style={{flex: 1}}>
                {this._renderMainContent()}
            </Card>
        );
    }

    _renderDateFormat(date) {
        if (date != null && date != undefined) {
            var dateStr = date.substring(0, 10);
            console.log(date);
            dateStr = dateStr.replace(/(\d{4})-(\d{1,2})-(\d{1,2})/, function (match, y, m, d) {
                return d + '/' + m + '/' + y;
            });
            return dateStr;
        } else {
            return '';
        }
    }

    _renderMainContent() {
        return (
            <TouchableOpacity
                onPress={() => Actions.contractConcreteDetail({contract: this.props.contract})}
                activeOpacity={0.9}
            >
                <CardItem header>
                    <Left>
                        <Text style={styles.titleBranch}>
                            <Icon active name="cube"
                                  style={styles.titleBranch}/> {this.state.contract.tenChiNhanh}
                        </Text>
                    </Left>
                    <Right>
                        {this._renderStatus(this.state.contract.trangThaiText)}
                    </Right>
                </CardItem>
                <CardItem bordered>
                    <Left>
                        <Text style={styles.muted}><Icon note name="md-person"
                                                         style={styles.icon}/> {Config.contractConcrete.providerName} :
                        </Text>
                    </Left>
                    <Right>
                        <Text style={styles.title}>{this.state.contract.tenNhaCungCap}</Text>
                    </Right>
                </CardItem>
                <CardItem bordered>
                    <Left>
                        <Text style={styles.muted}><Icon note name="briefcase"
                                                         style={styles.icon}/> {Config.contractConcrete.projectName} :
                        </Text>
                    </Left>
                    <Right>
                        <Text style={styles.title}>{this.state.contract.tenCongTrinh}</Text>
                    </Right>
                </CardItem>
                {/*<CardItem bordered>*/}
                {/*    <Left>*/}
                {/*        <Body>*/}
                {/*            <Text note><Icon note name="md-person" style={{fontSize: 16}}/> Nha cung cap : </Text>*/}
                {/*            <Text>{this.state.contract.tenNhaCungCap}</Text>*/}
                {/*        </Body>*/}
                {/*    </Left>*/}
                {/*    <Right>*/}
                {/*        <Body>*/}
                {/*            <Text note><Icon note name="md-business" style={{fontSize: 16}}/> Cong trinh : </Text>*/}
                {/*            <Text>San van dong </Text>*/}
                {/*        </Body>*/}
                {/*    </Right>*/}
                {/*</CardItem>*/}

                <CardItem>
                    <Left>
                        <Body>
                        <Text style={styles.muted}>{Config.common.fromDate}</Text>
                        <Button transparent>
                            <Icon name="md-calendar" style={{marginLeft: 0}}/>
                            <Text style={styles.date}>{this._renderDateFormat(this.state.contract.tuNgay)}</Text>
                        </Button>
                        </Body>
                    </Left>
                    <Right>
                        <Body>
                        <Text style={styles.muted}>{Config.common.toDate}</Text>
                        <Button transparent>
                            <Icon name="md-calendar" style={{}}/>
                            <Text style={styles.date}>{this._renderDateFormat(this.state.contract.denNgay)}</Text>
                        </Button>
                        </Body>
                    </Right>
                </CardItem>

            </TouchableOpacity>
        );


    }


    _renderStatus(status) {
        if (status == Config.state.wait) {
            return (
                <Text style={styles.statusRed}>
                    <Icon active name="md-lock" style={styles.statusRed}/> {Config.state.wait.toUpperCase()}
                </Text>
            );
        } else if (status == Config.state.approved) {
            return (
                <Text style={styles.statusSuccess}>
                    <Icon active name="md-checkmark" style={styles.statusSuccess}/> {Config.state.approved.toUpperCase()}
                </Text>
            );
        } else {
            return (
                <Text style={styles.statusRed}>
                    <Icon active name="md-lock-closed-outline" style={styles.statusRed}/> {status}
                </Text>
            );
        }

    }

}

