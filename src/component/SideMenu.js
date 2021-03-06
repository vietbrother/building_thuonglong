/**
 * This is the SideMenu component used in the navbar
 **/

// React native and others libraries imports
import React, {Component} from 'react';
import {ScrollView, LayoutAnimation, UIManager, Linking, Image, AsyncStorage} from 'react-native';
import {
    View,
    List,
    ListItem,
    Body,
    Left,
    Right,
    Icon,
    Item,
    Input,
    Button,
    Grid,
    Col,
    Toast,
    Container
} from 'native-base';
import {Actions} from 'react-native-router-flux';

// Our custom files and classes import
import SideMenuSecondLevel from './SideMenuSecondLevel';
import Text from './Text';
import Colors from "../Colors";

import Spinner from 'react-native-loading-spinner-overlay';
import Config from "../Config";

export default class SideMenu extends Component {
    constructor(props) {
        super(props);
        this.state = {
            search: "",
            searchError: false,
            subMenu: false,
            subMenuItems: [],
            clickedItem: '',
            sessionKey: null,
            isReload: true,
            isLoading: false,
            menuItems: []
        };

        UIManager.setLayoutAnimationEnabledExperimental && UIManager.setLayoutAnimationEnabledExperimental(true);
    }


    componentWillMount() {
        // AsyncStorage.getItem("cookieUserFromApi", (err, res) => {
        //     console.log("get cookieUserFromApi in menu ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        //     console.log("res : " + res);
        //     console.log("this.props.sessionLoginKey : " + this.props.sessionLoginKey);
        //     this.setState({sessionKey: res});
        //     console.log("state : " + this.state.sessionKey);
        //     this._fetchCategorieData();
        // });
    }

    _fetchCategorieData() {
        //Have a try and catch block for catching errors.
        try {
            //this.getSessionKey();
            if (this.props.fetchData != null && this.props.fetchData == '1') {
                console.log("++++++++++++++ reload data ++++++++++++++++++++++++")
                this.setState({isLoading: true});
                global.WooCommerceAPI.get('products/categories', {
                    per_page: 100, status: 'processing', page: 1
                })
                    .then(data => {
                        // data will contain the body content from the request
                        console.log("get category " + data.length);
                        // console.log(data);
                        var items = [];
                        data.map((item, i) => {
                            // if (item.parent != '0') {
                            items.push(item);
                            // }
                        });
                        // console.log(items);
                        this.setState({menuItems: items, isLoading: false});
                        AsyncStorage.setItem("MENU_CATEGORIES", JSON.stringify(items));
                    })
                    .catch(error => {
                        // error will return any errors that occur
                        console.log(error);
                        this.setState({
                            error: error.toString(),
                            isLoading: false
                        });
                    });
            } else {
                console.log("++++++++++++++ get data from store++++++++++++++++++++++++")
                AsyncStorage.getItem("MENU_CATEGORIES", (err, res) => {
                    if (res) {
                        var items = JSON.parse(res);
                        this.setState({menuItems: items, isLoading: false});
                    }
                });
            }

        } catch (err) {
            console.log("Error fetching data-----------", err);
        }
    }

    render() {
        return (
            <ScrollView style={styles.container}>
                <Spinner
                    //visibility of Overlay Loading Spinner
                    visible={this.state.isLoading}
                    //Text with the Spinner
                    //textContent={'Đang lấy dữ liệu...'}
                    //Text style of the Spinner Text
                    textStyle={styles.spinnerTextStyle}
                />
                {this.renderMenu()}
            </ScrollView>
        );
    }

    renderMenu() {
        console.log("render SideMenu");
        console.log("this.props.sessionLoginKey " + this.props.sessionLoginKey);
        console.log("this.props.fetchData " + this.props.fetchData);
        if (!this.state.subMenu) {
            return (
                <View style={{color: Colors.navbarBackgroundColor}}>
                    {/*<View style={{paddingLeft: 15, paddingRight: 15}}>*/}
                    {/*<Item error={this.state.searchError}>*/}
                    {/*<Input*/}
                    {/*placeholder='Tìm kiếm...'*/}
                    {/*onChangeText={(text) => this.setState({search: text, searchError: false})}*/}
                    {/*onSubmitEditing={() => this.search()}*/}
                    {/*/>*/}
                    {/*<Icon active name='ios-search-outline' onPress={() => this.search()} />*/}
                    {/*</Item>*/}
                    {/*</View>*/}
                    <View style={{marginTop: 15, marginBottom: 15, width: '100%', alignItems: 'center'}}>
                        <Image style={{height: 100, width: 100}} source={require('../images/logo_menu.png')}/>
                        {/*<Text style={{*/}
                        {/*fontSize: 18,*/}
                        {/*fontWeight: 'bold',*/}
                        {/*textAlign: 'center',*/}
                        {/*width: '100%',*/}
                        {/*color: Colors.navbarBackgroundColor*/}
                        {/*}}>PLASMA </Text>*/}
                        <Text style={{
                            fontSize: 18,
                            fontWeight: 'bold',
                            textAlign: 'center',
                            width: '100%',
                            color: Config.colorBold
                        }}>{Config.titleCompany}<Text style={{fontWeight: '200', color: Config.colorThin}}>{Config.titleCompanySub}</Text> </Text>
                        {/*<Text style={{fontSize: 12, textAlign: 'left', width: '100%', color: '#687373'}}>Thực phẩm sạch Nhật Bản </Text>*/}
                    </View>
                    <View style={{paddingRight: 15}}>
                        <List>
                            {/*Homepage*/}
                            {/*<ListItem*/}
                                {/*icon*/}
                                {/*key={0}*/}
                                {/*button={true}*/}
                                {/*onPress={() => this._gotoHomepage(0)}*/}

                            {/*>*/}
                                {/*<Body>*/}
                                {/*<Text style={{color: Colors.navbarBackgroundColor}}>{Config.titleHome}</Text>*/}
                                {/*</Body>*/}
                                {/*/!*<Right>*!/*/}
                                {/*/!*<Icon name="ios-arrow-forward"/>*!/*/}
                                {/*/!*</Right>*!/*/}
                            {/*</ListItem>*/}

                            {this.renderMenuItems()}
                        </List>
                    </View>
                    {/*<View style={styles.line}/>*/}
                    <View style={{paddingRight: 15}}>
                        <List>
                            {/*{this.props.sessionLoginKey != null || this.state.sessionKey != null ?*/}
                            {/*this.renderSecondaryList() : this.renderSecondaryListNologin()}*/}
                            {this.renderSecondaryList()}
                        </List>
                    </View>
                    {/*<View style={styles.line}/>*/}
                    {/*<View style={{*/}
                    {/*    paddingRight: 15, paddingLeft: 15, paddingBottom: 15, textAlign: 'center',*/}
                    {/*    width: '100%',*/}
                    {/*}}>*/}
                    {/*    <Text> <Icon style={{fontSize: 18}} name={'ios-call'}/> {Config.titleHotline} <Text style={{*/}
                    {/*        color: "#c0392b",*/}
                    {/*        fontSize: 20,*/}
                    {/*    }}>{Config.hotline}</Text></Text>*/}
                    {/*    <Text style={{*/}
                    {/*        fontSize: 14,*/}
                    {/*        fontWeight: '200',*/}
                    {/*        paddingTop: 10,*/}
                    {/*        color: Config.colorBold*/}
                    {/*    }}>{Config.titleCopyRight}</Text>*/}
                    {/*</View>*/}
                </View>
            );
        } else {
            return (
                <SideMenuSecondLevel back={this.back.bind(this)} title={this.state.clickedItem}
                                     menu={this.state.subMenuItems}/>
            );
        }
    }

    _gotoHomepage(id) {
        Actions.home({id: id});
    }

    unflatten(arr) {
        var tree = [],
            mappedArr = {},
            arrElem,
            mappedElem;

        // First map the nodes of the array to an object -> create a hash table.
        for (var i = 0, len = arr.length; i < len; i++) {
            arrElem = arr[i];
            mappedArr[arrElem.id] = arrElem;
            mappedArr[arrElem.id]['subMenu'] = [];
            // console.log(arrElem.id + '--mappedElem.parent ' + arrElem.parent);
        }


        for (var id in mappedArr) {
            if (mappedArr.hasOwnProperty(id)) {
                mappedElem = mappedArr[id];
                // If the element is not at the root level, add it to its parent array of children.
                if (mappedElem.parent != null && mappedElem.parent != '0' && mappedArr[mappedElem.parent] != null) {
                    mappedArr[mappedElem.parent]['subMenu'].push(mappedElem);
                }
                // If the element is at the root level, add it to first level elements array.
                else if (mappedElem.parent != null && mappedElem.parent == '0') {
                    tree.push(mappedElem);
                }
            }
        }
        // console.log("===========================tree");
        // console.log(tree);
        return tree;
    }

    renderMenuItems() {
        if (this.state.menuItems != null && this.state.menuItems.length > 0) {
            console.log("___________________________________________this.state.menuItems");
            // console.log(this.state.menuItems);
            let items = [];
            try {
                var treeList = this.unflatten(this.state.menuItems);

                // console.log(treeList);

                treeList.map((item, i) => {
                    var key = new Date().valueOf();
                    items.push(
                        <ListItem
                            last={menuItems.length === i + 1}
                            icon
                            key={key + "-" + item.id}
                            button={true}
                            onPress={() => this.itemClicked(item)}
                        >
                            <Body>
                            <Text onPress={() => this._searchProductByCategoryId(item)}>{item.name}</Text>
                            </Body>
                            <Right>
                                <Icon name="ios-arrow-forward" onPress={() => this.itemClicked(item)}/>
                            </Right>
                        </ListItem>
                    );
                });
            } catch (e) {
                console.log(e);
            }
            return items;
        }

    }

    _searchProductByCategoryId(item) {
        console.log("============================item.id : " + item.id)
        Actions.category({id: item.id, title: item.name, reload: '1'});
    }

    itemClicked(item) {
        console.log(item.subMenu);
        // if (!item.subMenu || item.subMenu.length <= 0) {
        //     console.log("============================item.id : " + item.id)
        //     Actions.category({id: item.id, title: item.name, reload: '1'});
        //     // this.fetchProductByCategoryId(item.id, item.name);
        //     return;
        // }
        if (!item.subMenu || item.subMenu.length > 0) {
            var animationConfig = {
                duration: 150,
                create: {
                    type: LayoutAnimation.Types.easeInEaseOut,
                    property: LayoutAnimation.Properties.scaleXY,
                },
                update: {
                    type: LayoutAnimation.Types.easeInEaseOut,
                },
            };
            LayoutAnimation.configureNext(animationConfig);
            this.setState({subMenu: true, subMenuItems: item.subMenu, clickedItem: item.name});
        }
    }

    back() {
        var animationConfig = {
            duration: 150,
            create: {
                type: LayoutAnimation.Types.easeInEaseOut,
                property: LayoutAnimation.Properties.scaleXY,
            },
            update: {
                type: LayoutAnimation.Types.easeInEaseOut,
            },
        };
        LayoutAnimation.configureNext(animationConfig);
        this.setState({subMenu: false, subMenuItems: [], clickedItem: ''})
    }

    search(text) {
        if (this.state.search.length <= 2)
            this.setState({searchError: true, search: ""});
        else
            Actions.search({searchText: this.state.search});
    }

    renderSecondaryList() {
        let secondaryItems = [];
        var key = new Date();
        menusSecondaryItems.map((item, i) => {
            secondaryItems.push(
                <ListItem
                    last
                    icon
                    key={key+ '_' + item.id}
                    button={true}
                    onPress={Actions[item.key]}
                >
                    <Left>
                        <Icon style={{fontSize: 18}} name={item.icon}/>
                    </Left>
                    <Body style={{marginLeft: -15}}>
                    <Text allowFontScaling={false} style={{
                        fontSize: 16,
                        color: Colors.navbarBackgroundColor,
                        fontFamily: 'Roboto',
                    }}>{item.title}</Text>
                    </Body>
                </ListItem>
            );
        });
        return secondaryItems;
    }

    renderSecondaryListNologin() {
        let secondaryItems = [];
        secondaryItems.push(
            <ListItem
                last
                icon
                button={true}
                onPress={Actions['login']}
            >
                <Left>
                    <Icon style={{fontSize: 18}} name={'ios-log-in'}/>
                </Left>
                <Body style={{marginLeft: -15}}>
                <Text style={{fontSize: 16}}>{Config.btnLogin}</Text>
                </Body>
            </ListItem>
        );
        return secondaryItems;
    }
}

const styles = {
    container: {
        flex: 1,
        backgroundColor: '#fdfdfd'
    },
    line: {
        width: '100%',
        height: 1,
        backgroundColor: 'rgba(189, 195, 199, 0.6)',
        marginTop: 10,
        marginBottom: 10
    },
    spinnerTextStyle: {
        color: '#FFF',
        fontWeight: 'bold'
    },
};

var menuItems = [

    {
        id: 3333,
        title: 'Rau củ quả'
    },
    {
        id: 4333,
        title: 'Hải sản'
    }
];


const menusSecondaryItems = [
    {
        id: 14,
        title: Config.statisticDaily.title,
        icon: 'ios-podium',
        key: 'statistic'
    },
    {
        id: 11,
        title: Config.titleHopDongBeTong,
        icon: 'ios-paper',
        key: 'contractConcretes'
    },
    {
        id: 12,
        title: Config.titleLichXuatBeTong,
        icon: 'md-calendar',
        key: 'calendarConcretes'
    },
    {
        id: 13,
        title: Config.titleHopDongBanNVL,
        icon: 'ios-cube',
        key: 'contractMaterials'
    },
    {
        id: 17,
        title: Config.titleHopDongBanGach,
        icon: 'ios-grid',
        key: 'bricksContracts'
    },
    {
        id: 18,
        title: Config.titleLichBanGach,
        icon: 'md-calendar',
        key: 'calendarBricks'
    },
    // {
    //     id: 17,
    //     title: Config.titleGachXayDung,
    //     icon: 'ios-grid',
    //     key: 'contractBricks'
    // },
    // {
    //     id: 18,
    //     title: Config.titleGachTerrazo,
    //     icon: 'ios-grid',
    //     key: 'contractBrickTerrazos'
    // },
    // {
    //     id: 19,
    //     title: Config.titleGachMenBong,
    //     icon: 'ios-grid',
    //     key: 'contractBrickTiles'
    // },

    {
        id: 16,
        title: Config.btnLogout,
        icon: 'ios-log-out',
        key: 'login'
    },

];
