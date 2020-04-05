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
    Body, Input
} from 'native-base';
import {Actions} from 'react-native-router-flux';
import Carousel, {Pagination} from 'react-native-snap-carousel';

// Our custom files and classes import
import Config from '../../Config';
import Text from '../../component/Text';
import Navbar from '../../component/Navbar';
import Spinner from 'react-native-loading-spinner-overlay';


export default class ContractConcreteDetail extends Component {

    constructor(props) {
        super(props);
        this.state = {
            hasError: false,
            errorText: '',
            isLoading: false,
            contract: {}
        };
    }

    componentWillMount() {
    }

    componentDidMount() {
        this.setState({
            contract: this.props.contract,
        });
        console.log(this.props.contract);
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
                            <Text style={{fontSize: 20, fontWeight: 'bold'}}>{Config.deviceDetail}</Text>
                        </CardItem>

                        <CardItem>
                            <Text style={styles.title}>{Config.contractConcrete.branch} : </Text>
                            <Right>
                                <Text style={{textAlign: 'left'}}>
                                    {this.state.contract.tenChiNhanh}
                                </Text>
                            </Right>
                        </CardItem>
                        <CardItem>
                            <Body>
                            <Text style={styles.title}>{Config.contractConcrete.providerName} : </Text>
                            <Text style={{textAlign: 'left'}}>
                                {this.state.contract.tenNhaCungCap}
                            </Text>
                            </Body>
                        </CardItem>
                        <CardItem>
                            <Body>
                            <Text style={styles.title}>{Config.contractConcrete.projectName} : </Text>
                            <Text style={{textAlign: 'left'}}>
                                {this.state.contract.tenCongTrinh}
                            </Text>
                            </Body>
                        </CardItem>
                        <CardItem>
                            <Body>
                            <Text style={styles.title}>{Config.contractConcrete.concreteType} : </Text>
                            <Text style={{textAlign: 'left'}}>
                                {this.state.contract.tenMacBeTong}
                            </Text>
                            </Body>
                        </CardItem>
                        <CardItem>
                            <Body>
                            <Text style={styles.title}>{Config.contractConcrete.stoneType} : </Text>
                            <Text style={{textAlign: 'left'}}>
                                {this.state.contract.tenLoaiDa}
                            </Text>
                            </Body>
                        </CardItem>
                        <CardItem>
                            <Body>
                            <Text style={styles.title}>{Config.contractConcrete.subsidence} : </Text>
                            <Text style={{textAlign: 'left'}}>
                                {this.state.contract.tenDoSut}
                            </Text>
                            </Body>
                        </CardItem>
                        <CardItem>
                            <Body>
                            <Text style={styles.title}>{Config.contractConcrete.specialRequire} : </Text>
                            <Text style={{textAlign: 'left'}}>
                                {this.state.contract.tenYCDB}
                            </Text>
                            </Body>
                        </CardItem>
                        <CardItem>
                            <Body>
                            <Text style={styles.title}>{Config.contractConcrete.price} : </Text>
                            <Text style={{textAlign: 'left'}}>
                                {parseInt(this.state.contract.donGiaThanhToan).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ".")}
                            </Text>
                            </Body>
                        </CardItem>
                        <CardItem>
                            <Body>
                            <Text style={styles.title}>{Config.contractConcrete.priceBill} : </Text>
                            <Text style={{textAlign: 'left'}}>
                                {parseInt(this.state.contract.donGiaHoaDon).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ".")}
                            </Text>
                            </Body>
                        </CardItem>

                        <CardItem>
                            <Icon active name="ios-time"/>
                            <Text>{Config.common.fromDate} {new Date(this.state.contract.tuNgay).toLocaleDateString()}</Text>
                            <Right>
                                <Icon active name="ios-time"/>
                                <Text>{Config.common.toDate} {new Date(this.state.contract.denNgay).toLocaleDateString()}</Text>
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
                                <Text><Icon name='ios-arrow-back'/> {Config.btnClose}</Text>
                            </Button>
                            </Body>
                            <Right>
                                <Button active onPress={() => this._preApprove()} transparent>
                                    <Text><Icon name='ios-checkmark-circle'/> {Config.btnApprove}</Text>
                                </Button>
                            </Right>
                        </CardItem>

                    </Card>

                </Content>

            </Container>
        );
    }


}

const styles = {
    spinnerTextStyle: {
        color: '#FFF',
        fontWeight: 'bold'
    },
    title: {
        fontSize: 16,
        fontWeight: 'bold'
    }
};
