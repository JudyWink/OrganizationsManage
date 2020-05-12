import Vue from 'vue';
import Vuex from 'vuex';
Vue.use(Vuex);

const store = new Vuex.Store({

  state: {
    token: window.sessionStorage.getItem('token'),
    userName: window.sessionStorage.getItem('userName'),
    userType: window.sessionStorage.getItem('userType'),
    userID : window.sessionStorage.getItem('userID'),
    password: window.localStorage.getItem('password'),
    account : window.localStorage.getItem('account'),
    sb : window.sessionStorage.getItem('sb'),
  },

  mutations: {
    SB(state, value){
      state.sb = value;
       window.sessionStorage.setItem('sb',value);
    },

    SET_TOKEN (state, value) {
      state.token = value;
      window.sessionStorage.setItem('token',value);
    },

    SET_NAME(state, value){
    state.userName = value;
    window.sessionStorage.setItem('userName',value);
    },

    SET_TYPE(state,value){
    state.userType = value;
    window.sessionStorage.setItem('userType',value);
    },

    SET_USERID(state,value){
        state.userID = value;
        window.sessionStorage.setItem('userID',value);
        },

    REMEMBER_ACCOUNT(state,account){
    state.account = account;
    window.localStorage.setItem('account',account);
    },
    REMEMBER_PASSWORD(state,password){
    state.password = password;
    window.localStorage.setItem('password',password);
    },

    NO_REMEMBER(state){
    state.account = null;
    state.password = null;
    window.localStorage.removeItem('account');
    window.localStorage.removeItem('password');
    },

    LOGOUT(state){
   state.token = null;
   state.userName = null;
   state.userType = null;
   window.sessionStorage.removeItem('token');
   window.sessionStorage.removeItem('userName');
   window.sessionStorage.removeItem('userType');
   window.localStorage.removeItem('')
    }
  }
});

export default store;
