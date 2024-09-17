import type { Post } from '@/types/Post'
import type { Profile } from '@/types/Profile'
import axios from 'axios'
import { defineStore } from 'pinia'
import { ref } from 'vue'

/**
 * Store to manage the posts data
 * WARNING : this store is not complete, the fetchPosts method returns mock data
 * you have to implement the fetchPosts method to fetch the posts from the API
 */
export const usePostsStore = defineStore('postsStore', () => {
  const posts = ref<Post[] | null>(null)

  const fetchPosts = async (profileId: string) => {
    const response = await axios.get(`http://localhost:3000/profiles/${profileId}`)
    const profile = response.data as Profile
    posts.value = profile.posts
  }

  return { posts, fetchPosts }
})
