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

// Our custom files and classes import
import Config from '../../Config';
import Text from '../../component/Text';
import Navbar from '../../component/Navbar';
import Spinner from 'react-native-loading-spinner-overlay';


import styles from '../../styles/ContractStyles';
import Utils from "../../utils/Utils";
import moment from "moment";
import RNPicker from "rn-modal-picker";

export default class CalendarConcreteAdd extends Component {

    constructor(props) {
        super(props);
        this.state = {
            title: Config.calendarConcrete.add,
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
            calendarId: '',
            outDate: moment().utcOffset('+07:00').format('DD/MM/YYYY'),
            outTime: '09:00',
            branchSelected: {},
            providerSelected: {},
            projectSelected: {},
            category: '',
            employeeSelected: {},
            concreteTypeSelected: {},
            pumpTypeSelected: {},
            khoiLuongTamTinh: '',
            khoiLuongKhachHang: '',
            distance: '',
            technical: '',
            cashier: '',
        };
    }

    //E:\MyWorks\Project\20200303_stock_app\github\building_thuonglong\node_modules\native-base\src\basic\Icon\NBIcons.json
    componentWillReceiveProps(nextProps: Readonly<P>, nextContext: any): void {
        this.setState({componentKey: new Date()});//refresh menu
        this._initData();
    }

    componentWillMount() {
        this._initData();
    }

    async componentDidMount() {
        // this.setState({
        //     contract: this.props.contract,
        //     outDate: this.props.contract.ngayThang,
        //     outTime: this.props.contract.gioXuat,
        //     branchSelected: this.props.contract.chiNhanh,
        //     providerSelected: this.props.contract.nhaCungCap,
        //     projectSelected: this.props.contract.congTrinh,
        //     category: this.props.contract.hangMuc,
        //     employeeSelected: this.props.contract.nvkinhDoanh,
        //     concreteTypeSelected: this.props.contract.macBeTong,
        //     pumpTypeSelected: this.props.contract.hinhThucBom,
        //     khoiLuongTamTinh: this.props.contract.klthucxuat,
        //     khoiLuongKhachHang: this.props.contract.klkhachHang,
        //     distance: this.props.contract.cuLyVanChuyen,
        //     technical: this.props.contract.kyThuat,
        //     cashier: this.props.contract.nguoiThuTien,
        // });
        // console.log(this.props.contract);
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
        this._resetComboBoxData();
    }

    async setOutTime() {
        try {
            var currentOutTime = this.state.outTime;
            const {action, hour, minute} = await TimePickerAndroid.open({
                // hour: Utils._pad(currentOutTime.split(":")[0], 2),
                // minute: Utils._pad(currentOutTime.split(":")[1], 2),

                hour: parseInt(currentOutTime.split(":")[0]),
                minute: parseInt(currentOutTime.split(":")[1]),
                is24Hour: true, // Will display '2 PM'
            });
            if (action !== TimePickerAndroid.dismissedAction) {
                // Selected hour (0-23), minute (0-59)
                this.setState({outTime: hour + ':' + Utils._pad(minute, 2)});
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

    async _loadProviderData(idchiNhanh, loadDefault) {
        this.setState({isSearching: true});
        try {
            var param = {
                idchiNhanh: idchiNhanh,
                ngayThang: this.state.outDate
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
            if (responseObj != null && responseObj.length > 0 && loadDefault == '1') {
                //this.setState({branchSelected: responseObj[0].id});
            }
        } catch (e) {
            console.log(e);
            this.setState({isSearching: false});
        }
    }

    async _loadProjectData(idnhaCungCap, loadDefault) {
        this.setState({isSearching: true});
        try {
            var param = {
                idchiNhanh: this.state.branchSelected.id,
                idnhaCungCap: idnhaCungCap,
                ngayThang: this.state.outDate
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
            if (responseObj != null && responseObj.length > 0 && loadDefault == '1') {
                this.setState({projectSelected: responseObj[0]});
                this._selectedProject(0, responseObj[0]);
            }
        } catch (e) {
            console.log(e);
            this.setState({isSearching: false});
        }
    }

    async _loadEmployeeData(idcongTrinh, loadDefault) {
        this.setState({isSearching: true});
        try {
            var param = {
                idcongTrinh: idcongTrinh,
                ngayThang: this.state.outDate
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
            if (responseObj != null && responseObj.length > 0 && loadDefault == '1') {
                this.setState({employeeSelected: responseObj[0]});
            }
        } catch (e) {
            console.log(e);
            this.setState({isSearching: false});
        }
    }

    async _loadConcreteTypeData(idcongTrinh, loadDefault) {
        this.setState({isSearching: true});
        try {
            var param = {
                idcongTrinh: idcongTrinh,
                ngayThang: this.state.outDate
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
            if (responseObj != null && responseObj.length > 0 && loadDefault == '1') {
                this.setState({concreteTypeSelected: responseObj[0]});
            }
        } catch (e) {
            console.log(e);
            this.setState({isSearching: false});
        }
    }

    async _loadPumpTypeData(idcongTrinh, loadDefault) {
        this.setState({isSearching: true});
        try {
            var param = {
                // username: this.state.username,
                // idchiNhanh: this.state.projectSelected.id,
                idcongTrinh: idcongTrinh,
                ngayThang: this.state.outDate
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
            if (responseObj != null && responseObj.length > 0 && loadDefault == '1') {
                this.setState({pumpTypeSelected: responseObj[0]});
            }
        } catch (e) {
            console.log(e);
            this.setState({isSearching: false});
        }
    }

    _selectedBranch(index, item) {
        this.setState({branchSelected: item});
        this._loadProviderData(item.id);
        this.setState({
            providerSelected: {},
            projectSelected: {},
            employeeSelected: {},
            concreteTypeSelected: {},
            pumpTypeSelected: {}
        });
    }

    _selectedProvider(index, item) {
        this.setState({providerSelected: item});
        this._loadProjectData(item.id, '1');
        this.setState({
            projectSelected: {},
            employeeSelected: {},
            concreteTypeSelected: {},
            pumpTypeSelected: {}
        });
    }

    _selectedProject(index, item) {
        this.setState({projectSelected: item});
        this.setState({
            employeeSelected: {},
            concreteTypeSelected: {},
            pumpTypeSelected: {}
        });
        this._loadPumpTypeData(item.id, '1');
        this._loadConcreteTypeData(item.id, '1');
        this._loadEmployeeData(item.id, '1');
    }

    _selectedEmployee(index, item) {
        this.setState({employeeSelected: item});
    }

    _selectedConcreteType(index, item) {
        this.setState({concreteTypeSelected: item});
    }

    _selectedPumpType(index, item) {
        this.setState({pumpTypeSelected: item});
    }

    onChangedCategory(value) {
        // code to remove non-numeric characters from text
        if (value != null) {
            this.setState({category: value});
        }
    }

    onChangedDistance(value) {
        // code to remove non-numeric characters from text
        if (value != null) {
            this.setState({distance: value.replace(/[- #*;<>\{\}\[\]\\\/]/gi, '')});
        }
    }

    onChangedKhoiLuongTamTinh(value) {
        // code to remove non-numeric characters from text
        if (value != null) {
            this.setState({khoiLuongTamTinh: value.replace(/[- #*;<>\{\}\[\]\\\/]/gi, '')});
        }
    }

    onChangedKhoiLuongKhachHang(value) {
        // code to remove non-numeric characters from text
        if (value != null) {
            this.setState({khoiLuongKhachHang: value.replace(/[- #*;<>\{\}\[\]\\\/]/gi, '')});
        }
    }

    onChangedTechnical(value) {
        // code to remove non-numeric characters from text
        if (value != null) {
            this.setState({technical: value.replace(/[- #*;<>\{\}\[\]\\\/]/gi, '')});
        }
    }

    onChangedCashier(value) {
        // code to remove non-numeric characters from text
        if (value != null) {
            this.setState({cashier: value.replace(/[- #*;<>\{\}\[\]\\\/]/gi, '')});
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
                <Navbar left={left} right={right} title={this.state.title}/>
                <Content contentContainerStyle={{
                    paddingHorizontal: 10,
                    backgroundColor: '#f3f9ff'
                }}>
                    <Card transparent>
                        <CardItem header bordered>
                            <H3>{Config.calendarConcrete.title}</H3>
                        </CardItem>

                        <Form style={{backgroundColor: "#ffffff"}}>
                            <CardItem>
                                <Left>
                                    <Body>
                                    <Text style={styles.muted}><Icon name="md-calendar"
                                                                     style={styles.muted}/> {Config.calendarConcrete.exportHour}<Text
                                        style={styles.labelRed}> *</Text>
                                    </Text>
                                    <CardItem style={{marginTop: -3}}>
                                        <TouchableOpacity onPress={() => this.setOutTime()}>
                                            <Text style={styles.title}>{this.state.outTime}</Text>
                                        </TouchableOpacity>
                                    </CardItem>

                                    </Body>
                                </Left>
                                <Right>
                                    <Body>
                                    <Text style={styles.muted}><Icon name="md-calendar"
                                                                     style={styles.muted}/> {Config.calendarConcrete.exportDate}<Text
                                        style={styles.labelRed}> *</Text>
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
                                        placeHolderText={this.state.outDate}
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
                                </Right>
                            </CardItem>

                            <Item>
                                <Label>{Config.calendarConcrete.branch}<Text style={styles.labelRed}> *</Text></Label>
                            </Item>
                            <RNPicker
                                dataSource={this.state.branchs}
                                dummyDataSource={this.state.branchs}
                                defaultValue={true}
                                pickerTitle={Config.calendarConcrete.branch}
                                showSearchBar={true}
                                disablePicker={false}
                                changeAnimation={"none"}
                                searchBarPlaceHolder={Config.btnSearch}
                                showPickerTitle={true}
                                searchBarContainerStyle={this.props.searchBarContainerStyle}
                                pickerStyle={styles.pickerStyle}
                                itemSeparatorStyle={styles.itemSeparatorStyle}
                                pickerItemTextStyle={styles.listTextViewStyle}
                                selectedLabel={this.state.branchSelected.name}
                                placeHolderLabel={this.state.placeHolderText}
                                selectLabelTextStyle={styles.selectLabelTextStyle}
                                placeHolderTextStyle={styles.placeHolderTextStyle}
                                dropDownImageStyle={styles.dropDownImageStyle}
                                selectedValue={(index, item) => this._selectedBranch(index, item)}
                            />
                            <Item floatingLabel>
                                <Label>{Config.calendarConcrete.providerName}<Text
                                    style={styles.labelRed}> *</Text></Label>
                            </Item>
                            <RNPicker
                                dataSource={this.state.providers}
                                dummyDataSource={this.state.providers}
                                defaultValue={true}
                                pickerTitle={Config.calendarConcrete.providerName}
                                showSearchBar={true}
                                disablePicker={false}
                                changeAnimation={"none"}
                                searchBarPlaceHolder={Config.btnSearch}
                                showPickerTitle={true}
                                searchBarContainerStyle={this.props.searchBarContainerStyle}
                                pickerStyle={styles.pickerStyle}
                                itemSeparatorStyle={styles.itemSeparatorStyle}
                                pickerItemTextStyle={styles.listTextViewStyle}
                                selectedLabel={this.state.providerSelected.name}
                                placeHolderLabel={this.state.placeHolderText}
                                selectLabelTextStyle={styles.selectLabelTextStyle}
                                placeHolderTextStyle={styles.placeHolderTextStyle}
                                dropDownImageStyle={styles.dropDownImageStyle}
                                selectedValue={(index, item) => this._selectedProvider(index, item)}
                            />

                            <Item floatingLabel>
                                <Label>{Config.calendarConcrete.projectName}<Text
                                    style={styles.labelRed}> *</Text></Label>
                            </Item>
                            <RNPicker
                                dataSource={this.state.projects}
                                dummyDataSource={this.state.projects}
                                defaultValue={true}
                                pickerTitle={Config.calendarConcrete.projectName}
                                showSearchBar={true}
                                disablePicker={false}
                                changeAnimation={"none"}
                                searchBarPlaceHolder={Config.btnSearch}
                                showPickerTitle={true}
                                searchBarContainerStyle={this.props.searchBarContainerStyle}
                                pickerStyle={styles.pickerStyle}
                                itemSeparatorStyle={styles.itemSeparatorStyle}
                                pickerItemTextStyle={styles.listTextViewStyle}
                                selectedLabel={this.state.projectSelected.name}
                                placeHolderLabel={this.state.placeHolderText}
                                selectLabelTextStyle={styles.selectLabelTextStyle}
                                placeHolderTextStyle={styles.placeHolderTextStyle}
                                dropDownImageStyle={styles.dropDownImageStyle}
                                selectedValue={(index, item) => this._selectedProject(index, item)}
                            />
                            <Item floatingLabel>
                                <Label>{Config.calendarConcrete.hangMuc} </Label>
                                <Input style={{}}
                                       onChangeText={value => this.onChangedCategory(value)}
                                       value={this.state.category}/>
                            </Item>
                            <Item floatingLabel>
                                <Label>{Config.calendarConcrete.employee}<Text style={styles.labelRed}> *</Text></Label>
                            </Item>
                            <RNPicker
                                dataSource={this.state.employees}
                                dummyDataSource={this.state.employees}
                                defaultValue={true}
                                pickerTitle={Config.calendarConcrete.employee}
                                showSearchBar={true}
                                disablePicker={false}
                                changeAnimation={"none"}
                                searchBarPlaceHolder={Config.btnSearch}
                                showPickerTitle={true}
                                searchBarContainerStyle={this.props.searchBarContainerStyle}
                                pickerStyle={styles.pickerStyle}
                                itemSeparatorStyle={styles.itemSeparatorStyle}
                                pickerItemTextStyle={styles.listTextViewStyle}
                                selectedLabel={this.state.employeeSelected.name}
                                placeHolderLabel={this.state.placeHolderText}
                                selectLabelTextStyle={styles.selectLabelTextStyle}
                                placeHolderTextStyle={styles.placeHolderTextStyle}
                                dropDownImageStyle={styles.dropDownImageStyle}
                                selectedValue={(index, item) => this._selectedEmployee(index, item)}
                            />
                            <Item floatingLabel>
                                <Label>{Config.calendarConcrete.concreteType}<Text
                                    style={styles.labelRed}> *</Text></Label>
                            </Item>
                            <RNPicker
                                dataSource={this.state.concreteTypes}
                                dummyDataSource={this.state.concreteTypes}
                                defaultValue={true}
                                pickerTitle={Config.calendarConcrete.concreteType}
                                showSearchBar={true}
                                disablePicker={false}
                                changeAnimation={"none"}
                                searchBarPlaceHolder={Config.btnSearch}
                                showPickerTitle={true}
                                searchBarContainerStyle={this.props.searchBarContainerStyle}
                                pickerStyle={styles.pickerStyle}
                                itemSeparatorStyle={styles.itemSeparatorStyle}
                                pickerItemTextStyle={styles.listTextViewStyle}
                                selectedLabel={this.state.concreteTypeSelected.name}
                                placeHolderLabel={this.state.placeHolderText}
                                selectLabelTextStyle={styles.selectLabelTextStyle}
                                placeHolderTextStyle={styles.placeHolderTextStyle}
                                dropDownImageStyle={styles.dropDownImageStyle}
                                selectedValue={(index, item) => this._selectedConcreteType(index, item)}
                            />
                            <Item floatingLabel>
                                <Label>{Config.calendarConcrete.pumpType}<Text style={styles.labelRed}> *</Text></Label>
                            </Item>
                            <RNPicker
                                dataSource={this.state.pumpTypes}
                                dummyDataSource={this.state.pumpTypes}
                                defaultValue={true}
                                pickerTitle={Config.calendarConcrete.pumpType}
                                showSearchBar={true}
                                disablePicker={false}
                                changeAnimation={"none"}
                                searchBarPlaceHolder={Config.btnSearch}
                                showPickerTitle={true}
                                searchBarContainerStyle={this.props.searchBarContainerStyle}
                                pickerStyle={styles.pickerStyle}
                                itemSeparatorStyle={styles.itemSeparatorStyle}
                                pickerItemTextStyle={styles.listTextViewStyle}
                                selectedLabel={this.state.pumpTypeSelected.name}
                                placeHolderLabel={this.state.placeHolderText}
                                selectLabelTextStyle={styles.selectLabelTextStyle}
                                placeHolderTextStyle={styles.placeHolderTextStyle}
                                dropDownImageStyle={styles.dropDownImageStyle}
                                selectedValue={(index, item) => this._selectedPumpType(index, item)}
                            />

                            <Item floatingLabel>
                                <Label>{Config.calendarConcrete.khoiLuongTamTinh}<Text style={styles.labelRed}> *</Text></Label>
                                <Input style={{}}
                                       keyboardType="numeric"
                                       onChangeText={value => this.onChangedKhoiLuongTamTinh(value)}
                                       value={this.state.khoiLuongTamTinh}/>
                            </Item>
                            <Item floatingLabel>
                                <Label>{Config.calendarConcrete.khoiLuongKhachHang}<Text
                                    style={styles.labelRed}> *</Text></Label>
                                <Input style={{}}
                                       keyboardType="numeric"
                                       onChangeText={value => this.onChangedKhoiLuongKhachHang(value)}
                                       value={this.state.khoiLuongKhachHang}/>
                            </Item>
                            <Item floatingLabel>
                                <Label>{Config.calendarConcrete.distance}<Text style={styles.labelRed}> *</Text></Label>
                                <Input style={{color: Config.mainColor}}
                                       keyboardType="numeric"
                                       onChangeText={value => this.onChangedDistance(value)}
                                       value={this.state.distance}/>
                            </Item>
                            <Item floatingLabel>
                                <Label>{Config.calendarConcrete.technical} </Label>
                                <Input style={{}}
                                       onChangeText={value => this.onChangedTechnical(value)}
                                       value={this.state.technical}/>
                            </Item>
                            <Item floatingLabel last>
                                <Label>{Config.calendarConcrete.cashier}<Text style={styles.labelRed}> *</Text></Label>
                                <Input style={{}}
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
                                <TouchableOpacity active onPress={() => Actions.pop()} transparent>
                                    <Text style={styles.btnReject}><Icon style={[styles.icon, styles.labelRed]}
                                                                         name='ios-close-circle-outline'/> {Config.btnClose}
                                    </Text>
                                </TouchableOpacity>
                            </Left>
                            <Right>
                                <TouchableOpacity
                                    style={styles.btnApprove}
                                    onPress={() => this._preSave()}
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

    _initData() {
        console.log(this.props.contract);
        if (this.props.contract != null && this.props.contract != undefined) {
            var branchSelectedTemp = {
                id: this.props.contract.idchiNhanh,
                name: this.props.contract.tenChiNhanh
            };
            var providerSelectedTemp = {
                id: this.props.contract.idnhaCungCap,
                name: this.props.contract.tenNhaCungCap
            };
            var projectSelectedTemp = {
                id: this.props.contract.idcongTrinh,
                name: this.props.contract.tenCongTrinh
            };
            var employeeSelectedTemp = {
                ...this.state.employeeSelected,
                id: this.props.contract.idnhanVien,
                name: this.props.contract.tenNhanVien
            };
            var concreteTypeSelectedTemp = {
                id: this.props.contract.idmacBeTong,
                name: this.props.contract.tenMacBeTong
            };
            var pumpTypeSelectedTemp = {
                id: this.props.contract.idhinhThucBom,
                name: this.props.contract.hinhThucBom
            };
            var ngayThangTemp = moment(this.props.contract.ngayThang).utcOffset('+07:00').format('DD/MM/YYYY');
            this.setState({
                calendarId: this.props.contract.id,
                title: Config.calendarConcrete.edit,
                contract: this.props.contract,
                outDate: moment(this.props.contract.ngayThang).utcOffset('+07:00').format('DD/MM/YYYY'),
                outTime: this.props.contract.gioXuat,
                branchSelected: {
                    id: this.props.contract.idchiNhanh,
                    name: this.props.contract.tenChiNhanh
                },
                providerSelected: {
                    id: this.props.contract.idnhaCungCap,
                    name: this.props.contract.tenNhaCungCap
                },
                projectSelected: {
                    id: this.props.contract.idcongTrinh,
                    name: this.props.contract.tenCongTrinh
                },
                category: this.props.contract.hangMuc,
                employeeSelected: {
                    id: this.props.contract.idnhanVien,
                    name: this.props.contract.tenNhanVien
                },
                concreteTypeSelected: {
                    id: this.props.contract.idmacBeTong,
                    name: this.props.contract.tenMacBeTong
                },
                pumpTypeSelected: {
                    id: this.props.contract.idhinhThucBom,
                    name: this.props.contract.tenHinhThucBom
                },
                khoiLuongTamTinh: this.props.contract.klthucXuat.toString(),
                khoiLuongKhachHang: this.props.contract.klkhachHang.toString(),
                distance: this.props.contract.cuLyVanChuyen.toString(),
                technical: this.props.contract.kyThuat,
                cashier: this.props.contract.nguoiThuTien
            });
            // console.log('========================================================');
            // this.setState({outDate : ngayThangTemp});
            // this.setState({employeeSelected : employeeSelectedTemp});
            // console.log(employeeSelectedTemp);
            // console.log(this.state.employeeSelected);
            // console.log(ngayThangTemp);
            // console.log(this.state.outDate);

            this._loadBranchData();
            this._loadProviderData(this.props.contract.idchiNhanh);
            this._loadProjectData(this.props.contract.idnhaCungCap);
            this._loadPumpTypeData(this.props.contract.idcongTrinh);
            this._loadConcreteTypeData(this.props.contract.idcongTrinh);
            this._loadEmployeeData(this.props.contract.idcongTrinh);
            // this.setState({
            //     calendarId : this.props.contract.id,
            //     title: Config.calendarConcrete.edit,
            //     contract: this.props.contract,
            //     outDate: moment(this.props.contract.ngayThang).utcOffset('+07:00').format('DD/MM/YYYY'),
            //     outTime: this.props.contract.gioXuat,
            //     branchSelected: {
            //         id: this.props.contract.idchiNhanh,
            //         name: this.props.contract.tenChiNhanh
            //     },
            //     providerSelected: {
            //         id: this.props.contract.idnhaCungCap,
            //         name: this.props.contract.tenNhaCungCap
            //     },
            //     projectSelected: {
            //         id: this.props.contract.idcongTrinh,
            //         name: this.props.contract.tenCongTrinh
            //     },
            //     category: this.props.contract.hangMuc,
            //     employeeSelected: {
            //         id: this.props.contract.idnhanVien,
            //         name: this.props.contract.tenNhanVien
            //     },
            //     concreteTypeSelected: {
            //         id: this.props.contract.idmacBeTong,
            //         name: this.props.contract.tenMacBeTong
            //     },
            //     pumpTypeSelected: {
            //         id: this.props.contract.idhinhThucBom,
            //         name: this.props.contract.hinhThucBom
            //     },
            //     khoiLuongTamTinh: this.props.contract.klthucXuat.toString(),
            //     khoiLuongKhachHang: this.props.contract.klkhachHang.toString(),
            //     distance: this.props.contract.cuLyVanChuyen.toString(),
            //     technical: this.props.contract.kyThuat,
            //     cashier: this.props.contract.nguoiThuTien
            // });

        } else {
            console.log('Add');
            this.setState({
                outDate: moment().utcOffset('+07:00').format('DD/MM/YYYY'),
                outTime: '09:00',
                branchSelected: {},
                providerSelected: {},
                projectSelected: {},
                category: '',
                employeeSelected: {},
                concreteTypeSelected: {},
                pumpTypeSelected: {},
                khoiLuongTamTinh: '',
                khoiLuongKhachHang: '',
                distance: '',
                technical: '',
                cashier: '',
            });
            this._loadBranchData();
        }

    }

    _resetComboBoxData() {
        this.setState({
            branchSelected: {},
            providerSelected: {},
            projectSelected: {},
            employeeSelected: {},
            concreteTypeSelected: {},
            pumpTypeSelected: {}
        });
    }

    _preSave() {
        Alert.alert(
            '',
            Config.confirm_save, // <- this part is optional, you can pass an empty string
            [
                {
                    text: Config.btnApply, onPress: () => this._actionSave()
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

    async _actionSave() {
        try {
            if (this.state.outDate == '') {
                this.setState({hasError: true, errorText: Config.required + Config.calendarConcrete.exportDate});
                return;
            }
            if (this.state.branchSelected.name == '' || this.state.branchSelected.name == undefined) {
                this.setState({hasError: true, errorText: Config.required + Config.calendarConcrete.branch});
                return;
            }
            if (this.state.providerSelected.name == '' || this.state.providerSelected.name == undefined) {
                this.setState({hasError: true, errorText: Config.required + Config.calendarConcrete.providerName});
                return;
            }
            if (this.state.projectSelected.name == '' || this.state.projectSelected.name == undefined) {
                this.setState({hasError: true, errorText: Config.required + Config.calendarConcrete.projectName});
                return;
            }
            if (this.state.employeeSelected.name == '' || this.state.employeeSelected.name == undefined) {
                this.setState({hasError: true, errorText: Config.required + Config.calendarConcrete.employee});
                return;
            }
            if (this.state.concreteTypeSelected.name == '' || this.state.concreteTypeSelected.name == undefined) {
                this.setState({hasError: true, errorText: Config.required + Config.calendarConcrete.concreteType});
                return;
            }
            if (this.state.pumpTypeSelected.name == '' || this.state.pumpTypeSelected.name == undefined) {
                this.setState({hasError: true, errorText: Config.required + Config.calendarConcrete.concreteType});
                return;
            }
            if (this.state.khoiLuongTamTinh == '') {
                this.setState({hasError: true, errorText: Config.required + Config.calendarConcrete.exportReal});
                return;
            }
            if (this.state.khoiLuongKhachHang == '') {
                this.setState({
                    hasError: true,
                    errorText: Config.required + Config.calendarConcrete.khoiLuongKhachHang
                });
                return;
            }
            if (this.state.distance == '') {
                this.setState({
                    hasError: true,
                    errorText: Config.required + Config.calendarConcrete.distance
                });
                return;
            }
            if (this.state.cashier == '') {
                this.setState({
                    hasError: true,
                    errorText: Config.required + Config.calendarConcrete.cashier
                });
                return;
            }
            this.setState({isLoading: true});

            var param = {
                id: this.state.calendarId,
                cuLyVanChuyen: this.state.distance == '' ? 0 : this.state.distance,
                gioXuat: this.state.outTime,
                hangMuc: this.state.category,
                hinhThucBom: this.state.pumpTypeSelected.id,
                idchiNhanh: this.state.branchSelected.id,
                idchiTietKinhDoanh: '',
                idcongTrinh: this.state.projectSelected.id,
                idhopDong: new Date().getTime(),
                idhopDongBom: new Date().getTime(),
                idnhaCungCap: this.state.providerSelected.id,
                idnvkd: this.state.employeeSelected.id,
                kldaBan: this.state.khoiLuongKhachHang,
                kldaXuat: this.state.khoiLuongTamTinh,
                klkhachHang: this.state.khoiLuongKhachHang,
                klthucXuat: this.state.khoiLuongTamTinh,
                kyThuat: this.state.technical,
                macBeTong: this.state.concreteTypeSelected.id,
                ngayThang: this.state.outDate,
                nguoiTao: this.state.username,
                nguoiThuTien: this.state.cashier,
                trangThai: Config.stateCode.wait,
                trangThaiHoanThanh: Config.state.unComplete,
                trangThaiText: Config.state.wait
            };
            console.log(JSON.stringify(param));
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
