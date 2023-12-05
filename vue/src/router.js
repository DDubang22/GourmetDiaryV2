import { createWebHistory, createRouter } from "vue-router";
import LoginPage from "./components/LoginPage.vue";
import MapPage from "./components/MapPage.vue";
import BasicLogin from "./components/BasicLogin.vue"
import Service from "./components/Service.vue";
import CardPage from "./components/CardPage.vue";

import index from './components/ServicePage/index.vue';
import contact from './components/ServicePage/contact.vue';
import favorites from './components/ServicePage/favorites.vue';
import about from './components/ServicePage/about.vue';

const routes = [
  {
    path: "/login",
    component:LoginPage,
  },
  {
    path: "/map",
    component:MapPage,
  },
  {
    path: "/login/generallogin",
    component : BasicLogin,
  },
  {
    path: "/service",
    name: "Service",
    component: Service,
  },
  {
    path: "/cardpage",
    component: CardPage,
  },


  {
    path: "/index",
    name: "index",
    component: index,
  },
  {
    path: "/contact",
    component: contact,
  },
  {
    path: "/favorites",
    component: favorites,
  },
  {
    path: "/about",
    component: about,
  },
];


const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router; 