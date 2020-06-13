import Config from "../Config";
import React, {Component} from 'react';
import {Alert} from 'react-native';
import {Text, Button, Left, Right, Icon, CardItem, Body} from 'native-base';
import {Actions} from 'react-native-router-flux';
import styles from "../styles/ContractStyles";

const Utils = {
    _callApi: async (url, param) => {
        try {
            let response = await fetch(url, {
                method: 'POST',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(param)
            });
            var responseObj = await response.json();
            return responseObj;
        } catch (err) {
            error(err);
        }
    },

    _renderDateFormat(date) {
        if (date != null && date != undefined) {
            var dateStr = date.substring(0, 10);
            dateStr = dateStr.replace(/(\d{4})-(\d{1,2})-(\d{1,2})/, function (match, y, m, d) {
                return d + '/' + m + '/' + y;
            });
            return dateStr;
        } else {
            return '';
        }
    },
    _renderPriceFormat(price) {
        return parseInt(price).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ".");
    },
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
                    <Icon active name="md-checkmark"
                          style={styles.statusSuccess}/> {Config.state.approved.toUpperCase()}
                </Text>
            );
        } else if (status == Config.state.approve_delete) {
            return (
                <Text style={styles.statusOther}>
                    <Icon active name="md-trash"
                          style={styles.statusOther}/> {Config.state.approve_delete.toUpperCase()}
                </Text>
            );
        } else {
            return (
                <Text style={styles.statusOther}>
                    <Icon active name="md-trash" style={styles.statusOther}/> {status}
                </Text>
            );
        }

    },
    _getStatusCode(statusName) {
        if (statusName == Config.state.wait) {
            return Config.stateCode.wait;
        } else if (statusName == Config.state.approved) {
            return Config.stateCode.approved;
        } else if (statusName == Config.state.approve_delete) {
            return Config.stateCode.approve_delete;
        }
        return statusName;

    },

    _nFormatter(num, digits) {
        /*var si = [
          { value: 1, symbol: "" },
          { value: 1E3, symbol: "k" },
          { value: 1E6, symbol: "Trieu" },
          { value: 1E9, symbol: "Ti" },
          { value: 1E12, symbol: "T" },
          { value: 1E15, symbol: "P" },
          { value: 1E18, symbol: "E" }
        ];*/
        var si = [
            {value: 1, symbol: ""},
            {value: 1E3, symbol: Config.currencyUnit.thousand},
            {value: 1E6, symbol: Config.currencyUnit.million},
            {value: 1E9, symbol: Config.currencyUnit.billion}
        ];
        var rx = /\.0+$|(\.[0-9]*[1-9])0+$/;
        var i;
        for (i = si.length - 1; i > 0; i--) {
            if (num >= si[i].value) {
                break;
            }
        }
        return (num / si[i].value).toFixed(digits).replace(rx, "$1") + si[i].symbol;
    },
    numberWithCommas(x) {
        return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    },
    // _renderApproveButton(status, callback) {
    //     if (status == Config.state.wait) {
    //         return (
    //             <CardItem>
    //                 <Left>
    //                     <Button active onPress={() => Actions.pop()} transparent>
    //                         <Text style={styles.btnClose}><Icon style={styles.icon} name='ios-close'/> {Config.btnClose}
    //                         </Text>
    //                     </Button>
    //                 </Left>
    //                 <Right>
    //                     <TouchableOpacity
    //                         style={styles.btnApprove}
    //                         onPress={() => this._alertConfirm(callback)}
    //                         activeOpacity={0.9}
    //                     >
    //                         <Text style={styles.titleApprove}><Icon style={styles.titleApprove}
    //                                                                 name='md-checkmark'/> {Config.btnApprove}
    //                         </Text>
    //                     </TouchableOpacity>
    //                 </Right>
    //             </CardItem>
    //         );
    //     } else if (status == Config.state.approved) {
    //         return (
    //             <CardItem>
    //                 <Body>
    //                     <Button active onPress={() => Actions.pop()} transparent>
    //                         <Text style={styles.btnClose}><Icon style={styles.icon} name='ios-close'/> {Config.btnClose}
    //                         </Text>
    //                     </Button>
    //                 </Body>
    //             </CardItem>
    //         );
    //     } else {
    //         return (
    //             <CardItem>
    //                 <Body>
    //                     <Button active onPress={() => Actions.pop()} transparent>
    //                         <Text style={styles.btnClose}><Icon style={styles.icon} name='ios-close'/> {Config.btnClose}
    //                         </Text>
    //                     </Button>
    //                 </Body>
    //             </CardItem>
    //         );
    //     }
    //
    // },

    _alert(messages) {
        Alert.alert(
            '',
            messages, // <- this part is optional, you can pass an empty string
            [
                {
                    text: Config.btnClose,
                    onPress: () => console.log('Cancel Pressed'),
                    style: 'cancel',
                },
            ],
            {cancelable: false},
        );
    },
    _alertConfirm(callback) {
        Alert.alert(
            '',
            Config.confirm_approve, // <- this part is optional, you can pass an empty string
            [
                {
                    text: Config.btnApply, onPress: () => {
                        if (typeof callback == 'function') {
                            callback();
                        }
                    }
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
};
export default Utils;