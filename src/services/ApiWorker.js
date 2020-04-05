import Config from "../Config";

const ApiWorker = {
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
    login: async (data) => {
        try {
/*            let response = await fetch(Config.api.url + Config.api.apiLogin, {
                method: 'POST',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({
                    'userName': username,
                    'password': password,
                })
            });
            var responseObj = await response.json();*/
            var param = {
                userName: data.userName,
                password: data.password
            };
            return this._callApi(Config.api.url + Config.api.apiLogin, param);
        } catch (err) {
            error(err);
        }
    },
    getListHopDongBeTong: async (param) => {
        try {
            return this._callApi(Config.api.url + Config.api.apiHopDongBeTong, param);
        } catch (err) {
            error(err);
        }
    },
    getListLichXuatBeTong: async (param) => {
        try {
            return this._callApi(Config.api.url + Config.api.apiHopDongBeTong, param);
        } catch (err) {
            error(err);
        }
    },

};
export default ApiWorker;