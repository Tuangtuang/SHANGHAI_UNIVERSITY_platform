// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import Vuex from 'vuex'
import App from './App'
import router from './router'
import iView from 'iview'
import 'iview/dist/styles/iview.css'
import axios from 'axios'
import VueAxios from 'vue-axios'
import store from './../store/store'

Vue.config.productionTip = false
Vue.use(iView)
Vue.use(VueAxios,axios)

axios.defaults.timeout = 5000
axios.defaults.baseURL = 'http://localhost:8081/api'

axios.interceptors.request.use(
  config => {
    config.data = JSON.stringify(config.data)
    return config
  }
)
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})

router.beforeEach((to, from, next) => {
  if(to.meta.requireAuth) {
    if(store.state.token) {
      next();
    } else{
      next({
        path: '/Login',
        query: {redirect: to.fullPath}
      })
    }
  }
  else if(to.meta.requireManage) {
    axios({
      url: '/ifmanage/'+store.state.userId,
      headers: {"Authorization": store.state.token},
      method: 'get',
    }).then((response) => {
      let res = response.data;
      if(res.status === "success") {
        if(res.data.ifmanage){
          next();
        }else {
          next({
            path: '/HomePage',
          });
        }
      } else {
        this.$Message.info('失败');
      }
    })
  }
  else {
    next();
  }
})
