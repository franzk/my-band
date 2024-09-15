// import { Profile } from '@/types/Profile'
import type { Picture } from '@/types/Picture'
import type { Profile } from '@/types/Profile'
import axios from 'axios'
import { defineStore } from 'pinia'
import { ref } from 'vue'

export const usePicturesStore = defineStore('picturesStore', () => {
  const pictures = ref<Picture[] | null>(null)

  const fetchPictures = async (profileId: string) => {
    const response = await axios.get(`http://localhost:3000/profiles/${profileId}`)
    const profile = response.data as Profile
    pictures.value = profile.posts.filter((p) => p.picture).map((p) => p.picture)
  }

  return { pictures, fetchPictures }
})
