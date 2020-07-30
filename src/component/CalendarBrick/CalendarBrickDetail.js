/**
 * This is the Main file
 **/

// React native and others libraries imports
import React, {Component} from 'react';
import {Image, Dimensions, TouchableWithoutFeedback, TouchableOpacity, AsyncStorage, Alert} from 'react-native';
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

export default class CalendarBrickDetail extends Component {

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
        //return Utils._renderApproveButton(status, this._actionApprove());
        if (status == Config.state.wait) {
            return (
                <CardItem>
                    <Left>
                        {/*<TouchableOpacity onPress={() => Actions.pop()}>*/}
                        {/*    <Text style={styles.btnReject}><Icon style={[styles.icon, styles.labelRed]} name='ios-close-circle-outline'/> {Config.btnReject}*/}
                        {/*    </Text>*/}
                        {/*</TouchableOpacity>*/}
                        <TouchableOpacity onPress={() => this._preDelete()}>
                            <Text style={styles.btnReject}><Icon style={[styles.icon, styles.labelRed]} name='ios-trash-outline'/> {Config.btnDelete}
                            </Text>
                        </TouchableOpacity>
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
        } else if (status == Config.state.approved) {
            return (
                <CardItem>
                    <Left>
                        {/*<TouchableOpacity active onPress={() => Actions.pop()} transparent>*/}
                        {/*    <Text style={styles.btnReject}><Icon style={[styles.icon, styles.labelRed]} name='ios-close-circle-outline'/> {Config.btnClose}</Text>*/}
                        {/*</TouchableOpacity>*/}
                        <TouchableOpacity onPress={() => this._preDelete()}>
                            <Text style={styles.btnReject}><Icon style={[styles.icon, styles.labelRed]} name='ios-trash-outline'/> {Config.btnDelete}
                            </Text>
                        </TouchableOpacity>
                    </Left>
                    <Right>
                        {this._renderCompleteButton()}
                    </Right>
                </CardItem>
            );
        } else {
            return (
                <CardItem>
                    <Body>
                        {/*<TouchableOpacity active onPress={() => Actions.pop()} transparent>*/}
                        {/*    <Text style={styles.btnReject}><Icon style={[styles.icon, styles.labelRed]} name='ios-close-circle-outline'/> {Config.btnClose}*/}
                        {/*    </Text>*/}
                        {/*</TouchableOpacity>*/}
                        <TouchableOpacity onPress={() => this._preDelete()}>
                            <Text style={styles.btnReject}><Icon style={[styles.icon, styles.labelRed]} name='ios-trash-outline'/> {Config.btnDelete}
                            </Text>
                        </TouchableOpacity>
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
                {
                    text: Config.btnApply, onPress: () => this._actionApprove()
                },
                {
                    text: Config.btnCancel,
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
                type: Config.APPROVE_TYPE.CALENDAR_BRICK,
                username: this.state.username
            };
            // var res = Api.login(param);
            // this._getResLogin(res);

            let response = await fetch(global.hostAPI[0] + Config.api.apiApprove, {
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
                Utils._alert(Config.successApprove);
                Actions.calendarBricks({branchId: this.state.contract.idchiNhanh});
            } else {
                Utils._alert(Config.err_approve + " : " + responseObj.message);
            }
        } catch (error) {
            console.error(error);
            this.setState({isLoading: false});
        }
    }

    _renderCompleteButton() {
        if (this.state.contract.trangThaiHoanThanh == Config.state.unComplete) {
            return (
                <TouchableOpacity
                    style={styles.btnComplete}
                    onPress={() => this._preComplete()}
                    activeOpacity={0.9}
                >
                    <Text style={styles.titleApprove}><Icon style={styles.titleApprove}
                                                            name='md-power'/> {Config.btnComplete}
                    </Text>
                </TouchableOpacity>
            );
        }
        return (<Text></Text>);
    }

    _preComplete() {
        Alert.alert(
            '',
            Config.confirm_complete, // <- this part is optional, you can pass an empty string
            [
                {
                    text: Config.btnApply, onPress: () => this._actionComplete()
                },
                {
                    text: Config.btnCancel,
                    onPress: () => console.log('Cancel Pressed'),
                    style: 'cancel',
                },
            ],
            {cancelable: false},
        );
    }

    async _actionComplete() {
        try {
            this.setState({isLoading: true});

            var param = {
                approveStateId: Utils._getStatusComplateCode(this.state.contract.trangThaiHoanThanh),
                contractId: this.state.contract.id,
                type: Config.APPROVE_TYPE.CALENDAR_BRICK,
                username: this.state.username
            };
            // var res = Api.login(param);
            // this._getResLogin(res);

            let response = await fetch(global.hostAPI[0] + Config.api.apiApprove, {
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
                Utils._alert(Config.successComplete);
                Actions.calendarBricks({branchId: this.state.contract.idchiNhanh});
            } else {
                Utils._alert(Config.err_complete + " : " + responseObj.message);
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
        var right = '';
        if (this.props.contract != null && this.props.contract != undefined) {
            right = (
                <Right style={{flex: 1}}>
                    <Button onPress={() => Actions.calendarBrickAdd({contract: this.props.contract})} transparent>
                        <Icon name='md-create'/>
                    </Button>
                </Right>
            );
        } else {
            right = (
                <Right style={{flex: 1}}>

                </Right>
            );
        }

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
                <Navbar left={left} right={right} title={Config.calendarBrick.detail}/>
                <Content contentContainerStyle={{
                    paddingHorizontal: 10,
                    backgroundColor: '#f3f9ff'
                }}>
                    <Card transparent>
                        <CardItem header bordered>
                            <H3>{Config.calendarBrick.title}</H3>
                        </CardItem>

                        <CardItem>
                            <Left>
                                {Utils._renderStatus(this.state.contract.trangThaiText)}
                            </Left>
                            <Right>
                                {Utils._renderStatusComplete(this.state.contract.trangThaiHoanThanh)}
                            </Right>
                        </CardItem>
                        <CardItem>
                            <Left>
                                <Text style={styles.titleMuted}><Icon note name="md-cube"
                                                                      style={styles.icon}/> {Config.calendarBrick.branch} :
                                </Text>
                            </Left>
                            <Right>
                                <Text style={styles.titleBranch}>{this.state.contract.tenChiNhanh}</Text>
                            </Right>
                        </CardItem>

                        <CardItem>
                            <Left>
                                <Text style={styles.titleMuted}><Icon note name="md-person"
                                                                      style={styles.icon}/> {Config.calendarBrick.providerName} :
                                </Text>
                            </Left>
                            <Right>
                                <Text style={styles.title}>{this.state.contract.tenNhaCungCap}</Text>
                            </Right>
                        </CardItem>
                        <CardItem>
                            <Left>
                                <Text style={styles.titleMuted}><Icon note name="briefcase"
                                                                      style={styles.icon}/> {Config.calendarBrick.projectName} :
                                </Text>
                            </Left>
                            <Right>
                                <Text>{this.state.contract.tenCongTrinh}</Text>
                            </Right>
                        </CardItem>
                        {/*<CardItem>*/}
                            {/*<Left>*/}
                                {/*<Text style={styles.titleMuted}><Icon note name="md-pricetag"*/}
                                                                      {/*style={styles.icon}/> {Config.calendarBrick.subsidence} :*/}
                                {/*</Text>*/}
                            {/*</Left>*/}
                            {/*<Right>*/}
                                {/*<Text style={styles.title}>{this.state.contract.hangMuc}</Text>*/}
                            {/*</Right>*/}
                        {/*</CardItem>*/}
                        <CardItem>
                            <Left>
                                <Text style={styles.titleMuted}><Icon note name="md-pricetag"
                                                                      style={styles.icon}/> {Config.calendarBrick.materialType} :
                                </Text>
                            </Left>
                            <Right>
                                <Text style={styles.title}>{this.state.contract.tenLoaiVatLieu}</Text>
                            </Right>
                        </CardItem>
                        <CardItem bordered>
                            <Left>
                                <Text style={styles.titleMuted}><Icon note name="md-pricetag"
                                                                      style={styles.icon}/> {Config.calendarBrick.unit} :
                                </Text>
                            </Left>
                            <Right>
                                <Text style={styles.title}>{this.state.contract.tenDonViTinh}</Text>
                            </Right>
                        </CardItem>

                        <CardItem>
                            <Left>
                                <Text style={styles.titleMuted}><Icon note name="md-person"
                                                                      style={styles.icon}/> {Config.calendarBrick.employee} :
                                </Text>
                            </Left>
                            <Right>
                                <Text style={styles.title}>{this.state.contract.tenNhanVien}</Text>
                            </Right>
                        </CardItem>
                        <CardItem bordered>
                            <Left>
                                <Text style={styles.titleMuted}><Icon note name="md-person"
                                                                      style={styles.icon}/> {Config.calendarBrick.cashier} :
                                </Text>
                            </Left>
                            <Right>
                                <Text style={styles.title}>{this.state.contract.nguoiThuTien}</Text>
                            </Right>
                        </CardItem>

                        <CardItem>
                            <Left>
                                <Text style={styles.titleMuted}><Icon note name="md-speedometer"
                                                                      style={styles.icon}/> {Config.calendarBrick.exportReal} :
                                </Text>
                            </Left>
                            <Right>
                                <Text style={styles.statusRed}>
                                    {Utils._renderPriceFormat(this.state.contract.klthucXuat)}
                                </Text>
                            </Right>
                        </CardItem>
                        <CardItem >
                            <Left>
                                <Text style={styles.titleMuted}><Icon note name="md-speedometer"
                                                                      style={styles.icon}/> {Config.calendarBrick.exportCustomer} :
                                </Text>
                            </Left>
                            <Right>
                                <Text style={styles.statusRed}>
                                    {Utils._renderPriceFormat(this.state.contract.klkhachHang)}
                                </Text>
                            </Right>
                        </CardItem>

                        <CardItem bordered>
                            <Left>
                                <Text style={styles.titleMuted}><Icon note name="md-star-outline"
                                                                      style={styles.icon}/> {Config.calendarBrick.distance} :
                                </Text>
                            </Left>
                            <Right>
                                <Text style={styles.statusRed}>{this.state.contract.cuLyVanChuyen}</Text>
                            </Right>
                        </CardItem>

                        <CardItem>
                            <Left>
                                {/*<Body>*/}
                                {/*    <Text style={styles.muted}>{Config.common.fromDate}</Text>*/}
                                {/*    <Button transparent>*/}
                                {/*        <Icon name="md-calendar" style={{marginLeft: 0}}/>*/}
                                {/*        <Text style={styles.date}>{this._renderDateFormat(this.state.contract.tuNgay)}</Text>*/}
                                {/*    </Button>*/}
                                {/*</Body>*/}

                                {/*<Right>*/}
                                <Body>
                                <Text style={styles.muted}>{Config.calendarBrick.exportDate}</Text>
                                <Button transparent>
                                    <Icon name="md-calendar" style={{}}/>
                                    <Text
                                        style={styles.date}>{Utils._renderDateFormat(this.state.contract.ngayThang)}</Text>
                                </Button>
                                </Body>
                                {/*</Right>*/}
                            </Left>
                            <Right>
                                <Body>
                                <Text style={styles.muted}>{Config.calendarBrick.exportHour}</Text>
                                <Button transparent>
                                    <Icon name="ios-time-outline" style={{}}/>
                                    <Text
                                        style={styles.date}>{this.state.contract.gioXuat}</Text>
                                </Button>
                                </Body>
                            </Right>
                        </CardItem>


                        {this._renderApproveButton(this.state.contract.trangThaiText)}

                    </Card>

                </Content>

            </Container>
        );
    }

    _preDelete() {
        Alert.alert(
            '',
            Config.confirm_delete, // <- this part is optional, you can pass an empty string
            [
                {
                    text: Config.btnApply, onPress: () => this._actionDelete()
                },
                {
                    text: Config.btnCancel,
                    onPress: () => console.log('Cancel Pressed'),
                    style: 'cancel',
                },
            ],
            {cancelable: false},
        );
    }

    async _actionDelete() {
        try {
            this.setState({isLoading: true});

            var param = {
                id: this.state.contract.id,
                idchiNhanh: this.state.contract.idchiNhanh,
                idnhaCungCap: this.state.contract.idnhaCungCap,
                nguoiTao: this.state.username
            };

            let response = await fetch(global.hostAPI[0] + Config.api.apiLichBanGachDelete, {
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
                Utils._alert(Config.successDelete);
                Actions.calendarBricks({branchId: this.state.contract.idchiNhanh});
            } else {
                Utils._alert(Config.err_delete + " : " + responseObj.message);
            }
        } catch (error) {
            console.error(error);
            this.setState({isLoading: false});
        }
    }
}
