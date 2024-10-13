import type { Post } from '@/types/Post'
import type { Profile } from '@/types/Profile'
import axios from 'axios'
import { defineStore } from 'pinia'
import { ref } from 'vue'

const postAPIUrl = 'http://localhost:8202/api/v1/post'

/**
 * Store to manage the posts
 * WARNING : this store is not complete, the getPosts method returns mock data
 * you have to implement the getPosts method to fetch the posts from the API
 */
export const usePostStore = defineStore('postStore', () => {
  /**
   * fetched posts
   */
  const posts = ref<Post[] | null>(null)

  /**
   * error status of the last fetch
   */
  const error = ref<null | string>(null)

  /**
   * fetch the posts from the API
   * @param profileId : the id of the profile to fetch the posts from
   */
  const getPosts = async (profileId: string) => {
    axios
      .get(`${postAPIUrl}/profile`, { params: { profileId } })
      .then((response) => {
        posts.value = response.data as Post[]
        error.value = null
      })
      .catch((err) => {
        error.value = err.status ? err.status : 'error'
      })
  }

  return { posts, error, getPosts }
})
