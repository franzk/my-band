import type { Profile } from '@/types/Profile'
import { defineStore } from 'pinia'
import { ref } from 'vue'
import axios from 'axios'

const profileAPIUrl = 'http://localhost:3000/profiles'

/**
 * Store to manage the profile data
 */
export const useProfileStore = defineStore('profileStore', () => {
  /**
   * currently displayed profile
   */
  const profile = ref<null | Profile>(null)

  const error = ref(null as string | null)

  /**
   * fetch a profile from the API
   * @param id : l'id du profil à fetch
   */
  const fetchProfile = async (id: number) => {
    axios
      .get(`${profileAPIUrl}/${id}`)
      .then((response) => (profile.value = response.data as Profile))
      .catch((error) => (error.value = error.message))
  }

  return {
    profile,
    error,
    fetchProfile
  }
})
