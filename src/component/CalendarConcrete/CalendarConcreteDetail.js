/**
 * This is the Main file
 **/

// React native and others libraries imports
import React, {Component} from 'react';
import {Image, Dimensions, TouchableWithoutFeedback, AsyncStorage, Alert} from 'react-native';
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

export default class CalendarConcreteDetail extends Component {

    constructor(props) {
        super(props);
        this.state = {
            hasError: false,
            errorText: '',
            isLoading: false,
            contract: {}
        };
    }
    //E:\MyWorks\Project\20200303_stock_app\github\building_thuonglong\node_modules\native-base\src\basic\Icon\NBIcons.json

    componentWillMount() {
    }

    componentDidMount() {
        this.setState({
            contract: this.props.contract,
        });
        console.log(this.props.contract);
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

    _preApprove() {
        Alert.alert(
            '',
            'Bạn có chắc chắn phê duyệt hợp đồng này?', // <- this part is optional, you can pass an empty string
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

    _actionApprove() {

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
                <Navbar left={left} right={right} title={Config.calendarConcrete.detail}/>
                <Content contentContainerStyle={{
                    paddingHorizontal: 10,
                    backgroundColor: '#f3f9ff'
                }}>
                    <Card transparent>
                        <CardItem header bordered>
                            <H3>{Config.calendarConcrete.title}</H3>
                        </CardItem>

                        <CardItem>
                            <Left></Left>
                            <Right>
                                {this._renderStatus(this.state.contract.trangThaiText)}
                            </Right>
                        </CardItem>
                        <CardItem>
                            <Left>
                                <Text style={styles.titleMuted}><Icon note name="md-cube"
                                                                      style={styles.icon}/> {Config.calendarConcrete.branch} :
                                </Text>
                            </Left>
                            <Right>
                                <Text style={styles.titleBranch}>{this.state.contract.tenChiNhanh}</Text>
                            </Right>
                        </CardItem>

                        <CardItem>
                            <Left>
                                <Text style={styles.titleMuted}><Icon note name="md-person"
                                                                      style={styles.icon}/> {Config.calendarConcrete.providerName} :
                                </Text>
                            </Left>
                            <Right>
                                <Text style={styles.title}>{this.state.contract.tenNhaCungCap}</Text>
                            </Right>
                        </CardItem>
                        <CardItem>
                            <Left>
                                <Text style={styles.titleMuted}><Icon note name="briefcase"
                                                                      style={styles.icon}/> {Config.calendarConcrete.projectName} :
                                </Text>
                            </Left>
                            <Right>
                                <Text>{this.state.contract.tenCongTrinh}</Text>
                            </Right>
                        </CardItem>
                        <CardItem>
                            <Left>
                                <Text style={styles.titleMuted}><Icon note name="md-pricetag"
                                                                      style={styles.icon}/> {Config.calendarConcrete.concreteType} :
                                </Text>
                            </Left>
                            <Right>
                                <Text style={styles.title}>{this.state.contract.tenMacBeTong}</Text>
                            </Right>
                        </CardItem>
                        <CardItem>
                            <Left>
                                <Text style={styles.titleMuted}><Icon note name="md-grid"
                                                                      style={styles.icon}/> {Config.calendarConcrete.stoneType} :
                                </Text>
                            </Left>
                            <Right>
                                <Text style={styles.title}>{this.state.contract.tenLoaiDa}</Text>
                            </Right>
                        </CardItem>
                        <CardItem>
                            <Left>
                                <Text style={styles.titleMuted}><Icon note name="ios-bookmark"
                                                                      style={styles.icon}/> {Config.calendarConcrete.subsidence} :
                                </Text>
                            </Left>
                            <Right>
                                <Text style={styles.title}>{this.state.contract.tenDoSut}</Text>
                            </Right>
                        </CardItem>
                        <CardItem bordered>
                            <Left>
                                <Text style={styles.titleMuted}><Icon note name="md-star-outline"
                                                                      style={styles.icon}/> {Config.calendarConcrete.specialRequire} :
                                </Text>
                            </Left>
                            <Right>
                                <Text style={styles.statusRed}>{this.state.contract.tenYCDB}</Text>
                            </Right>
                        </CardItem>

                        <CardItem>
                            <Left>
                                <Text style={styles.titleMuted}><Icon note name="md-pricetag"
                                                                      style={styles.icon}/> {Config.calendarConcrete.pumpType} :
                                </Text>
                            </Left>
                            <Right>
                                <Text style={styles.title}>{this.state.contract.tenHinhThucBom}</Text>
                            </Right>
                        </CardItem>
                        <CardItem>
                            <Left>
                                <Text style={styles.titleMuted}><Icon note name="md-cash"
                                                                      style={styles.icon}/> {Config.calendarConcrete.exportReal} :
                                </Text>
                            </Left>
                            <Right>
                                <Text style={styles.statusRed}>
                                    {parseInt(this.state.contract.klthucXuat).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ".")}
                                </Text>
                            </Right>
                        </CardItem>
                        <CardItem bordered>
                            <Left>
                                <Text style={styles.titleMuted}><Icon note name="md-cash"
                                                                      style={styles.icon}/> {Config.calendarConcrete.exportPlan} :
                                </Text>
                            </Left>
                            <Right>
                                <Text style={styles.statusRed}>
                                    {parseInt(this.state.contract.klkhachHang).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ".")}
                                </Text>
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
                            </Left>
                            <Right>
                                <Body>
                                    <Text style={styles.muted}>{Config.calendarConcrete.calendarConcrete}</Text>
                                    <Button transparent>
                                        <Icon name="md-calendar" style={{}}/>
                                        <Text style={styles.date}>{this._renderDateFormat(this.state.contract.ngayThang)}</Text>
                                    </Button>
                                </Body>
                            </Right>
                        </CardItem>


                        <CardItem>
                            <Left>
                                {/*<Button bordered onPress={() => this.add()}>*/}
                                {/*<Text style={{color: '#fdfdfd'}}> {Config.customerAddTitle} </Text>*/}
                                {/*</Button>*/}
                            </Left>
                            <Body>
                                <Button active onPress={() => Actions.pop()} transparent>
                                    <Text style={styles.btnClose}><Icon style={styles.icon} name='ios-close'/> {Config.btnClose}</Text>
                                </Button>
                            </Body>
                            <Right>
                                <Button style={styles.btnApprove} onPress={() => this._preApprove()}>
                                    <Text style={styles.titleApprove}><Icon style={styles.icon} name='ios-checkmark-circle'/> {Config.btnApprove}</Text>
                                </Button>
                            </Right>
                        </CardItem>

                    </Card>

                </Content>

            </Container>
        );
    }


}
