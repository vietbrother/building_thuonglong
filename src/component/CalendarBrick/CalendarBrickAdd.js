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

export default class CalendarBrickAdd extends Component {

    constructor(props) {
        super(props);
        this.state = {
            title: Config.calendarBrick.add,
            hasError: false,
            errorText: '',
            isLoading: false,
            contract: {},
            username: '',
            branchs: [],
            providers: [],
            projects: [],
            employees: [],
            nhomvatlieus: [],
            loaivatlieus: [],
            donvitinhs: [],
            calendarId: '',
            outDate: moment().utcOffset('+07:00').format('DD/MM/YYYY'),
            outTime: '09:00',
            branchSelected: {},
            providerSelected: {},
            projectSelected: {},
            category: '',
            employeeSelected: {},
            nhomvatlieuSelected: {},
            loaivatlieuSelected: {},
            donvitinhSelected: {},
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

    async _loadProviderData(idchiNhanh) {
        this.setState({isSearching: true});
        try {
            var param = {
                idchiNhanh: idchiNhanh,
                ngayThang: this.state.outDate
            };

            let response = await fetch(global.hostAPI[0] + Config.api.apiLichBanGachNhaCungCap, {
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

    async _loadProjectData(idnhaCungCap, loadDefault) {
        this.setState({isSearching: true});
        try {
            var param = {
                idchiNhanh: this.state.branchSelected.id,
                idnhaCungCap: idnhaCungCap,
                ngayThang: this.state.outDate
            };

            let response = await fetch(global.hostAPI[0] + Config.api.apiLichBanGachCongTrinh, {
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

            let response = await fetch(global.hostAPI[0] + Config.api.apiLichBanGachEmployee, {
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

    async _loadNhomVatLieuData(idcongTrinh, loadDefault) {
        this.setState({isSearching: true});
        try {
            var param = {
                idcongTrinh: idcongTrinh,
                ngayThang: this.state.outDate
            };

            let response = await fetch(global.hostAPI[0] + Config.api.apiLichBanGachNhomVatLieu, {
                method: 'POST',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(param)
            });
            var responseObj = await response.json();
            this.setState({isSearching: false});
            this.setState({nhomvatlieus: responseObj});
            if (responseObj != null && responseObj.length > 0 && loadDefault == '1') {
                this.setState({nhomvatlieuSelected: responseObj[0]});
                this._selectedNhomVatLieu(0, responseObj[0]);
            }
        } catch (e) {
            console.log(e);
            this.setState({isSearching: false});
        }
    }

    async _loadLoaiVatLieuData(idnhomVatLieu, loadDefault) {
        this.setState({isSearching: true});
        try {
            var param = {
                // username: this.state.username,
                // idchiNhanh: this.state.branchSelected.id,
                idcongTrinh: this.state.projectSelected.id,
                idnhomVatLieu: idnhomVatLieu,
                ngayThang: this.state.outDate
            };

            let response = await fetch(global.hostAPI[0] + Config.api.apiLichBanGachLoaiVatLieu, {
                method: 'POST',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(param)
            });
            var responseObj = await response.json();
            this.setState({isSearching: false});
            this.setState({loaivatlieus: responseObj});
            if (responseObj != null && responseObj.length > 0 && loadDefault == '1') {
                this.setState({loaivatlieuSelected: responseObj[0]});
                this._selectedLoaiVatLieu(0, responseObj[0]);
            }
        } catch (e) {
            console.log(e);
            this.setState({isSearching: false});
        }
    }

    async _loadDonViTinhData(idloaiVatLieu, loadDefault) {
        this.setState({isSearching: true});
        try {
            var param = {
                // username: this.state.username,
                // idchiNhanh: this.state.branchSelected.id,
                idcongTrinh: this.state.projectSelected.id,
                idloaiVatLieu: idloaiVatLieu,
                ngayThang: this.state.outDate
            };

            let response = await fetch(global.hostAPI[0] + Config.api.apiLichBanGachDonViTinh, {
                method: 'POST',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(param)
            });
            var responseObj = await response.json();
            this.setState({isSearching: false});
            this.setState({donvitinhs: responseObj});
            if (responseObj != null && responseObj.length > 0 && loadDefault == '1') {
                this.setState({donvitinhSelected: responseObj[0]});
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
            nhomvatlieuSelected: {},
            loaivatlieuSelected: {},
            donvitinhSelected: {},
        });
    }

    _selectedProvider(index, item) {
        this.setState({providerSelected: item});
        this._loadProjectData(item.id, '1');
        this.setState({
            projectSelected: {},
            employeeSelected: {},
            nhomvatlieuSelected: {},
            loaivatlieuSelected: {},
            donvitinhSelected: {},
        });
    }

    _selectedProject(index, item) {
        this.setState({projectSelected: item});
        this.setState({
            employeeSelected: {},
            nhomvatlieuSelected: {},
            loaivatlieuSelected: {},
            donvitinhSelected: {},
        });
        this._loadEmployeeData(item.id, '1');
        this._loadNhomVatLieuData(item.id, '1');
    }
    _selectedNhomVatLieu(index, item) {
        this.setState({nhomvatlieuSelected: item});
        this.setState({
            loaivatlieuSelected: {},
            donvitinhSelected: {},
        });
        this._loadLoaiVatLieuData(item.id, '1');
    }
    _selectedLoaiVatLieu(index, item) {
        this.setState({loaivatlieuSelected: item});
        this.setState({
            donvitinhSelected: {},
        });
        this._loadDonViTinhData(item.id, '1');
    }
    _selectedDonViTinh(index, item) {
        this.setState({donvitinhSelected: item});
    }

    _selectedEmployee(index, item) {
        this.setState({employeeSelected: item});
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
                            <H3>{Config.calendarBrick.title}</H3>
                        </CardItem>

                        <Form style={{backgroundColor: "#ffffff"}}>
                            <CardItem>
                                <Left>
                                    <Body>
                                        <Text style={styles.muted}><Icon name="md-calendar"
                                                                         style={styles.muted}/> {Config.calendarBrick.exportHour}<Text style={styles.labelRed}> *</Text>
                                        </Text>
                                        <TouchableOpacity onPress={() => this.setOutTime()}>
                                            <Text style={styles.title}>{this.state.outTime}</Text>
                                        </TouchableOpacity>

                                    </Body>
                                </Left>
                                <Right>
                                    <Body>
                                        <Text style={styles.muted}><Icon name="md-calendar"
                                                                         style={styles.muted}/> {Config.calendarBrick.exportDate}<Text style={styles.labelRed}> *</Text>
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
                                <Label>{Config.calendarBrick.branch}<Text style={styles.labelRed}> *</Text></Label>
                            </Item>
                            <RNPicker
                                dataSource={this.state.branchs}
                                dummyDataSource={this.state.branchs}
                                defaultValue={true}
                                pickerTitle={Config.calendarBrick.branch}
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
                                <Label>{Config.calendarBrick.providerName}<Text style={styles.labelRed}> *</Text></Label>
                            </Item>
                            <RNPicker
                                dataSource={this.state.providers}
                                dummyDataSource={this.state.providers}
                                defaultValue={true}
                                pickerTitle={Config.calendarBrick.providerName}
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
                                <Label>{Config.calendarBrick.projectName}<Text style={styles.labelRed}> *</Text></Label>
                            </Item>
                            <RNPicker
                                dataSource={this.state.projects}
                                dummyDataSource={this.state.projects}
                                defaultValue={true}
                                pickerTitle={Config.calendarBrick.projectName}
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
                                <Label>{Config.calendarBrick.hangMuc} </Label>
                                <Input style={{}}
                                       onChangeText={value => this.onChangedCategory(value)}
                                       value={this.state.category}/>
                            </Item>
                            <Item floatingLabel>
                                <Label>{Config.calendarBrick.employee}<Text style={styles.labelRed}> *</Text></Label>
                            </Item>
                            <RNPicker
                                dataSource={this.state.employees}
                                dummyDataSource={this.state.employees}
                                defaultValue={true}
                                pickerTitle={Config.calendarBrick.employee}
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
                                <Label>{Config.calendarBrick.nhomVatLieu}<Text style={styles.labelRed}> *</Text></Label>
                            </Item>
                            <RNPicker
                                dataSource={this.state.nhomvatlieus}
                                dummyDataSource={this.state.nhomvatlieus}
                                defaultValue={true}
                                pickerTitle={Config.calendarBrick.nhomVatLieu}
                                showSearchBar={true}
                                disablePicker={false}
                                changeAnimation={"none"}
                                searchBarPlaceHolder={Config.btnSearch}
                                showPickerTitle={true}
                                searchBarContainerStyle={this.props.searchBarContainerStyle}
                                pickerStyle={styles.pickerStyle}
                                itemSeparatorStyle={styles.itemSeparatorStyle}
                                pickerItemTextStyle={styles.listTextViewStyle}
                                selectedLabel={this.state.nhomvatlieuSelected.name}
                                placeHolderLabel={this.state.placeHolderText}
                                selectLabelTextStyle={styles.selectLabelTextStyle}
                                placeHolderTextStyle={styles.placeHolderTextStyle}
                                dropDownImageStyle={styles.dropDownImageStyle}
                                selectedValue={(index, item) => this._selectedNhomVatLieu(index, item)}
                            />
                            <Item floatingLabel>
                                <Label>{Config.calendarBrick.loaiVatLieu}<Text style={styles.labelRed}> *</Text></Label>
                            </Item>
                            <RNPicker
                                dataSource={this.state.loaivatlieus}
                                dummyDataSource={this.state.loaivatlieus}
                                defaultValue={true}
                                pickerTitle={Config.calendarBrick.loaiVatLieu}
                                showSearchBar={true}
                                disablePicker={false}
                                changeAnimation={"none"}
                                searchBarPlaceHolder={Config.btnSearch}
                                showPickerTitle={true}
                                searchBarContainerStyle={this.props.searchBarContainerStyle}
                                pickerStyle={styles.pickerStyle}
                                itemSeparatorStyle={styles.itemSeparatorStyle}
                                pickerItemTextStyle={styles.listTextViewStyle}
                                selectedLabel={this.state.loaivatlieuSelected.name}
                                placeHolderLabel={this.state.placeHolderText}
                                selectLabelTextStyle={styles.selectLabelTextStyle}
                                placeHolderTextStyle={styles.placeHolderTextStyle}
                                dropDownImageStyle={styles.dropDownImageStyle}
                                selectedValue={(index, item) => this._selectedLoaiVatLieu(index, item)}
                            />
                            <Item floatingLabel>
                                <Label>{Config.calendarBrick.unit}<Text style={styles.labelRed}> *</Text></Label>
                            </Item>
                            <RNPicker
                                dataSource={this.state.donvitinhs}
                                dummyDataSource={this.state.donvitinhs}
                                defaultValue={true}
                                pickerTitle={Config.calendarBrick.loaiVatLieu}
                                showSearchBar={true}
                                disablePicker={false}
                                changeAnimation={"none"}
                                searchBarPlaceHolder={Config.btnSearch}
                                showPickerTitle={true}
                                searchBarContainerStyle={this.props.searchBarContainerStyle}
                                pickerStyle={styles.pickerStyle}
                                itemSeparatorStyle={styles.itemSeparatorStyle}
                                pickerItemTextStyle={styles.listTextViewStyle}
                                selectedLabel={this.state.donvitinhSelected.name}
                                placeHolderLabel={this.state.placeHolderText}
                                selectLabelTextStyle={styles.selectLabelTextStyle}
                                placeHolderTextStyle={styles.placeHolderTextStyle}
                                dropDownImageStyle={styles.dropDownImageStyle}
                                selectedValue={(index, item) => this._selectedDonViTinh(index, item)}
                            />

                            <Item floatingLabel>
                                <Label>{Config.calendarBrick.khoiLuongTamTinh}<Text style={styles.labelRed}> *</Text></Label>
                                <Input style={{}}
                                       keyboardType="numeric"
                                       onChangeText={value => this.onChangedKhoiLuongTamTinh(value)}
                                       value={this.state.khoiLuongTamTinh}/>
                            </Item>
                            <Item floatingLabel>
                                <Label>{Config.calendarBrick.khoiLuongKhachHang}<Text style={styles.labelRed}> *</Text></Label>
                                <Input style={{}}
                                       keyboardType="numeric"
                                       onChangeText={value => this.onChangedKhoiLuongKhachHang(value)}
                                       value={this.state.khoiLuongKhachHang}/>
                            </Item>
                            <Item floatingLabel>
                                <Label>{Config.calendarBrick.distance}<Text style={styles.labelRed}> *</Text></Label>
                                <Input style={{}}
                                       keyboardType="numeric"
                                       onChangeText={value => this.onChangedDistance(value)}
                                       value={this.state.distance}/>
                            </Item>
                            <Item floatingLabel>
                                <Label>{Config.calendarBrick.technical} </Label>
                                <Input style={{}}
                                       onChangeText={value => this.onChangedTechnical(value)}
                                       value={this.state.technical}/>
                            </Item>
                            <Item floatingLabel last>
                                <Label>{Config.calendarBrick.cashier}<Text style={styles.labelRed}> *</Text></Label>
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
            this.setState({
                calendarId : this.props.contract.id,
                title: Config.calendarBrick.edit,
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
                    id: this.props.contract.idnvkd,
                    name: this.props.contract.tenNhanVien
                },
                nhomvatlieuSelected: {
                    id: this.props.contract.idnhomVatLieu,
                    name: this.props.contract.tenNhomVatLieu
                },
                loaivatlieuSelected: {
                    id: this.props.contract.idloaiVatLieu,
                    name: this.props.contract.tenLoaiVatLieu
                },
                donvitinhSelected: {
                    id: this.props.contract.iddonViTinh,
                    name: this.props.contract.tenDonViTinh
                },
                khoiLuongTamTinh: this.props.contract.klthucXuat.toString(),
                khoiLuongKhachHang: this.props.contract.klkhachHang.toString(),
                distance: this.props.contract.cuLyVanChuyen.toString(),
                technical: this.props.contract.kyThuat,
                cashier: this.props.contract.nguoiThuTien
            });

            this._loadBranchData();
            this._loadProviderData(this.props.contract.idchiNhanh);
            this._loadProjectData(this.props.contract.idnhaCungCap);
            this._loadEmployeeData(this.props.contract.idcongTrinh);
            this._loadNhomVatLieuData(this.props.contract.idcongTrinh);
            this._loadLoaiVatLieuData(this.props.contract.idnhomVatLieu);
            this._loadDonViTinhData(this.props.contract.idloaiVatLieu);

        } else {
            this.setState({
                outDate: moment().utcOffset('+07:00').format('DD/MM/YYYY'),
                outTime: '09:00',
                branchSelected: {},
                providerSelected: {},
                projectSelected: {},
                category: '',
                employeeSelected: {},
                nhomvatlieuSelected: {},
                loaivatlieuSelected: {},
                donvitinhSelected: {},
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
            nhomvatlieuSelected: {},
            loaivatlieuSelected: {},
            donvitinhSelected: {}
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
                this.setState({hasError: true, errorText: Config.required + Config.calendarBrick.exportDate});
                return;
            }
            if (this.state.branchSelected.name == '' || this.state.branchSelected.name == undefined) {
                this.setState({hasError: true, errorText: Config.required + Config.calendarBrick.branch});
                return;
            }
            if (this.state.providerSelected.name == '' || this.state.providerSelected.name == undefined) {
                this.setState({hasError: true, errorText: Config.required + Config.calendarBrick.providerName});
                return;
            }
            if (this.state.projectSelected.name == '' || this.state.projectSelected.name == undefined) {
                this.setState({hasError: true, errorText: Config.required + Config.calendarBrick.projectName});
                return;
            }
            if (this.state.khoiLuongTamTinh == '') {
                this.setState({hasError: true, errorText: Config.required + Config.calendarBrick.exportReal});
                return;
            }
            if (this.state.khoiLuongKhachHang == '') {
                this.setState({
                    hasError: true,
                    errorText: Config.required + Config.calendarBrick.khoiLuongKhachHang
                });
                return;
            }
            this.setState({isLoading: true});

            console.log(this.state.employeeSelected);
            var param = {
                id: this.state.calendarId,
                cuLyVanChuyen: this.state.distance == '' ? 0 : this.state.distance,
                gioXuat: this.state.outTime,
                hangMuc: this.state.category,
                idchiNhanh: this.state.branchSelected.id,
                idchiTietKinhDoanh: '',
                idcongTrinh: this.state.projectSelected.id,
                iddonViTinh: this.state.donvitinhSelected.id,
                idhopDong: new Date().getTime(),
                idloaiVatLieu: this.state.loaivatlieuSelected.id,
                idnhaCungCap: this.state.providerSelected.id,
                idnhomVatLieu: this.state.nhomvatlieuSelected.id,
                idnvkd: this.state.employeeSelected.id,
                kldaBan: 0,
                kldaXuat: 0,
                klkhachHang: this.state.khoiLuongKhachHang,
                klthucXuat: this.state.khoiLuongTamTinh,
                moTa: '',
                ngayThang: this.state.outDate,
                nguoiTao: this.state.username,
                kyThuat: this.state.technical,
                nguoiThuTien: this.state.cashier,
                trangThai: Config.stateCode.wait,
                trangThaiHoanThanh: Config.state.unComplete,
                trangThaiText: Config.state.wait
            };
            console.log(JSON.stringify(param));
            let response = await fetch(global.hostAPI[0] + Config.api.apiLichBanGachSave, {
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
                Actions.calendarBricks({branchId: this.state.contract.idchiNhanh});
            } else {
                Utils._alert(Config.err_save + " : " + responseObj.message);
            }
        } catch (error) {
            console.error(error);
            this.setState({isLoading: false});
        }
    }
}
