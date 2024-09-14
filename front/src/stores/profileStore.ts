import type { Profile } from '@/types/Profile'
import { defineStore } from 'pinia'
import { ref } from 'vue'
import axios from 'axios'

export const useProfileStore = defineStore('profileStore', () => {
  /**
   * le profil actuellement affiché
   */
  const profile = ref<null | Profile>(null)

  /**
   * fetch les données d'un profil
   * @param id : l'id du profil à fetch
   */
  const fetchProfile = async (id: number) => {
    const response = await axios.get(`http://localhost:3000/profiles/${id}`)
    const data = await response.data

    profile.value = data as Profile
  }

  return { profile, fetchProfile }
})
