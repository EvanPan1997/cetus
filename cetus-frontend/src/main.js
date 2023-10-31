import {createApp} from 'vue'
import 'element-plus/dist/index.css'
import App from "@/App.vue"
import router from "@/router/router"
import ElementPlus from 'element-plus'
import '@/style/index.css'

createApp(App)
    .use(ElementPlus, {})
    .use(router).mount('#app')