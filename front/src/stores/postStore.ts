import type { Post } from '@/types/Post'
import { defineStore } from 'pinia'
import { ref } from 'vue'

export const usePostStore = defineStore('postStore', () => {
  /**
   * the currently displayed post
   */
  const post = ref<Post | null>(null)

  const setPost = (data: Post) => {
    post.value = data
  }

  return { post, setPost }
})
