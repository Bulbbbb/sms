import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const store = new Vuex.Store({
    state: {
        userMsg:{},
        count:0
    },
    mutations: {
      changeUserMsg (state,userMsg) {
        state.userMsg=userMsg;
      }
    }
  })

  
export default store