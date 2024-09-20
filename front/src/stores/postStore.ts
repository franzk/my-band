import type { Post } from '@/types/Post'
import type { Profile } from '@/types/Profile'
import axios from 'axios'
import { defineStore } from 'pinia'
import { ref } from 'vue'

/**
 * Store to manage the posts
 * WARNING : this store is not complete, the getPosts method returns mock data
 * you have to implement the getPosts method to fetch the posts from the API
 */
export const usePostStore = defineStore('postStore', () => {
  const posts = ref<Post[] | null>(null)

  const getPosts = async (profileId: string) => {
    const response = await axios.get(`http://localhost:3000/profiles/${profileId}`)
    const profile = response.data as Profile
    posts.value = profile.posts
  }

  return { posts, getPosts }
})
