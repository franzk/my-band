import type { Post } from '@/types/Post'
import { defineStore } from 'pinia'
import { ref } from 'vue'

export const usePostStore = defineStore('postStore', () => {
  /**
   * the currently displayed post
   */
  const post = ref<Post | null>(null)

  /**
   * fetch post from the API
   */
  const fetchPost = async (id: number) => {
    try {
      const response = await fetch(`http://localhost:3000/posts/${id}`)
      const data = await response.json()

      post.value = data as Post
    } catch (error) {
      console.error('Error fetching post', error)
      post.value = null
    }
  }

  return { post, fetchPost }
})
