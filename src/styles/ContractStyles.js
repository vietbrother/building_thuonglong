'use strict';
import {StyleSheet} from 'react-native';
import Config from "../Config";

export default StyleSheet.create({
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
        width: 160,
        height: 160,
        borderRadius: 10,
        marginRight: 5,
        borderColor: '#dfe3ee',
        borderWidth: 0.5
    },
    capturePhoto: {
        width: 180,
        height: 180,
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
        fontSize: 16
    },
    titleBold: {
        fontSize: 16,
        fontWeight: 'bold'
    },
    titleMuted: {
        color: '#849192',
        fontSize: 16
    },
    subTitle: {
        fontFamily: 'Roboto',
        fontWeight: '200',
    },
    icon: {
        fontSize: 16
    },
    buttonChangeState: {
        backgroundColor: 'white',
        borderRadius: 4,
        borderWidth: 0.5,
        borderColor: Config.mainColor
    },

    statusRed: {
        color: 'red',
        fontSize: 16,
    },
    statusSuccess: {
        color: 'green',
        fontSize: 16,
    },
    statusOther: {
        color: Config.colorThin,
        fontSize: 16,
    },
    titleBranch: {
        color: 'dodgerblue', fontSize: 20, marginLeft: 0, fontWeight: 'bold'
    },
    muted: {
        color: '#849192',
        fontSize: 14
    },
    date: {
        fontSize: 16,
        marginLeft: -10
    },

    btnApprove: {
        borderBottomColor: Config.mainColor,
        borderBottomWidth: 0.5,
        borderTopColor: Config.mainColor,
        borderTopWidth: 0.5,
        borderLeftColor: Config.mainColor,
        borderLeftWidth: 0.5,
        borderRightColor: Config.mainColor,
        borderRightWidth: 0.5,
        borderRadius: 5,
        backgroundColor: Config.mainColor,
        color: 'white',
        padding: 10,
    },
    btnReject: {
        borderBottomColor: Config.warning,
        borderBottomWidth: 1,
        borderTopColor: Config.warning,
        borderTopWidth: 1,
        borderLeftColor: Config.warning,
        borderLeftWidth: 1,
        borderRightColor: Config.warning,
        borderRightWidth: 1,
        borderRadius: 5,
        backgroundColor: 'white',
        color: 'red',
        padding: 10,
        fontSize: 18
    },
    titleApprove: {
        fontWeight: 'bold',
        color: 'white',
        fontSize: 18
    },
    btnCancel: {
        padding: 10,
        color: '#849192',
    },
    branchPicker: {
        width: '100%',
        height: 50,
        padding: 10,
        borderWidth: 0.5,
        borderBottomColor: Config.mainColor,
        borderTopColor: Config.mainColor,
        borderLeftColor: Config.mainColor,
        borderRightColor: Config.mainColor,
    },
    branchPickerItem: {
        borderWidth: 0.5,
        borderBottomColor: Config.mainColor,
        borderTopColor: Config.mainColor,
        borderLeftColor: Config.mainColor,
        borderRightColor: Config.mainColor,
        color: Config.mainColor
    },

    tabActive: {
        height: 4, backgroundColor: Config.mainColor
    },
    tabHeading: {
        backgroundColor: 'white'
    },
    tabTitle: {
        backgroundColor: 'transparent', color: Config.mainColor
    },
    tabIcon: {
        backgroundColor: 'transparent', color: Config.mainColor
    },
    loadingActivity: {
        paddingTop: 40
    },
    badgeTitle: {
        marginTop: 5, marginLeft: 5
    },
    badgeTitleText: {
        color: 'white', padding: 2, fontSize: 14, fontWeight: 'bold'
    },

    main: {
        backgroundColor: '#f4f4ff', flex: 1
    },
    boxTitle: {
        width: '100%',
        fontWeight: 'bold',
        fontSize: 36,
        marginTop: 10,
        textAlign: 'center', alignSelf: 'stretch'
    },
    boxTitleSecond: {
        width: '100%',
        fontWeight: 'bold',
        fontSize: 26,
        //marginTop: 10,
        textAlign: 'center', alignSelf: 'stretch'
    },
    box: {
        shadowColor: "#f3f3f3",
        shadowOffset: {
            width: 0,
            height: 5,
        },
        shadowOpacity: 0.34,
        shadowRadius: 6.27,
        elevation: 10,
        borderRadius: 5
    },
    boxItem: {
        paddingTop: 10,
        paddingLeft: 20,
        paddingRight: 20,
        paddingBottom: 10,
        textAlign: 'center'
    },
    boxContent: {
        padding: 10,
        alignItems: 'flex-end',
        textAlign: 'right'
    },
    subItem: {
        padding: 15
    },
    subColItemLeft: {
        paddingLeft: 20,
        paddingBottom: 20,
        paddingTop: 20,
        paddingRight: 10,
    },
    subColItemRight: {
        paddingLeft: 10,
        paddingBottom: 20,
        paddingTop: 20,
        paddingRight: 20,
    },
    labelRed: {
        color: 'red',
    },
    labelSuccess: {
        color: 'green',
    },
    labelWhite: {
        color: 'white',
    },
    labelMain: {
        color: Config.mainColor
    },
    titleUnder: {
        //color: '#849192',
        color: '#5c6566',
        fontSize: 16,
        width: '100%',
        textAlign: 'center', alignSelf: 'stretch',
        marginTop: -15,
        //paddingRight: 10
    },
    titleAbove: {
        //color: '#849192',
        color: '#5c6566',
        fontSize: 16,
        width: '100%',
        textAlign: 'center', alignSelf: 'stretch',
        //marginBottom: -20,
        //paddingRight: 10
    },
    labelHeader: {
        color: Config.mainColor,
        fontSize: 20,

    },
    iconMedium: {
        fontSize: 24
    },
    labelValue: {
        color: Config.mainColor,
        fontWeight: 'bold',
        fontSize: 24,
        //padding: 10
    },

    m_r_5: {
       marginRight: 10
    },
    fontXL:{

    },
    p_t_b_20:{
        paddingTop : 20,
        paddingBottom : 20,
    },
    header: {
        paddingTop: 10,
        paddingBottom: 60,
    },
    bgMain: {
        backgroundColor : Config.mainColor,
        color: 'white'
    },
    subHeader: {
        marginTop: -40
    },
    mainTitle: {
        marginTop: -20
    }
});