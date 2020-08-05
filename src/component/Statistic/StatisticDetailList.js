/**
 * This is the Home page
 **/

// React native and others libraries imports
import React, {Component} from 'react';
import {
    Image,
    ActivityIndicator, FlatList
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


export default class StatisticDetailList extends Component {

    constructor(props) {
        super(props);

        this.state = {
            dataDetailList : []
        };
    }


    componentWillMount(): void {
        this.setState({
            dataDetailList: this.props.dataDetailList,
            dataDetailType: this.props.dataDetailType,
        });
    }

    componentWillReceiveProps(nextProps: Readonly<P>, nextContext: any): void {
        this.setState({
            dataDetailList: this.props.dataDetailList,
            dataDetailType: this.props.dataDetailType,
        });
    }

    componentDidMount() {
    }

    _renderItemResult(item) {
        let type = this.state.dataDetailType;
        if(type == 'bricks'){
            return (
                <Card transparent>
                    <CardItem style={[styles.detailItem]}>
                        <Text style={[styles.boxTitleSecond, styles.labelMain, styles.font18]}>
                            {Utils.numberWithCommas(item.value)} {Config.statisticDaily.brickUnit}
                        </Text>
                    </CardItem>
                    <CardItem  style={[styles.detailItem]} bordered>
                        <Text style={styles.titleUnder}>{item.name}</Text>
                    </CardItem>
                </Card>
            );
        } else {
            return (
                <Card transparent>
                    <CardItem style={[styles.detailItem]}>
                        <Text style={[styles.boxTitleSecond, styles.labelMain, styles.font18]}>
                            {Utils.numberWithCommas(item.value)}
                        </Text>
                    </CardItem>
                    <CardItem  style={[styles.detailItem]} bordered>
                        <Text style={styles.titleUnder}>{item.name}</Text>
                    </CardItem>
                </Card>
            );
        }

    }

    render() {

        return (
            <View style={styles.main}>
                <CardItem header>
                    <Body>
                        <Text style={styles.titleBranch}>
                            <Icon active name="cube"
                                  style={styles.titleBranch}/> {this.state.branchSelected.tenChiNhanh}
                        </Text>
                    </Body>
                </CardItem>

                <List style={{backgroundColor: 'white', marginTop: 20, marginBottom: 20}}>
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
                        key={'statisticDetailListId'}
                        style={{width: '100%'}}
                        data={this.state.dataDetailList}
                        renderItem={({item}) => this._renderItemResult(item)}
                    />

                </List>

            </View>
        );

    }

}

