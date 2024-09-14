import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '@/views/HomeView.vue'
import ProfileView from '@/views/profile/ProfileView.vue'
import ProfileHomeView from '@/views/profile/ProfileHomeView.vue'
import ProfileLinks from '@/components/profile/content/ProfileLinks.vue'
import PostView from '@/views/PostView.vue'

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
          path: '/profile/:id/pictures',
          name: 'profile-pictures',
          component: ProfileHomeView
        },
        {
          path: '/profile/:id/videos',
          name: 'profile-videos',
          component: ProfileHomeView
        },
        {
          path: '/profile/:id/music',
          name: 'profile-music',
          component: ProfileHomeView
        },
        {
          path: '/profile/:id/content/links',
          name: 'profile-links',
          component: ProfileLinks
        }
      ]
    },
    {
      path: '/post/:id',
      name: 'post',
      component: PostView
    }
  ]
})

export default router
