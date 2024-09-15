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

  /**
   * error status of the last fetch
   */
  const error = ref<null | string>(null)

  /**
   * fetch a profile from the API
   * @param id : the id of the profile to fetch
   */
  const fetchProfile = async (id: string) => {
    axios
      .get(`${profileAPIUrl}/${id}`)
      .then((response) => {
        profile.value = response.data as Profile
        error.value = null
      })
      .catch((err) => {
        error.value = err.status ? err.status : 'error'
      })
  }

  return {
    profile,
    error,
    fetchProfile
  }
})
