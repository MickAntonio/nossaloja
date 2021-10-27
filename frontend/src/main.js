import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";

import { registerModules } from "./register-modules";
import vuetify from "./plugins/vuetify";

import LoadScript from 'vue-plugin-load-script';
import productosModule from "./modules/productos";
import carrinhoModule from "./modules/carrinho";

registerModules({
  produtos: productosModule,
  carrinho: carrinhoModule,
});

Vue.config.productionTip = false;


Vue.use(LoadScript);

Vue.loadScript("/js/jquery-3.3.1.min.js")
Vue.loadScript("/js/jquery-ui.min.js")
Vue.loadScript("/js/jquery.slicknav.js")
Vue.loadScript("/js/fontawesome.js")
Vue.loadScript("/js/bootstrap.min.js")
Vue.loadScript("/js/jquery.nice-select.min.js")
Vue.loadScript("/js/mixitup.min.js")
Vue.loadScript("/js/owl.carousel.min.js")
Vue.loadScript("/js/main.js")

new Vue({
  router,
  store,
  vuetify,
  render: h => h(App)
}).$mount("#app");
