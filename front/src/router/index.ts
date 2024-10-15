import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '@/views/HomeView.vue'
import ProfileView from '@/views/profile/ProfileView.vue'
import ProfileHomeView from '@/views/profile/ProfileHomeView.vue'
import ErrorView from '@/views/error/ErrorView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/profile/:id',
      name: 'profile',
      component: ProfileView,
      children: [
        {
          path: '',
          name: 'profile-home',
          component: ProfileHomeView
        }
      ]
    },
    {
      path: '/error',
      name: 'error',
      component: ErrorView
    }
  ]
})

export default router
