import { Profile } from '@/types/Profile'
import { Picture } from '@/types/Picture'
import axios from 'axios'
import { defineStore } from 'pinia'
import { ref } from 'vue'

/**
 * Store to manage the pictures data
 * Warning : this is a mock store that returns the pictures in a profile
 * in real life, you would have to fetch the pictures from an API
 *
 */
export const usePicturesStore = defineStore('picturesStore', () => {
  const pictures = ref<Picture[] | null>(null)
  const error = ref(null)

  const fetchPictures = async (profileId: string) => {
    // replace all this with a call to a picture API
    const response = await axios.get(`http://localhost:3000/profiles/${profileId}`)
    const profile = response.data as Profile

    if (profile.pictures) {
      pictures.value = profile.posts.filter((p) => p.picture).map((p) => p.picture)
    } else {
      pictures.value = []
    }
  }

  return {
    pictures,
    error,
    fetchPictures
  }
})
