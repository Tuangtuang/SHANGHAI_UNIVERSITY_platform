import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)


const store = new Vuex.Store({
  state: {
    token: "" || localStorage.getItem("token"),
    // token: "dsaf",
    userNickname: "" || localStorage.getItem("userNickname"),
    // userNickname: "li",
    userId: "" || localStorage.getItem("userId"),
    // userId: "16122075"
  },
  mutations: {
    isLogin1(state,msg){
      state.token = msg;
      localStorage.setItem("token",msg);
    },
    isLogin2(state,msg){
      state.userNickname = msg;
      localStorage.setItem("userNickname",msg);
    },
    isLogin3(state,msg){
      state.userId = msg;
      localStorage.setItem("userId",msg);
    },
    isLogout(state){
      state.token = "";
      state.userNickname = "";
      state.userId = "";
      localStorage.removeItem("token");
      localStorage.removeItem("userNickname");
      localStorage.removeItem("userId");
    }
  },
  getters: {
    getToken(state){
      return state.token
    },
    getUserNickname(state){
      return state.userNickname
    }
  }
})

export default store
