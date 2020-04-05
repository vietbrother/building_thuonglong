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
    FlatList
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
    Input, List, ListItem,
    // Text
} from 'native-base';
import {Actions} from 'react-native-router-flux';


import Text from '../../component/Text';
import Navbar from '../../component/Navbar';
import SideMenu from '../../component/SideMenu';
import SideMenuDrawer from '../../component/SideMenuDrawer';
import Colors from "../../Colors";
import Config from "../../Config";
import HTML from 'react-native-render-html';
import CalendarConcretesItem from "../../component/CalendarConcrete/CalendarConcreteItem";


export default class CalendarConcretes extends Component {

    constructor(props) {
        super(props);

        this.state = {
            contracts: [],
            // isLoading: true,
            isSearching: false,
            error: null,
            sessionKey: null,

            extractedText: "",
            searchText: '',
            CalendarConcretesSelected: {},
            componentKey: new Date()
        };
    }

    componentWillReceiveProps(nextProps: Readonly<P>, nextContext: any): void {
        this.setState({componentKey: new Date(), searchText: ''});
    }

    componentDidMount() {
        this.search();
    }

    _renderItemResult(item) {
        var key = new Date().valueOf();
        return (
            <View style={{
                flex: 1,
                width: '100%', color: Config.mainColor, fontSize: 16,
                borderBottomColor: Colors.navbarBackgroundColor, borderBottomWidth: 0.5,
                paddingLeft: 10,
                paddingTop: 10, paddingBottom: 10
            }}>
                <CalendarConcretesItem key={key} CalendarConcretes={item}></CalendarConcretesItem>
                {this._renderButton(item)}
            </View>
        );
    }

    async search() {
        console.log('CalendarConcretess-----------------search');
        this.setState({isSearching: true});
        let items = [];
        try {
            let response = await fetch(Config.api.url + Config.api.apiLogin, {
                method: 'POST',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(param)
            });
            var responseObj = await response.json();
            this.setState({isSearching: false});
            this.setState({contracts: responseObj});
        } catch (e) {
            console.log(e);
            this.setState({isSearching: false});
        }
    }

    _renderButton(CalendarConcretes) {
        return (
            <CardItem>
                <Left style={{flex: 1}}></Left>
                <Right>
                    <Button transparent
                            onPress={() => {
                                this._actionChangeStage(CalendarConcretes)
                            }}>
                        <Icon name="ios-git-compare" style={{color: Config.mainColor}}></Icon>
                        <Text style={{color: Config.mainColor}}>Chuyển trạng thái</Text>
                    </Button>
                </Right>
            </CardItem>
        );
    }

    _actionChangeStage(CalendarConcretes) {
        this.setState({CalendarConcretesSelected: CalendarConcretes});
        var newStage = this._switchStage(CalendarConcretes.stage);
        if (newStage == '4') {//chuyen trang thai tu binh ton sang xuat cho khach
            Alert.alert(
                '',
                'Xuất bình ' + CalendarConcretes.code + ' cho khách', // <- this part is optional, you can pass an empty string
                [
                    {
                        text: 'Xuất cho khách',
                        onPress: () => Actions.stockOut({
                            textDetect: CalendarConcretes.code,
                            CalendarConcretesInfo: CalendarConcretes
                        })
                    },
                    {
                        text: 'Hủy',
                        onPress: () => console.log('Cancel Pressed'),
                        style: 'cancel',
                    },
                ],
                {cancelable: true},
            );
            return;
        } else {
            Alert.alert(
                '',
                'Chuyển trạng thái bình ' + CalendarConcretes.code, // <- this part is optional, you can pass an empty string
                [
                    {
                        text: 'Chuyển trạng thái bình',
                        onPress: () => this._fetchChangeStage(CalendarConcretes, newStage)
                    },
                    {
                        text: 'Hủy',
                        onPress: () => console.log('Cancel Pressed'),
                        style: 'cancel',
                    },
                ],
                {cancelable: true},
            );
        }
        this.setState({newStage: newStage, oldStage: CalendarConcretes.stage});

    }

    _fetchChangeStage(CalendarConcretes, newState) {
        try {
            this.setState({isLoading: true});
            console.log('--------------id ' + CalendarConcretes.id + "---newState  " + newState);
            // Connect to Odoo
            global.odooAPI.connect(this._getResConnect.bind(this));

            var codeCalendarConcretes = CalendarConcretes.code;
            var params = {
                stage: newState
            }; //params
            global.odooAPI.update('p.equipment', CalendarConcretes.id, params, this._getResUpdate.bind(this)); //update stage
        } catch (e) {
            console.log(e);
            alert('Chuyển trạng thái bình ' + CalendarConcretes.code + ' thất bại! ');
            this.setState({isLoading: false});
        }
    }

    _getResConnect(err) {
        if (err) {
            console.log('--------------connect error');
            this.setState({isLoading: false});
            alert(Config.err_connect);
            return console.log(err);
        }
    }

    _getResUpdate(err, response) {
        if (err) {
            this.setState({isLoading: false});
            alert(err);
            return console.log(err);
        }
        console.log('_______response___________________');
        console.log(response);
        try {
            this.setState({responseUpdate: response});
            this._createOrder('0');
        } catch (e) {
            console.log(e);
            alert('Chuyển trạng thái mã bình ' + this.state.CalendarConcretesSelected.code + ' thất bại! ');
            this.setState({isLoading: false});
        }
    }



    _renderStatusName(status) {
        if (status == Config.stateCode.wait) {
            return Config.state.wait;
        } else if (status == Config.stateCode.approved) {
            return Config.state.approved;
        } else {
            return {status};
        }
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
                {/*<Button onPress={() => Actions.search()} transparent>*/}
                {/*<Icon name='ios-search-outline'/>*/}
                {/*</Button>*/}
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
                    <Navbar left={left} right={right} title={Config.contractConcrete.title}/>
                    <Content>
                        <View style={{
                            flex: 1,
                            justifyContent: 'center',
                            alignItems: 'center',
                            paddingLeft: 10,
                            paddingRight: 10
                        }}>
                            <Item>
                                <Input
                                    placeholder="Tìm kiếm bình..."
                                    // value={this.state.searchText}
                                    onChangeText={(text) => this.setState({searchText: text})}
                                    onSubmitEditing={() => this.search(this.state.searchText)}
                                    // style={{marginTop: 9}}
                                />
                                <Icon name="ios-search" style={Config.mainColor}
                                      onPress={() => this.search(this.state.searchText)}/>
                            </Item>
                            <ActivityIndicator
                                animating={this.state.isSearching}
                                color={Config.mainColor}
                                size="large"
                            />
                            {/*{this._renderResult()}*/}

                            <FlatList
                                style={{width: '100%'}}
                                data={this.state.contracts}
                                renderItem={({item}) => this._renderItemResult(item)}
                            />
                        </View>

                    </Content>
                </Container>
            </SideMenuDrawer>);
    }


}


const styles = StyleSheet.create({
    container: {
        flex: 1,
        alignItems: 'center',
        justifyContent: 'center',
        paddingTop: 10,
    },
    scrollContainer: {
        // height: 150,
        marginTop: 5,
        paddingRight: 5,
        paddingLeft: 5,
        paddingBottom: 20
    },
    image: {
        width: 120,
        height: 120,
        borderRadius: 10,
        marginRight: 5,
        borderColor: '#dfe3ee',
        borderWidth: 0.5
    },
    capturePhoto: {
        width: 120,
        height: 120,
        borderRadius: 10,
        // marginRight: 5,
        borderColor: '#dfe3ee',
        borderWidth: 0.5
    },

    line: {
        width: '47%',
        height: 3,
        backgroundColor: '#7f8c8d',
        position: 'absolute',
        bottom: '0%',
        marginLeft: 5
    },
    titleView: {
        flex: 1, width: '97%',
        backgroundColor: Config.mainColor,
        borderRadius: 5,
        borderWidth: 0.5,
        margin: 5,
    },
    title: {
        fontSize: 16, fontFamily: 'Roboto',
        fontWeight: '200',
        color: 'white',
        margin: 10,
    },
    icon: {
        fontSize: 13
    },
    stage0: {
        color: '#ffa505'
    },
    stage1: {
        color: Config.colorThin
    },
    stage2: {
        color: '#ff00ff'
    },
    stage3: {
        color: '#c40521'
    },
    stage4: {
        color: '#44bc37'
    },
});

const _styles = {
    font: {
        fontFamily: 'Roboto',
        color: Colors.navbarBackgroundColor
    },
    icon: {
        fontSize: 13
    },
    stage0: {
        color: '#ffa505'
    },
    stage1: {
        color: Config.colorThin
    },
    stage2: {
        color: '#ff00ff'
    },
    stage3: {
        color: '#c40521'
    },
    stage4: {
        color: '#44bc37'
    },

};

