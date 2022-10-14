import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'Home',
      component: HomeView
    },
    {
      path: '/products',
      name: 'Produtos',
      component: () => import('../views/ProductsView.vue')
    },
    {
      path: '/emails',
      name: 'Emails',
      component: () => import('../views/EmailView.vue')
    }
  ]
})

export default router
