'use strict';
import {StyleSheet} from 'react-native';
import Config from "../../Config";

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
    titleBranch: {
        color: 'dodgerblue', fontSize: 20, marginLeft: 0
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
        backgroundColor: 'white'
    },
    titleApprove: {
        padding: 10,
        fontWeight: 'bold',
        color: Config.mainColor,
        fontSize: 18
    },
    btnCancel: {
        padding: 10,
        color: '#849192',
    }

});