import { createRouter, createWebHistory } from 'vue-router'
import NotFound from '@/components/NotFound/NotFound.vue'
import LoginView from '@/views/LoginView.vue'
import Logout from '@/views/Logout.vue'
import DoacaoView from '@/views/DoacaoView.vue'
import HomeView from '@/views/HomeView.vue'
import ColaboradoresView from '@/views/ColaboradoresView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'login',
      component: LoginView
    },
    // {
    //   path: '/admin',
    //   name: 'admin',
    //   component: AdminView
    // },
    {
      path: '/home',
      name: 'home',
      component: HomeView
    },
    {
      path: '/doacao',
      name: 'doacao',
      component: DoacaoView
    },
    {
      path: '/colaboradores',
      name: 'colaboradores',
      component: ColaboradoresView
    },
    {
      path: '/logout',
      name: 'logout',
      component: Logout
    },
    {
      path: "/:catchAll(.*)",
      name: "NotFound",
      component: NotFound,
    },

  ]
})

export default router
