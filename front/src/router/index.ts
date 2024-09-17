import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '@/views/HomeView.vue'
import ProfileView from '@/views/profile/ProfileView.vue'
import ProfileHomeView from '@/views/profile/ProfileHomeView.vue'
import PostView from '@/views/PostView.vue'
import ProfileLinksView from '@/views/profile/ProfileLinksView.vue'
import ProfilePicturesView from '@/views/profile/ProfilePicturesView.vue'
import ProfileVideosView from '@/views/profile/ProfileVideosView.vue'
import ProfileMusicView from '@/views/profile/ProfileMusicView.vue'
import NotFoundErrorView from '@/views/error/NotFoundErrorView.vue'
import ErrorView from '@/views/error/ErrorView.vue'
import ProfilePostsView from '@/views/profile/ProfilePostsView.vue'

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
          path: '/profile/:id/posts',
          name: 'profile-posts',
          component: ProfilePostsView
        },
        {
          path: '/profile/:id/pictures',
          name: 'profile-pictures',
          component: ProfilePicturesView
        },
        {
          path: '/profile/:id/videos',
          name: 'profile-videos',
          component: ProfileVideosView
        },
        {
          path: '/profile/:id/music',
          name: 'profile-music',
          component: ProfileMusicView
        },
        {
          path: '/profile/:id/content/links',
          name: 'profile-links',
          component: ProfileLinksView
        }
      ]
    },
    {
      path: '/post/:id',
      name: 'post',
      component: PostView
    },
    {
      path: '/404',
      name: 'error-404',
      component: NotFoundErrorView
    },
    {
      path: '/:pathMatch(.*)*',
      redirect: '/404' // Redirect all non existing routes to 404
    },
    {
      path: '/error',
      name: 'error',
      component: ErrorView
    }
  ]
})

export default router
