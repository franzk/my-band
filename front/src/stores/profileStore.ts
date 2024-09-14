import type { Profile } from '@/types/Profile'
import { defineStore } from 'pinia'
import { ref } from 'vue'
import axios from 'axios'

export const useProfileStore = defineStore('profileStore', () => {
  /**
   * the currently displayed profile
   */
  const profile = ref<null | Profile>(null)

  /**
   * fetch a profile from the API
   * @param id : the id of the profile to fetch
   */
  const fetchProfile = async (id: number) => {
    const response = await axios.get(`http://localhost:3000/profiles/${id}`)
    const data = await response.data

    profile.value = data as Profile
  }

  return { profile, fetchProfile }
})
