import type { Post } from '@/types/Post'
import { defineStore } from 'pinia'
import { ref } from 'vue'

export const usePostStore = defineStore('postStore', () => {
  /**
   * le post actuellement affiché
   */
  const post = ref<Post | null>(null)

  const setPost = (data: Post) => {
    post.value = data
  }

  return { post, setPost }
})
