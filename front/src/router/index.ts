import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '@/views/HomeView.vue'
import ProfileView from '@/views/profile/ProfileView.vue'
import ProfileHomeView from '@/views/profile/ProfileHomeView.vue'
import ProfileAboutView from '@/views/profile/ProfileAboutView.vue'
import ProfileMediaView from '@/views/profile/ProfileMediaView.vue'

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
        },
        {
          path: '/profile/:id/media',
          name: 'profile-feed',
          component: ProfileMediaView
        }
      ]
    }
  ]
})

export default router
