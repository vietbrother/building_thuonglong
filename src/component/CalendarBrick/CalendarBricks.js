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
    Dimensions,
    Alert,
    FlatList, Picker, Clipboard
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
    Tab, Tabs, TabHeading, Badge, Toast, DatePicker, Col, Body, Grid
    // Text
} from 'native-base';
import {Actions} from 'react-native-router-flux';


import Text from '../../component/Text';
import Navbar from '../../component/Navbar';
import SideMenuDrawer from '../../component/SideMenuDrawer';
import Config from "../../Config";
// import HTML from 'react-native-render-html';
import CalendarBrickItem from "./CalendarBrickItem";
import styles from "../../styles/ContractStyles";
import Utils from "../../utils/Utils";
import moment from "moment";


export default class CalendarBricks extends Component {

    constructor(props) {
        super(props);

        this.state = {
            contracts: [],
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
            componentKey: new Date(),
            copyDate: moment().utcOffset('+07:00').format('DD/MM/YYYY'),
            fromDate: moment().subtract(7, 'days').utcOffset('+07:00').format('DD/MM/YYYY'),
            toDate: moment().utcOffset('+07:00').format('DD/MM/YYYY')
        };
    }

    componentWillReceiveProps(nextProps: Readonly<P>, nextContext: any): void {
        this.setState({componentKey: new Date()});//refresh menu
        console.log(this.state.branchSelected);
        this.search(this.state.branchSelected, Config.stateCode.wait);
        this.search(this.state.branchSelected, Config.stateCode.approved);
    }

    //
    // componentDidMount() {
    //     this._loadBranchData();
    // }

    componentWillMount() {
        this._loadBranchData();
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
            // this.search(responseObj[0].id);
            this.search(responseObj[0].id, Config.stateCode.wait);
            this.search(responseObj[0].id, Config.stateCode.approved);
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


    _renderItemResult(item) {
        // console.log(item);
        var key = new Date().valueOf();
        return (
            /*            <View style={{
                            flex: 1,
                            width: '100%', color: Config.mainColor, fontSize: 16,
                            borderBottomColor: Colors.navbarBackgroundColor, borderBottomWidth: 0.5,
                            padding: 5
                        }}>*/
            <CalendarBrickItem key={item.id} contract={item}></CalendarBrickItem>
            /*</View>*/
        );
    }

    _actionSelectBranch(itemValue) {
        console.log("+++++++++++++++++++++++ " + itemValue);
        this.setState({branchSelected: itemValue});
        this.search(itemValue, Config.stateCode.wait);
        this.search(itemValue, Config.stateCode.approved);
    }


    async search(branchId, type) {
        console.log('CalendarBrickss-----------------search');
        this._switchState(type, [], true);
        let items = [];
        try {
            var param = {
                idchiNhanh: branchId,
                idTrangThai: type,
                tuNgay: this.state.fromDate,
                denNgay: this.state.toDate
            };
            let response = await fetch(global.hostAPI[0] + Config.api.apiLichBanGach, {
                method: 'POST',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(param)
            });
            var responseObj = await response.json();
            this._switchState(type, responseObj, false);
        } catch (e) {
            console.log(e);
            this._switchState(type, [], false);
        }
    }

    _switchState(type, data, status) {
        if (type == Config.stateCode.approved) {
            this.setState({isSearchingActive: status});
            this.setState({contractsActive: data});
        } else {
            this.setState({isSearching: status});
            this.setState({contracts: data});
        }
    }

    _copyToClipboard() {
        var contentMsgDetail = '';
        // var copyDate = Utils.formatDate(this.state.copyDate.toISOString().split('T')[0]);
        var copyDate = this.state.copyDate;
        var index = 0;
        for (var i = this.state.contractsActive.length - 1; i >= 0; i--) {
            var item = this.state.contractsActive[i];
            if (copyDate == Utils._renderDateFormat(item.ngayThang)) {
                index++;
                contentMsgDetail += index + '.' +
                    '   👉 ⏰ Giờ xuất: ' + Utils._viewValue(item.gioXuat) + '\n' +
                    '   ✔ Tên KH: ' + Utils._viewValue(item.tenNhaCungCap) + '\n' +
                    '   ✔ Điện thoại: ' + Utils._viewValue(item.soDienThoai) + '\n' +
                    '   ✔ Địa chỉ: ' + Utils._viewValue(item.diaChi) + '\n' +
                    '   ✔ Công trình: ' + item.tenCongTrinh + '\n' +
                    '   ✔ Tên loại vật liệu: ' + Utils._viewValue(item.tenLoaiVatLieu) + '\n' +
                    '   ✔ Khối lượng thực xuất:' + Utils._viewValue(item.klthucXuat) + ' ' + item.tenDonViTinh + '\n' +
                    '   ✔ Thu ngân: ' + Utils._viewValue(item.nguoiThuTien) + '\n' +
                    '   ✔ Nhân viên kinh doanh: ' + Utils._viewValue(item.tenNhanVien) + '\n' +
                    ' \n'
                ;
            }
        }
        if (contentMsgDetail == '' || contentMsgDetail == null) {
            Toast.show({
                text: Config.err_no_data,
                position: 'bottom',
                buttonText: 'Ẩn',
                duration: 3000,
                buttonTextStyle: {color: "#fff"},
                buttonStyle: {backgroundColor: Config.mainColor}
            });
        } else {
            contentMsgDetail = Config.calendarBrick.title + ' 📅 Ngày xuất: ' + copyDate + '\n\n' + contentMsgDetail;
            Clipboard.setString(contentMsgDetail);

            Toast.show({
                text: Config.successCopyToClipboard,
                position: 'bottom',
                buttonText: Config.btnHide,
                duration: 3000,
                buttonTextStyle: {color: "#fff"},
                buttonStyle: {backgroundColor: Config.mainColor}
            });
        }

    }


    setDate(newDate) {
        //alert(newDate);
        this.setState({copyDate: moment(newDate).format('DD/MM/YYYY')});
        console.log('select date ' + newDate);
    }

    setFromDate(newDate) {
        //alert(newDate);
        let toDate = moment(this.state.toDate, 'DD MM YYYY').toDate().getTime();
        this.setState({fromDate: moment(newDate).format('DD/MM/YYYY')});
        console.log('select date ' + newDate);
        if (moment(newDate).toDate().getTime() > toDate) {
            Utils._alert(Config.err_from_to_date);
            return;
        }
        if (moment(newDate).utcOffset('+07:00').toDate().getTime() + (3600 * 1000 * 24 * 7)
            < toDate) {
            Utils._alert(Config.err_from_to_date_max);
            return;
        }
        this.search(this.state.branchSelected, Config.stateCode.wait);
        this.search(this.state.branchSelected, Config.stateCode.approved);
    }

    setToDate(newDate) {
        //alert(newDate);
        let fromDate = moment(this.state.fromDate, 'DD MM YYYY').toDate().getTime();
        this.setState({toDate: moment(newDate).format('DD/MM/YYYY')});
        console.log('select date ' + newDate);
        if (moment(newDate).toDate().getTime() < fromDate) {
            Utils._alert(Config.err_from_to_date);
            return;
        }
        if (moment(newDate).toDate().getTime() - (3600 * 1000 * 24 * 7) > fromDate) {
            Utils._alert(Config.err_from_to_date_max);
            return;
        }
        this.search(this.state.branchSelected, Config.stateCode.wait);
        this.search(this.state.branchSelected, Config.stateCode.approved);
    }

    render() {
        var left = (
            <Left style={{flex: 1}}>
                <Button onPress={() => this._sideMenuDrawer.open()} transparent>
                    <Icon name='ios-menu-outline'/>
                </Button>
            </Left>
        );
        var right = (
            <Right style={{flex: 1}}>
                <Button onPress={() => Actions.calendarBrickAdd({})} transparent>
                    <Icon name='md-add'/>
                </Button>
                {/*<Button onPress={() => Actions.cart()} transparent>*/}
                {/*<Icon name='ios-cart'/>*/}
                {/*</Button>*/}
            </Right>
        );

        return (
            <SideMenuDrawer ref={(ref) => this._sideMenuDrawer = ref}
                            key={this.state.componentKey}
                // key={new Date().valueOf()}
                // fetchData={'1'}
                // sessionLoginKey={this.props.sessionLoginKey}
            >
                <Container>
                    <Navbar left={left} right={right} title={Config.calendarBrick.title}/>
                    <Content>
                        <View style={{
                            flex: 1,
                            justifyContent: 'center',
                            alignItems: 'center',
                            // paddingLeft: 10,
                            // paddingRight: 10
                        }}>
                            <CardItem>
                                <Left>
                                    <Body>
                                    <Text style={styles.muted}><Icon name="md-calendar"
                                                                     style={styles.muted}/> {Config.common.fromDate}
                                    </Text>
                                    <DatePicker
                                        defaultDate={moment().subtract(7, 'days').toDate()}
                                        //minimumDate={new Date()}
                                        //maximumDate={new Date()}
                                        locale={'en'}
                                        timeZoneOffsetInMinutes={undefined}
                                        modalTransparent={false}
                                        animationType={'fade'}
                                        androidMode={'default'}
                                        placeHolderText={moment().subtract(7, 'days').utcOffset('+07:00').format('DD/MM/YYYY')}
                                        textStyle={{color: 'green'}}
                                        placeHolderTextStyle={{color: Config.mainColor}}
                                        onDateChange={(date) => {
                                            this.setFromDate(date)
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
                                                                     style={styles.muted}/> {Config.common.toDate}
                                    </Text>
                                    <DatePicker
                                        defaultDate={moment().toDate()}
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
                                            this.setToDate(date)
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

                            {/*<Grid>*/}
                                {/*<Col size={3} style={{textAlign: 'center', padding: 5, paddingLeft: 10}}>*/}
                                    {/*<Picker*/}
                                        {/*style={styles.branchPicker}*/}
                                        {/*itemStyle={styles.branchPickerItem}*/}
                                        {/*selectedValue={this.state.branchSelected}*/}
                                        {/*onValueChange={(itemValue, itemIndex) => this._actionSelectBranch(itemValue)}>*/}
                                        {/*{this._renderBranch()}*/}
                                    {/*</Picker>*/}
                                {/*</Col>*/}
                                {/*<Col size={2} style={{textAlign: 'center', padding: 5}}>*/}
                                    {/*<TouchableOpacity*/}
                                        {/*style={styles.btnApprove}*/}
                                        {/*onPress={() => Actions.calendarBrickAdd({})}*/}
                                        {/*activeOpacity={0.9}*/}
                                    {/*>*/}
                                        {/*<Text style={styles.titleApprove}><Icon style={styles.titleApprove}*/}
                                                                                {/*name='md-add'/> {Config.btnAdd}*/}
                                        {/*</Text>*/}
                                    {/*</TouchableOpacity>*/}
                                {/*</Col>*/}
                            {/*</Grid>*/}

                            <Grid style={{marginTop: -20}}>
                                <Col size={2}
                                     style={{textAlign: 'center', paddingTop: 5, paddingLeft: 25, marginTop: 15}}>
                                    <Text style={styles.muted}><Icon name="cube"
                                                                     style={styles.muted}/> {Config.calendarConcrete.branch}
                                    </Text>
                                </Col>
                                <Col size={4} style={{textAlign: 'center', padding: 5}}>
                                    <Picker
                                        style={styles.branchPicker}
                                        itemStyle={styles.branchPickerItem}
                                        selectedValue={this.state.branchSelected}
                                        onValueChange={(itemValue, itemIndex) => this._actionSelectBranch(itemValue)}>
                                        {this._renderBranch()}
                                    </Picker>
                                </Col>
                            </Grid>
                            <Tabs tabBarUnderlineStyle={styles.tabActive}>
                                <Tab heading={
                                    <TabHeading style={styles.tabHeading}>
                                        <Icon name="md-lock" style={styles.tabTitle}/>
                                        <Text style={styles.tabTitle}> {Config.state.wait.toUpperCase()}</Text>
                                        <Badge style={styles.badgeTitle}><Text
                                            style={styles.badgeTitleText}>{this.state.contracts.length}</Text></Badge>
                                    </TabHeading>
                                }>
                                    <View style={{
                                        width: '100%',
                                        minHeight: 300
                                    }}>
                                        {this.state.isSearching ?
                                            <View style={styles.loadingActivity}>
                                                <ActivityIndicator
                                                    animating={this.state.isSearching}
                                                    color={Config.mainColor}
                                                    size="large"
                                                />
                                            </View>
                                            : <Text></Text>}
                                        <FlatList
                                            style={{width: '100%'}}
                                            data={this.state.contracts}
                                            renderItem={({item}) => this._renderItemResult(item)}
                                        />
                                    </View>
                                </Tab>
                                <Tab heading={
                                    <TabHeading style={styles.tabHeading}>
                                        <Icon name="md-checkmark" style={styles.tabTitle}/>
                                        <Text style={styles.tabTitle}> {Config.state.active.toUpperCase()}</Text>
                                    </TabHeading>
                                }>
                                    <View style={{
                                        width: '100%',
                                        minHeight: 300
                                    }}>
                                        {this.state.isSearchingActive ?
                                            <View style={styles.loadingActivity}>
                                                <ActivityIndicator
                                                    animating={this.state.isSearchingActive}
                                                    color={Config.mainColor}
                                                    size="large"
                                                />
                                            </View>
                                            : <Text></Text>}
                                        <CardItem>
                                            <Left>
                                                <Body>
                                                <Text style={styles.muted}><Icon name="md-calendar"
                                                                                 style={styles.muted}/> {Config.common.copyDate}
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
                                                        this.setDate(date)
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
                                                <TouchableOpacity
                                                    style={styles.btnApprove}
                                                    onPress={() => this._copyToClipboard()}
                                                    activeOpacity={0.9}
                                                >
                                                    <Text style={styles.titleApprove}><Icon style={styles.titleApprove}
                                                                                            name='ios-copy-outline'/> {Config.btnCopyByDate}
                                                    </Text>
                                                </TouchableOpacity>
                                            </Right>
                                        </CardItem>

                                        <FlatList
                                            style={{width: '100%'}}
                                            data={this.state.contractsActive}
                                            renderItem={({item}) => this._renderItemResult(item)}
                                        />
                                    </View>
                                </Tab>
                            </Tabs>
                        </View>

                    </Content>
                </Container>
            </SideMenuDrawer>);
    }


}

