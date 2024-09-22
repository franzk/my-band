import type { Picture } from '@/types/Picture'
import type { Profile } from '@/types/Profile'
import axios from 'axios'
import { defineStore } from 'pinia'
import { ref } from 'vue'

/**
 * Store to manage the pictures
 * WARNING : this store is not complete, the getPictures method returns mock data
 * you have to implement the fetchPictures method to fetch the pictures from the API
 */
export const usePictureStore = defineStore('pictureStore', () => {
  const pictures = ref<Picture[] | null>(null)

  const getPictures = async (profileId: string) => {
    const response = await axios.get(`http://localhost:3000/profiles/${profileId}`)
    const profile = response.data as Profile
    pictures.value = (profile.posts
      .filter((p) => p.picture)
      .map((p) => Object.assign({}, p.picture, { relatedPostId: p.id })) || []) as Picture[]
  }

  return { pictures, getPictures }
})
