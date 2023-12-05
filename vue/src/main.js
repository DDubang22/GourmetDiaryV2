import { createApp } from 'vue'
import App from './App.vue'
import router from './router.js'
import 'bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css'
import mitt from "mitt"
import store from './index'; // VueX 스토어 추가


let emitter = mitt();
let app = createApp(App)
app.config.globalProperties.emitter = emitter;
export default emitter;


app.use(router).use(store).mount('#app')
