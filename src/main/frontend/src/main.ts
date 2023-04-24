import { createApp } from 'vue'
import { createPinia } from 'pinia'
import { createVuetify } from 'vuetify'

import App from './App.vue'
import router from './router'

import 'vuetify/styles'

import * as components from 'vuetify/components'
import * as directives from 'vuetify/directives'
import { aliases, mdi } from 'vuetify/iconsets/mdi'
import '../src/assets/styles/_main.scss'

const pinia = createPinia()

pinia.use((context) => {
  const storeId = context.store.$id

  console.log(storeId);
  
  const serializer = {
    serialize: JSON.stringify,
    deserialize: JSON.parse
  }

 
   const fromStorage = serializer.deserialize(window.sessionStorage.getItem(storeId)||'null')
 
  

  /* const fromStorage:string=  */

  if (fromStorage!='null') {
    context.store.$patch(fromStorage)
  }

  context.store.$subscribe((mutation, state) => {
    window.sessionStorage.setItem(storeId, serializer.serialize(state))
  })
})

const vuetify = createVuetify({
  components,
  directives,
  icons: {
    defaultSet: 'mdi',
    aliases,
    sets: {
      mdi,
    }
  },
  theme: { defaultTheme: 'light' },
})

const app = createApp(App)

app.use(pinia)
app.use(router)
app.use(vuetify)


app.mount('#app')
