import { createApp } from 'vue'
import { createPinia } from 'pinia'
import VuePlyr from 'vue-plyr'
import router from './router'
import App from './App.vue'

import '@/assets/scss/_styles.scss'
import 'vue-plyr/dist/vue-plyr.css'

const app = createApp(App)

app.use(createPinia())
app.use(router)
app.use(VuePlyr)

app.mount('#app')
