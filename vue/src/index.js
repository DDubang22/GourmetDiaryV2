// src/store/index.js
import { createStore } from 'vuex';

export default createStore({
  state: {
    isLoggedIn: false,
    // 다른 상태들도 필요하다면 추가할 수 있습니다.
  },
  mutations: {
    setLoggedIn(state, value) {
      state.isLoggedIn = value;
    },
    // 다른 뮤테이션들도 필요하다면 추가할 수 있습니다.
  },
  getters: {
    isLoggedIn: state => state.isLoggedIn,
    // 다른 게터들도 필요하다면 추가할 수 있습니다.
  },
});
