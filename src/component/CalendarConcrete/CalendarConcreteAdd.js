/**
 * This is the Main file
 **/

// React native and others libraries imports
import React, {Component} from 'react';
import {
    Image,
    Dimensions,
    TouchableWithoutFeedback,
    TouchableOpacity,
    AsyncStorage,
    Alert,
    TimePickerAndroid,
    Picker
} from 'react-native';
import {
    View,
    Container,
    Content,
    Button,
    Left,
    Right,
    Icon,

    Item,
    Grid,
    Col,
    Toast,
    Text as NBText,
    List, ListItem,
    Card, CardItem,
    DatePicker,
    Body, Input, H3, Form, Label
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
import moment from "moment";

export default class CalendarConcreteAdd extends Component {

    constructor(props) {
        super(props);
        this.state = {
            hasError: false,
            errorText: '',
            isLoading: false,
            contract: {},
            username: '',
            branchs: [],
            providers: [],
            projects: [],
            employees: [],
            concreteTypes: [],
            pumpTypes: [],
            outDate: moment().utcOffset('+07:00').format('DD/MM/YYYY'),
            outTime: '09:00',
            branchSelected: '',
            providerSelected: '',
            projectSelected: '',
            category: '',
            employeeSelected: '',
            concreteTypeSelected: '',
            pumpTypeSelected: '',
            khoiLuongTamTinh: 0,
            khoiLuongKhachHang: 0,
            distance: 0,
            technical: '',
            cashier: '',
        };
    }

    //E:\MyWorks\Project\20200303_stock_app\github\building_thuonglong\node_modules\native-base\src\basic\Icon\NBIcons.json

    componentWillMount() {
    }

    async componentDidMount() {
        this.setState({
            contract: this.props.contract,
            outDate: this.props.contract.ngayThang,
            outTime: this.props.contract.gioXuat,
            branchSelected: this.props.contract.chiNhanh,
            providerSelected: this.props.contract.nhaCungCap,
            projectSelected: this.props.contract.congTrinh,
            category: this.props.contract.hangMuc,
            employeeSelected: this.props.contract.nvkinhDoanh,
            concreteTypeSelected: this.props.contract.macBeTong,
            pumpTypeSelected: this.props.contract.hinhThucBom,
            khoiLuongTamTinh: this.props.contract.klthucxuat,
            khoiLuongKhachHang: this.props.contract.klkhachHang,
            distance: this.props.contract.cuLyVanChuyen,
            technical: this.props.contract.kyThuat,
            cashier: this.props.contract.nguoiThuTien,
        });
        console.log(this.props.contract);
        let username = await AsyncStorage.getItem('userId');
        this.setState({
            username: username,
        });
        console.log(this.state.username);
    }

    setOutDate(newDate) {
        //alert(newDate);
        this.setState({outDate: moment(newDate).format('DD/MM/YYYY')});
        console.log('select date ' + newDate);
    }

    async setOutTime() {
        try {
            var currentOutTime = this.state.outTime;
            const {action, hour, minute} = await TimePickerAndroid.open({
                hour: Utils._pad(currentOutTime.split(":")[0], 2),
                minute: Utils._pad(currentOutTime.split(":")[1], 2),
                is24Hour: true, // Will display '2 PM'
            });
            if (action !== TimePickerAndroid.dismissedAction) {
                // Selected hour (0-23), minute (0-59)
                this.setState({outTime: hour + ':' + minute});
            }
        } catch ({code, message}) {
            console.warn('Cannot open time picker', message);
        }
    }

    async _loadBranchData() {
        this.setState({isSearching: true});
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
                responseObj.splice(0, 1);
                //this.setState({branchSelected: responseObj[0].id});
            }
        } catch (e) {
            console.log(e);
            this.setState({isSearching: false});
        }
    }

    _renderBranch() {
        var items = [];
        for (var i = 0; i < this.state.branchs.length; i++) {
            var branchItem = this.state.branchs[i];
            items.push(<Picker.Item key={branchItem.id} label={branchItem.tenChiNhanh} value={branchItem.id}/>);
        }
        return items;
    }

    async _loadProviderData() {
        this.setState({isSearching: true});
        try {
            var param = {
                username: this.state.username
            };

            let response = await fetch(global.hostAPI[0] + Config.api.apiLichXuatBeTongNhaCungCap, {
                method: 'POST',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(param)
            });
            var responseObj = await response.json();
            this.setState({isSearching: false});
            this.setState({providers: responseObj});
            if (responseObj != null && responseObj.length > 0) {
                //this.setState({branchSelected: responseObj[0].id});
            }
        } catch (e) {
            console.log(e);
            this.setState({isSearching: false});
        }
    }

    async _loadProjectData() {
        this.setState({isSearching: true});
        try {
            var param = {
                username: this.state.username
            };

            let response = await fetch(global.hostAPI[0] + Config.api.apiLichXuatBeTongCongTrinh, {
                method: 'POST',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(param)
            });
            var responseObj = await response.json();
            this.setState({isSearching: false});
            this.setState({projects: responseObj});
            if (responseObj != null && responseObj.length > 0) {
                //this.setState({branchSelected: responseObj[0].id});
            }
        } catch (e) {
            console.log(e);
            this.setState({isSearching: false});
        }
    }

    async _loadEmployeeData() {
        this.setState({isSearching: true});
        try {
            var param = {
                username: this.state.username
            };

            let response = await fetch(global.hostAPI[0] + Config.api.apiLichXuatBeTongEmployee, {
                method: 'POST',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(param)
            });
            var responseObj = await response.json();
            this.setState({isSearching: false});
            this.setState({employees: responseObj});
            if (responseObj != null && responseObj.length > 0) {
                //this.setState({branchSelected: responseObj[0].id});
            }
        } catch (e) {
            console.log(e);
            this.setState({isSearching: false});
        }
    }

    async _loadConcreteTypeData() {
        this.setState({isSearching: true});
        try {
            var param = {
                username: this.state.username
            };

            let response = await fetch(global.hostAPI[0] + Config.api.apiLichXuatBeTongMacBeTong, {
                method: 'POST',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(param)
            });
            var responseObj = await response.json();
            this.setState({isSearching: false});
            this.setState({concreteTypes: responseObj});
            if (responseObj != null && responseObj.length > 0) {
                //this.setState({branchSelected: responseObj[0].id});
            }
        } catch (e) {
            console.log(e);
            this.setState({isSearching: false});
        }
    }

    async _loadPumpTypeData() {
        this.setState({isSearching: true});
        try {
            var param = {
                username: this.state.username
            };

            let response = await fetch(global.hostAPI[0] + Config.api.apiLichXuatBeTongHinhThucBom, {
                method: 'POST',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(param)
            });
            var responseObj = await response.json();
            this.setState({isSearching: false});
            this.setState({pumpTypes: responseObj});
            if (responseObj != null && responseObj.length > 0) {
                //this.setState({branchSelected: responseObj[0].id});
            }
        } catch (e) {
            console.log(e);
            this.setState({isSearching: false});
        }
    }

    onChangedCategory(value) {
        // code to remove non-numeric characters from text
        this.setState({category: value.replace(/[- #*;,.<>\{\}\[\]\\\/]/gi, '')});
    }

    onChangedDistance(value) {
        // code to remove non-numeric characters from text
        this.setState({distance: value.replace(/[- #*;,.<>\{\}\[\]\\\/]/gi, '')});
    }

    onChangedKhoiLuongTamTinh(value) {
        // code to remove non-numeric characters from text
        this.setState({khoiLuongTamTinh: value.replace(/[- #*;,.<>\{\}\[\]\\\/]/gi, '')});
    }

    onChangedKhoiLuongKhachHang(value) {
        // code to remove non-numeric characters from text
        this.setState({khoiLuongKhachHang: value.replace(/[- #*;,.<>\{\}\[\]\\\/]/gi, '')});
    }

    onChangedTechnical(value) {
        // code to remove non-numeric characters from text
        this.setState({technical: value.replace(/[- #*;,.<>\{\}\[\]\\\/]/gi, '')});
    }

    onChangedCashier(value) {
        // code to remove non-numeric characters from text
        this.setState({cashier: value.replace(/[- #*;,.<>\{\}\[\]\\\/]/gi, '')});
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
                <Navbar left={left} right={right} title={Config.calendarConcrete.add}/>
                <Content contentContainerStyle={{
                    paddingHorizontal: 10,
                    backgroundColor: '#f3f9ff'
                }}>
                    <Card transparent>
                        <CardItem header bordered>
                            <H3>{Config.calendarConcrete.title}</H3>
                        </CardItem>

                        <Form>
                            <CardItem>
                                <Left>
                                    <Body>
                                        <Text style={styles.muted}><Icon name="md-calendar"
                                                                         style={styles.muted}/> {Config.calendarConcrete.exportDate}
                                        </Text>
                                        <DatePicker
                                            defaultDate={new Date()}
                                            //minimumDate={new Date()}
                                            //maximumDate={new Date()}
                                            locale={'en'}
                                            timeZoneOffsetInMinutes={undefined}
                                            modalTransparent={false}
                                            animationType={'fade'}
                                            androidMode={'default'}
                                            placeHolderText={moment().utcOffset('+07:00').format('DD/MM/YYYY')}
                                            textStyle={{color: 'green'}}
                                            placeHolderTextStyle={{color: Config.mainColor}}
                                            onDateChange={(date) => {
                                                this.setOutDate(date)
                                            }}
                                            disabled={false}
                                            formatChosenDate={(date) => {
                                                // return Utils.formatDate(new Date(date.getTime() + 1000*60*60*24).toISOString().split('T')[0]);
                                                return moment(date).format('DD/MM/YYYY');
                                            }}
                                        >
                                        </DatePicker>
                                    </Body>
                                </Left>
                                <Right>
                                    <Body>
                                        <Text style={styles.muted}><Icon name="md-calendar"
                                                                         style={styles.muted}/> {Config.calendarConcrete.exportHour}
                                        </Text>
                                        <TouchableOpacity onPress={() => this.setOutTime()}>
                                            <Text style={styles.title}>{this.state.outTime}</Text>
                                        </TouchableOpacity>

                                    </Body>
                                </Right>
                            </CardItem>

                            <Item floatingLabel>
                                <Label>{Config.calendarConcrete.branch}</Label>
                                <Input/>
                            </Item>
                            <Item floatingLabel>
                                <Label>{Config.calendarConcrete.providerName} </Label>
                                <Input/>
                            </Item>
                            <Item floatingLabel>
                                <Label>{Config.calendarConcrete.projectName} </Label>
                                <Input/>
                            </Item>
                            <Item floatingLabel>
                                <Label>{Config.calendarConcrete.hangMuc} </Label>
                                <Input style={}
                                       onChangeText={value => this.onChangedTechnical(value)}
                                       value={this.state.category}/>
                            </Item>
                            <Item floatingLabel>
                                <Label>{Config.calendarConcrete.employee} </Label>
                                <Input/>
                            </Item>
                            <Item floatingLabel>
                                <Label>{Config.calendarConcrete.concreteType} </Label>
                                <Input/>
                            </Item>
                            <Item floatingLabel>
                                <Label>{Config.calendarConcrete.pumpType} </Label>
                                <Input/>
                            </Item>
                            <Item floatingLabel>
                                <Label>{Config.calendarConcrete.khoiLuongTamTinh} </Label>
                                <Input style={}
                                       keyboardType="numeric"
                                       onChangeText={value => this.onChangedKhoiLuongTamTinh(value)}
                                       value={this.state.khoiLuongTamTinh}/>
                            </Item>
                            <Item floatingLabel>
                                <Label>{Config.calendarConcrete.khoiLuongKhachHang} </Label>
                                <Input style={}
                                       keyboardType="numeric"
                                       onChangeText={value => this.onChangedKhoiLuongKhachHang(value)}
                                       value={this.state.khoiLuongKhachHang}/>
                            </Item>
                            <Item floatingLabel>
                                <Label>{Config.calendarConcrete.distance} </Label>
                                <Input style={}
                                       keyboardType="numeric"
                                       onChangeText={value => this.onChangedDistance(value)}
                                       value={this.state.distance}/>
                            </Item>
                            <Item floatingLabel>
                                <Label>{Config.calendarConcrete.technical} </Label>
                                <Input style={}
                                       onChangeText={value => this.onChangedTechnical(value)}
                                       value={this.state.technical}/>
                            </Item>
                            <Item floatingLabel last>
                                <Label>{Config.calendarConcrete.cashier}</Label>
                                <Input style={}
                                       onChangeText={value => this.onChangedCashier(value)}
                                       value={this.state.cashier}/>
                            </Item>
                        </Form>

                        {this.state.hasError ? <Text style={{
                            color: 'red',
                            textAlign: 'center',
                            marginTop: 10
                        }}>{this.state.errorText}</Text> : null}


                        <CardItem>
                            <Left>
                                <Button active onPress={() => Actions.pop()} transparent>
                                    <Text style={styles.btnReject}><Icon style={[styles.icon, styles.labelRed]}
                                                                         name='ios-close-circle-outline'/> {Config.btnReject}
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
                                                                            name='md-checkmark'/> {Config.btnSave}
                                    </Text>
                                </TouchableOpacity>
                            </Right>
                        </CardItem>

                    </Card>

                </Content>

            </Container>
        );
    }

    async _actionSave() {
        try {
            if (this.state.outDate == '') {
                this.setState({hasError: true, errorText: Config.required + Config.calendarConcrete.exportDate});
                return;
            }
            if (this.state.branchSelected == '') {
                this.setState({hasError: true, errorText: Config.required + Config.calendarConcrete.branch});
                return;
            }
            if (this.state.providerSelected == '') {
                this.setState({hasError: true, errorText: Config.required + Config.calendarConcrete.providerName});
                return;
            }
            if (this.state.concreteTypeSelected == '') {
                this.setState({hasError: true, errorText: Config.required + Config.calendarConcrete.concreteType});
                return;
            }
            if (this.state.khoiLuongTamTinh == '') {
                this.setState({hasError: true, errorText: Config.required + Config.calendarConcrete.exportReal});
                return;
            }
            if (this.state.khoiLuongKhachHang == '') {
                this.setState({hasError: true, errorText: Config.required + Config.calendarConcrete.khoiLuongKhachHang});
                return;
            }
            this.setState({isLoading: true});

            var param = {
                approveStateId: Utils._getStatusCode(this.state.contract.trangThaiText),
                contractId: this.state.contract.id,
                type: Config.APPROVE_TYPE.CALENDAR_CONCRETE,
                username: this.state.username
            };
            let response = await fetch(global.hostAPI[0] + Config.api.apiLichXuatBeTongSave, {
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
                Utils._alert(Config.successSave);
                Actions.calendarConcretes({branchId: this.state.contract.idchiNhanh});
            } else {
                Utils._alert(Config.err_save + " : " + responseObj.message);
            }
        } catch (error) {
            console.error(error);
            this.setState({isLoading: false});
        }
    }
}
