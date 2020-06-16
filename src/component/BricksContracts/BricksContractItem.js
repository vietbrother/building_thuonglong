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
import Utils from "../../utils/Utils";

export default class BricksContractItem extends Component {
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
        this.setState({contract: this.props.contract, sessionKey: this.props.sessionKey});
        console.log(this.props.sessionKey);
    }

    render() {
        return (
            <Card style={{flex: 1}}>
                {this._renderMainContent()}
            </Card>
        );
    }

    _renderMainContent() {
        return (
            <TouchableOpacity
                onPress={() => Actions.bricksContractDetail({contract: this.props.contract, sessionKey: this.props.sessionKey})}
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
                        {Utils._renderStatus(this.state.contract.trangThaiText)}
                    </Right>
                </CardItem>
                <CardItem bordered>
                    <Left>
                        <Body>
                        <Text style={styles.muted}><Icon note name="md-person"
                                                         style={styles.icon}/> {Config.contractConcrete.providerName} :
                        </Text>
                        </Body>
                    </Left>
                    <Right>
                        <Body>
                        <Text style={styles.title}>{this.state.contract.nhaCungCap}</Text>
                        </Body>
                    </Right>
                </CardItem>
                <CardItem bordered>
                    <Left>
                        <Body>
                        <Text style={styles.muted}><Icon note name="briefcase"
                                                         style={styles.icon}/> {Config.contractConcrete.projectName} :
                        </Text>
                        </Body>
                    </Left>
                    <Right>
                        <Body>
                        <Text style={styles.title}>{this.state.contract.congTrinh}</Text>
                        </Body>
                    </Right>
                </CardItem>


                <CardItem>
                    <Left>
                        <Body>
                        <Text style={styles.muted}>{Config.common.fromDate}</Text>
                        <Button transparent>
                            <Icon name="md-calendar" style={{marginLeft: 0}}/>
                            <Text style={styles.date}>{Utils._renderDateFormat(this.state.contract.tuNgay)}</Text>
                        </Button>
                        </Body>
                    </Left>
                    <Right>
                        <Body>
                        <Text style={styles.muted}>{Config.common.toDate}</Text>
                        <Button transparent>
                            <Icon name="md-calendar" style={{}}/>
                            <Text style={styles.date}>{Utils._renderDateFormat(this.state.contract.denNgay)}</Text>
                        </Button>
                        </Body>
                    </Right>
                </CardItem>

            </TouchableOpacity>
        );
    }

}

