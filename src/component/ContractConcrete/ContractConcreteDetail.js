/**
 * This is the Main file
 **/

// React native and others libraries imports
import React, {Component} from 'react';
import {Image, Dimensions, TouchableWithoutFeedback, AsyncStorage, Alert, TouchableOpacity} from 'react-native';
import {
    View,
    Container,
    Content,
    Button,
    Left,
    Right,
    Icon,
    Picker,
    Item,
    Grid,
    Col,
    Toast,
    Text as NBText,
    List, ListItem,
    Card, CardItem,
    DatePicker,
    Body, Input, H3
} from 'native-base';
import {Actions} from 'react-native-router-flux';
import Carousel, {Pagination} from 'react-native-snap-carousel';

// Our custom files and classes import
import Config from '../../Config';
import Text from '../../component/Text';
import Navbar from '../../component/Navbar';
import Spinner from 'react-native-loading-spinner-overlay';


import styles from '../../styles/ContractStyles';
import Utils from "../../utils/Utils";

export default class ContractConcreteDetail extends Component {

    constructor(props) {
        super(props);
        this.state = {
            hasError: false,
            errorText: '',
            isLoading: false,
            contract: {},
            username: '',
        };
    }

    //E:\MyWorks\Project\20200303_stock_app\github\building_thuonglong\node_modules\native-base\src\basic\Icon\NBIcons.json

    componentWillMount() {
    }

    async componentDidMount() {
        this.setState({
            contract: this.props.contract,
        });
        console.log(this.props.contract);
        let username = await AsyncStorage.getItem('userId');
        this.setState({
            username: username,
        });
        console.log(this.state.username);
    }

    _renderApproveButton(status) {
        if (status == Config.stateCode.wait) {
            return (
                <CardItem>
                    <Left>
                        <Button active onPress={() => Actions.pop()} transparent>
                            <Text style={styles.btnReject}><Icon style={styles.icon} name='ios-close'/> {Config.btnReject}
                            </Text>
                        </Button>
                    </Left>
                    <Right>
                        <TouchableOpacity
                            style={styles.btnApprove}
                            onPress={() => this._preApprove()}
                            activeOpacity={0.9}
                        >
                            <Text style={styles.titleApprove}><Icon style={styles.titleApprove}
                                                                    name='md-checkmark'/> {Config.btnApprove}
                            </Text>
                        </TouchableOpacity>
                    </Right>
                </CardItem>
            );
        } else if (status == Config.stateCode.approved) {
            return (
                <CardItem>
                    <Body>
                    <Button active onPress={() => Actions.pop()} transparent>
                        <Text style={styles.btnReject}><Icon style={styles.icon} name='ios-close'/> {Config.btnClose}
                        </Text>
                    </Button>
                    </Body>
                </CardItem>
            );
        } else {
            return (
                <CardItem>
                    <Body>
                    <Button active onPress={() => Actions.pop()} transparent>
                        <Text style={styles.btnReject}><Icon style={styles.icon} name='ios-close'/> {Config.btnClose}
                        </Text>
                    </Button>
                    </Body>
                </CardItem>
            );
        }

    }

    _preApprove() {
        Alert.alert(
            '',
            Config.confirm_approve, // <- this part is optional, you can pass an empty string
            [
                {text: 'Đồng ý', onPress: () => this._actionApprove()},
                {
                    text: 'Hủy',
                    onPress: () => console.log('Cancel Pressed'),
                    style: 'cancel',
                },
            ],
            {cancelable: false},
        );
    }

    async _actionApprove() {
        try {
            this.setState({isLoading: true});

            var param = {
                approveStateId: Utils._getStatusCode(this.state.contract.trangThaiText),
                contractId: this.state.contract.id,
                type: Config.APPROVE_TYPE.CONTRACT_CONCRETE,
                username: this.state.username,
            };
            console.log(param);

            let response = await fetch(Config.api.url + Config.api.apiApprove, {
                method: 'POST',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(param)
            });
            var responseObj = await response.json();
            this.setState({isLoading: false});
            console.log(responseObj);
            if (responseObj != null && responseObj.code == Config.resCode.success) {
                alert(Config.successApprove);
                Actions.contractConcretes({branchId: '123'});
            } else {
                alert(Config.err_approve + " : " + responseObj.message);
            }
        } catch (error) {
            console.error(error);
            this.setState({isLoading: false});
        }
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
            <Container style={{backgroundColor: '#fdfdfd'}}>
                <Spinner
                    //visibility of Overlay Loading Spinner
                    visible={this.state.isLoading}
                    //Text with the Spinner
                    //textContent={'Đang đăng nhập ...'}
                    //Text style of the Spinner Text
                    textStyle={styles.spinnerTextStyle}
                />
                <Navbar left={left} right={right} title={Config.contractConcrete.detail}/>
                <Content contentContainerStyle={{
                    paddingHorizontal: 10,
                    backgroundColor: '#f3f9ff'
                }}>
                    <Card transparent>
                        <CardItem header bordered>
                            <H3>{Config.contractConcrete.title}</H3>
                        </CardItem>

                        <CardItem>
                            <Left></Left>
                            <Right>
                                {Utils._renderStatus(this.state.contract.trangThaiText)}
                            </Right>
                        </CardItem>
                        <CardItem>
                            <Left>
                                <Text style={styles.titleMuted}><Icon note name="md-cube"
                                                                      style={styles.icon}/> {Config.contractConcrete.branch} :
                                </Text>
                            </Left>
                            <Right>
                                <Text style={styles.titleBranch}>{this.state.contract.tenChiNhanh}</Text>
                            </Right>
                        </CardItem>

                        <CardItem>
                            <Left>
                                <Text style={styles.titleMuted}><Icon note name="md-person"
                                                                      style={styles.icon}/> {Config.contractConcrete.providerName} :
                                </Text>
                            </Left>
                            <Right>
                                <Text style={styles.title}>{this.state.contract.tenNhaCungCap}</Text>
                            </Right>
                        </CardItem>
                        <CardItem>
                            <Left>
                                <Text style={styles.titleMuted}><Icon note name="briefcase"
                                                                      style={styles.icon}/> {Config.contractConcrete.projectName} :
                                </Text>
                            </Left>
                            <Right>
                                <Text>{this.state.contract.tenCongTrinh}</Text>
                            </Right>
                        </CardItem>
                        <CardItem>
                            <Left>
                                <Text style={styles.titleMuted}><Icon note name="md-pricetag"
                                                                      style={styles.icon}/> {Config.contractConcrete.concreteType} :
                                </Text>
                            </Left>
                            <Right>
                                <Text style={styles.title}>{this.state.contract.tenMacBeTong}</Text>
                            </Right>
                        </CardItem>
                        <CardItem>
                            <Left>
                                <Text style={styles.titleMuted}><Icon note name="md-grid"
                                                                      style={styles.icon}/> {Config.contractConcrete.stoneType} :
                                </Text>
                            </Left>
                            <Right>
                                <Text style={styles.title}>{this.state.contract.tenLoaiDa}</Text>
                            </Right>
                        </CardItem>
                        {/*<CardItem>*/}
                        {/*    <Left>*/}
                        {/*        <Text style={styles.titleMuted}><Icon note name="ios-bookmark"*/}
                        {/*                                              style={styles.icon}/> {Config.contractConcrete.subsidence} :*/}
                        {/*        </Text>*/}
                        {/*    </Left>*/}
                        {/*    <Right>*/}
                        {/*        <Text style={styles.title}>{this.state.contract.tenDoSut}</Text>*/}
                        {/*    </Right>*/}
                        {/*</CardItem>*/}
                        {/*<CardItem bordered>*/}
                        {/*    <Left>*/}
                        {/*        <Text style={styles.titleMuted}><Icon note name="md-star-outline"*/}
                        {/*                                              style={styles.icon}/> {Config.contractConcrete.specialRequire} :*/}
                        {/*        </Text>*/}
                        {/*    </Left>*/}
                        {/*    <Right>*/}
                        {/*        <Text style={styles.statusRed}>{this.state.contract.tenYCDB}</Text>*/}
                        {/*    </Right>*/}
                        {/*</CardItem>*/}

                        <CardItem>
                            <Left>
                                <Text style={styles.titleMuted}><Icon note name="md-cash"
                                                                      style={styles.icon}/> {Config.contractConcrete.price} :
                                </Text>
                            </Left>
                            <Right>
                                <Text style={styles.statusRed}>
                                    {Utils._renderPriceFormat(this.state.contract.donGiaThanhToan)}
                                </Text>
                            </Right>
                        </CardItem>

                        <CardItem bordered>
                            <Left>
                                <Text style={styles.titleMuted}><Icon note name="md-cash"
                                                                      style={styles.icon}/> {Config.contractConcrete.priceBill} :
                                </Text>
                            </Left>
                            <Right>
                                <Text style={styles.statusRed}>
                                    {Utils._renderPriceFormat(this.state.contract.donGiaHoaDon)}
                                </Text>
                            </Right>
                        </CardItem>


                        <CardItem>
                            <Left>
                                <Body>
                                <Text style={styles.muted}>{Config.common.fromDate}</Text>
                                <Button transparent>
                                    <Icon name="md-calendar" style={{marginLeft: 0}}/>
                                    <Text
                                        style={styles.date}>{Utils._renderDateFormat(this.state.contract.tuNgay)}</Text>
                                </Button>
                                </Body>
                            </Left>
                            <Right>
                                <Body>
                                <Text style={styles.muted}>{Config.common.toDate}</Text>
                                <Button transparent>
                                    <Icon name="md-calendar" style={{}}/>
                                    <Text
                                        style={styles.date}>{Utils._renderDateFormat(this.state.contract.denNgay)}</Text>
                                </Button>
                                </Body>
                            </Right>
                        </CardItem>


                        {this._renderApproveButton(this.state.contract.trangThai)}

                    </Card>

                </Content>

            </Container>
        );
    }


}
